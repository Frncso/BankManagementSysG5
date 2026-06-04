package BankManage; 
import BankManage.AccountModels.CustomerModel;
import BankManage.AppService.Encryption;
import BankManage.AppService.SessionManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BalanceUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    Encryption en = new Encryption();
    
    // panels
    
    private final JPanel sidebarPanel, mainContentPanel, linePanel, accountsColumnPanel, balancePanel, savingsPanel, actionsColumnPanel, quickActionsPanel, insightsPanel;
    
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
    
    // balance panel
    
    private final JLabel vaultbankBalbl, availBalancelbl, availlbl, quicklbl;
    private final JButton gotoTransactionbtn;
    protected String accNo = "ACC-1001";
    
    //
    
    // savings panel
    
    private final JLabel savingslbl, savingBalancelbl, savingavaillbl, savingquicklbl;
    private final JButton gotoSavingsbtn, gotoHistorybtn;
    
    //
    
    // quick panel
    
    private final JLabel manageFundslbl, inputAmtLbl, selectAcclbl, actionlbl;
    private final JButton withdrawBtn, depositBtn;
    private JTextField inputAmttxb;
    private JComboBox accountcmb;
    
    // not final
    private String[] accountSelect = {
        "Select Account",
        accNo+" Checking",
        accNo+" Saving"
    };
    
    //
    
    // financial insights
    
    int yAutoSize = 245;
    private JLabel insightlbl, totalBallbl, totallbl, breakdownlbl;
    private JLabel account1lbl, account2lbl;
    private double checkBal = 121502.60;
    private double saveBal = 30242.55;
    private double totalBal = checkBal + saveBal;
    
    //
    
    public BalanceUI() {
        
        if (SessionManage.isCustomerLoggedIn()){
            CustomerModel customer = SessionManage.getCurrentCustomer();
            
            System.out.println("Logged in as: " + en.decrypt(customer.getFirstName())); // debug
        }
        
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
        
        transactBtn = new JButton("Transact", transactIcon);
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
        
        // bal panel
        
        balancePanel = new JPanel();
        balancePanel.setLayout(null);
        balancePanel.setBounds(30, 80, 570, 245);
        balancePanel.setBackground(cs.white);
        balancePanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        vaultbankBalbl = new JLabel(accNo+" Checking Balance"); 
        vaultbankBalbl.setBounds(20, 20, 450, 20);
        vaultbankBalbl.setFont(new Font("", Font.BOLD, 18));
        vaultbankBalbl.setForeground(cs.darkerPurple);
        balancePanel.add(vaultbankBalbl);
        
        availBalancelbl = new JLabel("₱"+String.valueOf(checkBal));
        availBalancelbl.setBounds(20, 65, 300, 30);
        availBalancelbl.setFont(new Font("Arial", Font.BOLD, 36));
        availBalancelbl.setForeground(cs.darkerPurple);
        balancePanel.add(availBalancelbl);
        
        quicklbl = new JLabel("Check History");
        quicklbl.setBounds(20, 150, 150, 20);
        quicklbl.setForeground(cs.darkerPurple);
        balancePanel.add(quicklbl);
        
        availlbl = new JLabel("Available");
        availlbl.setBounds(20, 108, 150, 20);
        availlbl.setForeground(cs.gray);
        balancePanel.add(availlbl);
        
        gotoTransactionbtn = new JButton("Go to Transactions", transactIcon);
        gotoTransactionbtn.setBounds(20, 180, 530, 45);
        gotoTransactionbtn.setBackground(cs.darkPurple);
        gotoTransactionbtn.setForeground(cs.white);
        gotoTransactionbtn.setFocusPainted(false);
        gotoTransactionbtn.setBorderPainted(false);
        
        gotoTransactionbtn.setHorizontalAlignment(SwingConstants.CENTER);
        gotoTransactionbtn.setMargin(new Insets(0, 0, 0, 10));
        gotoTransactionbtn.setIconTextGap(10);
        gotoTransactionbtn.addActionListener(this);
        balancePanel.add(gotoTransactionbtn);
        
        accountsColumnPanel.add(balancePanel);
        
        // end bal
        
        // save panel
        
        savingsPanel = new JPanel();
        savingsPanel.setLayout(null);
        savingsPanel.setBounds(30, 350, 570, 245);
        savingsPanel.setBackground(cs.white);
        savingsPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        savingslbl = new JLabel(accNo+" Savings Balance"); 
        savingslbl.setBounds(20, 20, 450, 20);
        savingslbl.setFont(new Font("", Font.BOLD, 18));
        savingslbl.setForeground(cs.darkerPurple);
        savingsPanel.add(savingslbl);
        
        savingBalancelbl = new JLabel("₱"+String.valueOf(saveBal));
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
        gotoSavingsbtn.setBounds(20, 180, 255, 45);
        gotoSavingsbtn.setBackground(cs.darkPurple);
        gotoSavingsbtn.setForeground(cs.white);
        gotoSavingsbtn.setFocusPainted(false);
        gotoSavingsbtn.setBorderPainted(false);
        
        gotoSavingsbtn.setHorizontalAlignment(SwingConstants.CENTER);
        gotoSavingsbtn.setMargin(new Insets(0, 0, 0, 10));
        gotoSavingsbtn.setIconTextGap(10);
        gotoSavingsbtn.addActionListener(this);
        savingsPanel.add(gotoSavingsbtn);
        
        gotoHistorybtn = new JButton("Goal History", historyIcon);
        gotoHistorybtn.setBounds(295, 180, 255, 45);
        gotoHistorybtn.setBackground(cs.darkPurple);
        gotoHistorybtn.setForeground(cs.white);
        gotoHistorybtn.setFocusPainted(false);
        gotoHistorybtn.setBorderPainted(false);
        
        gotoHistorybtn.setHorizontalAlignment(SwingConstants.CENTER);
        gotoHistorybtn.setMargin(new Insets(0, 0, 0, 10));
        gotoHistorybtn.setIconTextGap(10);
        gotoHistorybtn.addActionListener(this);
        savingsPanel.add(gotoHistorybtn);
        
        accountsColumnPanel.add(savingsPanel);
        
        // end save
        
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
        
        accountcmb = new JComboBox<>(accountSelect);
        accountcmb.setBounds(295, 90, 255, 35);
        accountcmb.setSelectedIndex(0);
        accountcmb.setBackground(cs.white);
        accountcmb.setForeground(cs.gray);
        quickActionsPanel.add(accountcmb);
        
        actionlbl = new JLabel("Choose Action");
        actionlbl.setBounds(20, 150, 250, 20);
        actionlbl.setForeground(cs.darkerPurple);
        quickActionsPanel.add(actionlbl);
        
        depositBtn = new JButton("Deposit", depositIcon);
        depositBtn.setBounds(20, 180, 255, 45);
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
        withdrawBtn.setBounds(295, 180, 255, 45);
        withdrawBtn.setBackground(cs.darkPurple);
        withdrawBtn.setForeground(cs.white);
        withdrawBtn.setFocusPainted(false);
        withdrawBtn.setBorderPainted(false);
        withdrawBtn.addActionListener(this);
        
        withdrawBtn.setHorizontalAlignment(SwingConstants.CENTER);
        withdrawBtn.setMargin(new Insets(0, 0, 0, 10));
        withdrawBtn.setIconTextGap(10);
        quickActionsPanel.add(withdrawBtn);
        
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
        
        totalBallbl = new JLabel("₱"+String.valueOf(totalBal));
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
        
        account1lbl = new JLabel(accNo + " Checking Balance: ₱"+ String.valueOf(checkBal));
        account1lbl.setBounds(20, 180, 450, 20);
        account1lbl.setForeground(cs.gray);
        insightsPanel.add(account1lbl);
        
        account2lbl = new JLabel(accNo + " Saving Balance: ₱"+ String.valueOf(saveBal));
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
        
        
    }
}