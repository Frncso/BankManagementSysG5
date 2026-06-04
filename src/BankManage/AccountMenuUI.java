package BankManage; 
import BankManage.AccountModels.CustomerModel;
import BankManage.AppService.Encryption;
import BankManage.AppService.SessionManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountMenuUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    Encryption en = new Encryption();
    
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
    
    java.net.URL totalbalImgURL = CustomerDashboard.class.getResource("resources/money.png");
    
    private ImageIcon totalbalRaw = new ImageIcon(totalbalImgURL);
    private Image totalbalScale = totalbalRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon totalbalIcon = new ImageIcon(totalbalScale);
    
//    java.net.URL withdrawImgURL = CustomerDashboard.class.getResource("resources/withdraw.png");
//    
//    private ImageIcon withdrawRaw = new ImageIcon(withdrawImgURL);
//    private Image withdrawScale = withdrawRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//    private ImageIcon withdrawIcon = new ImageIcon(withdrawScale);
    
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
    
    java.net.URL changeImgURL = CustomerDashboard.class.getResource("resources/change.png");
    
    private ImageIcon changeRaw = new ImageIcon(changeImgURL);
    private Image changeScale = changeRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon changeIcon = new ImageIcon(changeScale);
    
    java.net.URL moneyImgURL = CustomerDashboard.class.getResource("resources/money.png");
    
    private ImageIcon moneyRaw = new ImageIcon(moneyImgURL);
    private Image moneyScale = moneyRaw.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    private JLabel moneyIMG = new JLabel(new ImageIcon(moneyScale));
    
    java.net.URL checkTotalImgURL = CustomerDashboard.class.getResource("resources/balanceIMG.png");
    
    private ImageIcon checkTotalRaw = new ImageIcon(checkTotalImgURL);
    private Image checkTotalScale = checkTotalRaw.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    private JLabel checkTotalIMG = new JLabel(new ImageIcon(checkTotalScale));
    
    java.net.URL saveTotalImgURL = CustomerDashboard.class.getResource("resources/savingsIMG.png");
    
    private ImageIcon saveTotalRaw = new ImageIcon(saveTotalImgURL);
    private Image saveTotalScale = saveTotalRaw.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
    private JLabel saveTotalIMG = new JLabel(new ImageIcon(saveTotalScale));
    
    
