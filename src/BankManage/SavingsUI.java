package BankManage; 
import BankManage.AccountModels.BankAccount;
import BankManage.AccountModels.CustomerModel;
import BankManage.AppService.BankAccountService;
import BankManage.AppService.SavingsService;
import BankManage.AppService.SessionManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

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
    
    java.net.URL targetImgURL = CustomerDashboard.class.getResource("resources/target.png");
    
    private ImageIcon targetRaw = new ImageIcon(targetImgURL);
    private Image targetScale = targetRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon targetIcon = new ImageIcon(targetScale);
    
    java.net.URL checkImgURL = CustomerDashboard.class.getResource("resources/list.png");
    
    private ImageIcon checkRaw = new ImageIcon(checkImgURL);
    private Image checkScale = checkRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon checkIcon = new ImageIcon(checkScale);
    
    java.net.URL eyeImgURL = CustomerDashboard.class.getResource("resources/eye.png");
    
    private ImageIcon eyeRaw = new ImageIcon(eyeImgURL);
    private Image eyeScale = eyeRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon eyeIcon = new ImageIcon(eyeScale);
    
    
    // logo
    
    java.net.URL logoImgURL = CustomerDashboard.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));;
    
    // sidebar + Added
    
    private final JButton homeBtn, transactBtn, balanceBtn, savingsBtn, accountsBtn, logoutBtn;
    
    private final JLabel logoName;
    
    private JLabel actionlbl, actionTwolbl;
    
    private double savingsBal;
    
    private JLabel dashboardTitle;
    private JLabel lTitle, lLabel, lcurLabel;
    private JLabel achievedTitle, achievedCountLabel, achievedSubLabel;
   
    private JPanel lPanel;
    private JPanel achievedPanel;
    
    private JButton targetBtn, viewGoalBtn;
    private JButton viewAchievedBtn;

    public SavingsUI() {
        
        setTitle("Dashboard - Savings");
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
        
        transactBtn = new JButton("Transactions", transactIcon);
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
        lPanel.setBounds(30, 80, 1185, 200); 
        mainContentPanel.add(lPanel);
        
        lTitle = new JLabel("VaultBank Total Savings");
        lTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lTitle.setBounds(20, 15, 300, 25);
        lPanel.add(lTitle); 
        
        lLabel = new JLabel("₱"+String.format("%,.2f", savingsBal)); 
        lLabel.setFont(new Font("Arial", Font.BOLD, 26));
        lLabel.setBounds(20, 50, 300, 35);
        lPanel.add(lLabel); 
        
        lcurLabel = new JLabel("Current");
        lcurLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        lcurLabel.setForeground(Color.GRAY);
        lcurLabel.setBounds(20, 90, 100, 20);
        lPanel.add(lcurLabel); 
        
        targetBtn = new JButton("Target", targetIcon);
        targetBtn.setBounds(545, 130, 300, 45); 
        targetBtn.setBackground(cs.darkPurple); 
        targetBtn.setForeground(Color.WHITE);
        targetBtn.setFont(new Font("Arial", Font.BOLD, 15));
        targetBtn.setBorderPainted(false);
        targetBtn.setFocusable(false);
        targetBtn.setHorizontalAlignment(SwingConstants.CENTER);
        targetBtn.setMargin(new Insets(0, 0, 0, 10));
        targetBtn.setIconTextGap(10);
        targetBtn.addActionListener(this);
        lPanel.add(targetBtn);
        
        viewGoalBtn = new JButton("View Goals", checkIcon);
        viewGoalBtn.setBounds(865, 130, 300, 45);
        viewGoalBtn.setBackground(cs.darkPurple);
        viewGoalBtn.setForeground(Color.WHITE);
        viewGoalBtn.setFont(new Font("Arial", Font.BOLD, 15));
        viewGoalBtn.setBorderPainted(false);
        viewGoalBtn.setFocusable(false);
        viewGoalBtn.setHorizontalAlignment(SwingConstants.CENTER);
        viewGoalBtn.setMargin(new Insets(0, 0, 0, 10));
        viewGoalBtn.setIconTextGap(10);
        viewGoalBtn.addActionListener(this);
        lPanel.add(viewGoalBtn);
        
        actionlbl = new JLabel("Choose Action");
        actionlbl.setBounds(545, 100, 250, 20);
        actionlbl.setForeground(cs.darkerPurple);
        lPanel.add(actionlbl);
        
        achievedPanel = new JPanel();
        achievedPanel.setLayout(null);
        achievedPanel.setBackground(Color.WHITE);
        achievedPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1)); 
        achievedPanel.setBounds(30, 310, 1185, 200); 
        mainContentPanel.add(achievedPanel);
        
        achievedTitle = new JLabel("VaultBank Achieved Goals");
        achievedTitle.setFont(new Font("Arial", Font.BOLD, 18));
        achievedTitle.setBounds(20, 15, 300, 25);
        achievedPanel.add(achievedTitle);
        
        achievedCountLabel = new JLabel("0 Goals Done");
        achievedCountLabel.setFont(new Font("Arial", Font.BOLD, 26));
        achievedCountLabel.setBounds(20, 50, 300, 35);
        achievedPanel.add(achievedCountLabel);
        
        achievedSubLabel = new JLabel("Savings History");
        achievedSubLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        achievedSubLabel.setForeground(Color.GRAY);
        achievedSubLabel.setBounds(20, 90, 150, 20);
        achievedPanel.add(achievedSubLabel);
        
        actionTwolbl = new JLabel("Choose Action");
        actionTwolbl.setBounds(545, 100, 250, 20);
        actionTwolbl.setForeground(cs.darkerPurple);
        achievedPanel.add(actionTwolbl);
        
        viewAchievedBtn = new JButton("View Achieved", eyeIcon);
        viewAchievedBtn.setBounds(545, 130, 620, 45); 
        viewAchievedBtn.setBackground(cs.darkPurple);
        viewAchievedBtn.setForeground(Color.WHITE);
        viewAchievedBtn.setFont(new Font("Arial", Font.BOLD, 15));
        viewAchievedBtn.setBorderPainted(false); 
        viewAchievedBtn.setFocusable(false);     
        viewAchievedBtn.setHorizontalAlignment(SwingConstants.CENTER);
        viewAchievedBtn.setMargin(new Insets(0, 0, 0, 10));
        viewAchievedBtn.setIconTextGap(10);
        viewAchievedBtn.addActionListener(this);
        achievedPanel.add(viewAchievedBtn);

        transactBtn.addActionListener(this);
        balanceBtn.addActionListener(this);
        homeBtn.addActionListener(this);
        accountsBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

        
        if (SessionManage.isCustomerLoggedIn()){
            CustomerModel customer = SessionManage.getCurrentCustomer();
            System.out.println("Logged in as: " + customer.getFirstName()); // debug
            loadSavingTotal();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        CustomerModel customer = SessionManage.getCurrentCustomer();
        
        
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
         
        else if(e.getSource() == targetBtn){
            String getUser = customer.getCustomerId();
            SavingsTargetUI savTget = new SavingsTargetUI(getUser);
            savTget.setVisible(true);
            dispose();
        }
         
         else if(e.getSource() == viewGoalBtn){
             String getUser = customer.getCustomerId();
             SavingsViewGoalsUI savViewGoals = new SavingsViewGoalsUI(getUser, savingsBal, "SaveUI");
             savViewGoals.setVisible(true);
             dispose();
        }
         
         else if(e.getSource() == viewAchievedBtn){
             String getUser = customer.getCustomerId();
             SavingsViewAchievedGoalsUI savViewAchievedGoalsUI = new SavingsViewAchievedGoalsUI(getUser);
             savViewAchievedGoalsUI.setVisible(true);
             dispose();
        }
    }
    
    private List<BankAccount> customerAccounts = new ArrayList<>();
    
    private void loadSavingTotal(){

        CustomerModel customer = SessionManage.getCurrentCustomer();

        BankAccountService accountService = new BankAccountService();
        customerAccounts = accountService.getCustomerAccounts(customer.getCustomerId());

        // grouping accs by type for future use
        Map<String, List<BankAccount>> accountsByType = new HashMap<>();

        for (BankAccount acc : customerAccounts) {
            accountsByType
                .computeIfAbsent(acc.getAccountType(), k -> new ArrayList<>())
                .add(acc);
        }
        
        updateGoalsAchievedLabel();
        
        Map<String, Double> totalsByType = calculateTotalsByType(customerAccounts);
        double totalSavings  = totalsByType.getOrDefault("Savings", 0.0);
        
        lLabel.setText("₱" + String.format("%,.2f", totalSavings));
        savingsBal = totalSavings;
    }
    
    private Map<String, Double> calculateTotalsByType(List<BankAccount> accounts) {
        Map<String, Double> totals = new HashMap<>();

        for (BankAccount acc : accounts) {
            String type = acc.getAccountType();
            double currentTotal = totals.getOrDefault(type, 0.0);
            totals.put(type, currentTotal + acc.getBalance());
        }

        return totals;
    }
    
    private void updateGoalsAchievedLabel() {
        SavingsService goalService = new SavingsService();
        CustomerModel customer = SessionManage.getCurrentCustomer();

        int completed = goalService.getCompletedGoalsCount(customer.getCustomerId());
        achievedCountLabel.setText(completed + " Goals Achieved");
    }
    
}