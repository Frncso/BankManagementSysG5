package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SummaryTransactUI extends JFrame implements ActionListener {

    private JLabel lblTitle;
    private JPanel sidePanel;
    private JFrame parentDashboard;

    public SummaryTransactUI(JFrame dashboard) {
        this.parentDashboard = dashboard;

        setTitle("Transaction History");
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
            
            if (name.equals("History")) {
                btn.setBackground(new Color(80, 65, 140));
            } else {
                btn.setBackground(new Color(60, 45, 120)); 
            }
            
            btn.addActionListener(this);
            naviPanel.add(btn);
        }
        
        sidePanel.add(naviPanel);
        lblTitle = new JLabel("Transaction History");
        lblTitle.setFont(new Font("Serif", Font.BOLD, 48));
        lblTitle.setBounds(320, 80, 500, 60);
        lblTitle.setForeground(new Color(60, 45, 120)); 
        add(lblTitle);

        JPanel box1 = new JPanel();
        box1.setBounds(320, 160, 600, 100);
        box1.setBackground(Color.WHITE);
        box1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); 
        box1.setLayout(null);

        JLabel lblDate1 = new JLabel("April 2, 2026 (Deposit)");
        lblDate1.setFont(new Font("Arial", Font.PLAIN, 24));
        lblDate1.setBounds(20, 10, 400, 40);
        box1.add(lblDate1);

        JLabel lblAmt1 = new JLabel("+ P 5,000.00");
        lblAmt1.setFont(new Font("Arial", Font.BOLD, 24));
        lblAmt1.setForeground(new Color(46, 204, 113));
        lblAmt1.setBounds(20, 50, 400, 40);
        box1.add(lblAmt1);
        add(box1);

        JPanel box2 = new JPanel();
        box2.setBounds(320, 280, 600, 100); 
        box2.setBackground(Color.WHITE);
        box2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        box2.setLayout(null);

        JLabel lblDate2 = new JLabel("February 27, 2026 (Withdrawal)");
        lblDate2.setFont(new Font("Arial", Font.PLAIN, 24));
        lblDate2.setBounds(20, 10, 400, 40);
        box2.add(lblDate2);

        JLabel lblAmt2 = new JLabel("- P 2,500.00");
        lblAmt2.setFont(new Font("Arial", Font.BOLD, 24));
        lblAmt2.setForeground(new Color(231, 76, 60));
        lblAmt2.setBounds(20, 50, 400, 40);
        box2.add(lblAmt2);
        add(box2);

        JPanel box3 = new JPanel();
        box3.setBounds(320, 400, 600, 100); 
        box3.setBackground(Color.WHITE);
        box3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        box3.setLayout(null);

        JLabel lblDate3 = new JLabel("March 17, 2026 (Withdrawal)");
        lblDate3.setFont(new Font("Arial", Font.PLAIN, 24));
        lblDate3.setBounds(20, 10, 400, 40);
        box3.add(lblDate3);

        JLabel lblAmt3 = new JLabel("- P 7,000.00");
        lblAmt3.setFont(new Font("Arial", Font.BOLD, 24));
        lblAmt3.setForeground(new Color(231, 76, 60)); 
        lblAmt3.setBounds(20, 50, 400, 40);
        box3.add(lblAmt3);
        add(box3);

        JButton btnBack = new JButton("← Back to Dashboard");
        btnBack.setBounds(320, 550, 220, 45); 
        btnBack.setFont(new Font("Arial", Font.BOLD, 16));
        btnBack.setBackground(Color.WHITE);
        btnBack.setForeground(new Color(60, 45, 120));
        btnBack.addActionListener(this);
        add(btnBack);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
   String command = e.getActionCommand();
        if (command.equals("Home")) {
            parentDashboard.setVisible(true);
            this.dispose();
        } else if (command.equals("History")) {
            new SummaryTransactUI(parentDashboard);
            this.dispose();
        } else if (command.equals("Logout")) {
            System.exit(0);
        }
    }
}