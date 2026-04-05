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
        sidebar.setBounds(0, 0, 200, 600);
        sidebar.setBackground(cs.bgColor); 
        sidebar.setLayout(null); 

        homeBtn = new JButton("Home");
        homeBtn.setBounds(20, 30, 160, 40);
        homeBtn.setBackground(cs.btnColorSelected); 
        homeBtn.setForeground(cs.white);
        homeBtn.setFocusPainted(false);
        homeBtn.setBorderPainted(false);

        changeInfoBtn = new JButton("Change info");
        changeInfoBtn.setBounds(20, 90, 160, 40);
        changeInfoBtn.setBackground(cs.btnColorSelect); 
        changeInfoBtn.setForeground(cs.white);
        changeInfoBtn.setFocusPainted(false);
        changeInfoBtn.setBorderPainted(false);
        changeInfoBtn.addActionListener(this);

        updateRoleBtn = new JButton("Update role");
        updateRoleBtn.setBounds(20, 150, 160, 40);
        updateRoleBtn.setBackground(cs.btnColorSelect); 
        updateRoleBtn.setForeground(cs.white);
        updateRoleBtn.setFocusPainted(false);
        updateRoleBtn.setBorderPainted(false);
        updateRoleBtn.addActionListener(this);

        etcBtn = new JButton("etc");
        etcBtn.setBounds(20, 210, 160, 40);
        etcBtn.setBackground(cs.btnColorSelect);
        etcBtn.setForeground(cs.white);
        etcBtn.setFocusPainted(false);
        etcBtn.setBorderPainted(false);
        etcBtn.addActionListener(this);
        
        homeLabel = new JLabel("Home", SwingConstants.CENTER);
        homeLabel.setFont(new Font("Arial", Font.BOLD, 72));
        homeLabel.setForeground(new Color(100, 100, 100));
        homeLabel.setBounds(200, 0, 700, 600);
        
        
        
        add(sidebar);
        sidebar.add(homeBtn);
        sidebar.add(changeInfoBtn);
        sidebar.add(updateRoleBtn);
        sidebar.add(etcBtn);
        add(homeLabel);
        
        
        
        setSize(900, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == changeInfoBtn) {
               dispose();
               new  AdminDashChngInfo();
                       
            } else if (e.getSource() == updateRoleBtn) {
                
            } else if (e.getSource() == etcBtn) {
                
            }    
        
    }
    
}

