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
    
    private TransactionTrackerUI parentFrame;
    
    public TransactionSummaryUI() {

        setTitle("Transaction Summary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(593, 720);
        setLocationRelativeTo(null); 
        setResizable(false);
        
        // main content panel
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        mainContentPanel.setBounds(0, 0, 593, 720);
        
        pageTitle = new JLabel("Transaction Summary");
        pageTitle.setBounds(30, 15, 300, 20);
        pageTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(pageTitle);
        
        linePanel = new JPanel();
        
        linePanel.setBounds(30, 50, 520, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        // summary panel
        
        summaryPanel = new JPanel();
        summaryPanel.setLayout(null);
        summaryPanel.setBounds(30, 80, 520, 480);
        summaryPanel.setBackground(cs.white);
        summaryPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        summaryTitlelbl = new JLabel("Transaction Details"); 
        summaryTitlelbl.setBounds(25, 20, 300, 30);
        summaryTitlelbl.setFont(new Font("", Font.BOLD, 18));
        summaryTitlelbl.setForeground(cs.darkerPurple);
        summaryPanel.add(summaryTitlelbl);
        
        divider = new JPanel();
        divider.setBounds(25, 58, 650, 2);
        divider.setBackground(cs.darkPurple);
        summaryPanel.add(divider);
        
        // static placeholder labels (plain & non-dynamic)
        
        txnIDlbl = new JLabel("Transaction ID:");
        txnIDlbl.setBounds(25, 75, 200, 30);
        txnIDlbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(txnIDlbl);
        
        txnIDval = new JLabel("TXN-001");
        txnIDval.setBounds(230, 75, 430, 30);
        txnIDval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(txnIDval);
        
        accountIDlbl = new JLabel("Account ID:");
        accountIDlbl.setBounds(25, 123, 200, 30);
        accountIDlbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(accountIDlbl);
        
        accountIDval = new JLabel("ACC-12345");
        accountIDval.setBounds(230, 123, 430, 30);
        accountIDval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(accountIDval);
        
        accountTypelbl = new JLabel("Account Type:");
        accountTypelbl.setBounds(25, 171, 200, 30);
        accountTypelbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(accountTypelbl);
        
        accountTypeval = new JLabel("Savings");
        accountTypeval.setBounds(230, 171, 430, 30);
        accountTypeval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(accountTypeval);
        
        firstNamelbl = new JLabel("First Name:");
        firstNamelbl.setBounds(25, 219, 200, 30);
        firstNamelbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(firstNamelbl);
        
        firstNameval = new JLabel("Ezekiel");
        firstNameval.setBounds(230, 219, 430, 30);
        firstNameval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(firstNameval);
        
        purchaseNamelbl = new JLabel("Purchase Name:");
        purchaseNamelbl.setBounds(25, 267, 200, 30);
        purchaseNamelbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(purchaseNamelbl);
        
        purchaseNameval = new JLabel("Fully Booked");
        purchaseNameval.setBounds(230, 267, 430, 30);
        purchaseNameval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(purchaseNameval);
        
        datelbl = new JLabel("Date:");
        datelbl.setBounds(25, 315, 200, 30);
        datelbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(datelbl);
        
        dateval = new JLabel("May 10, 2026");
        dateval.setBounds(230, 315, 430, 30);
        dateval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(dateval);
        
        amountlbl = new JLabel("Amount:");
        amountlbl.setBounds(25, 363, 200, 30);
        amountlbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(amountlbl);
        
        amountval = new JLabel("₱25,120.50");
        amountval.setBounds(230, 363, 430, 30);
        amountval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(amountval);
        
        statuslbl = new JLabel("Status:");
        statuslbl.setBounds(25, 411, 200, 30);
        statuslbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(statuslbl);
        
        statusval = new JLabel("Completed");
        statusval.setBounds(230, 411, 430, 30);
        statusval.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(statusval);
        
        mainContentPanel.add(summaryPanel);
        
        // buttons
        
        acceptBtn = new JButton("Accept");
        acceptBtn.setBounds(30, 590, 150, 45);
        acceptBtn.setBackground(new Color(34, 139, 34));
        acceptBtn.setForeground(cs.white);
        acceptBtn.setFocusPainted(false);
        acceptBtn.setBorderPainted(false);
        acceptBtn.setFont(new Font("Arial", Font.BOLD, 13));
        mainContentPanel.add(acceptBtn);
        
        declineBtn = new JButton("Decline");
        declineBtn.setBounds(200, 590, 150, 45);
        declineBtn.setBackground(new Color(178, 34, 34));
        declineBtn.setForeground(cs.white);
        declineBtn.setFocusPainted(false);
        declineBtn.setBorderPainted(false);
        declineBtn.setFont(new Font("Arial", Font.BOLD, 13));
        mainContentPanel.add(declineBtn);
        
        returnBtn = new JButton("Return");
        returnBtn.setBounds(370, 590, 150, 45);
        returnBtn.setBackground(cs.darkPurple);
        returnBtn.setForeground(cs.white);
        returnBtn.setFocusPainted(false);
        returnBtn.setBorderPainted(false);
        returnBtn.setFont(new Font("Arial", Font.BOLD, 13));
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
    
    public static void main(String[] args){
        TransactionSummaryUI tata = new TransactionSummaryUI();
        tata.setVisible(true);
    }
    
}