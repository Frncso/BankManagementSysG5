package BankManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RequestNewAccUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();

    // panels
    
    private JPanel mainContentPanel, linePanel;
    
    // mainContentPanel
    
    private final JLabel headerLbl, firstNamelbl, lastNamelbl, descriptionlbl;
    private JTextField firstNameField, lastNameField;
    private JTextArea descriptionArea;
    private JButton requestBtn, cancelBtn;
    
    public RequestNewAccUI(String accountType) {
        setTitle("Request New Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(720, 550);
        setLocationRelativeTo(null); 
        setResizable(false);
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        
        // dynamic header based on passed account type
        headerLbl = new JLabel(accountType.equals("Checking") ? "Checking Account" : "Savings Account"); 
        headerLbl.setBounds(30, 20, 400, 30);
        headerLbl.setFont(new Font("", Font.BOLD, 24));
        headerLbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(headerLbl);
        
        linePanel = new JPanel();
        linePanel.setBounds(30, 65, 650, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        // form fields
        
        firstNamelbl = new JLabel("First Name");
        firstNamelbl.setBounds(30, 90, 150, 20);
        firstNamelbl.setFont(new Font("Arial", Font.BOLD, 14));
        firstNamelbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(firstNamelbl);
        
        firstNameField = new JTextField();
        firstNameField.setBounds(30, 115, 300, 35);
        firstNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        firstNameField.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainContentPanel.add(firstNameField);
        
        lastNamelbl = new JLabel("Last Name");
        lastNamelbl.setBounds(380, 90, 150, 20);
        lastNamelbl.setFont(new Font("Arial", Font.BOLD, 14));
        lastNamelbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(lastNamelbl);
        
        lastNameField = new JTextField();
        lastNameField.setBounds(380, 115, 300, 35);
        lastNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        lastNameField.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainContentPanel.add(lastNameField);
        
        descriptionlbl = new JLabel("Description / Purpose of Request");
        descriptionlbl.setBounds(30, 170, 400, 20);
        descriptionlbl.setFont(new Font("Arial", Font.BOLD, 14));
        descriptionlbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(descriptionlbl);
        
        descriptionArea = new JTextArea();
        descriptionArea.setBounds(30, 195, 650, 140);
        descriptionArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descriptionArea.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        mainContentPanel.add(descriptionArea);
        
        // buttons
        
        requestBtn = new JButton("Request");
        requestBtn.setBounds(180, 380, 160, 45);
        requestBtn.setBackground(cs.darkPurple);
        requestBtn.setForeground(cs.white);
        requestBtn.setFocusPainted(false);
        requestBtn.setBorderPainted(false);
        requestBtn.setFont(new Font("Arial", Font.BOLD, 14));
        requestBtn.setHorizontalAlignment(SwingConstants.CENTER);
        mainContentPanel.add(requestBtn);
        
        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(380, 380, 160, 45);
        cancelBtn.setBackground(cs.darkPurple);
        cancelBtn.setForeground(cs.white);
        cancelBtn.setFocusPainted(false);
        cancelBtn.setBorderPainted(false);
        cancelBtn.setFont(new Font("Arial", Font.BOLD, 14));
        cancelBtn.setHorizontalAlignment(SwingConstants.CENTER);
        mainContentPanel.add(cancelBtn);
        
        mainContentPanel.setBounds(0, 0, 720, 550);
        mainContentPanel.setBackground(cs.white);
        add(mainContentPanel);
        
        requestBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // buttons
        
        if(e.getSource() == requestBtn){
            JOptionPane.showMessageDialog(this,
                "Successfully filed a request.", "Success",
                JOptionPane.INFORMATION_MESSAGE);
            
            AccountMenuUI amUI = new AccountMenuUI();
            amUI.setVisible(true);
            dispose();
            
        }
        
        else if(e.getSource() == cancelBtn){
            int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to quit?",
                "Confirm Exit", JOptionPane.YES_NO_OPTION);
            
            if(confirm == JOptionPane.YES_OPTION){
                AccountMenuUI amUI = new AccountMenuUI();
                amUI.setVisible(true);
                dispose();
            }
        }
        
        // buttons end
        
    }
    
}