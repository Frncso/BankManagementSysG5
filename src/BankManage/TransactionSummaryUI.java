package BankManage;

import BankManage.AccountModels.TransactionModel;
import BankManage.AppService.TransactionService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionSummaryUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    private TransactionService transactionService = new TransactionService();

    private JPanel mainContentPanel, linePanel, summaryPanel;
    private JLabel pageTitle, summaryTitlelbl;
    private JPanel divider;

    private JButton flagBtn, returnBtn;

    private String currentTransactId;
    private TransactionModel currentTransaction;

    public TransactionSummaryUI(String transactId) {
        this.currentTransactId = transactId;
        this.currentTransaction = transactionService.getTransactionById(transactId);

        setTitle("Transaction Summary");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(810, 680);
        setLocationRelativeTo(null);
        setResizable(false);

        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        mainContentPanel.setBounds(0, 0, 800, 680);

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
        summaryPanel.setBounds(50, 80, 700, 480);
        summaryPanel.setBackground(cs.white);
        summaryPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainContentPanel.add(summaryPanel);

        summaryTitlelbl = new JLabel("Transaction Details");
        summaryTitlelbl.setBounds(35, 20, 300, 30);
        summaryTitlelbl.setFont(new Font("", Font.BOLD, 18));
        summaryTitlelbl.setForeground(cs.darkerPurple);
        summaryPanel.add(summaryTitlelbl);

        divider = new JPanel();
        divider.setBounds(35, 60, 630, 2);
        divider.setBackground(cs.darkPurple);
        summaryPanel.add(divider);

        // label and value present
        int y = 75;
        addDetailRow("Transaction ID:", currentTransaction != null ? currentTransaction.getTransactionId() : "N/A", y); y += 35;
        addDetailRow("Account ID:", currentTransaction != null ? currentTransaction.getAccountId() : "N/A", y); y += 35;
        addDetailRow("Account Type:", currentTransaction != null ? currentTransaction.getAccountType() : "N/A", y); y += 35;
        addDetailRow("Customer Name:", currentTransaction != null ? currentTransaction.getCustomerName() : "N/A", y); y += 35;
        addDetailRow("Purchase Name:", currentTransaction != null ? currentTransaction.getPurchaseName() : "N/A", y); y += 35;
        addDetailRow("Date:", currentTransaction != null ? currentTransaction.getDate() : "N/A", y); y += 35;
        addDetailRow("Amount:", currentTransaction != null ? "₱" + currentTransaction.getAmount() : "N/A", y); y += 35;
        addDetailRow("Status:", currentTransaction != null ? currentTransaction.getStatus() : "N/A", y); y += 35;
        addDetailRow("Flagged:", currentTransaction != null && currentTransaction.isFlagged() ? "YES (Suspicious)" : "NO", y); y += 35;
        addDetailRow("From:", currentTransaction != null ? currentTransaction.getFromAccount() : "N/A", y); y += 35;
        addDetailRow("To:", currentTransaction != null ? currentTransaction.getToAccount() : "N/A", y);

        flagBtn = new JButton(currentTransaction != null && currentTransaction.isFlagged() ? "Unflag Transaction" : "Flag as Suspicious");
        flagBtn.setBounds(50, 580, 200, 40);
        flagBtn.setBackground(currentTransaction != null && currentTransaction.isFlagged() ? cs.darkPurple : cs.red);
        flagBtn.setForeground(cs.white);
        flagBtn.setFocusPainted(false);
        flagBtn.setBorderPainted(false);
        flagBtn.setFont(new Font("Arial", Font.BOLD, 13));
        mainContentPanel.add(flagBtn);

        returnBtn = new JButton("Return");
        returnBtn.setBounds(600, 580, 150, 40);
        returnBtn.setBackground(cs.darkPurple);
        returnBtn.setForeground(cs.white);
        returnBtn.setFocusPainted(false);
        returnBtn.setBorderPainted(false);
        returnBtn.setFont(new Font("Arial", Font.BOLD, 14));
        mainContentPanel.add(returnBtn);

        add(mainContentPanel);

        flagBtn.addActionListener(this);
        returnBtn.addActionListener(this);
    }

    private void addDetailRow(String label, String value, int y) {
        JLabel lbl = new JLabel(label);
        lbl.setBounds(45, y, 200, 30);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(lbl);

        JLabel val = new JLabel(value);
        val.setBounds(250, y, 400, 30);
        val.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(val);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == flagBtn) {
            if (currentTransaction == null) return;

            boolean newFlagStatus = !currentTransaction.isFlagged();
            boolean success = transactionService.flagTransaction(currentTransactId, newFlagStatus);

            if (success) {
                currentTransaction.setFlagged(newFlagStatus);
                JOptionPane.showMessageDialog(this, 
                    newFlagStatus ? "Transaction has been flagged as suspicious." : "Transaction flag has been removed.");

                // refresh
                dispose();
                new TransactionSummaryUI(currentTransactId).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update flag status.");
            }
        } 
        else if (e.getSource() == returnBtn) {
            new TransactionTrackerUI().setVisible(true);
            dispose();
        }
    }
}