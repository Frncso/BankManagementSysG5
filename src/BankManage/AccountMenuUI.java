package BankManage; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

public class AccountMenuUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    
    // panels
    
    private JPanel sidebarPanel, mainContentPanel, linePanel; // gamitin nyo mainContentPanel para mag lagay ng content na hindi mag ooverlap kay sidebar
    
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
    
    java.net.URL withdrawImgURL = CustomerDashboard.class.getResource("resources/withdraw.png");
    
    private ImageIcon withdrawRaw = new ImageIcon(withdrawImgURL);
    private Image withdrawScale = withdrawRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon withdrawIcon = new ImageIcon(withdrawScale);
    
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
    
     java.net.URL transferImgURL = CustomerDashboard.class.getResource("resources/transfer.png");
    
    private ImageIcon transferRaw = new ImageIcon(transferImgURL);
    private Image transferScale = transferRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon transferIcon = new ImageIcon(transferScale);
    
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
    private final JLabel logoName, totalbankBalbl, availBalancelbl, welcomelbl, accCount;
    private final JLabel totalSavings, savingsAmnt, checkingLbl, checkingAmnt, otherLbl, otherAmnt;
    private final JButton addAcc;
    private final JTextField searchField;
    
    // components for historyPanel headers
    private final JLabel accountHeader, typeHeader, customerHeader, balanceHeader;
    
    // components for row 1
    private final JLabel account1, type1, customer1, balance1;
    private final JLabel account2, type2, customer2, balance2;

    
    // main
    
    private JLabel dashboardTitle;
    private JPanel balancePanel, savingsPanel, checkingPanel, othersPanel, historyPanel;
    
    // separator panels
    private JPanel separator;
    
    
    //
    
    public AccountMenuUI() {
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
        accountsBtn.setBackground(cs.btnColorSelect);
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
        
        dashboardTitle = new JLabel("Accounts");
        dashboardTitle.setBounds(30, 15, 100, 20);
        dashboardTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(dashboardTitle);
        
        linePanel = new JPanel();
        
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        
        
        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);
        
        welcomelbl = new JLabel("Account Management");
        welcomelbl.setBounds(30, 67, 300, 30);
        welcomelbl.setFont(new Font("", Font.BOLD, 24));
        mainContentPanel.add(welcomelbl);
        
        accCount = new JLabel("2 accounts");
        accCount.setBounds(30, 85, 200, 30);
        accCount.setFont(new Font("", Font.BOLD, 12));
        mainContentPanel.add(accCount);
        
        addAcc = new JButton("+ New Account");
        addAcc.setBounds(1030, 65, 170, 45);
        addAcc.setBackground(cs.darkPurple);
        addAcc.setForeground(cs.white);
        addAcc.setFocusPainted(false);
        addAcc.setBorderPainted(false);
        mainContentPanel.add(addAcc);
        
        balancePanel = new JPanel();
        balancePanel.setLayout(null);
        balancePanel.setBounds(30, 140, 270, 100);
        balancePanel.setBackground(cs.white);
        balancePanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        totalbankBalbl = new JLabel("Total Balance"); 
        totalbankBalbl.setBounds(80, 20, 250, 20);
        totalbankBalbl.setFont(new Font("", Font.BOLD, 12));
        totalbankBalbl.setForeground(cs.darkerPurple);
        balancePanel.add(totalbankBalbl);
        
        availBalancelbl = new JLabel("₱2523.00");
        availBalancelbl.setBounds(80, 50, 300, 30);
        availBalancelbl.setFont(new Font("Arial", Font.BOLD, 36));
        availBalancelbl.setForeground(cs.darkerPurple);
        balancePanel.add(availBalancelbl);
        
        savingsPanel = new JPanel();
        savingsPanel.setLayout(null);
        savingsPanel.setBounds(330, 140, 270, 100);
        savingsPanel.setBackground(cs.white);
        savingsPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        totalSavings = new JLabel("Savings"); 
        totalSavings.setBounds(80, 20, 250, 20);
        totalSavings.setFont(new Font("", Font.BOLD, 12));
        totalSavings.setForeground(cs.darkerPurple);
        savingsPanel.add(totalSavings);
        
        savingsAmnt = new JLabel("₱2000.00");
        savingsAmnt.setBounds(80, 50, 300, 30);
        savingsAmnt.setFont(new Font("Arial", Font.BOLD, 36));
        savingsAmnt.setForeground(cs.darkerPurple);
        savingsPanel.add(savingsAmnt);
        
        checkingPanel = new JPanel();
        checkingPanel.setLayout(null);
        checkingPanel.setBounds(630, 140, 270, 100);
        checkingPanel.setBackground(cs.white);
        checkingPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        checkingLbl = new JLabel("Checking"); 
        checkingLbl.setBounds(80, 20, 250, 20);
        checkingLbl.setFont(new Font("", Font.BOLD, 12));
        checkingLbl.setForeground(cs.darkerPurple);
        checkingPanel.add(checkingLbl);
        
        checkingAmnt = new JLabel("₱34,000.00");
        checkingAmnt.setBounds(80, 50, 300, 30);
        checkingAmnt.setFont(new Font("Arial", Font.BOLD, 36));
        checkingAmnt.setForeground(cs.darkerPurple);
        checkingPanel.add(checkingAmnt);
        
        othersPanel = new JPanel();
        othersPanel.setLayout(null);
        othersPanel.setBounds(930, 140, 270, 100);
        othersPanel.setBackground(cs.white);
        othersPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        otherLbl = new JLabel("Other"); 
        otherLbl.setBounds(80, 20, 250, 20);
        otherLbl.setFont(new Font("", Font.BOLD, 12));
        otherLbl.setForeground(cs.darkerPurple);
        othersPanel.add(otherLbl);
        
        otherAmnt = new JLabel("₱0.00");
        otherAmnt.setBounds(80, 50, 300, 30);
        otherAmnt.setFont(new Font("Arial", Font.BOLD, 36));
        otherAmnt.setForeground(cs.darkerPurple);
        othersPanel.add(otherAmnt);
        
        historyPanel = new JPanel();
        historyPanel.setLayout(null);
        historyPanel.setBounds(30, 280, 1170, 400);
        historyPanel.setBackground(cs.white);
        historyPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        searchField = new JTextField("   Search accounts...");
        searchField.setBounds(15, 10, 250, 28);
        searchField.setFont(new Font("Arial", Font.PLAIN, 13));
        searchField.setBorder(null);
        searchField.setBackground(new Color(240, 240, 240));
        historyPanel.add(searchField);
        
        accountHeader = new JLabel("ACCOUNT #");
        accountHeader.setBounds(15, 50, 200, 25);
        accountHeader.setFont(new Font("Arial", Font.BOLD, 12));
        historyPanel.add(accountHeader);
        
        typeHeader = new JLabel("TYPE");
        typeHeader.setBounds(300, 50, 150, 25);
        typeHeader.setFont(new Font("Arial", Font.BOLD, 12));
        historyPanel.add(typeHeader);
        
        customerHeader = new JLabel("CUSTOMER");
        customerHeader.setBounds(500, 50, 400, 25);
        customerHeader.setFont(new Font("Arial", Font.BOLD, 12));
        historyPanel.add(customerHeader);
        
        balanceHeader = new JLabel("BALANCE");
        balanceHeader.setBounds(1100, 50, 300, 25);
        balanceHeader.setFont(new Font("Arial", Font.BOLD, 12));
        historyPanel.add(balanceHeader);
        
        separator = new JPanel();
        separator.setBounds(0, 80, 1170, 1);
        separator.setBackground(new Color(200, 200, 200));
        historyPanel.add(separator);
        
        account1 = new JLabel("SA-100001");
        account1.setBounds(15, 95, 200, 25);
        account1.setFont(new Font("Arial", Font.PLAIN, 12));
        historyPanel.add(account1);
        
        type1 = new JLabel("savings");
        type1.setBounds(300, 95, 150, 25);
        type1.setFont(new Font("Arial", Font.PLAIN, 12));
        historyPanel.add(type1);
        
        customer1 = new JLabel("Maria Santos");
        customer1.setBounds(500, 95, 400, 25);
        customer1.setFont(new Font("Arial", Font.PLAIN, 12));
        historyPanel.add(customer1);
        
        balance1 = new JLabel("$78,989.09");
        balance1.setBounds(1100, 95, 300, 25);
        balance1.setFont(new Font("Arial", Font.PLAIN, 12));
        historyPanel.add(balance1);
        
        account2 = new JLabel("CK-100002");
        account2.setBounds(15, 130, 200, 25);
        account2.setFont(new Font("Arial", Font.PLAIN, 12));
        historyPanel.add(account2);
        
        type2 = new JLabel("checking");
        type2.setBounds(300, 130, 150, 25);
        type2.setFont(new Font("Arial", Font.PLAIN, 12));
        historyPanel.add(type2);
        
        customer2 = new JLabel("Maria Santos");
        customer2.setBounds(500, 130, 400, 25);
        customer2.setFont(new Font("Arial", Font.PLAIN, 12));
        historyPanel.add(customer2);
        
        balance2 = new JLabel("$32,678.90");
        balance2.setBounds(1100, 130, 300, 25);
        balance2.setFont(new Font("Arial", Font.PLAIN, 12));
        historyPanel.add(balance2);
