package BankManage;
import BankManage.AccountModels.EmployeeModel;
import BankManage.AccountModels.BankAccount;
import BankManage.AppService.ActivityLogService;
import BankManage.AppService.BankAccountService;
import BankManage.AppService.NotificationService;
import BankManage.AppService.OneTimeCodeService;
import BankManage.AppService.SessionManage;
import BankManage.DataService.CustomerDataService;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountRoleUI extends JFrame implements ActionListener{

    ColorScheme cs = new ColorScheme();
    
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
    private JPanel mainContentPanel, linePanel, statsPanel, accountsListPanel;
    private JLabel dashboardTitle;
    private JPanel totalAccountsCard, activeAccountsCard, frozenAccountsCard, suspendedAccountsCard;

    // Search components
    private JTextField searchField;
    private JButton searchBtn, refreshBtn;

    // Account cards
    private JPanel[] accountCards;
    private JLabel[] accountIds, accountNames, accountBalances, accountStatuses;
    private JButton[] freezeBtns, suspendBtns, closeBtns, activateBtns;

    private JButton generateCodeBtn, viewCodesBtn;
    
    public AccountRoleUI() {
         
        if (SessionManage.isStaffLoggedIn()){
            EmployeeModel staff = SessionManage.getCurrentStaff();
            
            System.out.println("Logged in as: " + staff.getEmployeeFName()); // debug
        }
        
        setTitle("Admin Dashboard - Account Controls");
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
        
        dashboardTitle = new JLabel("Accounts Controls");
        dashboardTitle.setBounds(30, 15, 200, 20);
        dashboardTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(dashboardTitle);
        
        linePanel = new JPanel();
        
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        JLabel actionlbl = new JLabel("For Staff Creation:");
        actionlbl.setBounds(640, 67, 250, 40);
        actionlbl.setForeground(cs.darkerPurple);
        actionlbl.setFont(new Font("Arial", Font.BOLD, 16));
        mainContentPanel.add(actionlbl);
        
        generateCodeBtn = new JButton("Generate Access Code");
        generateCodeBtn.setBounds(805, 72, 200, 30);
        generateCodeBtn.setBackground(cs.darkPurple);
        generateCodeBtn.setForeground(cs.white);
        generateCodeBtn.setFont(new Font("Arial", Font.BOLD, 12));
        generateCodeBtn.setFocusPainted(false);
        generateCodeBtn.setBorderPainted(false);
        mainContentPanel.add(generateCodeBtn);

        viewCodesBtn = new JButton("View Available Codes");
        viewCodesBtn.setBounds(1015, 72, 200, 30);
        viewCodesBtn.setBackground(cs.darkPurple);
        viewCodesBtn.setForeground(cs.white);
        viewCodesBtn.setFont(new Font("Arial", Font.BOLD, 12));
        viewCodesBtn.setFocusPainted(false);
        viewCodesBtn.setBorderPainted(false);
        mainContentPanel.add(viewCodesBtn);

        generateCodeBtn.addActionListener(this);
        viewCodesBtn.addActionListener(this);

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
        statsPanel.setBounds(30, 120, 1190, 100);
        statsPanel.setOpaque(false);

        refreshStatsPanel();
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
        searchPanel.setBounds(30, 240, 1185, 40);
        searchPanel.setBackground(cs.white);
        searchPanel.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));

        JLabel searchLabel = new JLabel("Search by Acc ID:");
        searchLabel.setBounds(15, 8, 120, 25);
        searchLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        searchLabel.setForeground(new Color(80, 80, 80));
        searchPanel.add(searchLabel);

        searchField = new JTextField();
        searchField.setBounds(140, 8, 200, 25);
        searchField.setFont(new Font("Arial", Font.PLAIN, 13));
        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchField.setBackground(cs.lightgray);
        searchPanel.add(searchField);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(350, 5, 90, 30);
        searchBtn.setBackground(cs.darkPurple);
        searchBtn.setForeground(cs.white);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 12));
        searchBtn.setFocusPainted(false);
        searchBtn.setBorderPainted(false);
        searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchBtn.addActionListener(this);
        searchPanel.add(searchBtn);

        refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(450, 5, 90, 30);
        refreshBtn.setBackground(new Color(100,100,100));
        refreshBtn.setForeground(cs.white);
        refreshBtn.setFont(new Font("Arial", Font.BOLD, 12));
        refreshBtn.setFocusPainted(false);
        refreshBtn.setBorderPainted(false);
        refreshBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        refreshBtn.addActionListener(e -> {
            searchField.setText("");
            loadAccountsDynamically();
        });
        searchPanel.add(refreshBtn);   
        mainContentPanel.add(searchPanel);
    }

    private void initAccountsList() {
        accountsListPanel = new JPanel();
        accountsListPanel.setLayout(null);
        accountsListPanel.setBackground(new Color(245, 245, 245));

        JScrollPane accountsScrollPane = new JScrollPane(accountsListPanel);
        accountsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        accountsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        accountsScrollPane.setBorder(null);
        accountsScrollPane.setBounds(20, 300, 1200, 610);

        mainContentPanel.add(accountsScrollPane);

        loadAccountsDynamically();
    }

        // for refresh and /or viewing everything
    private void loadAccountsDynamically() {
        loadFilteredAccounts(""); // show all
    }

    // loading accounts gamit yung acc id nila
    private void loadFilteredAccounts(String keyword) {
        accountsListPanel.removeAll();

        BankAccountService accountService = new BankAccountService();
        CustomerDataService customerService = new CustomerDataService();

        List<BankAccount> allAccounts = accountService.getAllAccountsWithCustomerName();

        // filtering accounts
        List<BankAccount> filteredAccounts = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase().trim();

        if (lowerKeyword.isEmpty()) {
            filteredAccounts = allAccounts;
        } else {
            for (BankAccount acc : allAccounts) {
                String fullName = customerService.getFullNameByCustomerId(acc.getCustomerId()).toLowerCase();
                if (acc.getAccountId().toLowerCase().contains(lowerKeyword) ||
                    fullName.contains(lowerKeyword)) {
                    filteredAccounts.add(acc);
                }
            }
        }

        // array of buttons
        int size = filteredAccounts.size();
        accountCards = new JPanel[size];
        accountIds = new JLabel[size];
        accountNames = new JLabel[size];
        accountBalances = new JLabel[size];
        accountStatuses = new JLabel[size];
        freezeBtns = new JButton[size];
        suspendBtns = new JButton[size];
        closeBtns = new JButton[size];
        activateBtns = new JButton[size];

        int totalHeight = 10;

        for (int i = 0; i < filteredAccounts.size(); i++) {
            BankAccount acc = filteredAccounts.get(i);
            int yPos = i * 120 + 10;
            totalHeight = yPos + 120;

            String fullName = customerService.getFullNameByCustomerId(acc.getCustomerId());

            createAccountCard(
                acc.getAccountId(),
                acc.getCustomerId(),
                fullName,                           
                "₱" + acc.getBalance(),
                acc.getStatus(),
                i,
                yPos
            );
        }

        accountsListPanel.setPreferredSize(new Dimension(1200, Math.max(totalHeight, 610)));

        accountsListPanel.revalidate();
        accountsListPanel.repaint();
    }
    
    
    //Card per account 
    private void createAccountCard(String id, String cid, String fullName, String balance, String status, int index, int yPos) {
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

        JLabel nameLabel = new JLabel("User ID:");
        nameLabel.setBounds(180, 10, 100, 20);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        nameLabel.setForeground(new Color(120, 120, 120));
        card.add(nameLabel);

        accountNames[index] = new JLabel(cid);
        accountNames[index].setBounds(180, 30, 200, 20);
        accountNames[index].setFont(new Font("Arial", Font.BOLD, 13));
        accountNames[index].setForeground(new Color(50, 50, 50));
        card.add(accountNames[index]);

        JLabel emailLabel = new JLabel("Account Holder");
        emailLabel.setBounds(400, 10, 80, 20);
        emailLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        emailLabel.setForeground(new Color(120, 120, 120));
        card.add(emailLabel);

        JLabel emailValue = new JLabel(fullName);
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

        freezeBtns[index] = createCardButton("Freeze", cs.darkPurple, 20, 65, 95, 30);
        suspendBtns[index] = createCardButton("Suspend", cs.red, 125, 65, 95, 30);
        closeBtns[index] = createCardButton("Close", new Color(100, 100, 100), 230, 65, 95, 30);
        activateBtns[index] = createCardButton("Activate", cs.lime, 335, 65, 95, 30);

        String accountId = id; // from method parameter

        freezeBtns[index].addActionListener(e -> updateStatus(accountId, "Frozen"));
        suspendBtns[index].addActionListener(e -> updateStatus(accountId, "Suspended"));
        closeBtns[index].addActionListener(e -> updateStatus(accountId, "Closed"));
        activateBtns[index].addActionListener(e -> updateStatus(accountId, "Active"));
        
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
                return cs.lime;
            case "Frozen":
                return cs.darkPurple;
            case "Suspended":
                return cs.red;
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
        else if(e.getSource() == generateCodeBtn){
            ActivityLogService ls = new ActivityLogService();
            EmployeeModel staff = SessionManage.getCurrentStaff();

            generateNewAccessCode();
            
            ls.logActivity(
                "CODE GENERATION",
                staff.getEmployeeId(),
                staff.getEmployeePosition(),
                "Account Creation Code",
                staff.getEmployeeFName()
            );
            
        }
        
        else if(e.getSource() == searchBtn){
            String keyword = searchField.getText().trim();
            loadFilteredAccounts(keyword);
        }
        else if(e.getSource() == viewCodesBtn){
            ViewAccessCodesUI va = new ViewAccessCodesUI();
            va.setVisible(true);
            dispose();
        }
        
    }
    
    private void generateNewAccessCode() {
        OneTimeCodeService otcService = new OneTimeCodeService();
        String code = otcService.createNewAccessCode();

        if (code != null) {
            JOptionPane.showMessageDialog(this,
                "New Access Code Generated:\n\n" + code +
                "\n\nShare this with the new staff member.",
                "Access Code Generated", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to generate code.");
        }
    }
    
    private void updateStatus(String accountId, String newStatus) {
        // get acc details
        BankAccountService accountService = new BankAccountService();
        BankAccount account = accountService.getAccountById(accountId);
        EmployeeModel staff = SessionManage.getCurrentStaff();

        if (account == null) {
            JOptionPane.showMessageDialog(this, "Account not found.");
            return;
        }

        String oldStatus = account.getStatus();
        String customerId = account.getCustomerId();

        // ask for reason for status change
        String reason = JOptionPane.showInputDialog(this,
                "Enter reason for changing status to " + newStatus + ":",
                "Status Change Reason", JOptionPane.PLAIN_MESSAGE);

        if (reason == null || reason.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Reason is required to change account status.");
            return;
        }

        // action confirmation
        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to change account " + accountId + " from " + oldStatus + " to " + newStatus + "?",
                "Confirm Status Change", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }
        
        boolean updated = accountService.updateAccountStatus(accountId, newStatus);

        if (updated) {
            // if true, pass ung notification object
            NotificationService notificationService = new NotificationService();
            boolean notified = notificationService.createStatusChangeNotification(
                    customerId,
                    accountId,
                    oldStatus,
                    newStatus,
                    reason.trim()
            );
            
            ActivityLogService ls = new ActivityLogService();
            
            ls.logActivity(
                "ACC STATUS UPDATE",
                account.getCustomerId(),
                accountId,
                "Status to " + newStatus,
                staff.getEmployeeFName()
            );

            if (notified) {
                JOptionPane.showMessageDialog(this,
                        "Account status updated successfully.\nCustomer has been notified.",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Account status updated, but failed to send notification.",
                        "Partial Success", JOptionPane.WARNING_MESSAGE);
            }

            // refresh
            loadAccountsDynamically();

        } else {
            JOptionPane.showMessageDialog(this, "Failed to update account status.");
        }
    }
    
    private void refreshStatsPanel() {
        statsPanel.removeAll();

        BankAccountService ba = new BankAccountService();
        int totalAcc = ba.getTotalCnt();
        int activeAcc = ba.getActiveCnt("Active");
        int frozenAcc = ba.getFrozenCnt("Frozen");
        int suspendAcc = ba.getSuspendedCnt("Suspended");

        int cardWidth = 270;
        int spacing = 35;

        totalAccountsCard = createStatCard("Total Accounts", String.valueOf(totalAcc), new Color(67, 97, 238), 0, cardWidth);
        activeAccountsCard = createStatCard("Active Accounts", String.valueOf(activeAcc), cs.lime, cardWidth + spacing, cardWidth);
        frozenAccountsCard = createStatCard("Frozen Accounts", String.valueOf(frozenAcc), cs.darkPurple, 2 * (cardWidth + spacing), cardWidth);
        suspendedAccountsCard = createStatCard("Suspended Accounts", String.valueOf(suspendAcc), cs.red, 3 * (cardWidth + spacing), cardWidth);

        statsPanel.add(totalAccountsCard);
        statsPanel.add(activeAccountsCard);
        statsPanel.add(frozenAccountsCard);
        statsPanel.add(suspendedAccountsCard);

        statsPanel.revalidate();
        statsPanel.repaint();
    }

}
