package BankManage; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//dashboard @author athea-matt
public class CustomerDashboard extends JFrame {

    private JPanel contentArea;
    public CustomerDashboard() {
        setTitle("Customer Dashboard");
        setSize(1440, 960);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null); 

        JPanel sidebar = new JPanel();
        sidebar.setBounds(0, 0, 250, 960);
        sidebar.setBackground(new Color(60, 45, 120)); 
        sidebar.setLayout(null); 
        add(sidebar);

        JPanel naviPanel = new JPanel();
        naviPanel.setBounds(20, 150, 210, 400);
        naviPanel.setOpaque(false); 
        naviPanel.setLayout(new GridLayout(7, 1, 0, 15));

      String[] menu = {"Home", "Transact", "Balance", "Savings", "History", "Summaries", "Logout"};
        
        for (String name : menu) {
            JButton btn = new JButton(name);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            
            if (name.equals("Home")) {
                btn.setBackground(new Color(80, 65, 140)); 
            } else {
                btn.setBackground(new Color(60, 45, 120));
            }
            
            btn.addActionListener(e -> switchInterface(name));
            naviPanel.add(btn);
        }
        
        sidebar.add(naviPanel);
        contentArea = new JPanel();
        contentArea.setBounds(250, 0, 1190, 960);
        contentArea.setLayout(null);
        contentArea.setOpaque(false);
        add(contentArea);

        JLabel greetLabel = new JLabel("Welcome", SwingConstants.CENTER);
        greetLabel.setFont(new Font("Arial", Font.BOLD, 96));  
        greetLabel.setForeground(new Color(100, 100, 100));
        greetLabel.setBounds(300, 300, 1140, 120);
        
        JLabel userLabel = new JLabel("Melvin Mallon!", SwingConstants.CENTER);
        userLabel.setFont(new Font("Arial", Font.BOLD, 50));  
        userLabel.setForeground(new Color(100, 100, 100));
        userLabel.setBounds(300, 400, 1140, 80);

        contentArea.add(greetLabel);
        contentArea.add(userLabel);

        setVisible(true);
    }

    private void switchInterface(String name) {
        if (name.equals("Transact")) {
            TransactUI transactPage = new TransactUI(this);
            transactPage.setVisible(true);
            this.setVisible(false);
            return; 
        } else if (name.equals("History")) { 
            SummaryTransactUI historyPage = new SummaryTransactUI(this);
            historyPage.setVisible(true);
            this.setVisible(false);
            return;
        } else if (name.equals("Logout")) { 
            this.dispose();  
            System.exit(0);
            return;
        }
        
        contentArea.removeAll();
        if (name.equals("Home")) {
            JLabel greet = new JLabel("Welcome", SwingConstants.CENTER);
            greet.setBounds(0, 300, 1190, 120);
            greet.setFont(new Font("Arial", Font.BOLD, 96));
            contentArea.add(greet);
        }
        
        contentArea.revalidate();
        contentArea.repaint();
    }

    public static void main(String[] args) {
        new CustomerDashboard();
    }
}