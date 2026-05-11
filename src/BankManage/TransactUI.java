package BankManage;
import javax.swing.*;
import java.awt.*;

public class TransactUI extends JFrame {

    private JButton btnDeposit, btnWithdrawal, btnBack;
    private JLabel lblTitle;
    private JPanel sidePanel;
    private JFrame parentDashboard; 

    public TransactUI(JFrame dashboard) {
        this.parentDashboard = dashboard;
        
        setTitle("Transaction");
        setSize(1440, 960);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(245, 245, 245));
        setResizable(false);

        initializeComponents();
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        sidePanel = new JPanel();
        sidePanel.setBounds(0, 0, 250, 960);
        sidePanel.setBackground(new Color(60, 45, 120)); 
        sidePanel.setLayout(null);
        
        JPanel naviPanel = new JPanel();
        naviPanel.setBounds(20, 150, 210, 400);
        naviPanel.setOpaque(false); // Para transparent ang likod ng panel
        naviPanel.setLayout(new GridLayout(7, 1, 0, 15)); 
        
        JButton btnHome = new JButton("Home");
        btnHome.setFont(new Font("Arial", Font.BOLD, 20));
        btnHome.setForeground(Color.WHITE);
        btnHome.setBackground(new Color(60, 45, 120));
        btnHome.setFocusPainted(false);
        btnHome.setBorderPainted(false);
        btnHome.addActionListener(e -> goBackToDashboard());
        naviPanel.add(btnHome);

        JButton btnTransact = new JButton("Transact");
        btnTransact.setFont(new Font("Arial", Font.BOLD, 20));
        btnTransact.setForeground(Color.WHITE);
        btnTransact.setBackground(new Color(80, 65, 140)); // Lighter purple
        btnTransact.setFocusPainted(false);
        btnTransact.setBorderPainted(false);
        naviPanel.add(btnTransact);

        JButton btnBalance = new JButton("Balance");
        btnBalance.setFont(new Font("Arial", Font.BOLD, 20));
        btnBalance.setForeground(Color.WHITE);
        btnBalance.setBackground(new Color(60, 45, 120));
        btnBalance.setFocusPainted(false);
        btnBalance.setBorderPainted(false);
        naviPanel.add(btnBalance);

        JButton btnSavings = new JButton("Savings");
        btnSavings.setFont(new Font("Arial", Font.BOLD, 20));
        btnSavings.setForeground(Color.WHITE);
        btnSavings.setBackground(new Color(60, 45, 120));
        btnSavings.setFocusPainted(false);
        btnSavings.setBorderPainted(false);
        naviPanel.add(btnSavings);

        JButton btnHistory = new JButton("History");
        btnHistory.setFont(new Font("Arial", Font.BOLD, 20));
        btnHistory.setForeground(Color.WHITE);
        btnHistory.setBackground(new Color(60, 45, 120));
        btnHistory.setFocusPainted(false);
        btnHistory.setBorderPainted(false);
        naviPanel.add(btnHistory);

        JButton btnSummary = new JButton("Summaries");
        btnSummary.setFont(new Font("Arial", Font.BOLD, 20));
        btnSummary.setForeground(Color.WHITE);
        btnSummary.setBackground(new Color(60, 45, 120));
        btnSummary.setFocusPainted(false);
        btnSummary.setBorderPainted(false);
        naviPanel.add(btnSummary);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setFont(new Font("Arial", Font.BOLD, 20));
        btnLogout.setForeground(Color.WHITE);
        btnLogout.setBackground(new Color(60, 45, 120));
        btnLogout.setFocusPainted(false);
        btnLogout.setBorderPainted(false);
        naviPanel.add(btnLogout);   
        sidePanel.add(naviPanel);
        add(sidePanel);

        lblTitle = new JLabel("Transact");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 48));
        lblTitle.setBounds(320, 80, 400, 60);
        lblTitle.setForeground(new Color(60, 45, 120)); 
        add(lblTitle);

        btnDeposit = new JButton("Deposit");
        btnDeposit.setBounds(320, 250, 350, 120);
        btnDeposit.setFont(new Font("Arial", Font.BOLD, 28));
        btnDeposit.setBackground(new Color(46, 204, 113)); 
        btnDeposit.setForeground(Color.WHITE);
        btnDeposit.setFocusPainted(false);
        add(btnDeposit);

        btnWithdrawal = new JButton("Withdrawal");
        btnWithdrawal.setBounds(720, 250, 350, 120); 
        btnWithdrawal.setFont(new Font("Arial", Font.BOLD, 28));
        btnWithdrawal.setBackground(new Color(231, 76, 60)); 
        btnWithdrawal.setForeground(Color.WHITE);
        btnWithdrawal.setFocusPainted(false);
        add(btnWithdrawal);

        btnBack = new JButton("← Back to Dashboard");
        btnBack.setBounds(320, 450, 220, 45);
        btnBack.setFont(new Font("Arial", Font.BOLD, 16));
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(new Color(60, 45, 120));
        btnBack.setFocusPainted(false);
        btnBack.addActionListener(e -> goBackToDashboard());
        add(btnBack);
    }
    
    private void goBackToDashboard() {
        this.setVisible(false);     
        parentDashboard.setVisible(true); 
        this.dispose(); 
    }
}