package BankManage; 
import BankManage.AppService.Encryption;
import BankManage.AccountModels.CustomerModel;
import BankManage.AppService.SessionManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactUI extends JFrame implements ActionListener {
    
    ColorScheme cs = new ColorScheme();
    Encryption en = new Encryption();
    
    // panels
    
    private final JPanel sidebarPanel, mainContentPanel, linePanel; // gamitin nyo mainContentPanel para mag lagay ng content na hindi mag ooverlap kay sidebar
    
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
    
    // logo
    
    java.net.URL logoImgURL = CustomerDashboard.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));;
    
    // sidebar
    
    private final JButton homeBtn, transactBtn, balanceBtn, savingsBtn, accountsBtn, logoutBtn;
    private final JLabel logoName;
    
    // main contnet
    
    private final JLabel dashboardTitle;
    
    //
    
    private JPanel fPanel, sPanel, tPanel;
    private JPanel transactconPanel;
    
    private JLabel fTitle, fPhp, fSub;
    private JLabel sTitle, sPhp, sSub; 
    private JLabel tTitle, tPhp, tSub;
    private JLabel transactconTitleLabel;
    
    private JButton innerDepositBtn, innerWithdrawBtn, innerTransferBtn;
    private JButton depstfiBtn, withdrBtn, transFBtn;

    // transact tbl
    
    private JLabel transactlbl;
    private JTable recenttransacttbl;
    private JScrollPane recentnoScroll;
    
    protected String[] recentColumns = {
        "Name", "Date", "Status", "Amount"
    };
    
    protected String[][] sampleData = {
        {"PayPal Transfer", "May 10, 2026", "Completed", "+₱25,120.50"},
        {"Roblox 1000 ROBUX", "May 5, 2026", "Declined", "=₱0.00"},
        {"Minecraft Cape", "January 7, 2026", "Completed", "-₱250.00"},
        {"Minecraft Bundle", "January 6, 2026", "Completed", "-₱1,600.00"},
        {"Robux 20USD Gift Card", "January 1, 2026", "Completed", "-₱1,200.00"},
        {"Patreon Membership ", "January 1, 2026", "Completed", "-₱300.00"},
        {"Minecraft Gift", "January 1, 2026", "Completed", "-₱1,600.00"},
        {"YouTube Premium Yearly", "December 25, 2025", "Completed", "-₱2,000.00"},
        {"PayPal Transfer", "December 24, 2025", "Completed", "₱+50,600.00"},
        {"Robux 20USD Gift Card", "December 1, 2026", "Completed", "-₱1,200.00"},
        {"Patreon Membership ", "December 1, 2026", "Completed", "-₱300.00"},
        {"Minecraft Merch", "November 1, 2026", "Completed", "-₱1,600.00"},
        {"Spotify Premium Yearly", "September 25, 2025", "Completed", "-₱2,000.00"},
        {"PayPal Transfer", "September 24, 2025", "Completed", "+₱10,600.00"}
    };
    
    private JLabel formHeaderTitle, labelAction, labelFrom, labelTo, labelAmount, labelDesc;
    private JTextField txtFrom, txtTo, txtAmount, txtDesc;
    
    public TransactUI() {
        
        if (SessionManage.isCustomerLoggedIn()){
            CustomerModel customer = SessionManage.getCurrentCustomer();
            
            System.out.println("Logged in as: " + en.decrypt(customer.getFirstName())); // debug
        }
        
        setTitle("Dashboard - Transactions");
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
        transactBtn.setBackground(cs.btnColorSelect);
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
        mainContentPanel.setBackground(Color.WHITE);
        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);
        
        dashboardTitle = new JLabel("Transactions");
        dashboardTitle.setBounds(30, 15, 100, 20);
        dashboardTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(dashboardTitle);
        
        linePanel = new JPanel();
        
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        fPanel = new JPanel();
        fPanel.setLayout(null);
        fPanel.setBackground(Color.WHITE);
        fPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        fPanel.setBounds(30, 80, 360, 200); 
        mainContentPanel.add(fPanel);
        
        fTitle = new JLabel("VaultBank Deposit");
        fTitle.setFont(new Font("Arial", Font.BOLD, 16));
        fTitle.setForeground(cs.darkerPurple);
        fTitle.setBounds(20, 15, 300, 25);
        fPanel.add(fTitle); 
        
        fPhp = new JLabel("PHP ₱239,691.12"); 
        fPhp.setFont(new Font("Arial", Font.BOLD, 22));
        fPhp.setForeground(cs.darkerPurple);
        fPhp.setBounds(20, 50, 300, 35);
        fPanel.add(fPhp);
        
        fSub = new JLabel("Current");
        fSub.setForeground(Color.GRAY);
        fSub.setBounds(20, 90, 100, 20);
        fPanel.add(fSub); 
        
        innerDepositBtn = new JButton("Deposit", depositIcon);
        innerDepositBtn.setBounds(20, 130, 320, 45);
        innerDepositBtn.setBackground(cs.darkPurple);
        innerDepositBtn.setForeground(Color.WHITE);
        innerDepositBtn.setFocusPainted(false);
        innerDepositBtn.setBorderPainted(false);
        
        innerDepositBtn.setHorizontalAlignment(SwingConstants.CENTER);
        innerDepositBtn.setMargin(new Insets(0, 0, 0, 10));
        innerDepositBtn.setIconTextGap(10);

        innerDepositBtn.addActionListener(this);
        fPanel.add(innerDepositBtn);
        
        sPanel = new JPanel();
        sPanel.setLayout(null);
        sPanel.setBackground(Color.WHITE);
        sPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        sPanel.setBounds(440, 80, 360, 200); 
        mainContentPanel.add(sPanel);
        
        sTitle = new JLabel("VaultBank Withdrawals");
        sTitle.setFont(new Font("Arial", Font.BOLD, 16));
        sTitle.setForeground(cs.darkerPurple);
        sTitle.setBounds(20, 15, 300, 25);
        sPanel.add(sTitle); 
        
        sPhp = new JLabel("PHP -₱68,823.67"); 
        sPhp.setFont(new Font("Arial", Font.BOLD, 22));
        sPhp.setForeground(cs.darkerPurple);
        sPhp.setBounds(20, 50, 300, 35);
        sPanel.add(sPhp); 
        
        sSub = new JLabel("Recorded");
        sSub.setForeground(Color.GRAY);
        sSub.setBounds(20, 90, 100, 20);
        sPanel.add(sSub); 

        innerWithdrawBtn = new JButton("Withdraw", withdrawIcon); 
        innerWithdrawBtn.setBounds(20, 130, 320, 45);
        innerWithdrawBtn.setBackground(cs.darkPurple);
        innerWithdrawBtn.setForeground(Color.WHITE);
        innerWithdrawBtn.setFocusPainted(false);
        innerWithdrawBtn.setBorderPainted(false);
        
        innerWithdrawBtn.setHorizontalAlignment(SwingConstants.CENTER);
        innerWithdrawBtn.setMargin(new Insets(0, 0, 0, 10));
        innerWithdrawBtn.setIconTextGap(10);
        
        innerWithdrawBtn.addActionListener(this);
        sPanel.add(innerWithdrawBtn);
        
        tPanel = new JPanel();
        tPanel.setLayout(null);
        tPanel.setBackground(Color.WHITE);
        tPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        tPanel.setBounds(855, 80, 360, 200); 
        mainContentPanel.add(tPanel);
        
        tTitle = new JLabel("VaultBank Recent activity");
        tTitle.setFont(new Font("Arial", Font.BOLD, 16));
        tTitle.setForeground(cs.darkerPurple);
        tTitle.setBounds(20, 15, 300, 25);
        tPanel.add(tTitle);
        
        tPhp = new JLabel("PHP +₱25,120.50"); 
        tPhp.setFont(new Font("Arial", Font.BOLD, 22));
        tPhp.setForeground(cs.darkerPurple);
        tPhp.setBounds(20, 50, 300, 35);
        tPanel.add(tPhp);
        
        tSub = new JLabel("Funds");
        tSub.setForeground(Color.GRAY);
        tSub.setBounds(20, 90, 100, 20);
        tPanel.add(tSub);
        
        innerTransferBtn = new JButton("Transfer", transferIcon);
        innerTransferBtn.setBounds(20, 130, 320, 45);
        innerTransferBtn.setBackground(cs.darkPurple);
        innerTransferBtn.setForeground(Color.WHITE);
        innerTransferBtn.setFocusPainted(false);
        innerTransferBtn.setBorderPainted(false);
        
        innerTransferBtn.setHorizontalAlignment(SwingConstants.CENTER);
        innerTransferBtn.setMargin(new Insets(0, 0, 0, 10));
        innerTransferBtn.setIconTextGap(10);
        
        innerTransferBtn.addActionListener(this);
        tPanel.add(innerTransferBtn);
      
        transactconPanel = new JPanel();
        transactconPanel.setLayout(null);
        transactconPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        transactconPanel.setBackground(Color.WHITE);
        transactconPanel.setBounds(30, 310, 1185, 570); 
        mainContentPanel.add(transactconPanel);
        
        transactlbl = new JLabel("Transactions"); 
        transactlbl.setBounds(20, 20, 250, 20);
        transactlbl.setFont(new Font("", Font.BOLD, 18));
        transactlbl.setForeground(cs.darkerPurple);
        transactconPanel.add(transactlbl);
        
        recenttransacttbl = new JTable(sampleData, recentColumns);
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
        
        recenttransacttbl.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 14)
        );
        recenttransacttbl.getTableHeader().setPreferredSize(
            new Dimension(0, 45)
        );
        
        // no scroll
        
        recentnoScroll = new JScrollPane(recenttransacttbl);
        recentnoScroll.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        recentnoScroll.setBounds(20, 60, 1145, 490);
        transactconPanel.add(recentnoScroll);

        // Sidebar Shortcuts
        homeBtn.addActionListener(this);
        balanceBtn.addActionListener(this);
        savingsBtn.addActionListener(this);
        accountsBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == homeBtn){
            CustomerDashboard cusUI = new CustomerDashboard();
            cusUI.setVisible(true);
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
        }
    }