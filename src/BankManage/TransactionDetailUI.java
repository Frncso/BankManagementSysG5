package BankManage;

import BankManage.AccountModels.TransactionModel;
import BankManage.AppService.TransactionService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionDetailUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    private TransactionService transactionService = new TransactionService();

    private JPanel mainContentPanel, linePanel, summaryPanel;
    private JLabel pageTitle, summaryTitlelbl;
    private JPanel divider;
    private JButton closeBtn;

    public TransactionDetailUI(String transactId) {
        TransactionModel t = transactionService.getTransactionById(transactId);

        if (t == null) {
            JOptionPane.showMessageDialog(this, "Transaction not found.", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }

        setTitle("Transaction Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(815, 620);
        setLocationRelativeTo(null);
        setResizable(false);

        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        mainContentPanel.setBounds(0, 0, 800, 580);
        add(mainContentPanel);

        // title
        pageTitle = new JLabel("Transaction Details");
        pageTitle.setBounds(30, 15, 300, 20);
        pageTitle.setFont(new Font("", Font.BOLD, 16));
        pageTitle.setForeground(cs.darkerPurple);
        mainContentPanel.add(pageTitle);

        // separate
        linePanel = new JPanel();
        linePanel.setBounds(30, 50, 740, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);

        // summary panel
        summaryPanel = new JPanel();
        summaryPanel.setLayout(null);
        summaryPanel.setBounds(50, 80, 700, 420);
        summaryPanel.setBackground(cs.white);
        summaryPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainContentPanel.add(summaryPanel);

        summaryTitlelbl = new JLabel("Transaction Information");
        summaryTitlelbl.setBounds(35, 20, 300, 30);
        summaryTitlelbl.setFont(new Font("", Font.BOLD, 18));
        summaryTitlelbl.setForeground(cs.darkerPurple);
        summaryPanel.add(summaryTitlelbl);

        divider = new JPanel();
        divider.setBounds(35, 60, 630, 2);
        divider.setBackground(cs.darkPurple);
        summaryPanel.add(divider);

        // detailed rows
        int y = 75;
        addDetailRow("Transaction ID:", t.getTransactionId(), y); y += 35;
        addDetailRow("Purchase Name:", t.getPurchaseName(), y); y += 35;
        addDetailRow("From:", (t.getFromAccount() != null && !t.getFromAccount().isEmpty()) 
                ? t.getFromAccount() : "Self", y); y += 35;
        addDetailRow("To:", (t.getToAccount() != null && !t.getToAccount().isEmpty()) 
                ? t.getToAccount() : t.getPurchaseName(), y); y += 35;
        addDetailRow("Account Type:", t.getAccountType(), y); y += 35;
        addDetailRow("Amount:", transactionService.formatAmount(t.getAmount()), y); y += 35;
        addDetailRow("Status:", t.getStatus(), y); y += 35;
        addDetailRow("Date:", t.getDate(), y);

        // Close Button
        closeBtn = new JButton("Close");
        closeBtn.setBounds(325, 520, 150, 40);
        closeBtn.setBackground(cs.darkPurple);
        closeBtn.setForeground(cs.white);
        closeBtn.setFocusPainted(false);
        closeBtn.setBorderPainted(false);
        closeBtn.setFont(new Font("Arial", Font.BOLD, 14));
        mainContentPanel.add(closeBtn);

        closeBtn.addActionListener(this);
    }

    private void addDetailRow(String label, String value, int y) {
        JLabel lbl = new JLabel(label);
        lbl.setBounds(45, y, 200, 30);
        lbl.setFont(new Font("Arial", Font.BOLD, 14));
        summaryPanel.add(lbl);

        JLabel val = new JLabel(value);
        val.setBounds(250, y, 420, 30);
        val.setFont(new Font("Arial", Font.PLAIN, 14));
        summaryPanel.add(val);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == closeBtn) {
            new TransactUI().setVisible(true);
            dispose();
        }
    }
}