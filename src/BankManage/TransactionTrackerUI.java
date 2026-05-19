package BankManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionTrackerUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();

    private JPanel sidebarPanel, mainContentPanel, linePanel, tablePanel;

    // --- Sidebar Icons ---
    java.net.URL homeImgURL     = TransactionTrackerUI.class.getResource("resources/home.png");
    java.net.URL accountsImgURL = TransactionTrackerUI.class.getResource("resources/accounts.png");
    java.net.URL trackerImgURL  = TransactionTrackerUI.class.getResource("resources/tracker.png");
    java.net.URL logoutImgURL   = TransactionTrackerUI.class.getResource("resources/logout.png");
    java.net.URL logoImgURL     = TransactionTrackerUI.class.getResource("resources/bluewhiteLogo.png");

    private ImageIcon homeIcon, accountsIcon, trackerIcon, logoutIcon;

    private final JLabel logo;
    private final JButton homeBtn, accRequestBtn, transTrackerBtn, logoutBtn;
    private final JLabel logoName;

    private final JLabel pageTitle, allTransLbl;
    private JTable transTable;
    private JScrollPane tableScrollPane;
    private JTextField searchField;
    private JButton searchBtn;

    protected String[] columnHeaders = {
        "Transaction ID", "Account ID", "Account Type", "First Name", "Purchase Name", "Date", "Amount", "Status"
    };

    protected Object[][] tableData = {
        {"TXN-001", "ACC-12345", "Savings",  "Ezekiel", "Fully Booked",            "May 10, 2026",       "₱25,120.50", "Completed"},
        {"TXN-002", "ACC-12346", "Checking", "Inigo",   "Nintendo Shop",           "May 5, 2026",        "₱0.00",      "Declined"},
        {"TXN-003", "ACC-12347", "Savings",  "Athea",   "Fully Booked",            "January 7, 2026",    "₱250.00",    "Completed"},
        {"TXN-004", "ACC-12348", "Savings",  "Maria",   "Food Panda",              "January 6, 2026",    "₱1,600.00",  "Completed"},
        {"TXN-005", "ACC-12349", "Checking", "Jose",    "The Golden Fur PH",       "January 1, 2026",    "₱1,200.00",  "Completed"},
        {"TXN-006", "ACC-12350", "Savings",  "Ana",     "Shopee Philippines",      "January 1, 2026",    "₱300.00",    "Completed"},
        {"TXN-007", "ACC-12351", "Savings",  "Carlos",  "Minecraft Gift",          "January 1, 2026",    "₱1,600.00",  "Completed"},
        {"TXN-008", "ACC-12352", "Checking", "Rosa",    "Apple Pay Transfer",      "December 25, 2025",  "₱2,000.00",  "Completed"},
        {"TXN-009", "ACC-12353", "Savings",  "Pedro",   "Paypal Transfer",         "December 24, 2025",  "₱50,600.00", "Pending"},
        {"TXN-010", "ACC-12354", "Savings",  "Luis",    "Steam 20USD Gift Card",   "December 1, 2025",   "₱1,200.00",  "Completed"},
        {"TXN-011", "ACC-12355", "Checking", "Clara",   "LetterBoxd Patreon",      "December 1, 2025",   "₱999.00",    "Completed"},
        {"TXN-012", "ACC-12356", "Savings",  "Marco",   "GCash Transfer",          "November 1, 2025",   "₱1,600.00",  "Pending"},
        {"TXN-013", "ACC-12357", "Savings",  "Sofia",   "Spotify Premium Yearly",  "September 25, 2025", "₱2,000.00",  "Completed"},
        {"TXN-014", "ACC-12358", "Checking", "Diego",   "PayPal Transfer",         "September 24, 2025", "₱10,600.00", "Completed"},
    };

    public TransactionTrackerUI() {
        setTitle("Admin Dashboard - Transaction Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1440, 960);
        setLocationRelativeTo(null);
        setResizable(false);

        // Scale icons
        homeIcon     = scaleIcon(homeImgURL, 20, 20);
        accountsIcon = scaleIcon(accountsImgURL, 20, 20);
        trackerIcon  = scaleIcon(trackerImgURL, 20, 20);
        logoutIcon   = scaleIcon(logoutImgURL, 20, 20);

        logo = new JLabel(scaleIcon(logoImgURL, 30, 30));

        // ── Sidebar ──────────────────────────────────────────────
        sidebarPanel = new JPanel();
        sidebarPanel.setLayout(null);
        sidebarPanel.setBackground(cs.purple);
        sidebarPanel.setBounds(0, 0, 180, 960);

        logoName = new JLabel("VAULTBANK");
        logoName.setBounds(52, 14, 130, 30);
        logoName.setForeground(cs.white);
        logoName.setFont(new Font("Cascadia Code", Font.BOLD, 20));
        sidebarPanel.add(logoName);

        logo.setBounds(12, 15, 30, 30);
        sidebarPanel.add(logo);

        homeBtn = makeSidebarBtn("Home", homeIcon, cs.darkPurple, 60);
        sidebarPanel.add(homeBtn);

        accRequestBtn = makeSidebarBtn("Account Requests", accountsIcon, cs.darkPurple, 140);
        sidebarPanel.add(accRequestBtn);

        transTrackerBtn = makeSidebarBtn("Transaction Tracker", trackerIcon, cs.btnColorSelect, 220);
        sidebarPanel.add(transTrackerBtn);

        logoutBtn = makeSidebarBtn("Logout", logoutIcon, cs.darkPurple, 840);
        sidebarPanel.add(logoutBtn);

        add(sidebarPanel);

        // ── Main Content ──────────────────────────────────────────
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        mainContentPanel.setBounds(180, 0, 1260, 960);

        pageTitle = new JLabel("Transaction Tracker");
        pageTitle.setBounds(30, 15, 300, 20);
        pageTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(pageTitle);

        linePanel = new JPanel();
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);

        // Search bar
        JLabel searchLbl = new JLabel("Search Transaction ID:");
        searchLbl.setBounds(30, 65, 200, 30);
        searchLbl.setFont(new Font("Arial", Font.PLAIN, 13));
        mainContentPanel.add(searchLbl);

        searchField = new JTextField();
        searchField.setBounds(235, 65, 280, 30);
        searchField.setFont(new Font("Arial", Font.PLAIN, 13));
        searchField.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainContentPanel.add(searchField);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(525, 65, 100, 30);
        searchBtn.setBackground(cs.darkPurple);
        searchBtn.setForeground(cs.white);
        searchBtn.setFocusPainted(false);
        searchBtn.setBorderPainted(false);
        searchBtn.setContentAreaFilled(true);
        searchBtn.setOpaque(true);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 13));
        searchBtn.addActionListener(this);
        mainContentPanel.add(searchBtn);

        // Table panel
        tablePanel = new JPanel();
        tablePanel.setLayout(null);
        tablePanel.setBounds(30, 110, 1185, 790);
        tablePanel.setBackground(cs.white);
        tablePanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));

        allTransLbl = new JLabel("All Transactions");
        allTransLbl.setBounds(20, 15, 300, 30);
        allTransLbl.setFont(new Font("", Font.BOLD, 18));
        allTransLbl.setForeground(cs.darkerPurple);
        tablePanel.add(allTransLbl);

        transTable = new JTable(tableData, columnHeaders);
        transTable.setRowHeight(40);
        transTable.setFont(new Font("Arial", Font.PLAIN, 13));
        transTable.setFocusable(false);
        transTable.getTableHeader().setReorderingAllowed(false);
        transTable.getTableHeader().setBackground(cs.darkPurple);
        transTable.getTableHeader().setForeground(cs.white);
        transTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        transTable.getTableHeader().setPreferredSize(new Dimension(0, 45));
        transTable.setSelectionBackground(cs.lightPurple);
        transTable.setSelectionForeground(cs.white);
        transTable.setShowGrid(false);
        transTable.setDefaultEditor(Object.class, null);

        tableScrollPane = new JScrollPane(transTable);
        tableScrollPane.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        tableScrollPane.setBounds(20, 55, 1145, 715);
        tablePanel.add(tableScrollPane);

        mainContentPanel.add(tablePanel);
        add(mainContentPanel);

        homeBtn.addActionListener(this);
        accRequestBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
    }

    // ── Helpers ───────────────────────────────────────────────────
    private ImageIcon scaleIcon(java.net.URL url, int w, int h) {
        if (url == null) return new ImageIcon();
        return new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }

    private JButton makeSidebarBtn(String text, ImageIcon icon, Color bg, int y) {
        JButton btn = new JButton(text, icon);
        btn.setBounds(0, y, 180, 40);
        btn.setBackground(bg);
        btn.setForeground(cs.white);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setIconTextGap(8);
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeBtn) {
            new AdminDashboard().setVisible(true);
            dispose();

        } else if (e.getSource() == accRequestBtn) {
            new AccountRequestsUI().setVisible(true);
            dispose();

        } else if (e.getSource() == logoutBtn) {
            new LoginUI().setVisible(true);
            dispose();

        } else if (e.getSource() == searchBtn) {
            String query = searchField.getText().trim();
            if (query.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please enter a Transaction ID.", "Search", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Object[] found = null;
            for (Object[] row : tableData) {
                if (row[0].toString().equalsIgnoreCase(query)) {
                    found = row;
                    break;
                }
            }
            if (found == null) {
                JOptionPane.showMessageDialog(this,
                    "No transaction found for ID: " + query, "Not Found", JOptionPane.ERROR_MESSAGE);
            } else {
                TransactionSummaryUI summaryUI = new TransactionSummaryUI(found, this);
                summaryUI.setVisible(true);
                setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        TransactionTrackerUI tt = new TransactionTrackerUI();
        tt.setVisible(true);
    }
}