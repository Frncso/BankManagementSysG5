package BankManage;
import BankManage.AccountModels.EmployeeModel;
import BankManage.AppService.Encryption;
import BankManage.AppService.SessionManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionTrackerUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    Encryption en = new Encryption();

    // panels
    
    private JPanel sidebarPanel, mainContentPanel, linePanel, tablePanel;

    // import images
    
    java.net.URL homeImgURL = TransactionTrackerUI.class.getResource("resources/home.png");

    private ImageIcon homeRaw = new ImageIcon(homeImgURL);
    private Image homeScale = homeRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon homeIcon = new ImageIcon(homeScale);
    
    java.net.URL accountsImgURL = TransactionTrackerUI.class.getResource("resources/accounts.png");
    
    private ImageIcon accountsRaw = new ImageIcon(accountsImgURL);
    private Image accountsScale = accountsRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon accountsIcon = new ImageIcon(accountsScale);
    
    java.net.URL trackerImgURL = TransactionTrackerUI.class.getResource("resources/tracker.png");

    private ImageIcon trackerRaw = new ImageIcon(trackerImgURL);
    private Image trackerScale = trackerRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon trackerIcon = new ImageIcon(trackerScale);

    // Account Role icon (reusing accounts.png to match AdminDashboard exactly)
    java.net.URL roleImgURL = TransactionTrackerUI.class.getResource("resources/accounts.png");
    private ImageIcon roleRaw = new ImageIcon(roleImgURL);
    private Image roleScale = roleRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon roleIcon = new ImageIcon(roleScale);

    java.net.URL logoutImgURL = TransactionTrackerUI.class.getResource("resources/logout.png");
    
    private ImageIcon logoutRaw = new ImageIcon(logoutImgURL);
    private Image logoutScale = logoutRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon logoutIcon = new ImageIcon(logoutScale);
    
    java.net.URL reqImgURL = AdminDashboard.class.getResource("resources/requests.png");
    private ImageIcon reqRaw = new ImageIcon(reqImgURL);
    private Image reqScale = reqRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon reqIcon = new ImageIcon(reqScale);
    
    java.net.URL logoImgURL = TransactionTrackerUI.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));

    // sidebar
    
    private final JButton homeBtn, roleBtn, accRequestBtn, transTrackerBtn, logoutBtn;
    private final JLabel logoName;
    
    // mainContentPanel
    
    private final JLabel pageTitle;
    
    // search bar
    
    private JLabel searchLbl;
    private JTextField searchField;
    private JButton searchBtn;
    
    // table panel
    
    private final JLabel allTranslbl;
    private JTable transTable;
    private JScrollPane tableScrollPane;
    
    protected String[] columnHeaders = {
        "Transaction ID", "Account ID", "Account Type", "First Name", "Purchase Name", "Date", "Amount", "Status"
    };

    protected String[][] tableData = {
        {"TXN-001", "ACC-12345", "Savings",  "Ezekiel", "Fully Booked",            "May 25, 2026",       "₱25,120.50", "Completed"},
        {"TXN-002", "ACC-12346", "Checking", "Inigo",   "Nintendo Shop",           "May 30, 2026",        "₱0.00",      "Declined"},
        {"TXN-003", "ACC-12347", "Savings",  "Athea",   "Fully Booked",            "June 7, 2026",    "₱250.00",    "Completed"},
        {"TXN-004", "ACC-12348", "Savings",  "Maria",   "Food Panda",              "January 6, 2026",    "₱1,600.00",  "Completed"},
        {"TXN-005", "ACC-12349", "Checking", "Jose",    "The Golden Fur PH",       "January 1, 2026",    "₱1,200.00",  "Completed"},
        {"TXN-006", "ACC-12350", "Savings",  "Ana",     "Shopee Philippines",      "January 1, 2026",    "₱300.00",    "Completed"},
        {"TXN-007", "ACC-12351", "Savings",  "Carlos",  "Minecraft Gift",          "January 1, 2026",    "₱1,600.00",  "Completed"},
        {"TXN-008", "ACC-12352", "Checking", "Rosa",    "Apple Pay Transfer",      "December 25, 2025",  "₱2,000.00",  "Completed"},
        {"TXN-009", "ACC-12353", "Savings",  "Pedro",   "Paypal Transfer",         "December 24, 2025",  "₱50,600.00", "Pending"},
        {"TXN-010", "ACC-12354", "Savings",  "Luis",    "Steam 20USD Gift Card",   "December 1, 2025",   "₱1,200.00",  "Completed"},
        {"TXN-011", "ACC-12355", "Checking", "Clara",   "LetterBoxd Patreon",      "December 1, 2025",   "₱999.00",    "Completed"},
        {"TXN-012", "ACC-12356", "Savings",  "Marco",   "GCash Transfer",          "November 1, 2025",   "₱1,600.00",  "Pending"},
        {"TXN-013", "ACC-12357", "Savings",  "Sofia",   "Spotify Premium Yearly",  "September 25, 2025", "₱2,000.00",  "Completed"},
        {"TXN-014", "ACC-12358", "Checking", "Diego",   "PayPal Transfer",         "September 24, 2025", "₱10,600.00", "Completed"},
    };
    
    public TransactionTrackerUI() {
        
        if (SessionManage.isStaffLoggedIn()){
            EmployeeModel staff = SessionManage.getCurrentStaff();
            
            System.out.println("Logged in as: " + en.decrypt(staff.getEmployeeFName())); // debug
        }
        
        setTitle("Admin Dashboard - Transaction Tracker");
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
        
        // home icon
        
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
        
        roleBtn = new JButton("Account Controls", roleIcon);
        roleBtn.setBounds(0, 100, 180, 40);
        roleBtn.setBackground(cs.darkPurple);
        roleBtn.setForeground(cs.white);
        roleBtn.setFocusPainted(false);
        roleBtn.setBorderPainted(false);
        
        roleBtn.setHorizontalAlignment(SwingConstants.LEFT);
        roleBtn.setIconTextGap(8);
        sidebarPanel.add(roleBtn);
        
        // account requests
        
        accRequestBtn = new JButton("Account Requests", reqIcon);
        accRequestBtn.setBounds(0, 140, 180, 40);
        accRequestBtn.setBackground(cs.darkPurple);
        accRequestBtn.setForeground(cs.white);
        accRequestBtn.setFocusPainted(false);
        accRequestBtn.setBorderPainted(false);
        
        accRequestBtn.setHorizontalAlignment(SwingConstants.LEFT);
        accRequestBtn.setIconTextGap(8);
        sidebarPanel.add(accRequestBtn);
        
        // transaction tracker (selected)
        
        transTrackerBtn = new JButton("Transaction Tracker", trackerIcon);
        transTrackerBtn.setBounds(0, 180, 180, 40);
        transTrackerBtn.setBackground(cs.btnColorSelect);
        transTrackerBtn.setForeground(cs.white);
        transTrackerBtn.setFocusPainted(false);
        transTrackerBtn.setBorderPainted(false);
        
        transTrackerBtn.setHorizontalAlignment(SwingConstants.LEFT);
        transTrackerBtn.setIconTextGap(8);
        sidebarPanel.add(transTrackerBtn);

        // logout
        
        logoutBtn = new JButton("Logout", logoutIcon);
        logoutBtn.setBounds(0, 840, 180, 40);
        logoutBtn.setBackground(cs.darkPurple);
        logoutBtn.setForeground(cs.white);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorderPainted(false);
        
        logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
        logoutBtn.setIconTextGap(8);
        sidebarPanel.add(logoutBtn);
        
        sidebarPanel.setBackground(cs.purple);
        
        sidebarPanel.setBounds(0, 0, 180, 960);
        add(sidebarPanel);
        
        // main content panel
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        
        pageTitle = new JLabel("Transaction Tracker");
        pageTitle.setBounds(30, 15, 300, 20);
        pageTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(pageTitle);
        
        linePanel = new JPanel();
        
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        // search bar
        
        searchLbl = new JLabel("Search Transaction ID:");
        searchLbl.setBounds(30, 65, 200, 30);
        searchLbl.setFont(new Font("Arial", Font.PLAIN, 13));
        mainContentPanel.add(searchLbl);

        searchField = new JTextField();
        searchField.setBounds(165, 65, 280, 30);
        searchField.setFont(new Font("Arial", Font.PLAIN, 13));
        searchField.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainContentPanel.add(searchField);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(455, 65, 100, 30);
        searchBtn.setBackground(cs.darkPurple);
        searchBtn.setForeground(cs.white);
        searchBtn.setFocusPainted(false);
        searchBtn.setBorderPainted(false);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 13));
        mainContentPanel.add(searchBtn);
        
        // table panel
        
        tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(30, 110, 1185, 790);
        tablePanel.setBackground(cs.white);
        tablePanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        allTranslbl = new JLabel("All Transactions"); 
        allTranslbl.setBounds(20, 20, 300, 30);
        allTranslbl.setFont(new Font("", Font.BOLD, 18));
        allTranslbl.setForeground(cs.darkerPurple);
        tablePanel.add(allTranslbl);
        
        // table (objects papasok dito)
        
        transTable = new JTable(tableData, columnHeaders);
        transTable.setRowHeight(40);
        transTable.setFont(new Font("Arial", Font.PLAIN, 14));
        transTable.setFocusable(false);
        transTable.getTableHeader().setReorderingAllowed(false);
        transTable.getTableHeader().setBackground(cs.darkPurple);
        transTable.getTableHeader().setForeground(cs.white);
        transTable.setSelectionBackground(cs.lightPurple);
        transTable.setSelectionForeground(cs.white);
        transTable.setShowGrid(false);
        transTable.setDefaultEditor(Object.class, null);
        
        transTable.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 14)
        );
        transTable.getTableHeader().setPreferredSize(
            new Dimension(0, 45)
        );
        
        // no scroll
        
        tableScrollPane = new JScrollPane(transTable);
        
        tableScrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_NEVER
        );

        tableScrollPane.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        
        tableScrollPane.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        tableScrollPane.setBounds(20, 55, 1145, 715);
        tablePanel.add(tableScrollPane);
        
        mainContentPanel.add(tablePanel);
        
        // end table
        
        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);
        
        // end content panel
        
        homeBtn.addActionListener(this);
        roleBtn.addActionListener(this);
        accRequestBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // side bar
        
        if(e.getSource() == homeBtn){
            AdminDashboard ad = new AdminDashboard();
            ad.setVisible(true);
            dispose();

        }
        
        else if(e.getSource() == roleBtn){
            AccountRoleUI roleUI = new AccountRoleUI();
            roleUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == accRequestBtn){
            AccountRequestsUI ar = new AccountRequestsUI();
            ar.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == logoutBtn){
            int confirm = JOptionPane.showConfirmDialog(this, 
            "Are you sure you want to logout?", 
            "Logout", 
            JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                SessionManage.logout();
                LoginUI logUI = new LoginUI();
                logUI.setVisible(true);
                dispose();
            }
        }
        
        else if(e.getSource() == searchBtn){
            // query and search code here:
            TransactionSummaryUI ts = new TransactionSummaryUI();
            ts.setVisible(true);
            dispose();
        }
        
        // side bar end
        
        // main content
        
        
        //
        
    }
    
}