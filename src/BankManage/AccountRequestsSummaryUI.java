package BankManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountRequestsSummaryUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    
    private JPanel mainContentPanel, linePanel, summaryPanel;
    private final JLabel pageTitle;
    private final JLabel summaryTitlelbl;
    private final JPanel divider;
    private final JLabel requestIDlbl, fullNamelbl, emailAddresslbl, accountTypelbl, dateAppliedlbl;
    private final JLabel requestIDval, fullNameval, emailAddressval, accountTypeval, dateAppliedval;
    private final JButton acceptBtn, declineBtn, returnBtn;
    
    public AccountRequestsSummaryUI() {
        setTitle("Requests Summary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 600);
        setLocationRelativeTo(null); 
        setResizable(false);
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        mainContentPanel.setBounds(0, 0, 800, 600);
        
        pageTitle = new JLabel("Account Requests Summary");
        pageTitle.setBounds(30, 15, 300, 20);
        pageTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(pageTitle);
        
        linePanel = new JPanel();
        linePanel.setBounds(30, 50, 740, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        summaryPanel = new JPanel();
        summaryPanel.setLayout(null);
        summaryPanel.setBounds(50, 80, 700, 380);
        summaryPanel.setBackground(cs.white);
        summaryPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        summaryTitlelbl = new JLabel("Applicant Details"); 
        summaryTitlelbl.setBounds(35, 20, 300, 30);
        summaryTitlelbl.setFont(new Font("Arial", Font.BOLD, 20));
        summaryTitlelbl.setForeground(cs.darkerPurple);
        summaryPanel.add(summaryTitlelbl);
        
        divider = new JPanel();
        divider.setBounds(35, 60, 630, 2);
        divider.setBackground(cs.darkPurple);
        summaryPanel.add(divider);
        
        requestIDlbl = new JLabel("Request ID:");
        requestIDlbl.setBounds(45, 85, 200, 35);
        requestIDlbl.setFont(new Font("Arial", Font.BOLD, 15));
        summaryPanel.add(requestIDlbl);
        
        requestIDval = new JLabel("REQ-101");
        requestIDval.setBounds(250, 85, 400, 35);
        requestIDval.setFont(new Font("Arial", Font.PLAIN, 15));
        summaryPanel.add(requestIDval);
        
        fullNamelbl = new JLabel("Full Name:");
        fullNamelbl.setBounds(45, 140, 200, 35);
        fullNamelbl.setFont(new Font("Arial", Font.BOLD, 15));
        summaryPanel.add(fullNamelbl);
        
        fullNameval = new JLabel("Ezekiel Francisco");
        fullNameval.setBounds(250, 140, 400, 35);
        fullNameval.setFont(new Font("Arial", Font.PLAIN, 15));
        summaryPanel.add(fullNameval);
        
        emailAddresslbl = new JLabel("Email Address:");
        emailAddresslbl.setBounds(45, 195, 200, 35);
        emailAddresslbl.setFont(new Font("Arial", Font.BOLD, 15));
        summaryPanel.add(emailAddresslbl);
        
        emailAddressval = new JLabel("ezekiel@email.com");
        emailAddressval.setBounds(250, 195, 400, 35);
        emailAddressval.setFont(new Font("Arial", Font.PLAIN, 15));
        summaryPanel.add(emailAddressval);
        
        accountTypelbl = new JLabel("Account Type:");
        accountTypelbl.setBounds(45, 250, 200, 35);
        accountTypelbl.setFont(new Font("Arial", Font.BOLD, 15));
        summaryPanel.add(accountTypelbl);
        
        accountTypeval = new JLabel("Savings");
        accountTypeval.setBounds(250, 250, 400, 35);
        accountTypeval.setFont(new Font("Arial", Font.PLAIN, 15));
        summaryPanel.add(accountTypeval);
        
        dateAppliedlbl = new JLabel("Date Applied:");
        dateAppliedlbl.setBounds(45, 305, 200, 35);
        dateAppliedlbl.setFont(new Font("Arial", Font.BOLD, 15));
        summaryPanel.add(dateAppliedlbl);
        
        dateAppliedval = new JLabel("May 18, 2026");
        dateAppliedval.setBounds(250, 305, 400, 35);
        dateAppliedval.setFont(new Font("Arial", Font.PLAIN, 15));
        summaryPanel.add(dateAppliedval);
        mainContentPanel.add(summaryPanel);
        
        acceptBtn = new JButton("Accept");
        acceptBtn.setBounds(50, 480, 150, 40);
        acceptBtn.setBackground(new Color(34, 139, 34));
        acceptBtn.setForeground(cs.white);
        acceptBtn.setFocusPainted(false);
        acceptBtn.setBorderPainted(false);
        acceptBtn.setFont(new Font("Arial", Font.BOLD, 14));
        mainContentPanel.add(acceptBtn);
        
        declineBtn = new JButton("Decline");
        declineBtn.setBounds(220, 480, 150, 40);
        declineBtn.setBackground(new Color(178, 34, 34));
        declineBtn.setForeground(cs.white);
        declineBtn.setFocusPainted(false);
        declineBtn.setBorderPainted(false);
        declineBtn.setFont(new Font("Arial", Font.BOLD, 14));
        mainContentPanel.add(declineBtn);
        
        returnBtn = new JButton("Return");
        returnBtn.setBounds(600, 480, 150, 40);
        returnBtn.setBackground(cs.darkPurple);
        returnBtn.setForeground(cs.white);
        returnBtn.setFocusPainted(false);
        returnBtn.setBorderPainted(false);
        returnBtn.setFont(new Font("Arial", Font.BOLD, 14));
        mainContentPanel.add(returnBtn);
        add(mainContentPanel);
        
        acceptBtn.addActionListener(this);
        declineBtn.addActionListener(this);
        returnBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == acceptBtn) {
            JOptionPane.showMessageDialog(this, "Account Registration Approved!");
            AccountRequestsUI acc = new AccountRequestsUI();
            acc.setVisible(true);
            dispose();
        } else if (e.getSource() == declineBtn) {
            JOptionPane.showMessageDialog(this, "Account Registration Declined.");
            AccountRequestsUI dec = new AccountRequestsUI();
            dec.setVisible(true);
            dispose();
        } else if (e.getSource() == returnBtn) {
            AccountRequestsUI ret = new AccountRequestsUI();
            ret.setVisible(true);
            dispose();
        }
    }
}