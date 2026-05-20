package BankManage; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountRequestsUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    
    private JPanel sidebarPanel, mainContentPanel, linePanel, requestsTablePanel;
    
    java.net.URL homeImgURL = AccountRequestsUI.class.getResource("resources/home.png");
    
    private ImageIcon homeRaw = new ImageIcon(homeImgURL);
    private Image homeScale = homeRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon homeIcon = new ImageIcon(homeScale);
    
    java.net.URL accountsImgURL = AccountRequestsUI.class.getResource("resources/accounts.png");
    
    private ImageIcon accountsRaw = new ImageIcon(accountsImgURL);
    private Image accountsScale = accountsRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon accountsIcon = new ImageIcon(accountsScale);
    
    java.net.URL logoutImgURL = AccountRequestsUI.class.getResource("resources/logout.png");
    
    private ImageIcon logoutRaw = new ImageIcon(logoutImgURL);
    private Image logoutScale = logoutRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon logoutIcon = new ImageIcon(logoutScale);
    
    java.net.URL logoImgURL = AccountRequestsUI.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));
    
    java.net.URL trackerImgURL = AdminDashboard.class.getResource("resources/tracker.png");

    private ImageIcon trackerRaw = new ImageIcon(trackerImgURL);
    private Image trackerScale = trackerRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon trackerIcon = new ImageIcon(trackerScale);
    
    java.net.URL reqImgURL = AdminDashboard.class.getResource("resources/requests.png");
    private ImageIcon reqRaw = new ImageIcon(reqImgURL);
    private Image reqScale = reqRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon reqIcon = new ImageIcon(reqScale);
    
    private final JButton homeBtn, accRequestBtn, logoutBtn, transTrackerBtn, roleBtn;
    private final JLabel logoName;
    
    private final JLabel dashboardTitle, pendinglbl;
    private JTable requestsTable;
    private JScrollPane tableScrollPane;
    
    protected String[] columnHeaders = {
        "Request ID", "Full Name", "Email Address", "Account Type", "Date Applied"
    };
    
    protected String[][] sampleData = {
        {"REQ-101", "Ezekiel Francisco", "ezekiel@email.com", "Savings", "May 18, 2026"},
        {"REQ-102", "Inigo Baseleres", "inigo@email.com", "Checking", "May 17, 2026"},
        {"REQ-103", "Athea Rodriguez", "athea@email.com", "Savings", "May 16, 2026"},
    };
    
    public AccountRequestsUI() {
        setTitle("Admin Dashboard - Account Requests");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1440, 960);
        setLocationRelativeTo(null); 
        setResizable(false);
        
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(null);
        
        logoName = new JLabel("VAULTBANK");
        logoName.setBounds(52, 14, 130, 30);
        logoName.setForeground(cs.white);
        logoName.setFont(new Font("Cascadia Code", Font.BOLD, 20));
        sidebarPanel.add(logoName);
        
        logo.setBounds(12, 15, 30, 30);
        sidebarPanel.add(logo);
        
        homeBtn = new JButton("Home", homeIcon);
        homeBtn.setBounds(0, 60, 180, 40);
        homeBtn.setBackground(cs.darkPurple);
        homeBtn.setForeground(cs.white);
        homeBtn.setFocusPainted(false);
        homeBtn.setBorderPainted(false);
        homeBtn.setHorizontalAlignment(SwingConstants.LEFT);
        homeBtn.setIconTextGap(8);
        sidebarPanel.add(homeBtn);
        
        // account role
        
        roleBtn = new JButton("Account Role", accountsIcon);
        roleBtn.setBounds(0, 100, 180, 40);
        roleBtn.setBackground(cs.darkPurple);
        roleBtn.setForeground(cs.white);
        roleBtn.setFocusPainted(false);
        roleBtn.setBorderPainted(false);
        
        roleBtn.setHorizontalAlignment(SwingConstants.LEFT);
        roleBtn.setIconTextGap(8);
        sidebarPanel.add(roleBtn);
        
        accRequestBtn = new JButton("Account Requests", reqIcon);
        accRequestBtn.setBounds(0, 140, 180, 40);
        accRequestBtn.setBackground(cs.btnColorSelect);
        accRequestBtn.setForeground(cs.white);
        accRequestBtn.setFocusPainted(false);
        accRequestBtn.setBorderPainted(false);
        accRequestBtn.setHorizontalAlignment(SwingConstants.LEFT);
        accRequestBtn.setIconTextGap(8);
        sidebarPanel.add(accRequestBtn);
        
        logoutBtn = new JButton("Logout", logoutIcon);
        logoutBtn.setBounds(0, 840, 180, 40);
        logoutBtn.setBackground(cs.darkPurple);
        logoutBtn.setForeground(cs.white);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
        logoutBtn.setIconTextGap(8);
        sidebarPanel.add(logoutBtn);
        
        transTrackerBtn = new JButton("Transaction Tracker", trackerIcon);
        transTrackerBtn.setBounds(0, 180, 180, 40);
        transTrackerBtn.setBackground(cs.darkPurple);
        transTrackerBtn.setForeground(cs.white);
        transTrackerBtn.setFocusPainted(false);
        transTrackerBtn.setBorderPainted(false);
        transTrackerBtn.setHorizontalAlignment(SwingConstants.LEFT);
        transTrackerBtn.setIconTextGap(8);
        sidebarPanel.add(transTrackerBtn);
        
        sidebarPanel.setBackground(cs.purple);
        sidebarPanel.setBounds(0, 0, 180, 960);
        add(sidebarPanel);
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        
        dashboardTitle = new JLabel("Account Requests");
        dashboardTitle.setBounds(30, 15, 200, 20);
        dashboardTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(dashboardTitle);
        
        linePanel = new JPanel();
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        requestsTablePanel = new JPanel();
        requestsTablePanel.setLayout(null);
        requestsTablePanel.setBounds(30, 90, 1185, 795);
        requestsTablePanel.setBackground(cs.white);
        requestsTablePanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        pendinglbl = new JLabel("Pending Registration Approvals"); 
        pendinglbl.setBounds(20, 20, 300, 30);
        pendinglbl.setFont(new Font("", Font.BOLD, 18));
        pendinglbl.setForeground(cs.darkerPurple);
        requestsTablePanel.add(pendinglbl);
        
        requestsTable = new JTable(sampleData, columnHeaders);
        requestsTable.setRowHeight(40);
        requestsTable.setFont(new Font("Arial", Font.PLAIN, 14));
        requestsTable.setFocusable(false);
        requestsTable.getTableHeader().setReorderingAllowed(false);
        requestsTable.getTableHeader().setBackground(cs.darkPurple);
        requestsTable.getTableHeader().setForeground(cs.white);
        requestsTable.setSelectionBackground(cs.lightPurple);
        requestsTable.setSelectionForeground(cs.white);
        requestsTable.setShowGrid(false);
        requestsTable.setDefaultEditor(Object.class, null);
        
        requestsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        requestsTable.getTableHeader().setPreferredSize(new Dimension(0, 45));
        
        tableScrollPane = new JScrollPane(requestsTable);
        tableScrollPane.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        tableScrollPane.setBounds(20, 60, 1145, 710);
        requestsTablePanel.add(tableScrollPane);
        
        mainContentPanel.add(requestsTablePanel);
        
        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);
        
        roleBtn.addActionListener(this);
        homeBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        transTrackerBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeBtn) {
            AdminDashboard admUI = new AdminDashboard();
            admUI.setVisible(true);
            dispose();
            
        } if(e.getSource() == roleBtn){
            AccountRoleUI roleUI = new AccountRoleUI();
            roleUI.setVisible(true);
            dispose();
        }else if (e.getSource() == logoutBtn) {
            LoginUI logUI = new LoginUI();
            logUI.setVisible(true);
            dispose();
        } else if (e.getSource() == transTrackerBtn) {
        new TransactionTrackerUI().setVisible(true);
        dispose();
    }
}
}