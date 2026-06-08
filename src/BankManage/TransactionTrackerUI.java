package BankManage;
import BankManage.AccountModels.EmployeeModel;
import BankManage.AccountModels.TransactionModel;
import BankManage.AppService.Encryption;
import BankManage.AppService.SessionManage;
import BankManage.AppService.TransactionService;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionTrackerUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    Encryption en = new Encryption();

    // panels
    
    private JPanel sidebarPanel, mainContentPanel, linePanel, tablePanel;

    // import images
    
    java.net.URL homeImgURL = TransactionTrackerUI.class.getResource("resources/home.png");

    private ImageIcon homeRaw = new ImageIcon(homeImgURL);
    private Image homeScale = homeRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon homeIcon = new ImageIcon(homeScale);
    
    java.net.URL accountsImgURL = TransactionTrackerUI.class.getResource("resources/accounts.png");
    
    private ImageIcon accountsRaw = new ImageIcon(accountsImgURL);
    private Image accountsScale = accountsRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon accountsIcon = new ImageIcon(accountsScale);
    
    java.net.URL trackerImgURL = TransactionTrackerUI.class.getResource("resources/tracker.png");

    private ImageIcon trackerRaw = new ImageIcon(trackerImgURL);
    private Image trackerScale = trackerRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon trackerIcon = new ImageIcon(trackerScale);

    // Account Role icon (reusing accounts.png to match AdminDashboard exactly)
    java.net.URL roleImgURL = TransactionTrackerUI.class.getResource("resources/accounts.png");
    private ImageIcon roleRaw = new ImageIcon(roleImgURL);
    private Image roleScale = roleRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon roleIcon = new ImageIcon(roleScale);

    java.net.URL logoutImgURL = TransactionTrackerUI.class.getResource("resources/logout.png");
    
    private ImageIcon logoutRaw = new ImageIcon(logoutImgURL);
    private Image logoutScale = logoutRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon logoutIcon = new ImageIcon(logoutScale);
    
    java.net.URL reqImgURL = AdminDashboard.class.getResource("resources/requests.png");
    private ImageIcon reqRaw = new ImageIcon(reqImgURL);
    private Image reqScale = reqRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon reqIcon = new ImageIcon(reqScale);
    
    java.net.URL logoImgURL = TransactionTrackerUI.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));

    // sidebar
    
    private final JButton homeBtn, roleBtn, accRequestBtn, transTrackerBtn, logoutBtn;
    private final JLabel logoName;
    
    // mainContentPanel
    
    private final JLabel pageTitle;
    
    // search bar
    
    private JLabel searchLbl;
    private JTextField searchField;
    private JButton searchBtn;
    
    // table panel
    
    private final JLabel allTranslbl;
    private JTable transTable;
    private JScrollPane tableScrollPane;
    
    // filtering
    
    private JComboBox<String> filterCombo;
    private JButton filterBtn, clearFilterBtn, refreshBtn;
    
    protected String[] columnHeaders = {
        "Transaction ID", "Account ID", "Account Type", "First Name", "Purchase Name", "Date", "Amount", "Status", "Flagged"
    };
    
    public TransactionTrackerUI() {
        
        if (SessionManage.isStaffLoggedIn()){
            EmployeeModel staff = SessionManage.getCurrentStaff();
            
            System.out.println("Logged in as: " + en.decrypt(staff.getEmployeeFName())); // debug
        }
        
        setTitle("Admin Dashboard - Transaction Tracker");
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
        
        // account role
        
        roleBtn = new JButton("Account Controls", roleIcon);
        roleBtn.setBounds(0, 100, 180, 40);
        roleBtn.setBackground(cs.darkPurple);
        roleBtn.setForeground(cs.white);
        roleBtn.setFocusPainted(false);
        roleBtn.setBorderPainted(false);
        
        roleBtn.setHorizontalAlignment(SwingConstants.LEFT);
        roleBtn.setIconTextGap(8);
        sidebarPanel.add(roleBtn);
        
        // account requests
        
        accRequestBtn = new JButton("Account Requests", reqIcon);
        accRequestBtn.setBounds(0, 140, 180, 40);
        accRequestBtn.setBackground(cs.darkPurple);
        accRequestBtn.setForeground(cs.white);
        accRequestBtn.setFocusPainted(false);
        accRequestBtn.setBorderPainted(false);
        
        accRequestBtn.setHorizontalAlignment(SwingConstants.LEFT);
        accRequestBtn.setIconTextGap(8);
        sidebarPanel.add(accRequestBtn);
        
        // transaction tracker (selected)
        
        transTrackerBtn = new JButton("Transaction Tracker", trackerIcon);
        transTrackerBtn.setBounds(0, 180, 180, 40);
        transTrackerBtn.setBackground(cs.btnColorSelect);
        transTrackerBtn.setForeground(cs.white);
        transTrackerBtn.setFocusPainted(false);
        transTrackerBtn.setBorderPainted(false);
        
        transTrackerBtn.setHorizontalAlignment(SwingConstants.LEFT);
        transTrackerBtn.setIconTextGap(8);
        sidebarPanel.add(transTrackerBtn);

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
        
        // main content panel
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        
        pageTitle = new JLabel("Transaction Tracker");
        pageTitle.setBounds(30, 15, 300, 20);
        pageTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(pageTitle);
        
        linePanel = new JPanel();
        
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        // search bar
        
        searchLbl = new JLabel("Search Transaction ID:");
        searchLbl.setBounds(30, 65, 200, 30);
        searchLbl.setFont(new Font("Arial", Font.PLAIN, 13));
        mainContentPanel.add(searchLbl);

        searchField = new JTextField();
        searchField.setBounds(165, 65, 280, 30);
        searchField.setFont(new Font("Arial", Font.PLAIN, 13));
        searchField.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainContentPanel.add(searchField);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(455, 65, 100, 30);
        searchBtn.setBackground(cs.darkPurple);
        searchBtn.setForeground(cs.white);
        searchBtn.setFocusPainted(false);
        searchBtn.setBorderPainted(false);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 13));
        mainContentPanel.add(searchBtn);
        
        // table panel
        
        tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(30, 110, 1185, 790);
        tablePanel.setBackground(cs.white);
        tablePanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));

        allTranslbl = new JLabel("All Transactions");
        allTranslbl.setBounds(20, 20, 300, 30);
        allTranslbl.setFont(new Font("", Font.BOLD, 18));
        allTranslbl.setForeground(cs.darkerPurple);
        tablePanel.add(allTranslbl);

        tableScrollPane = new JScrollPane();
        tableScrollPane.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        tableScrollPane.setBounds(20, 55, 1145, 715);
        tablePanel.add(tableScrollPane);

        mainContentPanel.add(tablePanel);

        // filtering
        String[] filterOptions = {
            TransactionService.FILTER_ALL,
            TransactionService.FILTER_COMPLETED,
            TransactionService.FILTER_DECLINED,
            TransactionService.FILTER_SUSPENDED,
            TransactionService.FILTER_FROZEN,
            TransactionService.FILTER_FLAGGED,
            TransactionService.FILTER_POSITIVE,
            TransactionService.FILTER_NEGATIVE
        };

        filterCombo = new JComboBox<>(filterOptions);
        filterCombo.setBounds(785, 20, 180, 28);
        filterCombo.setBackground(Color.WHITE);
        filterCombo.setForeground(cs.darkerPurple);
        filterCombo.setFont(new Font("Arial", Font.PLAIN, 13));
        filterCombo.setFocusable(false);
        tablePanel.add(filterCombo);

        filterBtn = new JButton("Apply Filter");
        filterBtn.setBounds(975, 20, 110, 28);
        filterBtn.setBackground(cs.darkPurple);
        filterBtn.setForeground(cs.white);
        filterBtn.setFont(new Font("Arial", Font.BOLD, 12));
        filterBtn.setFocusPainted(false);
        filterBtn.setBorderPainted(false);
        tablePanel.add(filterBtn);

        filterBtn.addActionListener(this);
        
        refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(1230, 20, 90, 28);
        refreshBtn.setBackground(new Color(108, 117, 125));
        refreshBtn.setForeground(cs.white);
        refreshBtn.setFont(new Font("Arial", Font.BOLD, 12));
        refreshBtn.setFocusPainted(false);
        refreshBtn.setBorderPainted(false);
        tablePanel.add(refreshBtn);

        refreshBtn.addActionListener(this);
        
        clearFilterBtn = new JButton("Clear");
        clearFilterBtn.setBounds(1095, 20, 70, 28);
        clearFilterBtn.setBackground(new Color(108, 117, 125));
        clearFilterBtn.setForeground(cs.white);
        clearFilterBtn.setFont(new Font("Arial", Font.BOLD, 12));
        clearFilterBtn.setFocusPainted(false);
        clearFilterBtn.setBorderPainted(false);
        tablePanel.add(clearFilterBtn);

        clearFilterBtn.addActionListener(this);
        
        // load yung datas    
            
        loadTransactions();
        
        // end table
        
        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);
        
        // end content panel
        
        homeBtn.addActionListener(this);
        roleBtn.addActionListener(this);
        accRequestBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // side bar
        
        if(e.getSource() == homeBtn){
            AdminDashboard ad = new AdminDashboard();
            ad.setVisible(true);
            dispose();

        }
        
        else if(e.getSource() == roleBtn){
            AccountRoleUI roleUI = new AccountRoleUI();
            roleUI.setVisible(true);
            dispose();
        }
        
        else if(e.getSource() == accRequestBtn){
            AccountRequestsUI ar = new AccountRequestsUI();
            ar.setVisible(true);
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
        
        else if(e.getSource() == searchBtn){
            String transactId = searchField.getText().trim();
            
            TransactionService transactionService = new TransactionService();
            TransactionModel transaction = transactionService.getTransactionById(transactId);

            if (transaction != null) {
                TransactionSummaryUI ts = new TransactionSummaryUI(transactId);
                ts.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Transaction ID not found: " + transactId, 
                    "Not Found", 
                    JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(e.getSource() == filterBtn){
            applyFilter();
        }
        else if(e.getSource() == refreshBtn){
            filterCombo.setSelectedIndex(0);
            searchField.setText("");
            loadTransactions();    
        }
        else if(e.getSource() == clearFilterBtn){
            filterCombo.setSelectedIndex(0);
            loadTransactions();   
        }
    }
    
    private void loadTransactions() {
        TransactionService transactionService = new TransactionService();

        // get all transact
        List<TransactionModel> transactions = transactionService.getAllTransactions();

        // convert into data (thanks inigo)
        String[][] data = transactionService.toTableData(transactions);

        // create the table itself
        transTable = new JTable(data, columnHeaders);
        transTable.setRowHeight(40);
        transTable.setFont(new Font("Arial", Font.PLAIN, 14));
        transTable.setFocusable(false);
        transTable.getTableHeader().setReorderingAllowed(false);
        transTable.getTableHeader().setBackground(cs.darkPurple);
        transTable.getTableHeader().setForeground(cs.white);
        transTable.setSelectionBackground(cs.lightPurple);
        transTable.setSelectionForeground(cs.white);
        transTable.setShowGrid(false);
        transTable.setDefaultEditor(Object.class, null);

        transTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        transTable.getTableHeader().setPreferredSize(new Dimension(0, 45));

        // row click listener para mag paste sa search field
        transTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = transTable.getSelectedRow();
                if (row != -1) {
                    String transactId = (String) transTable.getValueAt(row, 0);
                    new TransactionSummaryUI(transactId).setVisible(true);
                    dispose();
                }
            }
        });

        tableScrollPane.setViewportView(transTable);
    }

    private void applyFilter() {
        String selectedFilter = (String) filterCombo.getSelectedItem();
        if (selectedFilter == null) return;

        TransactionService transactionService = new TransactionService();

        // transactions
        List<TransactionModel> allTransactions = transactionService.getAllTransactions();

        // filtering method
        List<TransactionModel> filteredList = transactionService.filterTransactions(allTransactions, selectedFilter);

        // convert to data para ease
        String[][] filteredData = transactionService.toTableData(filteredList);

        // updating
        transTable = new JTable(filteredData, columnHeaders);
        transTable.setRowHeight(40);
        transTable.setFont(new Font("Arial", Font.PLAIN, 14));
        transTable.setFocusable(false);
        transTable.getTableHeader().setReorderingAllowed(false);
        transTable.getTableHeader().setBackground(cs.darkPurple);
        transTable.getTableHeader().setForeground(cs.white);
        transTable.setSelectionBackground(cs.lightPurple);
        transTable.setSelectionForeground(cs.white);
        transTable.setShowGrid(false);
        transTable.setDefaultEditor(Object.class, null);

        transTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        transTable.getTableHeader().setPreferredSize(new Dimension(0, 45));

        // click listener
        transTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = transTable.getSelectedRow();
                if (row != -1) {
                    String transactId = (String) transTable.getValueAt(row, 0);
                    TransactionSummaryUI ts = new TransactionSummaryUI(transactId);
                    ts.setVisible(true);
                    dispose();
                }
            }
        });

        tableScrollPane.setViewportView(transTable);
    }
    
}