//    java.net.URL transferImgURL = CustomerDashboard.class.getResource("resources/transfer.png");
//    
//    private ImageIcon transferRaw = new ImageIcon(transferImgURL);
//    private Image transferScale = transferRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//    private ImageIcon transferIcon = new ImageIcon(transferScale);
//    
//    java.net.URL depositImgURL = CustomerDashboard.class.getResource("resources/deposit.png");
//    
//    private ImageIcon depositRaw = new ImageIcon(depositImgURL);
//    private Image depositScale = depositRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
//    private ImageIcon depositIcon = new ImageIcon(depositScale);
    
    java.net.URL plusImgURL = CustomerDashboard.class.getResource("resources/plus.png");
    
    private ImageIcon plusRaw = new ImageIcon(plusImgURL);
    private Image plusScale = plusRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon plusIcon = new ImageIcon(plusScale);
    // logo
    
    java.net.URL logoImgURL = CustomerDashboard.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));;
    
    // sidebar
    
    private final JButton homeBtn, transactBtn, balanceBtn, savingsBtn, accountsBtn, logoutBtn;
    private final JLabel logoName, totalbankBalbl, availBalancelbl, welcomelbl, accCount;
    private final JLabel totalSavings, savingsAmnt, checkingLbl, checkingAmnt;
    private final JButton addAcc, changeAcc;

    // main
    
    private JLabel dashboardTitle;
    private JPanel balancePanel, savingsPanel, checkingPanel, historyPanel;
    
    // list of accounts
    
    private JLabel listlbl;
    private JTable listacctbl;
    private JScrollPane listnoScroll;
    
    protected String[] listColumns = {
        "Account No.", "Type", "Status", "Balance"
    };
    
    protected String[][] sampleData = {
        {"ACC-1001", "Checking", "Active", "₱121,502.60"},
        {"ACC-1001", "Savings", "Active", "₱30,242.55"}
    };
    
    
    //
    
    public AccountMenuUI() {
        
        if (SessionManage.isCustomerLoggedIn()){
            CustomerModel customer = SessionManage.getCurrentCustomer();
            
            System.out.println("Logged in as: " + en.decrypt(customer.getFirstName())); // debug
        }
        
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
        
        changeAcc = new JButton("Request Info Update", changeIcon);
        changeAcc.setBounds(695, 65, 250, 45);
        changeAcc.setBackground(cs.darkPurple);
        changeAcc.setForeground(cs.white);
        changeAcc.setFocusPainted(false);
        changeAcc.setBorderPainted(false);
        changeAcc.setHorizontalAlignment(SwingConstants.CENTER);
        changeAcc.setMargin(new Insets(0, 0, 0, 10));
        changeAcc.setIconTextGap(10);
        changeAcc.addActionListener(this);
        mainContentPanel.add(changeAcc);
        
        addAcc = new JButton("Request a New Account", plusIcon);
        addAcc.setBounds(965, 65, 250, 45);
        addAcc.setBackground(cs.darkPurple);
        addAcc.setForeground(cs.white);
        addAcc.setFocusPainted(false);
        addAcc.setBorderPainted(false);
        addAcc.setHorizontalAlignment(SwingConstants.CENTER);
        addAcc.setMargin(new Insets(0, 0, 0, 10));
        addAcc.setIconTextGap(10);
        addAcc.addActionListener(this);
        mainContentPanel.add(addAcc);
        
        balancePanel = new JPanel();
        balancePanel.setLayout(null);
        balancePanel.setBounds(30, 140, 368, 100);
        balancePanel.setBackground(cs.white);
        balancePanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        moneyIMG.setBounds(6, 15, 70, 70);
        balancePanel.add(moneyIMG);
        
        totalbankBalbl = new JLabel("Total Balance"); 
        totalbankBalbl.setBounds(80, 20, 250, 20);
        totalbankBalbl.setFont(new Font("", Font.BOLD, 12));
        totalbankBalbl.setForeground(cs.darkerPurple);
        balancePanel.add(totalbankBalbl);
        
        availBalancelbl = new JLabel("₱151,745.15");
        availBalancelbl.setBounds(80, 50, 300, 30);
        availBalancelbl.setFont(new Font("Arial", Font.BOLD, 36));
        availBalancelbl.setForeground(cs.darkerPurple);
        balancePanel.add(availBalancelbl);
        
        savingsPanel = new JPanel();
        savingsPanel.setLayout(null);
        savingsPanel.setBounds(438, 140, 368, 100);
        savingsPanel.setBackground(cs.white);
        savingsPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        checkTotalIMG.setBounds(6, 15, 70, 70);
        savingsPanel.add(checkTotalIMG);
        
        checkingAmnt = new JLabel("Total Checking"); 
        checkingAmnt.setBounds(80, 20, 250, 20);
        checkingAmnt.setFont(new Font("", Font.BOLD, 12));
        checkingAmnt.setForeground(cs.darkerPurple);
        savingsPanel.add(checkingAmnt);
        
        savingsAmnt = new JLabel("₱121,502.60");
        savingsAmnt.setBounds(80, 50, 300, 30);
        savingsAmnt.setFont(new Font("Arial", Font.BOLD, 36));
        savingsAmnt.setForeground(cs.darkerPurple);
        savingsPanel.add(savingsAmnt);
        
        checkingPanel = new JPanel();
        checkingPanel.setLayout(null);
        checkingPanel.setBounds(846, 140, 368, 100);
        checkingPanel.setBackground(cs.white);
        checkingPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        saveTotalIMG.setBounds(6, 15, 70, 70);
        checkingPanel.add(saveTotalIMG);
        
        checkingLbl = new JLabel("Total Savings"); 
        checkingLbl.setBounds(80, 20, 250, 20);
        checkingLbl.setFont(new Font("", Font.BOLD, 12));
        checkingLbl.setForeground(cs.darkerPurple);
        checkingPanel.add(checkingLbl);
        
        totalSavings = new JLabel("₱30,242.55");
        totalSavings.setBounds(80, 50, 300, 30);
        totalSavings.setFont(new Font("Arial", Font.BOLD, 36));
        totalSavings.setForeground(cs.darkerPurple);
        checkingPanel.add(totalSavings);
        
        historyPanel = new JPanel();
        historyPanel.setLayout(null);
        historyPanel.setBounds(30, 280, 1185, 600);
        historyPanel.setBackground(cs.white);
        historyPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        // Transaction
        
        listlbl = new JLabel("Your Accounts"); 
        listlbl.setBounds(20, 20, 250, 20);
        listlbl.setFont(new Font("", Font.BOLD, 18));
        listlbl.setForeground(cs.darkerPurple);
        historyPanel.add(listlbl);
        
        // table (objects papasok dito)
        
        listacctbl = new JTable(sampleData, listColumns);
        listacctbl.setRowHeight(40);
        listacctbl.setFont(new Font("Arial", Font.PLAIN, 14));
        listacctbl.setFocusable(false);
        listacctbl.getTableHeader().setReorderingAllowed(false);
        listacctbl.getTableHeader().setBackground(cs.darkPurple);
        listacctbl.getTableHeader().setForeground(cs.white);
        listacctbl.setSelectionBackground(cs.lightPurple);
        listacctbl.setSelectionForeground(cs.white);
        listacctbl.setShowGrid(false);
        listacctbl.setDefaultEditor(Object.class, null);
        
        listacctbl.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 14)
        );
        listacctbl.getTableHeader().setPreferredSize(
            new Dimension(0, 45)
        );
        
        // no scroll
        
        listnoScroll = new JScrollPane(listacctbl);
        
        listnoScroll.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_NEVER
        );

        listnoScroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        
        listnoScroll.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        listnoScroll.setBounds(20, 60, 1145, 520);
        historyPanel.add(listnoScroll);

          mainContentPanel.add(historyPanel);
          mainContentPanel.add(checkingPanel);
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
        else if(e.getSource() == addAcc){   
            
            String[] accountTypes = {"Checking", "Savings"};
            JComboBox<String> typeCombo = new JComboBox<>(accountTypes);
            typeCombo.setFont(new Font("Arial", Font.PLAIN, 14));
            
            int result = JOptionPane.showConfirmDialog(this,
                typeCombo,
                "Select Account Type",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
            
            if (result == JOptionPane.OK_OPTION) {
                String selectedType = (String) typeCombo.getSelectedItem();
                RequestNewAccUI reqUI = new RequestNewAccUI(selectedType);
                reqUI.setVisible(true);
                dispose();
            }
        }
        else if(e.getSource() == changeAcc){
            RequestChangeInfoUI reqUI = new RequestChangeInfoUI();
            reqUI.setVisible(true);
            dispose();
        }
        
    }
    
}