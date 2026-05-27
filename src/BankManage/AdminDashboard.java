package BankManage; 
import BankManage.AppService.RegisterService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    RegisterService rs = new RegisterService();
    
    // panels
    
    private JPanel sidebarPanel, mainContentPanel, linePanel, accountOverviewPanel, requestOverviewPanel, recentActivityPanel;
    
    // import images
    
    java.net.URL homeImgURL = AdminDashboard.class.getResource("resources/home.png");

    private ImageIcon homeRaw = new ImageIcon(homeImgURL);
    private Image homeScale = homeRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon homeIcon = new ImageIcon(homeScale);
    
    java.net.URL accountsImgURL = AdminDashboard.class.getResource("resources/accounts.png");
    
    private ImageIcon accountsRaw = new ImageIcon(accountsImgURL);
    private Image accountsScale = accountsRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon accountsIcon = new ImageIcon(accountsScale);
    
    java.net.URL logoutImgURL = AdminDashboard.class.getResource("resources/logout.png");
    
    private ImageIcon logoutRaw = new ImageIcon(logoutImgURL);
    private Image logoutScale = logoutRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon logoutIcon = new ImageIcon(logoutScale);
    
    java.net.URL logoImgURL = AdminDashboard.class.getResource("resources/bluewhiteLogo.png");
    
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

    // sidebar
    
    private final JButton homeBtn, roleBtn, accRequestBtn, logoutBtn, transTrackerBtn;
    private final JLabel logoName;
    
    // mainContentPanel
    
    private final JLabel dashboardTitle, welcomelbl, adminNamelbl, datelbl;
    private final JButton testBtn;
    
    // account overview panel
    
    private final JLabel accountOverviewTitlelbl, totalAccountslbl, totalAccountsDesclbl, activeUserslbl, activeUsersDesclbl;
    private final JButton manageRolesBtn;
    
    // requests overview panel
    
    private final JLabel requestOverviewTitlelbl, pendingRequestslbl, pendingRequestsDesclbl, approvedTodaylbl, approvedTodayDesclbl;
    private final JButton viewRequestsBtn;
    
    // recent panel
    
    private final JLabel recentActivitylbl;
    private JTable recentActivitytbl;
    private JScrollPane recentActivityScroll;
    
    protected String[] recentActivityColumns = {
        "User", "Acc ID", "Action", "Date", "Status"
    };
    
    protected String[][] recentActivityData = {
        {"Juan", "ACC-1001", "Account Activated", "May 18, 2026", "Completed"},
        {"Inigo", "ACC-1002", "Account Suspended", "May 17, 2026", "Completed"},
        {"Francisco", "ACC-1003", "New Account Request", "May 16, 2026", "Pending"},
        {"Matthew", "ACC-1004", "Suspicious Transaction", "May 15, 2026", "Reviewed"},
        {"Pogi", "ACC-1005", "Account Closed", "May 14, 2026", "Success"}
    };
    
    //
    
    private String adminName = "Juanito";
    private String currentDate = "May 20, 2026";
    private int totalAccountsCount = 8;
    private int activeUsersCount = 4;
    private int pendingRequestsCount = 3;
    private int approvedTodayCount = 2;
    
    public AdminDashboard() {
        setTitle("Admin Dashboard - Home");
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
        homeBtn.setBackground(cs.btnColorSelect);
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
        
        // transaction tracker
        
        transTrackerBtn = new JButton("Transaction Tracker", trackerIcon);
        transTrackerBtn.setBounds(0, 180, 180, 40);
        transTrackerBtn.setBackground(cs.darkPurple);
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
        
        dashboardTitle = new JLabel("Home");
        dashboardTitle.setBounds(30, 15, 200, 20);
        dashboardTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(dashboardTitle);
        
        linePanel = new JPanel();
        
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        welcomelbl = new JLabel("Welcome Back, ");
        welcomelbl.setBounds(30, 67, 200, 30);
        welcomelbl.setFont(new Font("", Font.BOLD, 24));
        mainContentPanel.add(welcomelbl);
        
        adminNamelbl = new JLabel(adminName);
        adminNamelbl.setBounds(210, 67, 300, 30);
        adminNamelbl.setFont(new Font("", Font.BOLD, 24));
        adminNamelbl.setForeground(cs.btnColorSelect);
        mainContentPanel.add(adminNamelbl);
        
        datelbl = new JLabel(currentDate);
        datelbl.setBounds(30, 103, 200, 20);
        datelbl.setForeground(cs.gray);
        mainContentPanel.add(datelbl);
        
        // account overview panel
        
        accountOverviewPanel = new JPanel();
        accountOverviewPanel.setLayout(null);
        accountOverviewPanel.setBounds(30, 150, 580, 245);
        accountOverviewPanel.setBackground(cs.white);
        accountOverviewPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        // test
        
        testBtn = new JButton("Retrieve");
        testBtn.setBounds(100, 100, 100, 40);
        testBtn.addActionListener(this);
        mainContentPanel.add(testBtn);
        
        accountOverviewTitlelbl = new JLabel("Account Overview"); 
        accountOverviewTitlelbl.setBounds(20, 20, 250, 20);
        accountOverviewTitlelbl.setFont(new Font("", Font.BOLD, 18));
        accountOverviewTitlelbl.setForeground(cs.darkerPurple);
        accountOverviewPanel.add(accountOverviewTitlelbl);
        
        totalAccountslbl = new JLabel(String.valueOf(totalAccountsCount));
        totalAccountslbl.setBounds(20, 55, 300, 30);
        totalAccountslbl.setFont(new Font("Arial", Font.BOLD, 36));
        totalAccountslbl.setForeground(cs.darkerPurple);
        accountOverviewPanel.add(totalAccountslbl);
        
        totalAccountsDesclbl = new JLabel("Total Registered Accounts");
        totalAccountsDesclbl.setBounds(20, 88, 300, 20);
        totalAccountsDesclbl.setForeground(cs.gray);
        accountOverviewPanel.add(totalAccountsDesclbl);
        
        activeUserslbl = new JLabel(String.valueOf(activeUsersCount) + " Active");
        activeUserslbl.setBounds(20, 130, 300, 25);
        activeUserslbl.setFont(new Font("Arial", Font.BOLD, 22));
        activeUserslbl.setForeground(cs.darkerPurple);
        accountOverviewPanel.add(activeUserslbl);
        
        activeUsersDesclbl = new JLabel("Currently active users");
        activeUsersDesclbl.setBounds(20, 153, 300, 20);
        activeUsersDesclbl.setForeground(cs.gray);
        accountOverviewPanel.add(activeUsersDesclbl);
        
        manageRolesBtn = new JButton("Manage Account Roles", accountsIcon);
        manageRolesBtn.setBounds(20, 180, 250, 45);
        manageRolesBtn.setBackground(cs.darkPurple);
        manageRolesBtn.setForeground(cs.white);
        manageRolesBtn.setFocusPainted(false);
        manageRolesBtn.setBorderPainted(false);
        
        manageRolesBtn.setHorizontalAlignment(SwingConstants.CENTER);
        manageRolesBtn.setMargin(new Insets(0, 0, 0, 10));
        manageRolesBtn.setIconTextGap(10);
        accountOverviewPanel.add(manageRolesBtn);
           
        mainContentPanel.add(accountOverviewPanel);
        
        // end account overview
        
        // requests overview panel
        
        requestOverviewPanel = new JPanel();
        requestOverviewPanel.setLayout(null);
        requestOverviewPanel.setBounds(635, 150, 580, 245);
        requestOverviewPanel.setBackground(cs.white);
        requestOverviewPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        requestOverviewTitlelbl = new JLabel("Requests Overview"); 
        requestOverviewTitlelbl.setBounds(20, 20, 250, 20);
        requestOverviewTitlelbl.setFont(new Font("", Font.BOLD, 18));
        requestOverviewTitlelbl.setForeground(cs.darkerPurple);
        requestOverviewPanel.add(requestOverviewTitlelbl);
        
        pendingRequestslbl = new JLabel(String.valueOf(pendingRequestsCount));
        pendingRequestslbl.setBounds(20, 55, 300, 30);
        pendingRequestslbl.setFont(new Font("Arial", Font.BOLD, 36));
        pendingRequestslbl.setForeground(cs.darkerPurple);
        requestOverviewPanel.add(pendingRequestslbl);
        
        pendingRequestsDesclbl = new JLabel("Pending Account Requests");
        pendingRequestsDesclbl.setBounds(20, 88, 300, 20);
        pendingRequestsDesclbl.setForeground(cs.gray);
        requestOverviewPanel.add(pendingRequestsDesclbl);
        
        approvedTodaylbl = new JLabel(String.valueOf(approvedTodayCount) + " Approved Today");
        approvedTodaylbl.setBounds(20, 130, 300, 25);
        approvedTodaylbl.setFont(new Font("Arial", Font.BOLD, 22));
        approvedTodaylbl.setForeground(cs.darkerPurple);
        requestOverviewPanel.add(approvedTodaylbl);
        
        approvedTodayDesclbl = new JLabel("Quick approval summary");
        approvedTodayDesclbl.setBounds(20, 153, 300, 20);
        approvedTodayDesclbl.setForeground(cs.gray);
        requestOverviewPanel.add(approvedTodayDesclbl);
        
        viewRequestsBtn = new JButton("View All Requests", reqIcon);
        viewRequestsBtn.setBounds(20, 180, 250, 45);
        viewRequestsBtn.setBackground(cs.darkPurple);
        viewRequestsBtn.setForeground(cs.white);
        viewRequestsBtn.setFocusPainted(false);
        viewRequestsBtn.setBorderPainted(false);
        
        viewRequestsBtn.setHorizontalAlignment(SwingConstants.CENTER);
        viewRequestsBtn.setMargin(new Insets(0, 0, 0, 10));
        viewRequestsBtn.setIconTextGap(10);
        requestOverviewPanel.add(viewRequestsBtn);
  
        mainContentPanel.add(requestOverviewPanel);
        
        // end requests overview
        
        // recent activity
        
        recentActivityPanel = new JPanel();
        recentActivityPanel.setLayout(null);
        recentActivityPanel.setBounds(30, 425, 1185, 460);
        recentActivityPanel.setBackground(cs.white);
        recentActivityPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        recentActivitylbl = new JLabel("Recent Activity"); 
        recentActivitylbl.setBounds(20, 20, 250, 20);
        recentActivitylbl.setFont(new Font("", Font.BOLD, 18));
        recentActivitylbl.setForeground(cs.darkerPurple);
        recentActivityPanel.add(recentActivitylbl);
        
        // table (objects papasok dito)
        
        recentActivitytbl = new JTable(recentActivityData, recentActivityColumns);
        recentActivitytbl.setRowHeight(40);
        recentActivitytbl.setFont(new Font("Arial", Font.PLAIN, 14));
        recentActivitytbl.setFocusable(false);
        recentActivitytbl.getTableHeader().setReorderingAllowed(false);
        recentActivitytbl.getTableHeader().setBackground(cs.darkPurple);
        recentActivitytbl.getTableHeader().setForeground(cs.white);
        recentActivitytbl.setSelectionBackground(cs.lightPurple);
        recentActivitytbl.setSelectionForeground(cs.white);
        recentActivitytbl.setShowGrid(false);
        recentActivitytbl.setDefaultEditor(Object.class, null);
        
        recentActivitytbl.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 14)
        );
        recentActivitytbl.getTableHeader().setPreferredSize(
            new Dimension(0, 45)
        );
        
        // no scroll
        
        recentActivityScroll = new JScrollPane(recentActivitytbl);
        
        recentActivityScroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_NEVER
        );

        recentActivityScroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        
        recentActivityScroll.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        recentActivityScroll.setBounds(20, 60, 1145, 380);
        recentActivityPanel.add(recentActivityScroll);
        
        mainContentPanel.add(recentActivityPanel);
        
        // end table
        
        // recent end
        
        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);
        
        // end content panel
        
        roleBtn.addActionListener(this);
        accRequestBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        transTrackerBtn.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // side bar
        
        if(e.getSource() == roleBtn){
            AccountRoleUI roleUI = new AccountRoleUI();
            roleUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == accRequestBtn){
            AccountRequestsUI reqUI = new AccountRequestsUI();
            reqUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == transTrackerBtn){
            new TransactionTrackerUI().setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == logoutBtn){
            LoginUI logUI = new LoginUI();
            logUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == testBtn){
            rs.printAllRegisteredUsers();
        }
        
        // side bar end
        
        // main content
        
        
        //
        
    }
}