//        availlbl = new JLabel("Checking + Saving");
//        availlbl.setBounds(20, 108, 150, 20);
//        availlbl.setForeground(cs.gray);
//        balancePanel.add(availlbl);
//        
//        quicklbl = new JLabel("Quick Actions");
//        quicklbl.setBounds(20, 150, 150, 20);
//        quicklbl.setForeground(cs.darkerPurple);
//        balancePanel.add(quicklbl);
//        
//        withdrawBtn = new JButton("Withdraw", withdrawIcon);
//        withdrawBtn.setBounds(20, 180, 170, 45);
//        withdrawBtn.setBackground(cs.darkPurple);
//        withdrawBtn.setForeground(cs.white);
//        withdrawBtn.setFocusPainted(false);
//        withdrawBtn.setBorderPainted(false);
//        
//        withdrawBtn.setHorizontalAlignment(SwingConstants.CENTER);
//        withdrawBtn.setMargin(new Insets(0, 0, 0, 10));
//        withdrawBtn.setIconTextGap(10);
//        balancePanel.add(withdrawBtn);
//        
//        depositBtn = new JButton("Deposit", depositIcon);
//        depositBtn.setBounds(205, 180, 170, 45);
//        depositBtn.setBackground(cs.darkPurple);
//        depositBtn.setForeground(cs.white);
//        depositBtn.setFocusPainted(false);
//        depositBtn.setBorderPainted(false);
//        
//        depositBtn.setHorizontalAlignment(SwingConstants.CENTER);
//        depositBtn.setMargin(new Insets(0, 0, 0, 10));
//        depositBtn.setIconTextGap(10);
//        balancePanel.add(depositBtn);
//        
//        transferBtn = new JButton("Transfer", transferIcon);
//        transferBtn.setBounds(390, 180, 170, 45);
//        transferBtn.setBackground(cs.darkPurple);
//        transferBtn.setForeground(cs.white);
//        transferBtn.setFocusPainted(false);
//        transferBtn.setBorderPainted(false);
//        
//        transferBtn.setHorizontalAlignment(SwingConstants.CENTER);
//        transferBtn.setMargin(new Insets(0, 0, 0, 5));
//        transferBtn.setIconTextGap(10);
//        balancePanel.add(transferBtn);

          mainContentPanel.add(historyPanel);
          mainContentPanel.add(checkingPanel);
          mainContentPanel.add(othersPanel);
          mainContentPanel.add(savingsPanel);
          mainContentPanel.add(balancePanel);
        
        // end content panel
        
        transactBtn.addActionListener(this);
        balanceBtn.addActionListener(this);
        savingsBtn.addActionListener(this);
        homeBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
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
        
        else if(e.getSource() == homeBtn){
            CustomerDashboard cusUI = new CustomerDashboard();
            cusUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == logoutBtn){
            // logout code
            LoginUI logUI = new LoginUI();
            logUI.setVisible(true);
            dispose();
        }
        
    }
    public static void main(String[] args){
        AccountMenuUI bu = new AccountMenuUI();
        bu.setVisible(true);
    }
    
}