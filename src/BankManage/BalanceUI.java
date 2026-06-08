package BankManage; 
import BankManage.AccountModels.BankAccount;
import BankManage.AccountModels.CustomerModel;
import BankManage.AppService.BankAccountService;
import BankManage.AppService.SessionManage;
import BankManage.AppService.TransactionService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BalanceUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    TransactionService transactSvc = new TransactionService();
    // panels
    
    private JPanel sidebarPanel, mainContentPanel, linePanel, accountsColumnPanel, actionsColumnPanel, quickActionsPanel, insightsPanel;
    
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
    
    java.net.URL historyImgURL = CustomerDashboard.class.getResource("resources/history.png");
    
    private ImageIcon historyRaw = new ImageIcon(historyImgURL);
    private Image historyScale = historyRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon historyIcon = new ImageIcon(historyScale);
    
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
    
    // logo
    
    java.net.URL logoImgURL = CustomerDashboard.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));;
    
    // sidebar
    
    private final JButton homeBtn, transactBtn, balanceBtn, savingsBtn, accountsBtn, logoutBtn;
    private final JLabel logoName;
    
    // main content
    
    private final JLabel dashboardTitle;
    
    // panel for scrolling
    
    private JPanel accountsListPanel;           // hold cards
    private JScrollPane accountsScrollPane;     // scroll capability
    
    // balance panel
    
    private JButton gotoTransactionbtn;
    protected String accNo = "ACC-1001";
    
    //
    
    // savings panel
    
    private JButton gotoSavingsbtn, gotoHistorybtn;
    
    //
    
    // quick panel
    
    private final JLabel manageFundslbl, inputAmtLbl, selectAcclbl, actionlbl;
    private final JButton withdrawBtn, depositBtn, transferBtn;
    private JTextField inputAmttxb;
  
    // combobox update
    
    private JComboBox<String> accountcmb;
    private DefaultComboBoxModel<String> accountComboModel;
    
    // financial insights
    
    int yAutoSize = 245;
    private JLabel insightlbl, totalBallbl, totallbl, breakdownlbl;
    private JLabel account1lbl, account2lbl;
    private double totalBal = getTotalBal();
    private double currentTotalSavings;
    
    //
    
    public BalanceUI() {
        
        setTitle("Dashboard - Balance");
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
        balanceBtn.setBackground(cs.btnColorSelect);
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
        
        dashboardTitle = new JLabel("Balance");
        dashboardTitle.setBounds(30, 15, 100, 20);
        dashboardTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(dashboardTitle);
        
        linePanel = new JPanel();
        
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        // accounts column panel
        
        accountsColumnPanel = new JPanel();
        accountsColumnPanel.setLayout(null);
        
        // Create dynamic accounts list
        accountsListPanel = new JPanel();
        accountsListPanel.setLayout(new BoxLayout(accountsListPanel, BoxLayout.Y_AXIS));

        accountsScrollPane = new JScrollPane(accountsListPanel);
        accountsScrollPane.setBorder(null);
        accountsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        accountsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        accountsScrollPane.setBounds(30, 80, 585, 760);

        // Add scroll pane into the left column
        accountsColumnPanel.add(accountsScrollPane);
        
        // actions column panel
        
        actionsColumnPanel = new JPanel();
        actionsColumnPanel.setLayout(null);
        
        // quick actions
        
        quickActionsPanel = new JPanel();
        quickActionsPanel.setLayout(null);
        quickActionsPanel.setBounds(15, 80, 570, 245);
        quickActionsPanel.setBackground(cs.white);
        quickActionsPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        actionsColumnPanel.add(quickActionsPanel);
        
        manageFundslbl = new JLabel("Manage Funds");
        manageFundslbl.setBounds(20, 20, 250, 20);
        manageFundslbl.setFont(new Font("", Font.BOLD, 18));
        manageFundslbl.setForeground(cs.darkerPurple);
        quickActionsPanel.add(manageFundslbl);
        
        inputAmtLbl = new JLabel("Input Amount");
        inputAmtLbl.setBounds(20, 60, 250, 20);
        inputAmtLbl.setForeground(cs.darkerPurple);
        quickActionsPanel.add(inputAmtLbl);
        
        inputAmttxb = new JTextField("");
        inputAmttxb.setBounds(20, 90, 255, 35);
        inputAmttxb.setBackground(cs.white);
        quickActionsPanel.add(inputAmttxb);
        
        selectAcclbl = new JLabel("Choose Account");
        selectAcclbl.setBounds(295, 60, 250, 20);
        selectAcclbl.setForeground(cs.darkerPurple);
        quickActionsPanel.add(selectAcclbl);
        
        accountComboModel = new DefaultComboBoxModel<>();
        accountcmb = new JComboBox<>(accountComboModel);
        accountcmb.setBounds(295, 90, 255, 35);
        accountcmb.setBackground(cs.white);
        accountcmb.setForeground(cs.gray);
        quickActionsPanel.add(accountcmb);
        
        actionlbl = new JLabel("Choose Action");
        actionlbl.setBounds(20, 150, 250, 20);
        actionlbl.setForeground(cs.darkerPurple);
        quickActionsPanel.add(actionlbl);
        
        depositBtn = new JButton("Deposit", depositIcon);
        depositBtn.setBounds(20, 180, 163, 45);
        depositBtn.setBackground(cs.darkPurple);
        depositBtn.setForeground(cs.white);
        depositBtn.setFocusPainted(false);
        depositBtn.setBorderPainted(false);
        depositBtn.addActionListener(this);
        
        depositBtn.setHorizontalAlignment(SwingConstants.CENTER);
        depositBtn.setMargin(new Insets(0, 0, 0, 10));
        depositBtn.setIconTextGap(10);
        quickActionsPanel.add(depositBtn);
        
        withdrawBtn = new JButton("Withdraw", withdrawIcon);
        withdrawBtn.setBounds(203, 180, 163, 45);
        withdrawBtn.setBackground(cs.darkPurple);
        withdrawBtn.setForeground(cs.white);
        withdrawBtn.setFocusPainted(false);
        withdrawBtn.setBorderPainted(false);
        withdrawBtn.addActionListener(this);
        
        withdrawBtn.setHorizontalAlignment(SwingConstants.CENTER);
        withdrawBtn.setMargin(new Insets(0, 0, 0, 10));
        withdrawBtn.setIconTextGap(10);
        quickActionsPanel.add(withdrawBtn);
        
        transferBtn = new JButton("Transfer", transferIcon);
        transferBtn.setBounds(386, 180, 164, 45);
        transferBtn.setBackground(cs.darkPurple);
        transferBtn.setForeground(cs.white);
        transferBtn.setFocusPainted(false);
        transferBtn.setBorderPainted(false);
        transferBtn.addActionListener(this);
        
        transferBtn.setHorizontalAlignment(SwingConstants.CENTER);
        transferBtn.setMargin(new Insets(0, 0, 0, 10));
        transferBtn.setIconTextGap(10);
        quickActionsPanel.add(transferBtn);
        
        mainContentPanel.add(actionsColumnPanel);
        
        // end input
        
        // brief history panel
        
        insightsPanel = new JPanel();
        insightsPanel.setLayout(null);
        insightsPanel.setBounds(15, 350, 570, yAutoSize);
        insightsPanel.setBackground(cs.white);
        insightsPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        insightlbl = new JLabel("Financial Insights"); 
        insightlbl.setBounds(20, 20, 450, 20);
        insightlbl.setFont(new Font("", Font.BOLD, 18));
        insightlbl.setForeground(cs.darkerPurple);
        insightsPanel.add(insightlbl);
        
        totalBallbl = new JLabel("₱"+String.format("%,.2f", totalBal));
        totalBallbl.setBounds(20, 65, 300, 30);
        totalBallbl.setFont(new Font("Arial", Font.BOLD, 36));
        totalBallbl.setForeground(cs.darkerPurple);
        insightsPanel.add(totalBallbl);
        
        totallbl = new JLabel("Total Balance Across Accounts");
        totallbl.setBounds(20, 108, 250, 20);
        totallbl.setForeground(cs.gray);
        insightsPanel.add(totallbl);
        
        breakdownlbl = new JLabel("Breakdown"); 
        breakdownlbl.setBounds(20, 150, 450, 20);
        breakdownlbl.setFont(new Font("", Font.BOLD, 18));
        breakdownlbl.setForeground(cs.darkerPurple);
        insightsPanel.add(breakdownlbl);
        
        account1lbl = new JLabel("Total Checking Balance: ₱0.00");
        account1lbl.setBounds(20, 180, 450, 20);
        account1lbl.setForeground(cs.gray);
        insightsPanel.add(account1lbl);
        
        account2lbl = new JLabel("Total Saving Balance: ₱0.00");
        account2lbl.setBounds(20, 200, 450, 20);
        account2lbl.setForeground(cs.gray);
        insightsPanel.add(account2lbl);
        
        actionsColumnPanel.add(insightsPanel);
        
        // end linked
        
        // end actions
        
        accountsColumnPanel.setBounds(0, 0, 630, 960);
        actionsColumnPanel.setBounds(630, 0, 630, 960);
        mainContentPanel.add(accountsColumnPanel);
        mainContentPanel.add(actionsColumnPanel);
        
        // end acc column panel
        

        //
        
        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);
        
        // end content panel
        
        transactBtn.addActionListener(this);
        homeBtn.addActionListener(this);
        savingsBtn.addActionListener(this);
        accountsBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        
        if (SessionManage.isCustomerLoggedIn()){
            CustomerModel customer = SessionManage.getCurrentCustomer();
            
            loadAndDisplayAccountsDynamically();
            loadCustomerAccounts();
            
            System.out.println("Logged in as: " + customer.getFirstName()); // debug
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == transactBtn){
            TransactUI traUI = new TransactUI();
            traUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == homeBtn){
            CustomerDashboard cusUI = new CustomerDashboard();
            cusUI.setVisible(true);
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
        
        else if(e.getSource() == gotoTransactionbtn){
            TransactUI trUI = new TransactUI();
            trUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == gotoHistorybtn){
            SavingsUI saveUI = new SavingsUI();
            saveUI.setVisible(true);
            dispose();
        }
        else if(e.getSource() == gotoSavingsbtn){
            SavingsUI saveUI = new SavingsUI();
            saveUI.setVisible(true);
            dispose();
        }
        else if(e.getSource() == depositBtn){
            handleDeposit();
        }
        else if(e.getSource() == withdrawBtn){
            handleWithdraw();
        }
        else if (e.getSource() == transferBtn){
            handleTransfer();
        }
    }
    
    private java.util.List<BankAccount> customerAccounts = new ArrayList<>(); // field

    private void loadCustomerAccounts() { // loading customers' accounts
        if (!SessionManage.isCustomerLoggedIn()) {
                return;
        }

        CustomerModel customer = SessionManage.getCurrentCustomer();

        BankAccountService accountService = new BankAccountService();
        customerAccounts = accountService.getCustomerAccounts(customer.getCustomerId());
        
        Map<String, Double> totalsByType = calculateTotalsByType(customerAccounts);
        
        double totalChecking = totalsByType.getOrDefault("Checking", 0.0);
        double totalSavings  = totalsByType.getOrDefault("Savings", 0.0);
        
        account1lbl.setText("Total Checking Balance: ₱" + String.format("%,.2f", totalChecking));
        account2lbl.setText("Total Savings Balance: ₱" + String.format("%,.2f", totalSavings));
        
        currentTotalSavings = totalSavings;
        updateAccountComboBox();
    }
    
    private void loadAndDisplayAccountsDynamically() {
        if (!SessionManage.isCustomerLoggedIn()) {
            return;
        }

        CustomerModel customer = SessionManage.getCurrentCustomer();

        // fetching accounts
        BankAccountService accountService = new BankAccountService();
        customerAccounts = accountService.getCustomerAccounts(customer.getCustomerId());

        // clearing previous cards for updation
        accountsListPanel.removeAll();

        // card per account
        for (BankAccount account : customerAccounts) {

            // creation ng account
            JPanel accountCard = createAccountCard(account);
            accountsListPanel.add(accountCard);
            accountsListPanel.add(Box.createRigidArea(new Dimension(0, 25))); // spacing
        }

        // refreshing yung scroll pane
        accountsListPanel.revalidate();
        accountsListPanel.repaint();
    }

    private JPanel createAccountCard(BankAccount account) {
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setPreferredSize(new Dimension(1140, 245));
        card.setMaximumSize(new Dimension(1140, 245));
        card.setBackground(cs.white);
        card.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));

        String accNo = account.getAccountId();
        String type = account.getAccountType();
        String status = account.getStatus();
        double balance = account.getBalance();

        if (type.equalsIgnoreCase("Checking")) {
            
            // checking panels
            
            JLabel title = new JLabel(accNo + " Checking Balance");
            title.setBounds(20, 20, 450, 20);
            title.setFont(new Font("", Font.BOLD, 18));
            title.setForeground(cs.darkerPurple);
            card.add(title);
            
            JLabel statusAcc = new JLabel(status);
            statusAcc.setBounds(480, 20, 300, 20);
            statusAcc.setFont(new Font("", Font.BOLD, 18));
            switch (status) {
                case "Active":
                    statusAcc.setForeground(cs.darkPurple);
                    break;
                case "Closed":
                    statusAcc.setForeground(cs.gray);
                    break;
                case "Frozen":
                    statusAcc.setForeground(cs.red);
                    break;
                case "Suspended":
                    statusAcc.setForeground(cs.red);
                    statusAcc.setBounds(440, 20, 300, 20);
                    break;
            }
            card.add(statusAcc);

            JLabel balanceLbl = new JLabel("₱" + String.format("%,.2f", balance));
            balanceLbl.setBounds(20, 65, 400, 30);
            balanceLbl.setFont(new Font("Arial", Font.BOLD, 36));
            balanceLbl.setForeground(cs.darkerPurple);
            card.add(balanceLbl);

            JLabel avail = new JLabel("Available");
            avail.setBounds(20, 108, 150, 20);
            avail.setForeground(cs.gray);
            
            switch(status){
                case "Closed":
                    avail.setText("Unavailable");
                    break;
                case "Frozen":
                    avail.setText("Unavailable");
                    break;
                case "Suspended":
                    avail.setText("Unavailable");
                    break;
            }
            
            card.add(avail);

            JLabel quick = new JLabel("Check History");
            quick.setBounds(20, 150, 150, 20);
            
            switch(status){
                case "Closed":
                    quick.setVisible(false);
                    break;
                case "Frozen":
                    quick.setVisible(false);
                    break;
                case "Suspended":
                    quick.setVisible(false);
                    break;
            }
            
            quick.setForeground(cs.darkerPurple);
            card.add(quick);

            JButton goToTrans = new JButton("Go to Transactions", transactIcon);
            goToTrans.setBounds(20, 180, 530, 45);
            goToTrans.setBackground(cs.darkPurple);
            goToTrans.setForeground(cs.white);
            goToTrans.setFocusPainted(false);
            goToTrans.setBorderPainted(false);
            goToTrans.setHorizontalAlignment(SwingConstants.CENTER);
            goToTrans.setMargin(new Insets(0, 0, 0, 10));
            goToTrans.setIconTextGap(10);
            
            switch(status){
                case "Closed":
                    goToTrans.setVisible(false);
                    break;
                case "Frozen":
                    goToTrans.setVisible(false);
                    break;
                case "Suspended":
                    goToTrans.setVisible(false);
                    break;
            }
            
            goToTrans.addActionListener(e -> {
                TransactUI trUI = new TransactUI();
                trUI.setVisible(true);
                dispose();
            });
            card.add(goToTrans);

        } else if (type.equalsIgnoreCase("Savings")) {
            CustomerModel customer = SessionManage.getCurrentCustomer();
            String userId = customer.getCustomerId();
            
            // savings panels
            JLabel title = new JLabel(accNo + " Savings Balance");
            title.setBounds(20, 20, 450, 20);
            title.setFont(new Font("", Font.BOLD, 18));
            title.setForeground(cs.darkerPurple);
            card.add(title);

            JLabel balanceLbl = new JLabel("₱" + String.format("%,.2f", balance));
            balanceLbl.setBounds(20, 65, 400, 30);
            balanceLbl.setFont(new Font("Arial", Font.BOLD, 36));
            balanceLbl.setForeground(cs.darkerPurple);
            card.add(balanceLbl);
            
            JLabel statusAcc = new JLabel(status);
            statusAcc.setBounds(480, 20, 300, 20);
            statusAcc.setFont(new Font("", Font.BOLD, 18));
            switch (status) {
                case "Active":
                    statusAcc.setForeground(cs.darkPurple);
                    break;
                case "Closed":
                    statusAcc.setForeground(cs.gray);
                    break;
                case "Frozen":
                    statusAcc.setForeground(cs.red);
                    break;
                case "Suspended":
                    statusAcc.setForeground(cs.red);
                    statusAcc.setBounds(440, 20, 300, 20);
                    break;
            }
            card.add(statusAcc);

            JLabel avail = new JLabel("Available");
            avail.setBounds(20, 108, 150, 20);
            avail.setForeground(cs.gray);
            
            switch(status){
                case "Closed":
                    avail.setText("Unavailable");
                    break;
                case "Frozen":
                    avail.setText("Unavailable");
                    break;
                case "Suspended":
                    avail.setText("Unavailable");
                    break;
            }
            
            card.add(avail);

            JLabel quick = new JLabel("Quick Actions");
            quick.setBounds(20, 150, 150, 20);
            quick.setForeground(cs.darkerPurple);
            
            switch(status){
                case "Closed":
                    quick.setVisible(false);
                    break;
                case "Frozen":
                    quick.setVisible(false);
                    break;
                case "Suspended":
                    quick.setVisible(false);
                    break;
            }
            
            card.add(quick);

            JButton goToSavings = new JButton("Go To Savings", savingsIcon);
            goToSavings.setBounds(20, 180, 255, 45);
            goToSavings.setBackground(cs.darkPurple);
            goToSavings.setForeground(cs.white);
            goToSavings.setFocusPainted(false);
            goToSavings.setBorderPainted(false);
            goToSavings.setHorizontalAlignment(SwingConstants.CENTER);
            goToSavings.setMargin(new Insets(0, 0, 0, 10));
            goToSavings.setIconTextGap(10);
            
            switch(status){
                case "Closed":
                    goToSavings.setVisible(false);
                    break;
                case "Frozen":
                    goToSavings.setVisible(false);
                    break;
                case "Suspended":
                    goToSavings.setVisible(false);
                    break;
            }
            
            goToSavings.addActionListener(e -> {
                SavingsUI saveUI = new SavingsUI();
                saveUI.setVisible(true);
                dispose();
            });
            card.add(goToSavings);

            JButton goalHistory = new JButton("Goal List", historyIcon);
            goalHistory.setBounds(295, 180, 255, 45);
            goalHistory.setBackground(cs.darkPurple);
            goalHistory.setForeground(cs.white);
            goalHistory.setFocusPainted(false);
            goalHistory.setBorderPainted(false);
            goalHistory.setHorizontalAlignment(SwingConstants.CENTER);
            goalHistory.setMargin(new Insets(0, 0, 0, 10));
            goalHistory.setIconTextGap(10);
            
            switch(status){
                case "Closed":
                    goalHistory.setVisible(false);
                    break;
                case "Frozen":
                    goalHistory.setVisible(false);
                    break;
                case "Suspended":
                    goalHistory.setVisible(false);
                    break;
            }
            
            goalHistory.addActionListener(e -> {
                SavingsViewGoalsUI saveUI = new SavingsViewGoalsUI(userId, currentTotalSavings, "BalUI");
                saveUI.setVisible(true);
                dispose();
            });
            card.add(goalHistory);
    }

    return card;
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

    private Map<String, Double> calculateTotalsByType(java.util.List<BankAccount> accounts) {
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
    
    private void updateAccountComboBox() {
        if (accountComboModel == null) {
            accountComboModel = new DefaultComboBoxModel<>();
            accountcmb = new JComboBox<>(accountComboModel);
            accountcmb.setBounds(295, 90, 255, 35);
            accountcmb.setBackground(cs.white);
            accountcmb.setForeground(cs.gray);
            quickActionsPanel.add(accountcmb);
        }

        accountComboModel.removeAllElements();
        accountComboModel.addElement("Select Account");

        for (BankAccount acc : customerAccounts) {
            // only active in combo box
            if ("Active".equalsIgnoreCase(acc.getStatus())) {
                String display = acc.getAccountId() + " " + acc.getAccountType();
                accountComboModel.addElement(display);
            }
        }
    }
    
    private java.util.List<BankAccount> getActiveAccounts() {
        java.util.List<BankAccount> activeAccounts = new ArrayList<>();
        for (BankAccount acc : customerAccounts) {
            if ("Active".equalsIgnoreCase(acc.getStatus())) {
                activeAccounts.add(acc);
            }
        }
        return activeAccounts;
    }
    
        // deposit
    private void handleDeposit() {
        String selected = (String) accountcmb.getSelectedItem();

        if (selected == null || selected.equals("Select Account")) {
            JOptionPane.showMessageDialog(this, "Please select an account.");
            return;
        }

        String accountId = selected.split(" ")[0];
        String amountText = inputAmttxb.getText().trim();

        if (amountText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an amount.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount entered.");
            return;
        }

        if (amount <= 0) {
            JOptionPane.showMessageDialog(this, "Amount must be greater than zero.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Do you want to deposit ₱" + String.format("%,.2f", amount) + " to " + accountId + "?",
                "Confirm Deposit", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = transactSvc.recordDeposit(
                    accountId,
                    getAccountTypeFromCombo(selected),
                    SessionManage.getCurrentUserDisplayName(),
                    amount,
                    java.time.LocalDate.now().toString()
            );

            if (success) {
                JOptionPane.showMessageDialog(this, "Deposit successful!");
                inputAmttxb.setText("");
                loadAndDisplayAccountsDynamically();
                loadCustomerAccounts();
            } else {
                JOptionPane.showMessageDialog(this, "Deposit failed. Please try again.");
            }
        }
    }

    private void handleWithdraw() {
        String selected = (String) accountcmb.getSelectedItem();

        if (selected == null || selected.equals("Select Account")) {
            JOptionPane.showMessageDialog(this, "Please select an account.");
            return;
        }

        String accountId = selected.split(" ")[0];
        String amountText = inputAmttxb.getText().trim();

        if (amountText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an amount.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount entered.");
            return;
        }

        if (amount <= 0) {
            JOptionPane.showMessageDialog(this, "Amount must be greater than zero.");
            return;
        }

        // Find selected account to check balance
        BankAccount selectedAccount = null;
        for (BankAccount acc : customerAccounts) {
            if (acc.getAccountId().equals(accountId)) {
                selectedAccount = acc;
                break;
            }
        }

        if (selectedAccount == null) {
            JOptionPane.showMessageDialog(this, "Account not found.");
            return;
        }

        if (amount > selectedAccount.getBalance()) {
            JOptionPane.showMessageDialog(this, "Insufficient balance for this withdrawal.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Do you want to withdraw ₱" + String.format("%,.2f", amount) + " from " + accountId + "?",
                "Confirm Withdrawal", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = transactSvc.recordWithdraw(
                    accountId,
                    getAccountTypeFromCombo(selected),
                    SessionManage.getCurrentUserDisplayName(),
                    amount,
                    java.time.LocalDate.now().toString()
            );

            if (success) {
                JOptionPane.showMessageDialog(this, "Withdrawal successful!");
                inputAmttxb.setText("");
                loadAndDisplayAccountsDynamically();
                loadCustomerAccounts();
            } else {
                JOptionPane.showMessageDialog(this, "Withdrawal failed. Please try again.");
            }
        }
    }
    
    // transfer
    private void handleTransfer() {
        String selected = (String) accountcmb.getSelectedItem();

        if (selected == null || selected.equals("Select Account")) {
            JOptionPane.showMessageDialog(this, "Please select an account to transfer from.");
            return;
        }

        String fromAccountId = selected.split(" ")[0];

        // Get list of active accounts (excluding current one)
        java.util.List<String> activeAccounts = new ArrayList<>();
        for (BankAccount acc : customerAccounts) {
            if ("Active".equalsIgnoreCase(acc.getStatus()) && !acc.getAccountId().equals(fromAccountId)) {
                activeAccounts.add(acc.getAccountId() + " " + acc.getAccountType());
            }
        }

        if (activeAccounts.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No other active accounts available for transfer.");
            return;
        }

        JComboBox<String> toAccountCombo = new JComboBox<>(activeAccounts.toArray(new String[0]));
        toAccountCombo.setFont(new Font("Arial", Font.PLAIN, 14));

        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.add(new JLabel("Transfer to:"));
        panel.add(toAccountCombo);

        int result = JOptionPane.showConfirmDialog(this, panel,
                "Select Destination Account", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result != JOptionPane.OK_OPTION) return;

        String toAccountDisplay = (String) toAccountCombo.getSelectedItem();
        String toAccountId = toAccountDisplay.split(" ")[0];

        String amountText = inputAmttxb.getText().trim();
        if (amountText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an amount to transfer.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount.");
            return;
        }

        if (amount <= 0) {
            JOptionPane.showMessageDialog(this, "Amount must be greater than zero.");
            return;
        }

        // source balance
        BankAccount fromAccount = null;
        for (BankAccount acc : customerAccounts) {
            if (acc.getAccountId().equals(fromAccountId)) {
                fromAccount = acc;
                break;
            }
        }

        if (fromAccount == null || amount > fromAccount.getBalance()) {
            JOptionPane.showMessageDialog(this, "Insufficient balance for transfer.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Transfer ₱" + String.format("%,.2f", amount) + " from " + fromAccountId + " to " + toAccountId + "?",
                "Confirm Transfer", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            boolean success = transactSvc.recordTransfer(
                    fromAccountId,
                    toAccountId,
                    fromAccount.getAccountType(),
                    SessionManage.getCurrentUserDisplayName(),
                    amount,
                    java.time.LocalDate.now().toString(),
                    "Transfer from " + fromAccountId + " to " + toAccountId
            );

            if (success) {
                JOptionPane.showMessageDialog(this, "Transfer successful!");
                inputAmttxb.setText("");
                loadAndDisplayAccountsDynamically();
                loadCustomerAccounts();
            } else {
                JOptionPane.showMessageDialog(this, "Transfer failed.");
            }
        }
    }
    
    private String getAccountTypeFromCombo(String selectedItem) {
        if (selectedItem == null || selectedItem.equals("Select Account")) {
            return "";
        }
        String[] parts = selectedItem.split(" ");
        return parts.length > 1 ? parts[1] : "";
    }
    
}