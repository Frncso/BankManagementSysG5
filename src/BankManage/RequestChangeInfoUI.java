package BankManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RequestChangeInfoUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();

    // panels
    
    private JPanel mainContentPanel, linePanel;
    
    // mainContentPanel
    
    private final JLabel headerLbl, firstNamelbl, lastNamelbl, passlbl, occupationlbl, incomeRangelbl, idNolbl;
    private JTextField firstNameField, lastNameField, idNoField;
    private JPasswordField passField;
    private JComboBox<String> occupationCombo, incomeRangeCombo;
    private JButton requestBtn, cancelBtn;
    
    public RequestChangeInfoUI() {
        setTitle("Request Change of Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(720, 650);
        setLocationRelativeTo(null); 
        setResizable(false);
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        
        headerLbl = new JLabel("Request Information Change"); 
        headerLbl.setBounds(30, 20, 450, 30);
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
        
        passlbl = new JLabel("Current Password");
        passlbl.setBounds(30, 170, 200, 20);
        passlbl.setFont(new Font("Arial", Font.BOLD, 14));
        passlbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(passlbl);
        
        passField = new JPasswordField();
        passField.setBounds(30, 195, 650, 35);
        passField.setFont(new Font("Arial", Font.PLAIN, 14));
        passField.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainContentPanel.add(passField);
        
        occupationlbl = new JLabel("Occupation");
        occupationlbl.setBounds(30, 250, 200, 20);
        occupationlbl.setFont(new Font("Arial", Font.BOLD, 14));
        occupationlbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(occupationlbl);
        
        occupationCombo = new JComboBox<>(new String[]{
            "Select Occupation", 
            "Employed (Full-Time)", 
            "Employed (Part-Time)", 
            "Self-Employed", 
            "Student", 
            "Unemployed", 
            "Retired", 
            "Unable to Work"
        });
        occupationCombo.setBounds(30, 275, 300, 35);
        occupationCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        occupationCombo.setBackground(cs.white);
        occupationCombo.setForeground(cs.darkerPurple);
        mainContentPanel.add(occupationCombo);
        
        incomeRangelbl = new JLabel("Monthly Income Range");
        incomeRangelbl.setBounds(380, 250, 200, 20);
        incomeRangelbl.setFont(new Font("Arial", Font.BOLD, 14));
        incomeRangelbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(incomeRangelbl);
        
        incomeRangeCombo = new JComboBox<>(new String[]{
            "Select Range",
            "Less than 10,000", 
            "10,000 - 20,000", 
            "20,000 - 30,000", 
            "30,000 - 50,000", 
            "50,000 - 75,000", 
            "75,000 - 100,000", 
            "100,000 - 150,000", 
            "150,000 - 200,000", 
            "Greater than 200,000"
        });
        incomeRangeCombo.setBounds(380, 275, 300, 35);
        incomeRangeCombo.setFont(new Font("Arial", Font.PLAIN, 14));
        incomeRangeCombo.setBackground(cs.white);
        incomeRangeCombo.setForeground(cs.darkerPurple);
        mainContentPanel.add(incomeRangeCombo);
        
        idNolbl = new JLabel("Valid ID Number");
        idNolbl.setBounds(30, 330, 200, 20);
        idNolbl.setFont(new Font("Arial", Font.BOLD, 14));
        idNolbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(idNolbl);
        
        idNoField = new JTextField();
        idNoField.setBounds(30, 355, 650, 35);
        idNoField.setFont(new Font("Arial", Font.PLAIN, 14));
        idNoField.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainContentPanel.add(idNoField);
        
        // buttons
        
        requestBtn = new JButton("Request");
        requestBtn.setBounds(180, 430, 160, 45);
        requestBtn.setBackground(cs.darkPurple);
        requestBtn.setForeground(cs.white);
        requestBtn.setFocusPainted(false);
        requestBtn.setBorderPainted(false);
        requestBtn.setFont(new Font("Arial", Font.BOLD, 14));
        requestBtn.setHorizontalAlignment(SwingConstants.CENTER);
        mainContentPanel.add(requestBtn);
        
        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(380, 430, 160, 45);
        cancelBtn.setBackground(cs.darkPurple);
        cancelBtn.setForeground(cs.white);
        cancelBtn.setFocusPainted(false);
        cancelBtn.setBorderPainted(false);
        cancelBtn.setFont(new Font("Arial", Font.BOLD, 14));
        cancelBtn.setHorizontalAlignment(SwingConstants.CENTER);
        mainContentPanel.add(cancelBtn);
        
        mainContentPanel.setBounds(0, 0, 720, 650);
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