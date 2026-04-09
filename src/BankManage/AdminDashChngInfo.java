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
        sidebar.setBounds(0, 0, 300, 960);
        sidebar.setBackground(cs.bgColor); 
        sidebar.setLayout(null); 

        homeBtn = new JButton("Home");
        homeBtn.setBounds(30, 50, 240, 60);
        homeBtn.setBackground(cs.btnColorSelect); 
        homeBtn.setForeground(cs.white);
        homeBtn.setFocusPainted(false);
        homeBtn.setBorderPainted(false);
        homeBtn.addActionListener(this);
    
        changeInfoBtn = new JButton("Change info");
        changeInfoBtn.setBounds(30, 140, 240, 60);
        changeInfoBtn.setBackground(cs.btnColorSelected); 
        changeInfoBtn.setForeground(cs.white);
        changeInfoBtn.setFocusPainted(false);
        changeInfoBtn.setBorderPainted(false);
  
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

        JLabel changeInfoLabel = new JLabel("Change Info");
        changeInfoLabel.setFont(new Font("Arial", Font.BOLD, 36));
        changeInfoLabel.setBounds(350, 50, 300, 50); 
        
        searchField = new JTextField();
        searchField.setBounds(350, 120, 400, 45);
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));

        searchBtn = new JButton("Search");
        searchBtn.setBounds(770, 120, 120, 45);
        searchBtn.setBackground(cs.btnColorSelected); 
        searchBtn.setForeground(cs.white);
        searchBtn.setFocusPainted(false);
        searchBtn.setBorderPainted(false);
        searchBtn.addActionListener(this);
    
        JLabel infoLabel = new JLabel("Personal Information");
        infoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        infoLabel.setBounds(350, 200, 300, 40);
        add(infoLabel);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        dobLabel.setBounds(350, 260, 150, 30);
        add(dobLabel);
        
        dobField = new JTextField();
        dobField.setBounds(350, 295, 200, 40);
        dobField.setFont(new Font("Arial", Font.PLAIN, 16));
        
        JLabel passwordLabel = new JLabel("Civil Status:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordLabel.setBounds(600, 260, 150, 30);
        add(passwordLabel);
        
        passwordField = new JTextField();
        passwordField.setBounds(600, 295, 200, 40);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
       
        JLabel etcLabel = new JLabel("Address:");
        etcLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        etcLabel.setBounds(350, 360, 150, 30);
        add(etcLabel);

        etcField = new JTextField();
        etcField.setBounds(350, 395, 450, 40);
        etcField.setFont(new Font("Arial", Font.PLAIN, 16)); 

        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(350, 480, 150, 45);
        updateBtn.setBackground(new Color(76, 175, 80));
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setFocusPainted(false);
        updateBtn.setBorderPainted(false);
        updateBtn.addActionListener(this);
        
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(520, 480, 150, 45);
        cancelBtn.setBackground(new Color(244, 67, 54));
        cancelBtn.setForeground(Color.WHITE);
        cancelBtn.setFocusPainted(false);
        cancelBtn.setBorderPainted(false);
        cancelBtn.addActionListener(this);
        
        add(sidebar);
        sidebar.add(homeBtn);
        sidebar.add(changeInfoBtn);
        sidebar.add(updateRoleBtn);
        sidebar.add(etcBtn);
        add(changeInfoLabel);
        add(searchField);
        add(searchBtn);
        add(dobLabel);
        add(dobField);
        add(passwordLabel);
        add(passwordField);
        add(etcLabel);
        add(etcField);
        add(updateBtn);
        add(cancelBtn);
    
        setSize(1440, 960);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == homeBtn) {        
            dispose();
            new AdminDashHOME();
        } else if (e.getSource() == updateRoleBtn) {
            dispose();

        } else if (e.getSource() == etcBtn) {

        } 
    }
}