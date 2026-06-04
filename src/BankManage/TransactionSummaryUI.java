package BankManage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionSummaryUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();

    // panels
    
    private JPanel mainContentPanel, linePanel, summaryPanel;

    // main content labels
    
    private final JLabel pageTitle;
    
    // summary panel labels and components
    
    private final JLabel summaryTitlelbl;
    private final JPanel divider;
    
    private final JLabel txnIDlbl, accountIDlbl, accountTypelbl, firstNamelbl, purchaseNamelbl, datelbl, amountlbl, statuslbl;
    
    private final JLabel txnIDval, accountIDval, accountTypeval, firstNameval, purchaseNameval, dateval, amountval, statusval;
    
    // buttons
    
    private final JButton acceptBtn, declineBtn, returnBtn;
    
    public TransactionSummaryUI() {

        setTitle("Transaction Summary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(800, 600);
        setLocationRelativeTo(null); 
        setResizable(false);
        
        // main content panel
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        mainContentPanel.setBounds(0, 0, 800, 600);
        
        pageTitle = new JLabel("Transaction Summary");
        pageTitle.setBounds(30, 15, 300, 20);
        pageTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(pageTitle);
        
        linePanel = new JPanel();
        
        linePanel.setBounds(30, 50, 740, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        // summary panel
        
        summaryPanel = new JPanel();
        summaryPanel.setLayout(null);
        summaryPanel.setBounds(50, 80, 700, 380);
        summaryPanel.setBackground(cs.white);
        summaryPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        summaryTitlelbl = new JLabel("Transaction Details"); 
        summaryTitlelbl.setBounds(35, 20, 300, 30);
        summaryTitlelbl.setFont(new Font("", Font.BOLD, 18));
        summaryTitlelbl.setForeground(cs.darkerPurple);
        summaryPanel.add(summaryTitlelbl);
        
        divider = new JPanel();
        divider.setBounds(35, 60, 630, 2);
        divider.setBackground(cs.darkPurple);
        summaryPanel.add(divider);
        
        // static placeholder labels (plain & non-dynamic)
        
        txnIDlbl = new JLabel("Transaction ID:");
        txnIDlbl.setBounds(45, 75, 200, 30);
        txnIDlbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(txnIDlbl);
        
        txnIDval = new JLabel("TXN-001");
        txnIDval.setBounds(250, 75, 400, 30);
        txnIDval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(txnIDval);
        
        accountIDlbl = new JLabel("Account ID:");
        accountIDlbl.setBounds(45, 110, 200, 30);
        accountIDlbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(accountIDlbl);
        
        accountIDval = new JLabel("ACC-12345");
        accountIDval.setBounds(250, 110, 400, 30);
        accountIDval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(accountIDval);
        
        accountTypelbl = new JLabel("Account Type:");
        accountTypelbl.setBounds(45, 145, 200, 30);
        accountTypelbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(accountTypelbl);
        
        accountTypeval = new JLabel("Savings");
        accountTypeval.setBounds(250, 145, 400, 30);
        accountTypeval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(accountTypeval);
        
        firstNamelbl = new JLabel("First Name:");
        firstNamelbl.setBounds(45, 180, 200, 30);
        firstNamelbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(firstNamelbl);
        
        firstNameval = new JLabel("Ezekiel");
        firstNameval.setBounds(250, 180, 400, 30);
        firstNameval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(firstNameval);
        
        purchaseNamelbl = new JLabel("Purchase Name:");
        purchaseNamelbl.setBounds(45, 215, 200, 30);
        purchaseNamelbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(purchaseNamelbl);
        
        purchaseNameval = new JLabel("Fully Booked");
        purchaseNameval.setBounds(250, 215, 400, 30);
        purchaseNameval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(purchaseNameval);
        
        datelbl = new JLabel("Date:");
        datelbl.setBounds(45, 250, 200, 30);
        datelbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(datelbl);
        
        dateval = new JLabel("May 25, 2026");
        dateval.setBounds(250, 250, 400, 30);
        dateval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(dateval);
        
        amountlbl = new JLabel("Amount:");
        amountlbl.setBounds(45, 285, 200, 30);
        amountlbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(amountlbl);
        
        amountval = new JLabel("₱25,120.50");
        amountval.setBounds(250, 285, 400, 30);
        amountval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(amountval);
        
        statuslbl = new JLabel("Status:");
        statuslbl.setBounds(45, 320, 200, 30);
        statuslbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(statuslbl);
        
        statusval = new JLabel("Completed");
        statusval.setBounds(250, 320, 400, 30);
        statusval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(statusval);
        
        mainContentPanel.add(summaryPanel);
        
        // buttons
        
        acceptBtn = new JButton("Accept");
        acceptBtn.setBounds(50, 480, 150, 40);
        acceptBtn.setBackground(new Color(34, 139, 34));
        acceptBtn.setForeground(cs.white);
        acceptBtn.setFocusPainted(false);
        acceptBtn.setBorderPainted(false);
        acceptBtn.setFont(new Font("Arial", Font.BOLD, 13));
        mainContentPanel.add(acceptBtn);
        
        declineBtn = new JButton("Decline");
        declineBtn.setBounds(220, 480, 150, 40);
        declineBtn.setBackground(new Color(178, 34, 34));
        declineBtn.setForeground(cs.white);
        declineBtn.setFocusPainted(false);
        declineBtn.setBorderPainted(false);
        declineBtn.setFont(new Font("Arial", Font.BOLD, 13));
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
            JOptionPane.showMessageDialog(this, "Transaction Approved!");
            
            // code query thingy
            
            TransactionTrackerUI tu1 = new TransactionTrackerUI();
            tu1.setVisible(true);
            dispose();
        } 
        else if (e.getSource() == declineBtn) {
            JOptionPane.showMessageDialog(this, "Transaction Declined.");
            
            // code decline thingy
            
            TransactionTrackerUI tu2 = new TransactionTrackerUI();
            tu2.setVisible(true);
            dispose();
        } 
        else if (e.getSource() == returnBtn) {
            TransactionTrackerUI tu3 = new TransactionTrackerUI();
            tu3.setVisible(true);
            dispose();
        }
        
    }
    
}