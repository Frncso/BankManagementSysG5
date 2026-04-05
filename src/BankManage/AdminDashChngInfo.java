package BankManage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AdminDashChngInfo extends JFrame implements ActionListener {

    private JButton homeBtn, changeInfoBtn, updateRoleBtn, etcBtn;
    private JButton searchBtn;
    private JTextField searchField;
    private JTextField dobField, passwordField, etcField;

    private ColorScheme cs = new ColorScheme();
    
    public AdminDashChngInfo(){
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel sidebar = new JPanel();
        sidebar.setBounds(0, 0, 200, 600);
        sidebar.setBackground(cs.bgColor); 
        sidebar.setLayout(null); 

        homeBtn = new JButton("Home");
        homeBtn.setBounds(20, 30, 160, 40);
        homeBtn.setBackground(cs.btnColorSelect); 
        homeBtn.setForeground(cs.white);
        homeBtn.setFocusPainted(false);
        homeBtn.setBorderPainted(false);
        homeBtn.addActionListener(this);
    
        changeInfoBtn = new JButton("Change info");
        changeInfoBtn.setBounds(20, 90, 160, 40);
        changeInfoBtn.setBackground(cs.btnColorSelected); 
        changeInfoBtn.setForeground(cs.white);
        changeInfoBtn.setFocusPainted(false);
        changeInfoBtn.setBorderPainted(false);
  
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
      
        JLabel changeInfoLabel = new JLabel("Change info");
        changeInfoLabel.setFont(new Font("Arial", Font.BOLD, 18));
        changeInfoLabel.setBounds(210, 30, 200, 30); 
        
        searchField = new JTextField();
        searchField.setBounds(210, 70, 180, 30); 

        searchBtn = new JButton("Search");
        searchBtn.setBounds(400, 70, 80, 30); 
        searchBtn.setBackground(cs.btnColorSelected); 
        searchBtn.setForeground(cs.white);
        searchBtn.setFocusPainted(false);
        searchBtn.setBorderPainted(false);
    
        JLabel infoLabel = new JLabel("Info");
        infoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        infoLabel.setBounds(210, 130, 100, 30);
        add(infoLabel);

        JLabel dobLabel = new JLabel("Date of birth");
        dobLabel.setBounds(210, 170, 100, 25);
        add(dobLabel);
        
        dobField = new JTextField();
        dobField.setBounds(210, 200, 120, 30); 
        
        JLabel passwordLabel = new JLabel("Civil Status");
        passwordLabel.setBounds(350, 170, 100, 25);
        add(passwordLabel);
        
        passwordField = new JTextField();
        passwordField.setBounds(350, 200, 120, 30);
       
        JLabel etcLabel = new JLabel("Address");
        etcLabel.setBounds(490, 170, 100, 25);

        etcField = new JTextField();
        etcField.setBounds(490, 200, 120, 30); 

        add(sidebar);
        sidebar.add(homeBtn);
        sidebar.add(changeInfoBtn);
        sidebar.add(updateRoleBtn);
        sidebar.add(etcBtn);
        add(changeInfoLabel);
        add(searchField);
        add(searchBtn);
        add(infoLabel);
        add(dobLabel);
        add(dobField);
        add(passwordLabel);
        add(passwordField);
        add(etcLabel);
        add(etcField);
    
        setSize(900, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeBtn) {        
            dispose();
            new AdminDashHOME();
            }else if (e.getSource() == updateRoleBtn) {
                
            } else if (e.getSource() == etcBtn) {
                
            }    
        
    }
    
}


