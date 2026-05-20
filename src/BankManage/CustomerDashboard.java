package BankManage; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerDashboard extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    
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
    private JScrollPane recentnoScroll;
    
    protected String[] recentColumns = {
        "Name", "Date", "Status", "Amount"
    };
    
    protected String[][] sampleData = {
        {"PayPal Transfer", "May 10, 2026", "Completed", "+₱25,120.50"},
        {"Roblox 1000 ROBUX", "May 5, 2026", "Declined", "=₱0"},
        {"Minecraft Cape", "January 7, 2026", "Completed", "-₱250.00"},
        {"Minecraft Bundle", "January 6, 2026", "Completed", "-₱1,600"},
    };
    
    //
    
    private String fname = "Juan", date = "May 15, 2026";
    private double checkBal = 121502.60;
    private double saveBal = 30242.55;
    private double totalBal = checkBal + saveBal;
    
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
        usrFName.setBounds(210, 67, 200, 30);
        usrFName.setFont(new Font("", Font.BOLD, 24));
        usrFName.setForeground(cs.btnColorSelect);
        mainContentPanel.add(usrFName);
        
        datelbl = new JLabel(date);
        datelbl.setBounds(30, 103, 100, 20);
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
        
        availBalancelbl = new JLabel("₱"+String.valueOf(totalBal));
        availBalancelbl.setBounds(20, 65, 300, 30);
        availBalancelbl.setFont(new Font("Arial", Font.BOLD, 36));
        availBalancelbl.setForeground(cs.darkerPurple);
        balancePanel.add(availBalancelbl);
        
        availlbl = new JLabel("Checking + Saving");
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
        
        gotoHistorybtn = new JButton("Goal History", historyIcon);
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
        
        // Transaction
        
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
        
        // table (objects papasok dito)
        
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
        
        recentnoScroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_NEVER
        );

        recentnoScroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        
        recentnoScroll.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        recentnoScroll.setBounds(20, 60, 1145, 380);
        recentTransactPanel.add(recentnoScroll);
        
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
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
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
            // logout code
            LoginUI logUI = new LoginUI();
            logUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == withdrawBtn){
            TransactUI trUI = new TransactUI();
            trUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == depositBtn){
            TransactUI trUI = new TransactUI();
            trUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == transferBtn){
            TransactUI trUI = new TransactUI();
            trUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == gotoSavingsbtn){
            SavingsUI saveUI = new SavingsUI();
            saveUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == gotoHistorybtn){
            SavingsUI saveUI = new SavingsUI();
            saveUI.setVisible(true);
            dispose();
        }
        
        // side bar end
        
        // main content
        
        
        
        //
        
    }

}