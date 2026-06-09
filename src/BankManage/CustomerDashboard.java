package BankManage; 
import BankManage.AppService.SessionManage;
import BankManage.AppService.GetDateAndTime;
import BankManage.AppService.BankAccountService;
import BankManage.AccountModels.*;
import BankManage.AppService.NotificationService;
import BankManage.AppService.TransactionService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class CustomerDashboard extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();         
    GetDateAndTime dateTime = new GetDateAndTime();
    
    // panels
    
    private JPanel sidebarPanel, mainContentPanel, linePanel, balancePanel, savingsPanel, recentTransactPanel;
    
    // import images
    
    java.net.URL homeImgURL = CustomerDashboard.class.getResource("resources/home.png");

    private ImageIcon homeRaw = new ImageIcon(homeImgURL);
    private Image homeScale = homeRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon homeIcon = new ImageIcon(homeScale);
    
    java.net.URL transactImgURL = CustomerDashboard.class.getResource("resources/transact.png");
    
    private ImageIcon transactRaw = new ImageIcon(transactImgURL);
    private Image transactScale = transactRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon transactIcon = new ImageIcon(transactScale);
    
    java.net.URL balanceImgURL = CustomerDashboard.class.getResource("resources/balance.png");
    
    private ImageIcon balanceRaw = new ImageIcon(balanceImgURL);
    private Image balanceScale = balanceRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon balanceIcon = new ImageIcon(balanceScale);
    
    java.net.URL savingsImgURL = CustomerDashboard.class.getResource("resources/savings.png");
    
    private ImageIcon savingsRaw = new ImageIcon(savingsImgURL);
    private Image savingsScale = savingsRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon savingsIcon = new ImageIcon(savingsScale);
    
    java.net.URL accountsImgURL = CustomerDashboard.class.getResource("resources/accounts.png");
    
    private ImageIcon accountsRaw = new ImageIcon(accountsImgURL);
    private Image accountsScale = accountsRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon accountsIcon = new ImageIcon(accountsScale);
    
    java.net.URL logoutImgURL = CustomerDashboard.class.getResource("resources/logout.png");
    
    private ImageIcon logoutRaw = new ImageIcon(logoutImgURL);
    private Image logoutScale = logoutRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon logoutIcon = new ImageIcon(logoutScale);
    
    java.net.URL withdrawImgURL = CustomerDashboard.class.getResource("resources/withdraw.png");
    
    private ImageIcon withdrawRaw = new ImageIcon(withdrawImgURL);
    private Image withdrawScale = withdrawRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon withdrawIcon = new ImageIcon(withdrawScale);
    
    java.net.URL depositImgURL = CustomerDashboard.class.getResource("resources/deposit.png");
    
    private ImageIcon depositRaw = new ImageIcon(depositImgURL);
    private Image depositScale = depositRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon depositIcon = new ImageIcon(depositScale);
    
    java.net.URL transferImgURL = CustomerDashboard.class.getResource("resources/transfer.png");
    
    private ImageIcon transferRaw = new ImageIcon(transferImgURL);
    private Image transferScale = transferRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon transferIcon = new ImageIcon(transferScale);
    
    java.net.URL historyImgURL = CustomerDashboard.class.getResource("resources/history.png");
    
    private ImageIcon historyRaw = new ImageIcon(historyImgURL);
    private Image historyScale = historyRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon historyIcon = new ImageIcon(historyScale);
    
    // logo
    
    java.net.URL logoImgURL = CustomerDashboard.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));;
    
    // sidebar
    
    private final JButton homeBtn, transactBtn, balanceBtn, savingsBtn, accountsBtn, logoutBtn;
    private final JLabel logoName;
    
    // mainContentPanel
    
    private final JLabel dashboardTitle, welcomelbl, usrFName, datelbl;
    
    //
    
    // balance panel
    
    private final JLabel vaultbankBalbl, availBalancelbl, availlbl, quicklbl;
    private final JButton withdrawBtn, depositBtn, transferBtn;
    
    //
    
    // savings panel
    
    private final JLabel savingslbl, savingBalancelbl, savingavaillbl, savingquicklbl;
    private final JButton gotoSavingsbtn, gotoHistorybtn;
    
    //
    
    // recent panel
    
    private final JLabel recentlbl;
    private JTable recenttransacttbl;
    private DefaultTableModel tableModel;
    private JScrollPane recentnoScroll;
    
    protected String[] recentColumns = {
        "Transaction Info", "Name", "Account ID", "Purchase Date", "Status", "Amount", "Account Type"
    };
    
    private Timer timeTick;
    
    //
    
    private String fname = SessionManage.getCurrentUserDisplayName();
    private String date = dateTime.currentTime();
    private double totalBal = getTotalBal();
    private double currentTotalSavings;
    
    public CustomerDashboard() {

        setTitle("Dashboard - Home");
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
        
        // icon beside button
        
        homeBtn.setHorizontalAlignment(SwingConstants.LEFT);
        homeBtn.setIconTextGap(8);
        sidebarPanel.add(homeBtn);
        
        // transact
        
        transactBtn = new JButton("Transactions", transactIcon);
        transactBtn.setBounds(0, 100, 180, 40);
        transactBtn.setBackground(cs.darkPurple);
        transactBtn.setForeground(cs.white);
        transactBtn.setFocusPainted(false);
        transactBtn.setBorderPainted(false);
        
        // icon beside button
        
        transactBtn.setHorizontalAlignment(SwingConstants.LEFT);
        transactBtn.setIconTextGap(8);
        sidebarPanel.add(transactBtn);
        
        // balance
        
        balanceBtn = new JButton("Balance", balanceIcon);
        balanceBtn.setBounds(0, 140, 180, 40);
        balanceBtn.setBackground(cs.darkPurple);
        balanceBtn.setForeground(cs.white);
        balanceBtn.setFocusPainted(false);
        balanceBtn.setBorderPainted(false);
        
        // icon beside button
        
        balanceBtn.setHorizontalAlignment(SwingConstants.LEFT);
        balanceBtn.setIconTextGap(8);
        sidebarPanel.add(balanceBtn);
        
        // savings
        
        savingsBtn = new JButton("Savings", savingsIcon);
        savingsBtn.setBounds(0, 180, 180, 40);
        savingsBtn.setBackground(cs.darkPurple);
        savingsBtn.setForeground(cs.white);
        savingsBtn.setFocusPainted(false);
        savingsBtn.setBorderPainted(false);
        
        // icon beside button
        
        savingsBtn.setHorizontalAlignment(SwingConstants.LEFT);
        savingsBtn.setIconTextGap(8);
        sidebarPanel.add(savingsBtn);
        
        // accounts
        
        accountsBtn = new JButton("Accounts", accountsIcon);
        accountsBtn.setBounds(0, 220, 180, 40);
        accountsBtn.setBackground(cs.darkPurple);
        accountsBtn.setForeground(cs.white);
        accountsBtn.setFocusPainted(false);
        accountsBtn.setBorderPainted(false);
        
        // icon beside button
        
        accountsBtn.setHorizontalAlignment(SwingConstants.LEFT);
        accountsBtn.setIconTextGap(8);
        sidebarPanel.add(accountsBtn);

        // logout
        
        logoutBtn = new JButton("Logout", logoutIcon);
        logoutBtn.setBounds(0, 840, 180, 40);
        logoutBtn.setBackground(cs.darkPurple);
        logoutBtn.setForeground(cs.white);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorderPainted(false);
        
        // icon beside button
        
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
        dashboardTitle.setBounds(30, 15, 100, 20);
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
        
        usrFName = new JLabel(fname);
        usrFName.setBounds(210, 67, 500, 30);
        usrFName.setFont(new Font("", Font.BOLD, 24));
        usrFName.setForeground(cs.btnColorSelect);
        mainContentPanel.add(usrFName);
        
        datelbl = new JLabel(date);
        datelbl.setBounds(30, 103, 200, 20);
        datelbl.setForeground(cs.gray);
        mainContentPanel.add(datelbl);
        
        // bal panel
        
        balancePanel = new JPanel();
        balancePanel.setLayout(null);
        balancePanel.setBounds(30, 150, 580, 245);
        balancePanel.setBackground(cs.white);
        balancePanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        vaultbankBalbl = new JLabel("VaultBank Balance"); 
        vaultbankBalbl.setBounds(20, 20, 250, 20);
        vaultbankBalbl.setFont(new Font("", Font.BOLD, 18));
        vaultbankBalbl.setForeground(cs.darkerPurple);
        balancePanel.add(vaultbankBalbl);
        
        availBalancelbl = new JLabel("₱"+String.format("%,.2f", totalBal));
        availBalancelbl.setBounds(20, 65, 300, 30);
        availBalancelbl.setFont(new Font("Arial", Font.BOLD, 36));
        availBalancelbl.setForeground(cs.darkerPurple);
        balancePanel.add(availBalancelbl);
        
        availlbl = new JLabel("Checkings + Savings");
        availlbl.setBounds(20, 108, 150, 20);
        availlbl.setForeground(cs.gray);
        balancePanel.add(availlbl);
        
        quicklbl = new JLabel("Quick Actions");
        quicklbl.setBounds(20, 150, 150, 20);
        quicklbl.setForeground(cs.darkerPurple);
        balancePanel.add(quicklbl);
        
        withdrawBtn = new JButton("Withdraw", withdrawIcon);
        withdrawBtn.setBounds(20, 180, 170, 45);
        withdrawBtn.setBackground(cs.darkPurple);
        withdrawBtn.setForeground(cs.white);
        withdrawBtn.setFocusPainted(false);
        withdrawBtn.setBorderPainted(false);
        
        withdrawBtn.setHorizontalAlignment(SwingConstants.CENTER);
        withdrawBtn.setMargin(new Insets(0, 0, 0, 10));
        withdrawBtn.setIconTextGap(10);
        withdrawBtn.addActionListener(this);
        balancePanel.add(withdrawBtn);
        
        depositBtn = new JButton("Deposit", depositIcon);
        depositBtn.setBounds(205, 180, 170, 45);
        depositBtn.setBackground(cs.darkPurple);
        depositBtn.setForeground(cs.white);
        depositBtn.setFocusPainted(false);
        depositBtn.setBorderPainted(false);
        
        depositBtn.setHorizontalAlignment(SwingConstants.CENTER);
        depositBtn.setMargin(new Insets(0, 0, 0, 10));
        depositBtn.setIconTextGap(10);
        depositBtn.addActionListener(this);
        balancePanel.add(depositBtn);
        
        transferBtn = new JButton("Transfer", transferIcon);
        transferBtn.setBounds(390, 180, 170, 45);
        transferBtn.setBackground(cs.darkPurple);
        transferBtn.setForeground(cs.white);
        transferBtn.setFocusPainted(false);
        transferBtn.setBorderPainted(false);
        
        transferBtn.setHorizontalAlignment(SwingConstants.CENTER);
        transferBtn.setMargin(new Insets(0, 0, 0, 5));
        transferBtn.setIconTextGap(10);
        transferBtn.addActionListener(this);
        balancePanel.add(transferBtn);
           
        mainContentPanel.add(balancePanel);
        
        // end bal
        
        // savings overview
        
        savingsPanel = new JPanel();
        savingsPanel.setLayout(null);
        savingsPanel.setBounds(635, 150, 580, 245);
        savingsPanel.setBackground(cs.white);
        savingsPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        savingslbl = new JLabel("Savings Overview"); 
        savingslbl.setBounds(20, 20, 250, 20);
        savingslbl.setFont(new Font("", Font.BOLD, 18));
        savingslbl.setForeground(cs.darkerPurple);
        savingsPanel.add(savingslbl);
        
        savingBalancelbl = new JLabel("₱ 0.00");
        savingBalancelbl.setBounds(20, 65, 300, 30);
        savingBalancelbl.setFont(new Font("Arial", Font.BOLD, 36));
        savingBalancelbl.setForeground(cs.darkerPurple);
        savingsPanel.add(savingBalancelbl);

        savingavaillbl = new JLabel("Available");
        savingavaillbl.setBounds(20, 108, 150, 20);
        savingavaillbl.setForeground(cs.gray);
        savingsPanel.add(savingavaillbl);
        
        savingquicklbl = new JLabel("Quick Actions");
        savingquicklbl.setBounds(20, 150, 150, 20);
        savingquicklbl.setForeground(cs.darkerPurple);
        savingsPanel.add(savingquicklbl);
        
        gotoSavingsbtn = new JButton("Go To Savings", savingsIcon);
        gotoSavingsbtn.setBounds(20, 180, 262, 45);
        gotoSavingsbtn.setBackground(cs.darkPurple);
        gotoSavingsbtn.setForeground(cs.white);
        gotoSavingsbtn.setFocusPainted(false);
        gotoSavingsbtn.setBorderPainted(false);
        
        gotoSavingsbtn.setHorizontalAlignment(SwingConstants.CENTER);
        gotoSavingsbtn.setMargin(new Insets(0, 0, 0, 10));
        gotoSavingsbtn.setIconTextGap(10);
        gotoSavingsbtn.addActionListener(this);
        savingsPanel.add(gotoSavingsbtn);
        
        gotoHistorybtn = new JButton("Goal List", historyIcon);
        gotoHistorybtn.setBounds(298, 180, 262, 45);
        gotoHistorybtn.setBackground(cs.darkPurple);
        gotoHistorybtn.setForeground(cs.white);
        gotoHistorybtn.setFocusPainted(false);
        gotoHistorybtn.setBorderPainted(false);
        
        gotoHistorybtn.setHorizontalAlignment(SwingConstants.CENTER);
        gotoHistorybtn.setMargin(new Insets(0, 0, 0, 10));
        gotoHistorybtn.setIconTextGap(10);
        gotoHistorybtn.addActionListener(this);
        savingsPanel.add(gotoHistorybtn);
  
        mainContentPanel.add(savingsPanel);
        
        // end savings
        
        // recent transactions

        recentTransactPanel = new JPanel();
        recentTransactPanel.setLayout(null);
        recentTransactPanel.setBounds(30, 425, 1185, 460);
        recentTransactPanel.setBackground(cs.white);
        recentTransactPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));

        recentlbl = new JLabel("Recent Transactions");
        recentlbl.setBounds(20, 20, 250, 20);
        recentlbl.setFont(new Font("", Font.BOLD, 18));
        recentlbl.setForeground(cs.darkerPurple);
        recentTransactPanel.add(recentlbl);

        // Create table model
        tableModel = new DefaultTableModel(recentColumns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Create table with model
        recenttransacttbl = new JTable(tableModel);
        recenttransacttbl.setRowHeight(40);
        recenttransacttbl.setFont(new Font("Arial", Font.PLAIN, 14));
        recenttransacttbl.setFocusable(false);
        recenttransacttbl.getTableHeader().setReorderingAllowed(false);
        recenttransacttbl.getTableHeader().setBackground(cs.darkPurple);
        recenttransacttbl.getTableHeader().setForeground(cs.white);
        recenttransacttbl.setSelectionBackground(cs.lightPurple);
        recenttransacttbl.setSelectionForeground(cs.white);
        recenttransacttbl.setShowGrid(false);
        recenttransacttbl.setDefaultEditor(Object.class, null);

        recenttransacttbl.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        recenttransacttbl.getTableHeader().setPreferredSize(new Dimension(0, 45));

        // Create scroll pane
        recentnoScroll = new JScrollPane(recenttransacttbl);
        recentnoScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        recentnoScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        recentnoScroll.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        recentnoScroll.setBounds(20, 60, 1145, 380);
        recentTransactPanel.add(recentnoScroll);

        mainContentPanel.add(recentTransactPanel);

        // Load real recent transactions (max 6)
        loadRecentTransactions();
        
        mainContentPanel.add(recentTransactPanel);
        
        // end table
        
        // recent end
        
        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);
        
        // end content panel
        
        transactBtn.addActionListener(this);
        balanceBtn.addActionListener(this);
        savingsBtn.addActionListener(this);
        accountsBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        
        if (SessionManage.isCustomerLoggedIn()){
            CustomerModel customer = SessionManage.getCurrentCustomer();
            
            loadCustomerAccounts();
            loadRecentTransactions();
            
            // NOTIFICATIONS !
            showAccountNotifications(customer.getCustomerId());
            
            System.out.println("Logged in as: " + customer.getFirstName()); // debug
        }
        
        timeTick = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String timeGet = dateTime.currentTime();
                datelbl.setText(timeGet);
            }
        });
        
        timeTick.start();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CustomerModel customer = SessionManage.getCurrentCustomer();
        String userId = customer.getCustomerId();
        // side bar
        
        if(e.getSource() == transactBtn){
            TransactUI traUI = new TransactUI();
            traUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == balanceBtn){
            BalanceUI balUI = new BalanceUI();
            balUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == savingsBtn){
            SavingsUI saveUI = new SavingsUI();
            saveUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == accountsBtn){
            AccountMenuUI accMenUI = new AccountMenuUI();
            accMenUI.setVisible(true);
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
        
        else if(e.getSource() == withdrawBtn){
            BalanceUI balUI = new BalanceUI();
            balUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == depositBtn){
            BalanceUI balUI = new BalanceUI();
            balUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == transferBtn){
            BalanceUI balUI = new BalanceUI();
            balUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == gotoSavingsbtn){
            SavingsUI saveUI = new SavingsUI();
            saveUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == gotoHistorybtn){
            SavingsViewGoalsUI saveUI = new SavingsViewGoalsUI(userId, currentTotalSavings, "DashUI");
            saveUI.setVisible(true);
            dispose();
        }
        
        // side bar end
        
        // main content
        
        
        
        //
        
    }
    
    private void loadRecentTransactions() {
        if (!SessionManage.isCustomerLoggedIn() || tableModel == null) {
            return;
        }

        CustomerModel customer = SessionManage.getCurrentCustomer();
        TransactionService transactionService = new TransactionService();

        // get all transactions
        List<TransactionModel> allTransactions = transactionService.getAllTransactions();

        // filter for current user only
        List<TransactionModel> userTransactions = new ArrayList<>();
        for (TransactionModel t : allTransactions) {
            for (BankAccount acc : customerAccounts) {
                if (t.getAccountId() != null && t.getAccountId().equals(acc.getAccountId())) {
                    userTransactions.add(t);
                    break;
                }
            }
        }

        // limit
        int limit = Math.min(userTransactions.size(), 8);
        List<TransactionModel> recentList = userTransactions.subList(0, limit);

        // clear existing
        tableModel.setRowCount(0);

        // feeding data from sql
        for (TransactionModel t : recentList) {
            Object[] row = new Object[7];
            row[0] = t.getTransactionId();                          
            row[1] = t.getPurchaseName();                            
            row[2] = t.getAccountId();                               
            row[3] = t.getDate();                                    
            row[4] = t.getStatus();                                  
            row[5] = transactionService.formatAmount(t.getAmount()); 
            row[6] = t.getAccountType();                             

            tableModel.addRow(row);
        }
    }

    private List<BankAccount> customerAccounts = new ArrayList<>();

    private void loadCustomerAccounts() {
        if (!SessionManage.isCustomerLoggedIn()) {
            return;
        }

        CustomerModel customer = SessionManage.getCurrentCustomer();
        BankAccountService accountService = new BankAccountService();
        customerAccounts = accountService.getCustomerAccounts(customer.getCustomerId());

        // active accounts for balance
        Map<String, Double> activeTotals = calculateActiveTotalsByType(customerAccounts);

        double totalSavings = activeTotals.getOrDefault("Savings", 0.0);

        currentTotalSavings = totalSavings;

        savingBalancelbl.setText("₱" + String.format("%,.2f", totalSavings));

    }
    
    private double getTotalBal() {
        if (!SessionManage.isCustomerLoggedIn()) {
            return 0;
        }
        CustomerModel customer = SessionManage.getCurrentCustomer();
        BankAccountService accountService = new BankAccountService();
        java.util.List<BankAccount> accounts = accountService.getCustomerAccounts(customer.getCustomerId());

        double total = 0;
        for (BankAccount acc : accounts) {
            if ("Active".equalsIgnoreCase(acc.getStatus())) {
                total += acc.getBalance();
            }
        }
        return total;
    }

    private Map<String, Double> calculateActiveTotalsByType(java.util.List<BankAccount> accounts) {
        Map<String, Double> totals = new HashMap<>();

        for (BankAccount acc : accounts) {
            if (!"Active".equalsIgnoreCase(acc.getStatus())) {
                continue;
            }

            String type = acc.getAccountType();
            double currentTotal = totals.getOrDefault(type, 0.0);
            totals.put(type, currentTotal + acc.getBalance());
        }
        return totals;
    }
    
    private void showAccountNotifications(String customerId) {
        NotificationService notificationService = new NotificationService();
        List<NotificationModel> unread = notificationService.getUnreadNotifications(customerId);

        if (!unread.isEmpty()) {
            StringBuilder message = new StringBuilder("Account Status Update(s):\n\n");
            for (NotificationModel n : unread) {
                message.append("• ").append(n.getMessage()).append("\n\n");
            }

            JOptionPane.showMessageDialog(this, message.toString(), 
                "Account Notification", JOptionPane.INFORMATION_MESSAGE);

            // mark as read
            notificationService.markAllNotificationsAsRead(customerId);
        }
    }
    
}