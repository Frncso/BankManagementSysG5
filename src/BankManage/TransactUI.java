package BankManage; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

public class TransactUI extends JFrame implements ActionListener {
    
    ColorScheme cs = new ColorScheme();
    
    // panels
    
    private JPanel sidebarPanel, mainContentPanel; // gamitin nyo mainContentPanel para mag lagay ng content na hindi mag ooverlap kay sidebar
    
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
    
    java.net.URL historyImgURL = CustomerDashboard.class.getResource("resources/history.png");
    
    private ImageIcon historyRaw = new ImageIcon(historyImgURL);
    private Image historyScale = historyRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon historyIcon = new ImageIcon(historyScale);
    
    java.net.URL summaryImgURL = CustomerDashboard.class.getResource("resources/summary.png");
    
    private ImageIcon summaryRaw = new ImageIcon(summaryImgURL);
    private Image summaryScale = summaryRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon summaryIcon = new ImageIcon(summaryScale);
    
    java.net.URL accountsImgURL = CustomerDashboard.class.getResource("resources/accounts.png");
    
    private ImageIcon accountsRaw = new ImageIcon(accountsImgURL);
    private Image accountsScale = accountsRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon accountsIcon = new ImageIcon(accountsScale);
    
    java.net.URL logoutImgURL = CustomerDashboard.class.getResource("resources/logout.png");
    
    private ImageIcon logoutRaw = new ImageIcon(logoutImgURL);
    private Image logoutScale = logoutRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon logoutIcon = new ImageIcon(logoutScale);
    
    // logo
    
