package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionTrackerUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();

    // panels

    private JPanel sidebarPanel, mainContentPanel, linePanel, trackerPanel;

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

    //logo

    java.net.URL logoImgURL = CustomerDashboard.class.getResource("resources/bluewhiteLogo.png");

    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));

    //sidebar

    private final JButton homeBtn, transactBtn, balanceBtn, savingsBtn, accountsBtn, logoutBtn;
    private final JLabel logoName;

    //main

    private JLabel dashboardTitle;

    //tracker table

    private JLabel trackerLbl;
    private JTable trackerTable;
    private JScrollPane trackerScroll;

    protected String[] trackerColumns = {
        "Name", "Date", "Type", "Status", "Amount"
    };

    protected String[][] trackerData = {
        {"Fully Booked",        "May 10, 2026",       "Credit",  "Completed", "+₱25,120.50"},
        {"Nintendo Shop",      "May 5, 2026",        "Debit",   "Declined",  "=₱0.00"},
        {"Fully Booked",         "January 7, 2026",    "Debit",   "Completed", "-₱250.00"},
        {"Food Panda",       "January 6, 2026",    "Debit",   "Completed", "-₱1,600.00"},
        {"The Golden Fur PH",  "January 1, 2026",    "Debit",   "Completed", "-₱1,200.00"},
        {"Shopee Philippines",     "January 1, 2026",    "Debit",   "Completed", "-₱300.00"},
        {"Minecraft Gift",         "January 1, 2026",    "Debit",   "Completed", "-₱1,600.00"},
        {"Apple Pay Transfer", "December 25, 2025",  "Debit",   "Completed", "-₱2,000.00"},
        {"Paypal Transfer",        "December 24, 2025",  "Credit",  "Completed", "+₱50,600.00"},
        {"Steam 20USD Gift Card",  "December 1, 2025",   "Debit",   "Completed", "-₱1,200.00"},
        {"LetterBoxd Patreon Membership",     "December 1, 2025",   "Debit",   "Completed", "-₱999.00"},
        {"Gcash Transfer",        "November 1, 2025",   "Debit",   "Completed", "-₱1,600.00"},
        {"Spotify Premium Yearly", "September 25, 2025", "Debit",   "Completed", "-₱2,000.00"},
        {"PayPal Transfer",        "September 24, 2025", "Credit",  "Completed", "+₱10,600.00"},
    };

    //

    public TransactionTrackerUI() {
        setTitle("Dashboard - Transaction Tracker");
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

        //home icon

        homeBtn = new JButton("Home", homeIcon);
        homeBtn.setBounds(0, 60, 180, 40);
        homeBtn.setBackground(cs.darkPurple);
        homeBtn.setForeground(cs.white);
        homeBtn.setFocusPainted(false);
        homeBtn.setBorderPainted(false);

        //icon beside button

        homeBtn.setHorizontalAlignment(SwingConstants.LEFT);
        homeBtn.setIconTextGap(8);
        sidebarPanel.add(homeBtn);

        //transact

        transactBtn = new JButton("Transact", transactIcon);
        transactBtn.setBounds(0, 100, 180, 40);
        transactBtn.setBackground(cs.btnColorSelect);
        transactBtn.setForeground(cs.white);
        transactBtn.setFocusPainted(false);
        transactBtn.setBorderPainted(false);

        //icon beside button

        transactBtn.setHorizontalAlignment(SwingConstants.LEFT);
        transactBtn.setIconTextGap(8);
        sidebarPanel.add(transactBtn);

        //balance

        balanceBtn = new JButton("Balance", balanceIcon);
        balanceBtn.setBounds(0, 140, 180, 40);
        balanceBtn.setBackground(cs.darkPurple);
        balanceBtn.setForeground(cs.white);
        balanceBtn.setFocusPainted(false);
        balanceBtn.setBorderPainted(false);

        //icon beside button

        balanceBtn.setHorizontalAlignment(SwingConstants.LEFT);
        balanceBtn.setIconTextGap(8);
        sidebarPanel.add(balanceBtn);

        //savings

        savingsBtn = new JButton("Savings", savingsIcon);
        savingsBtn.setBounds(0, 180, 180, 40);
        savingsBtn.setBackground(cs.darkPurple);
        savingsBtn.setForeground(cs.white);
        savingsBtn.setFocusPainted(false);
        savingsBtn.setBorderPainted(false);

        //icon beside button

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

        //icon beside button

        accountsBtn.setHorizontalAlignment(SwingConstants.LEFT);
        accountsBtn.setIconTextGap(8);
        sidebarPanel.add(accountsBtn);

        //logout

        logoutBtn = new JButton("Logout", logoutIcon);
        logoutBtn.setBounds(0, 840, 180, 40);
        logoutBtn.setBackground(cs.darkPurple);
        logoutBtn.setForeground(cs.white);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorderPainted(false);

        //icon beside button

        logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
        logoutBtn.setIconTextGap(8);
        sidebarPanel.add(logoutBtn);

        sidebarPanel.setBackground(cs.purple);

        sidebarPanel.setBounds(0, 0, 180, 960);
        add(sidebarPanel);

        //main content panel

        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);

        dashboardTitle = new JLabel("Transaction Tracker");
        dashboardTitle.setBounds(30, 15, 200, 20);
        dashboardTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(dashboardTitle);

        linePanel = new JPanel();

        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);

        //tracker panel

        trackerPanel = new JPanel();
        trackerPanel.setLayout(null);
        trackerPanel.setBounds(30, 75, 1185, 830);
        trackerPanel.setBackground(Color.WHITE);
        trackerPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainContentPanel.add(trackerPanel);

        trackerLbl = new JLabel("All Transactions");
        trackerLbl.setBounds(20, 20, 250, 20);
        trackerLbl.setFont(new Font("", Font.BOLD, 18));
        trackerLbl.setForeground(cs.darkerPurple);
        trackerPanel.add(trackerLbl);

        //table

        trackerTable = new JTable(trackerData, trackerColumns);
        trackerTable.setRowHeight(40);
        trackerTable.setFont(new Font("Arial", Font.PLAIN, 14));
        trackerTable.setFocusable(false);
        trackerTable.getTableHeader().setReorderingAllowed(false);
        trackerTable.getTableHeader().setBackground(cs.darkPurple);
        trackerTable.getTableHeader().setForeground(cs.white);
        trackerTable.setSelectionBackground(cs.lightPurple);
        trackerTable.setSelectionForeground(cs.white);
        trackerTable.setShowGrid(false);
        trackerTable.setDefaultEditor(Object.class, null);

        trackerTable.getTableHeader().setFont(
            new Font("Arial", Font.BOLD, 14)
        );
        trackerTable.getTableHeader().setPreferredSize(
            new Dimension(0, 45)
        );

        //scroll

        trackerScroll = new JScrollPane(trackerTable);
        trackerScroll.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        trackerScroll.setBounds(20, 60, 1145, 755);
        trackerPanel.add(trackerScroll);

        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);

        //end content panel

        homeBtn.addActionListener(this);
        transactBtn.addActionListener(this);
        balanceBtn.addActionListener(this);
        savingsBtn.addActionListener(this);
        accountsBtn.addActionListener(this);
        logoutBtn.addActionListener(this);

    }

@Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == homeBtn) {
            CustomerDashboard cusUI = new CustomerDashboard();
            cusUI.setVisible(true);
            dispose();
        }

        else if (e.getSource() == transactBtn) {
            TransactUI traUI = new TransactUI();
            traUI.setVisible(true);
            dispose();
        }

        else if (e.getSource() == balanceBtn) {
            BalanceUI balUI = new BalanceUI();
            balUI.setVisible(true);
            dispose();
        }

        else if (e.getSource() == savingsBtn) {
            SavingsUI saveUI = new SavingsUI();
            saveUI.setVisible(true);
            dispose();
        }

        else if (e.getSource() == accountsBtn) {
            AccountMenuUI accMenUI = new AccountMenuUI();
            accMenUI.setVisible(true);
            dispose();
        }

        else if (e.getSource() == logoutBtn) {
            LoginUI logUI = new LoginUI();
            logUI.setVisible(true);
            dispose();
        }

    }  //

    public static void main(String[] args) {
        TransactionTrackerUI trackerUI = new TransactionTrackerUI();
        trackerUI.setVisible(true);
    }

}