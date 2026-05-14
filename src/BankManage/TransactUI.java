package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactUI extends JFrame implements ActionListener {

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
        setLocationRelativeTo(null);

        sidePanel = new JPanel();
        sidePanel.setBounds(0, 0, 250, 960);
        sidePanel.setBackground(new Color(60, 45, 120));
        sidePanel.setLayout(null);
        add(sidePanel);

        JPanel naviPanel = new JPanel();
        naviPanel.setBounds(20, 150, 210, 400);
        naviPanel.setOpaque(false);
        naviPanel.setLayout(new GridLayout(7, 1, 0, 15));

        String[] menu = {"Home", "Transact", "Balance", "Savings", "History", "Summaries", "Logout"};

        for (String name : menu) {
            JButton btn = new JButton(name);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setForeground(Color.WHITE);
            if (name.equals("Transact")) {
                btn.setBackground(new Color(80, 65, 140));
            } else {
                btn.setBackground(new Color(60, 45, 120));
            }
            btn.setActionCommand(name);
            btn.addActionListener(this);
            naviPanel.add(btn);
        }
        sidePanel.add(naviPanel);
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
        btnDeposit.addActionListener(this);
        add(btnDeposit);

        btnWithdrawal = new JButton("Withdrawal");
        btnWithdrawal.setBounds(720, 250, 350, 120);
        btnWithdrawal.setFont(new Font("Arial", Font.BOLD, 28));
        btnWithdrawal.setBackground(new Color(231, 76, 60));
        btnWithdrawal.setForeground(Color.WHITE);
        btnWithdrawal.addActionListener(this);
        add(btnWithdrawal);

        btnBack = new JButton("← Back to Dashboard");
        btnBack.setBounds(320, 450, 220, 45);
        btnBack.setFont(new Font("Arial", Font.BOLD, 16));
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(new Color(60, 45, 120));
        btnBack.setActionCommand("Home"); // Treat Back button as Home trigger
        btnBack.addActionListener(this);
        add(btnBack);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String cmd = e.getActionCommand();
        if (cmd.equals("Home")) {
            parentDashboard.setVisible(true);
            this.dispose();
        } else if (cmd.equals("Summaries")) {
            new SummaryTransactUI(parentDashboard);
            this.dispose();
        } else if (cmd.equals("Logout")) {
            System.exit(0);
        }
    }
}