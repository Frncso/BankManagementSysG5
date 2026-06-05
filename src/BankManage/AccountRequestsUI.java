package BankManage; 
import BankManage.AccountModels.EmployeeModel;
import BankManage.AccountModels.RequestModel;
import BankManage.AppService.Encryption;
import BankManage.AppService.SessionManage;
import BankManage.AppService.RequestService;
import BankManage.DataService.RequestDataService;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountRequestsUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    Encryption en = new Encryption();
    RequestService rs = new RequestService();
    
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
    
    java.net.URL eyeImgURL = CustomerDashboard.class.getResource("resources/eye.png");
    private ImageIcon eyeRaw = new ImageIcon(eyeImgURL);
    private Image eyeScale = eyeRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon eyeIcon = new ImageIcon(eyeScale);
    
    private final JButton homeBtn, accRequestBtn, logoutBtn, transTrackerBtn, roleBtn;
    private final JLabel logoName;
    
    private final JLabel dashboardTitle, pendinglbl;
    private JTable requestsTable;
    private JScrollPane tableScrollPane;
    
    private JButton viewAnsReqbtn;
    
    private JLabel searchLbl;
    private JTextField searchField;
    private JButton searchBtn;
    
    private int count = rs.getPenReqCnt("Pending");
    
    protected String[] columnHeaders = {
        "Request ID", "Customer ID", "Account ID", "Request Type", "Account Type", "Status", "Date Applied"
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
        
        roleBtn = new JButton("Account Controls", accountsIcon);
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
        requestsTablePanel.setBounds(30, 110, 1185, 790);
        requestsTablePanel.setBackground(cs.white);
        requestsTablePanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        pendinglbl = new JLabel("Pending Request Approvals ("+ String.valueOf(count)+")"); 
        pendinglbl.setBounds(20, 20, 300, 30);
        pendinglbl.setFont(new Font("", Font.BOLD, 18));
        pendinglbl.setForeground(cs.darkerPurple);
        requestsTablePanel.add(pendinglbl);
        
        tableScrollPane = new JScrollPane(requestsTable);
        tableScrollPane.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        tableScrollPane.setBounds(20, 60, 1145, 710);
        requestsTablePanel.add(tableScrollPane);
        
        mainContentPanel.add(requestsTablePanel);
        
        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);
        
        viewAnsReqbtn = new JButton("View Processed Requests", eyeIcon);
        viewAnsReqbtn.setBounds(985, 65, 230, 30);
        viewAnsReqbtn.setBackground(cs.darkPurple);
        viewAnsReqbtn.setForeground(cs.white);
        viewAnsReqbtn.setFocusPainted(false);
        viewAnsReqbtn.setBorderPainted(false);
        viewAnsReqbtn.setFont(new Font("Arial", Font.BOLD, 13));
        viewAnsReqbtn.addActionListener(this);
        mainContentPanel.add(viewAnsReqbtn);
        
        searchLbl = new JLabel("Search Requests ID:");
        searchLbl.setBounds(30, 65, 200, 30);
        searchLbl.setFont(new Font("Arial", Font.PLAIN, 13));
        mainContentPanel.add(searchLbl);

        searchField = new JTextField();
        searchField.setBounds(235, 65, 280, 30);
        searchField.setFont(new Font("Arial", Font.PLAIN, 13));
        searchField.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainContentPanel.add(searchField);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(525, 65, 100, 30);
        searchBtn.setBackground(cs.darkPurple);
        searchBtn.setForeground(cs.white);
        searchBtn.setFocusPainted(false);
        searchBtn.setBorderPainted(false);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 13));
        mainContentPanel.add(searchBtn);

        roleBtn.addActionListener(this);
        homeBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        transTrackerBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        
        if (SessionManage.isStaffLoggedIn()){
            EmployeeModel staff = SessionManage.getCurrentStaff();
            
            loadRequestData();
            
            System.out.println("Logged in as: " + staff.getEmployeeFName()); // debug
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeBtn) {
            AdminDashboard admUI = new AdminDashboard();
            admUI.setVisible(true);
            dispose();
        } 
        else if(e.getSource() == roleBtn){
            AccountRoleUI roleUI = new AccountRoleUI();
            roleUI.setVisible(true);
            dispose();
        } 
        else if (e.getSource() == searchBtn) {
            String requestId = searchField.getText().trim();
            search(requestId);
        } 
        else if (e.getSource() == logoutBtn) {
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
        else if (e.getSource() == transTrackerBtn) {
            TransactionTrackerUI tu = new TransactionTrackerUI();
            tu.setVisible(true);
            dispose();
        } 
        else if (e.getSource() == viewAnsReqbtn){
            ProcessedRequestsUI ru = new ProcessedRequestsUI();
            ru.setVisible(true);
            dispose();
        }
    }
    
    private void loadRequestData() {
        RequestDataService requestDataService = new RequestDataService();
        List<RequestModel> requests = requestDataService.getAllRequestsByStatus("Pending");

        String[][] data = new String[requests.size()][7];

        for (int i = 0; i < requests.size(); i++) {
            RequestModel r = requests.get(i);

            data[i][0] = r.getRequestId();
            data[i][1] = r.getCustomerId();
            data[i][2] = r.getAccountNumber() != null ? r.getAccountNumber() : "N/A";
            data[i][3] = r.getRequestType();
            data[i][4] = r.getAccountType();
            data[i][5] = r.getStatus();
            data[i][6] = r.getTimestamp();
        }

        requestsTable = new JTable(data, columnHeaders);
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

        requestsTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = requestsTable.getSelectedRow();
                if (selectedRow != -1) {
                    String requestId = (String) requestsTable.getValueAt(selectedRow, 0);
                    searchField.setText(requestId); // pasting to search field
                }
            }
        });

        tableScrollPane.setViewportView(requestsTable);
    }
    
    private void search(String requestId){
    
        if (requestId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Request ID.");
            return;
        }

        RequestDataService requestDataService = new RequestDataService();
        RequestModel request = requestDataService.findByReqID(requestId);

        if (request == null) {
            JOptionPane.showMessageDialog(this, "Request not found.");
            return;
        }

        // depende kung ano oopen sa request type :D
        if (request.getRequestType().equalsIgnoreCase("Close Account")) {
            new AccountRequestsSummaryUI(requestId).setVisible(true);
        } 
        else if (request.getRequestType().equalsIgnoreCase("Open Account")) {
            new RequestOpenAccountSummaryUI(requestId).setVisible(true);
        } 
        else {
            JOptionPane.showMessageDialog(this, "Unknown request type.");
        }

        dispose();
        
    }
}