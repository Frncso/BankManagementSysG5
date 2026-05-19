package BankManage; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;

public class SavingsUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    
    // panels
    
    private JPanel sidebarPanel, mainContentPanel, linePanel;
    
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
    
    // logo
    
    java.net.URL logoImgURL = CustomerDashboard.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));;
    
    // sidebar + Added
    
    private final JButton homeBtn, transactBtn, balanceBtn, savingsBtn, accountsBtn, logoutBtn;
    
    private JButton calculateBtn;
    private final JLabel logoName;
    
    private JLabel savingsAccountLabel, savingsGoalLabel, goalLabel, targetLabel, currentLabel, completeLabel, interestCalcLabel, 
    monthlyGrowthLabel, enterMonthsLabel, resultLabel, savingsHistoryLabel, historyListLabel;
    private JLabel historyListTitleLabel, history1Label, history2Label;
    private JTextField monthsInputText;
    
    private JLabel dashboardTitle;
    private JLabel lTitle, lLabel, lcurLabel;
    private JLabel rTitle, rLabel, rAccrLabel;
    private JLabel achievedTitle, achievedCountLabel, achievedSubLabel;
   
    private JPanel lPanel, rPanel;
    private JPanel achievedPanel;
    
    private JButton targetBtn, completedBtn, viewGoalBtn;
    private JButton viewAchievedBtn;

    public SavingsUI() {
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
        balanceBtn.setHorizontalAlignment(SwingConstants.LEFT);
        balanceBtn.setIconTextGap(8);
        sidebarPanel.add(balanceBtn);
        
        // savings
        
        savingsBtn = new JButton("Savings", savingsIcon);
        savingsBtn.setBounds(0, 180, 180, 40);
        savingsBtn.setBackground(cs.btnColorSelect);
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
             
        logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
        logoutBtn.setIconTextGap(8);
        sidebarPanel.add(logoutBtn);
        
        sidebarPanel.setBackground(cs.purple);
        
        sidebarPanel.setBounds(0, 0, 180, 960);
        add(sidebarPanel);
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        mainContentPanel.setBackground(Color.WHITE); 
        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);
        
        dashboardTitle = new JLabel("Savings");
        dashboardTitle.setBounds(30, 15, 100, 20);
        dashboardTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(dashboardTitle);
        
        linePanel = new JPanel();
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        lPanel = new JPanel();
        lPanel.setLayout(null);
        lPanel.setBackground(Color.WHITE);
        lPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        lPanel.setBounds(30, 80, 580, 200); 
        mainContentPanel.add(lPanel);
        
        lTitle = new JLabel("VaultBank Savings Account");
        lTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lTitle.setBounds(20, 15, 300, 25);
        lPanel.add(lTitle); 
        
        lLabel = new JLabel("PHP 18,500.00"); 
        lLabel.setFont(new Font("Arial", Font.BOLD, 26));
        lLabel.setBounds(20, 50, 300, 35);
        lPanel.add(lLabel); 
        
        lcurLabel = new JLabel("Current");
        lcurLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        lcurLabel.setForeground(Color.GRAY);
        lcurLabel.setBounds(20, 90, 100, 20);
        lPanel.add(lcurLabel); 
        
        targetBtn = new JButton("Target");
        targetBtn.setBounds(20, 130, 160, 45); 
        targetBtn.setBackground(cs.darkPurple); 
        targetBtn.setForeground(Color.WHITE);
        targetBtn.setFont(new Font("Arial", Font.BOLD, 15));
        targetBtn.setBorderPainted(false);
        targetBtn.setFocusable(false);
        targetBtn.addActionListener(this);
        lPanel.add(targetBtn);
        
        completedBtn = new JButton("Completed");
        completedBtn.setBounds(200, 130, 160, 45);
        completedBtn.setBackground(cs.darkPurple);
        completedBtn.setForeground(Color.WHITE);
        completedBtn.setFont(new Font("Arial", Font.BOLD, 15));
        completedBtn.setBorderPainted(false);
        completedBtn.setFocusable(false);
        completedBtn.addActionListener(this);
        lPanel.add(completedBtn);
        
        viewGoalBtn = new JButton("View GOAL");
        viewGoalBtn.setBounds(380, 130, 180, 45);
        viewGoalBtn.setBackground(cs.darkPurple);
        viewGoalBtn.setForeground(Color.WHITE);
        viewGoalBtn.setFont(new Font("Arial", Font.BOLD, 15));
        viewGoalBtn.setBorderPainted(false);
        viewGoalBtn.setFocusable(false);
        viewGoalBtn.addActionListener(this);
        lPanel.add(viewGoalBtn);
        
        rPanel = new JPanel();
        rPanel.setLayout(null);
        rPanel.setBackground(Color.WHITE);
        rPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        rPanel.setBounds(635, 80, 580, 200); 
        mainContentPanel.add(rPanel);
        
        rTitle = new JLabel("VaultBank Interest Account");
        rTitle.setFont(new Font("Arial", Font.BOLD, 18));
        rTitle.setBounds(20, 15, 300, 25);
        rPanel.add(rTitle);
        
        rLabel = new JLabel("PHP 4% Annual");
        rLabel.setFont(new Font("Arial", Font.BOLD, 22));
        rLabel.setBounds(20, 52, 300, 35); 
        rPanel.add(rLabel);
        
        rAccrLabel = new JLabel("Months to Forecast:");
        rAccrLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        rAccrLabel.setForeground(Color.GRAY);
        rAccrLabel.setBounds(20, 90, 130, 25);
        rPanel.add(rAccrLabel); 
        
        monthsInputText = new JTextField("12");
        monthsInputText.setFont(new Font("Arial", Font.PLAIN, 14));
        monthsInputText.setBounds(155, 90, 50, 25);
        rPanel.add(monthsInputText); 
        
        resultLabel = new JLabel("Result: ₱18,500.00");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setBounds(215, 90, 240, 25); 
        rPanel.add(resultLabel);
        
        calculateBtn = new JButton("Calculate");
        calculateBtn.setBounds(20, 130, 540, 45); 
        calculateBtn.setBackground(cs.darkPurple);
        calculateBtn.setForeground(Color.WHITE);
        calculateBtn.setFont(new Font("Arial", Font.BOLD, 15));
        calculateBtn.setBorderPainted(false);
        calculateBtn.setFocusable(false);
        calculateBtn.addActionListener(this);
        rPanel.add(calculateBtn);
        
        achievedPanel = new JPanel();
        achievedPanel.setLayout(null);
        achievedPanel.setBackground(Color.WHITE);
        achievedPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        achievedPanel.setBounds(335, 310, 540, 200); 
        mainContentPanel.add(achievedPanel);
        
        achievedTitle = new JLabel("VaultBank Achieved Goals");
        achievedTitle.setFont(new Font("Arial", Font.BOLD, 18));
        achievedTitle.setBounds(20, 15, 300, 25);
        achievedPanel.add(achievedTitle);
        
        achievedCountLabel = new JLabel("2 Goals Done");
        achievedCountLabel.setFont(new Font("Arial", Font.BOLD, 26));
        achievedCountLabel.setBounds(20, 50, 300, 35);
        achievedPanel.add(achievedCountLabel);
        
        achievedSubLabel = new JLabel("Savings History");
        achievedSubLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        achievedSubLabel.setForeground(Color.GRAY);
        achievedSubLabel.setBounds(20, 90, 150, 20);
        achievedPanel.add(achievedSubLabel);
        
        viewAchievedBtn = new JButton("View Achieved");
        viewAchievedBtn.setBounds(20, 130, 500, 45); 
        viewAchievedBtn.setBackground(cs.darkPurple);
        viewAchievedBtn.setForeground(Color.WHITE);
        viewAchievedBtn.setFont(new Font("Arial", Font.BOLD, 15));
        viewAchievedBtn.setBorderPainted(false); 
        viewAchievedBtn.setFocusable(false);     
        viewAchievedBtn.addActionListener(this);
        achievedPanel.add(viewAchievedBtn);

        transactBtn.addActionListener(this);
        balanceBtn.addActionListener(this);
        homeBtn.addActionListener(this);
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
        
        else if(e.getSource() == balanceBtn){
            BalanceUI balUI = new BalanceUI();
            balUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == homeBtn){
            CustomerDashboard cusUI = new CustomerDashboard();
            cusUI.setVisible(true);
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