    java.net.URL logoImgURL = CustomerDashboard.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));;
    
    // sidebar
    
    private final JButton homeBtn, transactBtn, balanceBtn, savingsBtn, historyBtn, summaryBtn, accountsBtn, logoutBtn;
    private final JLabel logoName;
    
    private JPanel fPanel, sPanel, tPanel;
    private JPanel transactconPanel;
    
    private JLabel fTitle, fPhp, fSub;
    private JLabel sTitle, sPhp, sSub; 
    private JLabel tTitle, tPhp, tSub;
    private JLabel transactconTitleLabel;
    
    private JButton innerDepositBtn, innerWithdrawBtn, innerTransferBtn;
    private JButton depstfiBtn, withdrBtn, transFBtn;

    private JLabel formHeaderTitle, labelAction, labelFrom, labelTo, labelAmount, labelDesc;
    private JTextField txtFrom, txtTo, txtAmount, txtDesc;
    
    public TransactUI() {
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
        
        // history
        
        historyBtn = new JButton("History", historyIcon);
        historyBtn.setBounds(0, 220, 180, 40);
        historyBtn.setBackground(cs.darkPurple);
        historyBtn.setForeground(cs.white);
        historyBtn.setFocusPainted(false);
        historyBtn.setBorderPainted(false);
        
        // icon beside button
        
        historyBtn.setHorizontalAlignment(SwingConstants.LEFT);
        historyBtn.setIconTextGap(8);
        sidebarPanel.add(historyBtn);
        
        // summary
        
        summaryBtn = new JButton("Summary", summaryIcon);
        summaryBtn.setBounds(0, 260, 180, 40);
        summaryBtn.setBackground(cs.darkPurple);
        summaryBtn.setForeground(cs.white);
        summaryBtn.setFocusPainted(false);
        summaryBtn.setBorderPainted(false);
        
        // icon beside button
        
        summaryBtn.setHorizontalAlignment(SwingConstants.LEFT);
        summaryBtn.setIconTextGap(8);
        sidebarPanel.add(summaryBtn);
        
        // accounts
        
        accountsBtn = new JButton("Accounts", accountsIcon);
        accountsBtn.setBounds(0, 300, 180, 40);
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
        
        fPanel = new JPanel();
        fPanel.setLayout(null);
        fPanel.setBackground(Color.WHITE);
        fPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        fPanel.setBounds(50, 40, 360, 200); 
        mainContentPanel.add(fPanel);
        
        fTitle = new JLabel("VaultBank Deposit");
        fTitle.setFont(new Font("Arial", Font.BOLD, 16));
        fTitle.setBounds(20, 15, 300, 25);
        fPanel.add(fTitle); 
        
        fPhp = new JLabel("PHP ₱239,691.12"); 
        fPhp.setFont(new Font("Arial", Font.BOLD, 22));
        fPhp.setBounds(20, 50, 300, 35);
        fPanel.add(fPhp);
        
        fSub = new JLabel("Current");
        fSub.setFont(new Font("Arial", Font.PLAIN, 13));
        fSub.setForeground(Color.GRAY);
        fSub.setBounds(20, 90, 100, 20);
        fPanel.add(fSub); 
        
        innerDepositBtn = new JButton("Deposit");
        innerDepositBtn.setBounds(20, 130, 320, 45);
        innerDepositBtn.setBackground(new Color(138, 43, 226));
        innerDepositBtn.setForeground(Color.WHITE);
        innerDepositBtn.setFont(new Font("Arial", Font.BOLD, 15));
        innerDepositBtn.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        innerDepositBtn.addActionListener(this);
        fPanel.add(innerDepositBtn);
        
        sPanel = new JPanel();
        sPanel.setLayout(null);
        sPanel.setBackground(Color.WHITE);
        sPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        sPanel.setBounds(440, 40, 360, 200); 
        mainContentPanel.add(sPanel);
        
        sTitle = new JLabel("VaultBank Withdrawals");
        sTitle.setFont(new Font("Arial", Font.BOLD, 16));
        sTitle.setBounds(20, 15, 300, 25);
        sPanel.add(sTitle); 
        
        sPhp = new JLabel("PHP -₱68,823.67"); 
        sPhp.setFont(new Font("Arial", Font.BOLD, 22));
        sPhp.setBounds(20, 50, 300, 35);
        sPanel.add(sPhp); 
        
        sSub = new JLabel("Recorded");
        sSub.setFont(new Font("Arial", Font.PLAIN, 13));
        sSub.setForeground(Color.GRAY);
        sSub.setBounds(20, 90, 100, 20);
        sPanel.add(sSub); 

        innerWithdrawBtn = new JButton("Withdraw"); 
        innerWithdrawBtn.setBounds(20, 130, 320, 45);
        innerWithdrawBtn.setBackground(new Color(138, 43, 226));
        innerWithdrawBtn.setForeground(Color.WHITE);
        innerWithdrawBtn.setFont(new Font("Arial", Font.BOLD, 15));
        innerWithdrawBtn.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        innerWithdrawBtn.addActionListener(this);
        sPanel.add(innerWithdrawBtn);
        
        tPanel = new JPanel();
        tPanel.setLayout(null);
        tPanel.setBackground(Color.WHITE);
        tPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        tPanel.setBounds(830, 40, 360, 200); 
        mainContentPanel.add(tPanel);
        
        tTitle = new JLabel("VaultBank Recent activity");
        tTitle.setFont(new Font("Arial", Font.BOLD, 16));
        tTitle.setBounds(20, 15, 300, 25);
        tPanel.add(tTitle);
        
        tPhp = new JLabel("PHP -₱20,000.00"); 
        tPhp.setFont(new Font("Arial", Font.BOLD, 22));
        tPhp.setBounds(20, 50, 300, 35);
        tPanel.add(tPhp);
        
        tSub = new JLabel("Funds");
        tSub.setFont(new Font("Arial", Font.PLAIN, 13));
        tSub.setForeground(Color.GRAY);
        tSub.setBounds(20, 90, 100, 20);
        tPanel.add(tSub);
        
        innerTransferBtn = new JButton("Transfer");
        innerTransferBtn.setBounds(20, 130, 320, 45);
        innerTransferBtn.setBackground(new Color(138, 43, 226));
        innerTransferBtn.setForeground(Color.WHITE);
        innerTransferBtn.setFont(new Font("Arial", Font.BOLD, 15));
        innerTransferBtn.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        innerTransferBtn.addActionListener(this);
        tPanel.add(innerTransferBtn);
      
        transactconPanel = new JPanel();
        transactconPanel.setLayout(null);
        transactconPanel.setBackground(Color.WHITE);
        transactconPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        transactconPanel.setBounds(50, 270, 1140, 470); 
        mainContentPanel.add(transactconPanel);
        
        transactconTitleLabel = new JLabel("Transactions:");
        transactconTitleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        transactconTitleLabel.setBounds(30, 25, 200, 30);
        transactconPanel.add(transactconTitleLabel);
        
        depstfiBtn = new JButton("deposit");
        depstfiBtn.setBounds(760, 25, 100, 30);
        depstfiBtn.setBackground(new Color(138, 43, 226));
        depstfiBtn.setForeground(Color.WHITE);
        depstfiBtn.setFont(new Font("Arial", Font.BOLD, 13));
        depstfiBtn.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        depstfiBtn.addActionListener(this);
        transactconPanel.add(depstfiBtn); 
        
        withdrBtn = new JButton("withdraw");
        withdrBtn.setBounds(880, 25, 100, 30);
        withdrBtn.setBackground(new Color(138, 43, 226));
        withdrBtn.setForeground(Color.WHITE);
        withdrBtn.setFont(new Font("Arial", Font.BOLD, 13));
        withdrBtn.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        withdrBtn.addActionListener(this);
        transactconPanel.add(withdrBtn); 
        
        transFBtn = new JButton("transfer");
        transFBtn.setBounds(1000, 25, 100, 30);
        transFBtn.setBackground(new Color(138, 43, 226));
        transFBtn.setForeground(Color.WHITE);
        transFBtn.setFont(new Font("Arial", Font.BOLD, 13));
        transFBtn.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        transFBtn.addActionListener(this);
        transactconPanel.add(transFBtn);  

        // Sidebar Shortcuts
        homeBtn.addActionListener(this);
        balanceBtn.addActionListener(this);
        savingsBtn.addActionListener(this);
        historyBtn.addActionListener(this);
        summaryBtn.addActionListener(this);
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
        else if(e.getSource() == historyBtn){
            HistoryUI hisUI = new HistoryUI();
            hisUI.setVisible(true);
            dispose();
        }
        else if(e.getSource() == summaryBtn){
            SummaryTransactUI sumUI = new SummaryTransactUI();
            sumUI.setVisible(true);
            dispose();
        }
        else if(e.getSource() == accountsBtn){
            AccountMenuUI accMenUI = new AccountMenuUI();
            accMenUI.setVisible(true);
            dispose();
        }
        else if(e.getSource() == logoutBtn){
            LoginUI logUI = new LoginUI();
            logUI.setVisible(true);
            dispose();
        }
    }
}