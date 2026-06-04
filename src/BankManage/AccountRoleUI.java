package BankManage;
import BankManage.AppService.Encryption;
import BankManage.AccountModels.EmployeeModel;
import BankManage.AppService.SessionManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccountRoleUI extends JFrame implements ActionListener{

    ColorScheme cs = new ColorScheme();
    Encryption en = new Encryption();
    
    java.net.URL homeImgURL = CustomerDashboard.class.getResource("resources/home.png");
    private ImageIcon homeRaw = new ImageIcon(homeImgURL);
    private Image homeScale = homeRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon homeIcon = new ImageIcon(homeScale);

    java.net.URL accountsImgURL = CustomerDashboard.class.getResource("resources/accounts.png");
    private ImageIcon accountsRaw = new ImageIcon(accountsImgURL);
    private Image accountsScale = accountsRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon accountsIcon = new ImageIcon(accountsScale);

    java.net.URL logoutImgURL = CustomerDashboard.class.getResource("resources/logout.png");
    private ImageIcon logoutRaw = new ImageIcon(logoutImgURL);
    private Image logoutScale = logoutRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon logoutIcon = new ImageIcon(logoutScale);

    java.net.URL logoImgURL = CustomerDashboard.class.getResource("resources/bluewhiteLogo.png");
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

    // Sidebar components
    private JPanel sidebarPanel;
    private JButton homeBtn, roleBtn, accRequestBtn, transTrackerBtn, logoutBtn;
    private JLabel logoName;

    // Main content components
    private JPanel mainContentPanel, headerPanel, statsPanel, accountsListPanel;
    private JLabel welcomeLabel, dateLabel, pageTitleLabel;
    private JPanel totalAccountsCard, activeAccountsCard, frozenAccountsCard, suspendedAccountsCard;

    // Search components
    private JTextField searchField;
    private JButton searchBtn, refreshBtn;

    // Account cards
    private JPanel[] accountCards;
    private JLabel[] accountIds, accountNames, accountBalances, accountStatuses;
    private JButton[] freezeBtns, suspendBtns, closeBtns, activateBtns;

    public AccountRoleUI() {
        
        if (SessionManage.isStaffLoggedIn()){
            EmployeeModel staff = SessionManage.getCurrentStaff();
            
            System.out.println("Logged in as: " + en.decrypt(staff.getEmployeeFName())); // debug
        }
        
        setTitle("Admin Dashboard - Account Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1440, 960);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(245, 245, 245));

        initSidebar();
        initMainContent();

        setVisible(true);
    }

    private void initSidebar() {
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(null);
        sidebarPanel.setBackground(cs.purple);
        sidebarPanel.setBounds(0, 0, 180, 960);

        // Logo Name
        logoName = new JLabel("VAULTBANK");
        logoName.setBounds(52, 14, 130, 30);
        logoName.setForeground(cs.white);
        logoName.setFont(new Font("Cascadia Code", Font.BOLD, 20));
        sidebarPanel.add(logoName);

        // Logo Image
        logo.setBounds(12, 15, 30, 30);
        sidebarPanel.add(logo);

        // Home Button
        homeBtn = new JButton("Home", homeIcon);
        homeBtn.setBounds(0, 60, 180, 40);
        homeBtn.setBackground(cs.darkPurple);
        homeBtn.setForeground(cs.white);
        homeBtn.setFocusPainted(false);
        homeBtn.setBorderPainted(false);
        homeBtn.setHorizontalAlignment(SwingConstants.LEFT);
        homeBtn.setIconTextGap(8);
        sidebarPanel.add(homeBtn);

        // Account Role Button (this will be the active/selected one)
        roleBtn = new JButton("Account Controls", accountsIcon);
        roleBtn.setBounds(0, 100, 180, 40);
        roleBtn.setBackground(cs.btnColorSelect);
        roleBtn.setForeground(cs.white);
        roleBtn.setFocusPainted(false);
        roleBtn.setBorderPainted(false);
        roleBtn.setHorizontalAlignment(SwingConstants.LEFT);
        roleBtn.setIconTextGap(8);
        sidebarPanel.add(roleBtn);

        // Account Requests Button
        accRequestBtn = new JButton("Account Requests", reqIcon);
        accRequestBtn.setBounds(0, 140, 180, 40);
        accRequestBtn.setBackground(cs.darkPurple);
        accRequestBtn.setForeground(cs.white);
        accRequestBtn.setFocusPainted(false);
        accRequestBtn.setBorderPainted(false);
        accRequestBtn.setHorizontalAlignment(SwingConstants.LEFT);
        accRequestBtn.setIconTextGap(8);
        sidebarPanel.add(accRequestBtn);

        // Transaction Tracker Button
        transTrackerBtn = new JButton("Transaction Tracker", trackerIcon);
        transTrackerBtn.setBounds(0, 180, 180, 40);
        transTrackerBtn.setBackground(cs.darkPurple);
        transTrackerBtn.setForeground(cs.white);
        transTrackerBtn.setFocusPainted(false);
        transTrackerBtn.setBorderPainted(false);
        transTrackerBtn.setHorizontalAlignment(SwingConstants.LEFT);
        transTrackerBtn.setIconTextGap(8);
        sidebarPanel.add(transTrackerBtn);

        // Logout Button
        logoutBtn = new JButton("Logout", logoutIcon);
        logoutBtn.setBounds(0, 840, 180, 40);
        logoutBtn.setBackground(cs.darkPurple);
        logoutBtn.setForeground(cs.white);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
        logoutBtn.setIconTextGap(8);
        sidebarPanel.add(logoutBtn);

        add(sidebarPanel);
        homeBtn.addActionListener(this);
        roleBtn.addActionListener(this);
        accRequestBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        transTrackerBtn.addActionListener(this);
    }

    private void initMainContent() {
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        mainContentPanel.setBackground(new Color(245, 245, 245));
        mainContentPanel.setBounds(180, 0, 1260, 960);

        headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.setBackground(cs.white);
        headerPanel.setBounds(20, 20, 1220, 80);
        headerPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230, 230)));

        pageTitleLabel = new JLabel("Account Management");
        pageTitleLabel.setBounds(20, 20, 300, 30);
        pageTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        pageTitleLabel.setForeground(cs.darkPurple);
        headerPanel.add(pageTitleLabel);

        welcomeLabel = new JLabel("Welcome Back, Admin Juan");
        welcomeLabel.setBounds(20, 50, 250, 20);
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        welcomeLabel.setForeground(new Color(120, 120, 120));
        headerPanel.add(welcomeLabel);

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        dateLabel = new JLabel(today.format(formatter));
        dateLabel.setBounds(1080, 25, 120, 20);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        dateLabel.setForeground(new Color(120, 120, 120));
        headerPanel.add(dateLabel);

        mainContentPanel.add(headerPanel);

        // Stats Cards Panel
        initStatsPanel();

        // Search Panel
        initSearchPanel();

        // Accounts List Panel
        initAccountsList();

        add(mainContentPanel);
    }

    private void initStatsPanel() {
        statsPanel = new JPanel();
        statsPanel.setLayout(null);
        statsPanel.setBounds(20, 120, 1220, 100);
        statsPanel.setOpaque(false);

        int cardWidth = 290;
        int spacing = 20;
        
        totalAccountsCard = createStatCard("Total Accounts", "8", new Color(67, 97, 238), 0, cardWidth);
        activeAccountsCard = createStatCard("Active Accounts", "4", new Color(16, 185, 129), cardWidth + spacing, cardWidth);
        frozenAccountsCard = createStatCard("Frozen Accounts", "2", new Color(29, 198, 251), 2 * (cardWidth + spacing), cardWidth);
        suspendedAccountsCard = createStatCard("Suspended Accounts", "1", new Color(239, 68, 68), 3 * (cardWidth + spacing), cardWidth);

        statsPanel.add(totalAccountsCard);
        statsPanel.add(activeAccountsCard);
        statsPanel.add(frozenAccountsCard);
        statsPanel.add(suspendedAccountsCard);

        mainContentPanel.add(statsPanel);
    }

    private JPanel createStatCard(String title, String value, Color color, int xPos, int width) {
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(cs.white);
        card.setBounds(xPos, 0, width, 100);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setBounds(15, 15, width - 30, 20);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        titleLabel.setForeground(new Color(120, 120, 120));
        card.add(titleLabel);

        JLabel valueLabel = new JLabel(value);
        valueLabel.setBounds(15, 40, width - 30, 35);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 28));
        valueLabel.setForeground(color);
        card.add(valueLabel);

        // Color accent bar
        JPanel accentBar = new JPanel();
        accentBar.setBackground(color);
        accentBar.setBounds(0, 0, 5, 100);
        card.add(accentBar);

        return card;
    }

    private void initSearchPanel() {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(null);
        searchPanel.setBounds(20, 240, 1220, 40);
        searchPanel.setBackground(cs.white);
        searchPanel.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));

        JLabel searchLabel = new JLabel("Search by ID:");
        searchLabel.setBounds(15, 8, 100, 25);
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        searchLabel.setForeground(new Color(80, 80, 80));
        searchPanel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(120, 8, 200, 25);
        searchField.setFont(new Font("Arial", Font.PLAIN, 13));
        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchPanel.add(searchField);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(330, 5, 80, 30);
        searchBtn.setBackground(new Color(67, 97, 238));
        searchBtn.setForeground(cs.white);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 12));
        searchBtn.setFocusPainted(false);
        searchBtn.setBorderPainted(false);
        searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchPanel.add(searchBtn);

        refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(420, 5, 90, 30);
        refreshBtn.setBackground(new Color(100, 100, 100));
        refreshBtn.setForeground(cs.white);
        refreshBtn.setFont(new Font("Arial", Font.BOLD, 12));
        refreshBtn.setFocusPainted(false);
        refreshBtn.setBorderPainted(false);
        refreshBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchPanel.add(refreshBtn);

        mainContentPanel.add(searchPanel);
    }

    private void initAccountsList() {
        accountsListPanel = new JPanel();
        accountsListPanel.setLayout(null);
        accountsListPanel.setBackground(new Color(245, 245, 245));
        accountsListPanel.setBounds(20, 300, 1220, 610);

        String[][] accounts = {
            {"ACC-1001", "Inigo Dela Cruz", "Inigodelacruz@email.com", "₱151,745.15", "Active"},
            {"ACC-1002", "Inigo Santos", "Inigosantos@email.com", "₱89,250.00", "Active"},
            {"ACC-1003", "Inigo Rizal", "Inigorizal@email.com", "₱35,000.00", "Frozen"},
            {"ACC-1004", "Ingi Bonifacio", "Ingibonifacio@email.com", "₱12,750.50", "Suspended"},
            {"ACC-1005", "Melvin Malon Silang", "MelvinMalonsilang@email.com", "₱0.00", "Closed"}
        };

        accountCards = new JPanel[accounts.length];
        accountIds = new JLabel[accounts.length];
        accountNames = new JLabel[accounts.length];
        accountBalances = new JLabel[accounts.length];
        accountStatuses = new JLabel[accounts.length];
        freezeBtns = new JButton[accounts.length];
        suspendBtns = new JButton[accounts.length];
        closeBtns = new JButton[accounts.length];
        activateBtns = new JButton[accounts.length];

        for (int i = 0; i < accounts.length; i++) {
            int yPos = i * 120 + 10;
            createAccountCard(accounts[i][0], accounts[i][1], accounts[i][2], accounts[i][3], accounts[i][4], i, yPos);
        }

        mainContentPanel.add(accountsListPanel);
    }

    //Card per account 
    private void createAccountCard(String id, String name, String email, String balance, String status, int index, int yPos) {
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setBackground(cs.white);
        card.setBounds(10, yPos, 1200, 110);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(230, 230, 230)),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        accountsListPanel.add(card);

        JPanel statusIndicator = new JPanel();
        Color statusColor = getStatusColor(status);
        statusIndicator.setBackground(statusColor);
        statusIndicator.setBounds(0, 0, 5, 110);
        card.add(statusIndicator);

        JLabel idLabel = new JLabel("Account ID:");
        idLabel.setBounds(20, 10, 80, 20);
        idLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        idLabel.setForeground(new Color(120, 120, 120));
        card.add(idLabel);

        accountIds[index] = new JLabel(id);
        accountIds[index].setBounds(20, 30, 150, 20);
        accountIds[index].setFont(new Font("ArialI", Font.BOLD, 13));
        accountIds[index].setForeground(new Color(50, 50, 50));
        card.add(accountIds[index]);

        JLabel nameLabel = new JLabel("Account Holder:");
        nameLabel.setBounds(180, 10, 100, 20);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        nameLabel.setForeground(new Color(120, 120, 120));
        card.add(nameLabel);

        accountNames[index] = new JLabel(name);
        accountNames[index].setBounds(180, 30, 200, 20);
        accountNames[index].setFont(new Font("Arial", Font.BOLD, 13));
        accountNames[index].setForeground(new Color(50, 50, 50));
        card.add(accountNames[index]);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(400, 10, 80, 20);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        emailLabel.setForeground(new Color(120, 120, 120));
        card.add(emailLabel);

        JLabel emailValue = new JLabel(email);
        emailValue.setBounds(400, 30, 250, 20);
        emailValue.setFont(new Font("Arial", Font.PLAIN, 12));
        emailValue.setForeground(new Color(100, 100, 100));
        card.add(emailValue);

        JLabel balanceLabel = new JLabel("Balance:");
        balanceLabel.setBounds(700, 10, 80, 20);
        balanceLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        balanceLabel.setForeground(new Color(120, 120, 120));
        card.add(balanceLabel);

        accountBalances[index] = new JLabel(balance);
        accountBalances[index].setBounds(700, 30, 150, 20);
        accountBalances[index].setFont(new Font("Arial", Font.BOLD, 14));
        accountBalances[index].setForeground(new Color(16, 185, 129));
        card.add(accountBalances[index]);

        JLabel statusLabel = new JLabel("Status:");
        statusLabel.setBounds(880, 10, 80, 20);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        statusLabel.setForeground(new Color(120, 120, 120));
        card.add(statusLabel);

        accountStatuses[index] = new JLabel(status);
        accountStatuses[index].setBounds(880, 30, 100, 20);
        accountStatuses[index].setFont(new Font("Arial", Font.BOLD, 12));
        accountStatuses[index].setForeground(statusColor);
        card.add(accountStatuses[index]);

        freezeBtns[index] = createCardButton("Freeze", new Color(29, 198, 251), 20, 65, 95, 30);
        suspendBtns[index] = createCardButton("Suspend", new Color(239, 68, 68), 125, 65, 95, 30);
        closeBtns[index] = createCardButton("Close", new Color(139, 69, 19), 230, 65, 95, 30);
        activateBtns[index] = createCardButton("Activate", new Color(16, 185, 129), 335, 65, 95, 30);

        card.add(freezeBtns[index]);
        card.add(suspendBtns[index]);
        card.add(closeBtns[index]);
        card.add(activateBtns[index]);

        accountCards[index] = card;
    }

    private JButton createCardButton(String text, Color color, int x, int y, int width, int height) {
        JButton btn = new JButton(text);
        btn.setBounds(x, y, width, height);
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 11));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    
    // Taga palit ng color ng card depending on acc status
    private Color getStatusColor(String status) {
        switch (status) {
            case "Active":
                return new Color(16, 185, 129);
            case "Frozen":
                return new Color(29, 198, 251);
            case "Suspended":
                return new Color(239, 68, 68);
            case "Closed":
                return new Color(100, 100, 100);
            default:
                return new Color(120, 120, 120);
        }
    }
    
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == homeBtn){
            AdminDashboard ad = new AdminDashboard();
            ad.setVisible(true);
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
        
    }
    

}
