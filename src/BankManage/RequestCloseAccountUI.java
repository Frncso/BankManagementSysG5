package BankManage;
// request Model
// request Service
import BankManage.AppService.GetDateAndTime;
import BankManage.AccountModels.CustomerModel;
import BankManage.AccountModels.RequestModel;
import BankManage.AppService.RequestService;
import BankManage.AppService.SessionManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RequestCloseAccountUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    GetDateAndTime dateToday = new GetDateAndTime();

    // panels
    
    private JPanel mainContentPanel, linePanel, formPanel;
    
    private String dateTime = dateToday.currentTime();    
    
    // mainContentPanel
    
    private final JLabel headerLbl, forAccountlbl, accountIDlbl, accountTypelbl, accountTypeActuallbl, requestlbl, requestActionlbl, datelbl, dateActuallbl, purposelbl;
    private final JTextArea purposetxa;
    private final JButton requestBtn, cancelBtn;
    
    public RequestCloseAccountUI(String accountId, String accountType) {
        setTitle("Request Change of Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(960, 670);
        setLocationRelativeTo(null); 
        setResizable(false);
        
        System.out.println("Account ID: " + accountId + 
                "\nAccount Type: " + accountType); // debug
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        
        headerLbl = new JLabel("Request Account Closure"); 
        headerLbl.setBounds(30, 20, 450, 30);
        headerLbl.setFont(new Font("", Font.BOLD, 24));
        headerLbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(headerLbl);
        
        linePanel = new JPanel();
        linePanel.setBounds(30, 65, 885, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        formPanel = new JPanel();
        formPanel.setLayout(null);
        
        // form fields
        
        forAccountlbl = new JLabel("For Account: ");
        forAccountlbl.setBounds(15, 20, 150, 30);
        forAccountlbl.setFont(new Font("", Font.BOLD, 16));
        forAccountlbl.setForeground(cs.gray);
        formPanel.add(forAccountlbl);
        
        accountIDlbl = new JLabel(accountId);
        accountIDlbl.setBounds(155, 20, 150, 30);
        accountIDlbl.setFont(new Font("", Font.BOLD, 16));
        accountIDlbl.setForeground(cs.darkerPurple);
        formPanel.add(accountIDlbl);
        
        accountTypelbl = new JLabel("Account Type: ");
        accountTypelbl.setBounds(15, 50, 150, 30);
        accountTypelbl.setFont(new Font("", Font.BOLD, 16));
        accountTypelbl.setForeground(cs.gray);
        formPanel.add(accountTypelbl);
        
        accountTypeActuallbl = new JLabel(accountType);     
        accountTypeActuallbl.setBounds(155, 50, 150, 30);
        accountTypeActuallbl.setFont(new Font("", Font.BOLD, 16));
        accountTypeActuallbl.setForeground(cs.darkerPurple);
        formPanel.add(accountTypeActuallbl);
        
        requestlbl = new JLabel("Request Type: ");
        requestlbl.setBounds(15, 80, 150, 30);
        requestlbl.setFont(new Font("", Font.BOLD, 16));
        requestlbl.setForeground(cs.gray);
        formPanel.add(requestlbl);
        
        requestActionlbl = new JLabel("Closure");
        requestActionlbl.setBounds(155, 80, 150, 30);
        requestActionlbl.setFont(new Font("", Font.BOLD, 16));
        requestActionlbl.setForeground(cs.darkerPurple);
        formPanel.add(requestActionlbl);
        
        datelbl = new JLabel("Date Applied: ");
        datelbl.setBounds(15, 110, 150, 30);
        datelbl.setFont(new Font("", Font.BOLD, 16));
        datelbl.setForeground(cs.gray);
        formPanel.add(datelbl);
        
        dateActuallbl = new JLabel(dateTime);
        dateActuallbl.setBounds(155, 110, 350, 30);
        dateActuallbl.setFont(new Font("", Font.BOLD, 16));
        dateActuallbl.setForeground(cs.darkerPurple);
        formPanel.add(dateActuallbl);
        
        purposelbl = new JLabel("Purpose: ");
        purposelbl.setBounds(15, 140, 150, 30);
        purposelbl.setFont(new Font("", Font.BOLD, 16));
        purposelbl.setForeground(cs.gray);
        formPanel.add(purposelbl);
        
        purposetxa = new JTextArea(5, 20);
        purposetxa.setBounds(15, 180, 855, 180);
        purposetxa.setFont(new Font("", Font.PLAIN, 16));
        purposetxa.setLineWrap(true);
        purposetxa.setWrapStyleWord(true);
        purposetxa.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        purposetxa.setBackground(cs.lightgray);
        formPanel.add(purposetxa);
        
        // buttons
        
        requestBtn = new JButton("Request");
        requestBtn.setBounds(535, 430, 160, 45);
        requestBtn.setBackground(cs.darkPurple);
        requestBtn.setForeground(cs.white);
        requestBtn.setFocusPainted(false);
        requestBtn.setBorderPainted(false);
        requestBtn.setFont(new Font("Arial", Font.BOLD, 14));
        requestBtn.setHorizontalAlignment(SwingConstants.CENTER);
        formPanel.add(requestBtn);
        
        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(710, 430, 160, 45);
        cancelBtn.setBackground(cs.darkPurple);
        cancelBtn.setForeground(cs.white);
        cancelBtn.setFocusPainted(false);
        cancelBtn.setBorderPainted(false);
        cancelBtn.setFont(new Font("Arial", Font.BOLD, 14));
        cancelBtn.setHorizontalAlignment(SwingConstants.CENTER);
        formPanel.add(cancelBtn);
        
        formPanel.setBounds(30, 100, 885, 495);
        formPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        formPanel.setBackground(cs.white);
        mainContentPanel.add(formPanel);
        mainContentPanel.setBounds(0, 0, 960, 670);
        add(mainContentPanel);
        
        requestBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        
        if (SessionManage.isCustomerLoggedIn()){
            CustomerModel customer = SessionManage.getCurrentCustomer();
            
            System.out.println("Logged in as: " + customer.getFirstName()); // debug
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // buttons
        
        if(e.getSource() == requestBtn){
            
            String accountId = accountIDlbl.getText();
            String accountType = accountTypeActuallbl.getText();
            
            requestClose(accountId, accountType);
            
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
    
    private void requestClose(String accountId, String accountType){
        CustomerModel customer = SessionManage.getCurrentCustomer();

        RequestModel request = new RequestModel();
        request.setAccountNumber(accountId);
        request.setCustomerId(customer.getCustomerId());
        request.setAccountType(accountType); 
        request.setRequestType("Close Account");
        request.setPurpose(purposetxa.getText().trim());

        RequestService requestService = new RequestService();
        boolean success = requestService.createRequest(request);

        if (success) {
            JOptionPane.showMessageDialog(this, 
                "Your request to close account " + accountId + " has been submitted successfully!", "Request Submitted", JOptionPane.INFORMATION_MESSAGE);
            AccountMenuUI amUI = new AccountMenuUI();
            amUI.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to submit request. Please try again.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}