package BankManage; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminDashboard extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    
    private JPanel sidebarPanel, mainContentPanel, linePanel;
    
    java.net.URL homeImgURL = AdminDashboard.class.getResource("resources/home.png");
    
    private ImageIcon homeRaw = new ImageIcon(homeImgURL);
    private Image homeScale = homeRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon homeIcon = new ImageIcon(homeScale);
    
    java.net.URL accountsImgURL = AdminDashboard.class.getResource("resources/accounts.png");
    
    private ImageIcon accountsRaw = new ImageIcon(accountsImgURL);
    private Image accountsScale = accountsRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon accountsIcon = new ImageIcon(accountsScale);
    
    java.net.URL logoutImgURL = AdminDashboard.class.getResource("resources/logout.png");
    
    private ImageIcon logoutRaw = new ImageIcon(logoutImgURL);
    private Image logoutScale = logoutRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon logoutIcon = new ImageIcon(logoutScale);
    
    java.net.URL logoImgURL = AdminDashboard.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));
    
    java.net.URL trackerImgURL = AdminDashboard.class.getResource("resources/tracker.png");

    private ImageIcon trackerRaw = new ImageIcon(trackerImgURL);
    private Image trackerScale = trackerRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon trackerIcon = new ImageIcon(trackerScale);

    private final JButton homeBtn, accRequestBtn, logoutBtn, transTrackerBtn;
    private final JLabel logoName;
    
    private final JLabel dashboardTitle;
    
    public AdminDashboard() {
        setTitle("Admin Dashboard - Home");
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
        
        homeBtn = new JButton("Home", homeIcon);
        homeBtn.setBounds(0, 60, 180, 40);
        homeBtn.setBackground(cs.btnColorSelect);
        homeBtn.setForeground(cs.white);
        homeBtn.setFocusPainted(false);
        homeBtn.setBorderPainted(false);
        homeBtn.setHorizontalAlignment(SwingConstants.LEFT);
        homeBtn.setIconTextGap(8);
        sidebarPanel.add(homeBtn);
        
        accRequestBtn = new JButton("Account Requests", accountsIcon);
        accRequestBtn.setBounds(0, 140, 180, 40);
        accRequestBtn.setBackground(cs.darkPurple);
        accRequestBtn.setForeground(cs.white);
        accRequestBtn.setFocusPainted(false);
        accRequestBtn.setBorderPainted(false);
        accRequestBtn.setHorizontalAlignment(SwingConstants.LEFT);
        accRequestBtn.setIconTextGap(8);
        sidebarPanel.add(accRequestBtn);
        
        logoutBtn = new JButton("Logout", logoutIcon);
        logoutBtn.setBounds(0, 840, 180, 40);
        logoutBtn.setBackground(cs.darkPurple);
        logoutBtn.setForeground(cs.white);
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setHorizontalAlignment(SwingConstants.LEFT);
        logoutBtn.setIconTextGap(8);
        sidebarPanel.add(logoutBtn);
        
        transTrackerBtn = new JButton("Transaction Tracker", trackerIcon);
        transTrackerBtn.setBounds(0, 180, 180, 40);
        transTrackerBtn.setBackground(cs.darkPurple);
        transTrackerBtn.setForeground(cs.white);
        transTrackerBtn.setFocusPainted(false);
        transTrackerBtn.setBorderPainted(false);
        transTrackerBtn.setHorizontalAlignment(SwingConstants.LEFT);
        transTrackerBtn.setIconTextGap(8);
        sidebarPanel.add(transTrackerBtn);
        
        sidebarPanel.setBackground(cs.purple);
        sidebarPanel.setBounds(0, 0, 180, 960);
        add(sidebarPanel);
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        
        dashboardTitle = new JLabel("Home");
        dashboardTitle.setBounds(30, 15, 200, 20);
        dashboardTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(dashboardTitle);
        
        linePanel = new JPanel();
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        mainContentPanel.setBounds(180, 0, 1260, 960);
        add(mainContentPanel);
        
        accRequestBtn.addActionListener(this);
        logoutBtn.addActionListener(this);
        transTrackerBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accRequestBtn) {
            AccountRequestsUI reqUI = new AccountRequestsUI();
            reqUI.setVisible(true);
            dispose();
            
        } else if (e.getSource() == logoutBtn) {
            LoginUI logUI = new LoginUI();
            logUI.setVisible(true);
            dispose();
        } else if (e.getSource() == transTrackerBtn) {
        new TransactionTrackerUI().setVisible(true);
        dispose();
}
    }
    
    public static void main(String[] args) {
        AdminDashboard ad = new AdminDashboard();
        ad.setVisible(true);
    }
}
