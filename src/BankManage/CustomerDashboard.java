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
//diff.buttons/panel
        String[] menu = {"Home", "Transact", "Balance", "Savings", "History", "Summaries", "Logout"};
        for (String name : menu) {
            JButton btn = new JButton(name);
            btn.setFocusable(false);
            btn.addActionListener(e -> switchInterface(name));
            naviPanel.add(btn);
        }
        sidebar.add(naviPanel);

        contentArea = new JPanel();
        contentArea.setBounds(250, 0, 1190, 960);
        contentArea.setLayout(null);
        contentArea.setOpaque(false);
        add(contentArea);

//homeBtn = new JButton("Home");
//        homeBtn.setBounds(30, 50, 240, 60);  
//        homeBtn.setBackground(cs.btnColorSelected); 
//        homeBtn.setForeground(cs.white);
//        homeBtn.setFocusPainted(false);
//        homeBtn.setBorderPainted(false);
//
//        transcBtn = new JButton("Transact");
//        transcBtn.setBounds(30, 140, 240, 60); 
//        transcBtn.setBackground(cs.btnColorSelect); 
//        transcBtn.setForeground(cs.white);
//        transcBtn.setFocusPainted(false);
//        transcBtn.setBorderPainted(false);
//        
//
//        histBtn = new JButton("History");
//        histBtn.setBounds(30, 230, 240, 60);
//        histBtn.setBackground(cs.btnColorSelect); 
//        histBtn.setForeground(cs.white);
//        histBtn.setFocusPainted(false);
//        histBtn.setBorderPainted(false);
//
//        sumBtn = new JButton("Summaries");
//        sumBtn.setBounds(30, 320, 240, 60);
//        sumBtn.setBackground(cs.btnColorSelect);
//        sumBtn.setForeground(cs.white);
//        sumBtn.setFocusPainted(false);
//        sumBtn.setBorderPainted(false);
//        
//        accBtn = new JButton("Logout");
//        accBtn.setBounds(30, 410, 240, 60);
//        accBtn.setBackground(cs.btnColorSelect);
//        accBtn.setForeground(cs.white);
//        accBtn.setFocusPainted(false);
//        accBtn.setBorderPainted(false);

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
        contentArea.removeAll();
        if (name.equals("Home")) {
            JLabel greet = new JLabel("Welcome", SwingConstants.CENTER);
            greet.setBounds(0, 300, 1190, 120);
            greet.setFont(new Font("Arial", Font.BOLD, 96));
            contentArea.add(greet);
        } else if (name.equals("Transact")) {
        } else if (name.equals("Logout")) {
            this.dispose(); 
        }
        
        contentArea.revalidate();
        contentArea.repaint();
    }

    public static void main(String[] args) {
        new CustomerDashboard();
    }
}


