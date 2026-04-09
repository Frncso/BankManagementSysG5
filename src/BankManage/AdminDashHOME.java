package BankManage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class AdminDashHOME extends JFrame implements ActionListener {

    private JButton homeBtn, changeInfoBtn, updateRoleBtn, etcBtn;
    private JLabel homeLabel;
    private ColorScheme cs = new ColorScheme();
    
    public AdminDashHOME(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel sidebar = new JPanel();
        sidebar.setBounds(0, 0, 300, 960);
        sidebar.setBackground(cs.bgColor); 
        sidebar.setLayout(null); 

        homeBtn = new JButton("Home");
        homeBtn.setBounds(30, 50, 240, 60);  
        homeBtn.setBackground(cs.btnColorSelected); 
        homeBtn.setForeground(cs.white);
        homeBtn.setFocusPainted(false);
        homeBtn.setBorderPainted(false);
        homeBtn.addActionListener(this);

        changeInfoBtn = new JButton("Change info");
        changeInfoBtn.setBounds(30, 140, 240, 60); 
        changeInfoBtn.setBackground(cs.btnColorSelect); 
        changeInfoBtn.setForeground(cs.white);
        changeInfoBtn.setFocusPainted(false);
        changeInfoBtn.setBorderPainted(false);
        changeInfoBtn.addActionListener(this);

        updateRoleBtn = new JButton("Update role");
        updateRoleBtn.setBounds(30, 230, 240, 60);
        updateRoleBtn.setBackground(cs.btnColorSelect); 
        updateRoleBtn.setForeground(cs.white);
        updateRoleBtn.setFocusPainted(false);
        updateRoleBtn.setBorderPainted(false);
        updateRoleBtn.addActionListener(this);

        etcBtn = new JButton("etc");
        etcBtn.setBounds(30, 320, 240, 60);
        etcBtn.setBackground(cs.btnColorSelect);
        etcBtn.setForeground(cs.white);
        etcBtn.setFocusPainted(false);
        etcBtn.setBorderPainted(false);
        etcBtn.addActionListener(this);

        homeLabel = new JLabel("Home", SwingConstants.CENTER);
        homeLabel.setFont(new Font("Arial", Font.BOLD, 96));  
        homeLabel.setForeground(new Color(100, 100, 100));
        homeLabel.setBounds(300, 0, 1140, 960);

        add(sidebar);
        sidebar.add(homeBtn);
        sidebar.add(changeInfoBtn);
        sidebar.add(updateRoleBtn);
        sidebar.add(etcBtn);
        add(homeLabel);

        setSize(1440, 960);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == changeInfoBtn) {
            dispose();
            new AdminDashChngInfo();
        } else if (e.getSource() == updateRoleBtn) {

        } else if (e.getSource() == etcBtn) {

        } else if (e.getSource() == homeBtn) {

        }    
    }
}