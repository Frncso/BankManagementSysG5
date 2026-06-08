package BankManage;

import BankManage.AccountModels.TransactionModel;
import BankManage.AppService.TransactionService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionDetailUI extends JFrame implements ActionListener{

    ColorScheme cs = new ColorScheme();
    private TransactionService transactionService = new TransactionService();
    
    private JButton closeBtn;

    public TransactionDetailUI(String transactId) {
        setTitle("Transaction Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(750, 520);
        setLocationRelativeTo(null);
        setResizable(false);

        TransactionModel t = transactionService.getTransactionById(transactId);

        if (t == null) {
            JOptionPane.showMessageDialog(this, "Transaction not found.", "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
            return;
        }

        // mcp
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 750, 520);
        add(mainPanel);

        // titles
        JLabel pageTitle = new JLabel("Transaction Details");
        pageTitle.setBounds(30, 20, 300, 25);
        pageTitle.setFont(new Font("Arial", Font.BOLD, 20));
        pageTitle.setForeground(cs.darkerPurple);
        mainPanel.add(pageTitle);

        // separate line
        JPanel line = new JPanel();
        line.setBounds(30, 55, 690, 3);
        line.setBackground(cs.darkPurple);
        mainPanel.add(line);

        // details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(null);
        detailsPanel.setBounds(30, 75, 690, 340);
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        mainPanel.add(detailsPanel);

        int y = 25;
        int labelX = 40;
        int valueX = 220;
        int rowHeight = 32;

        // t_ID
        addDetailRow(detailsPanel, "Transaction ID:", t.getTransactionId(), labelX, valueX, y);
        y += rowHeight;

        // from
        String from = (t.getFromAccount() != null && !t.getFromAccount().isEmpty()) 
                ? t.getFromAccount() : "Self";
        addDetailRow(detailsPanel, "From:", from, labelX, valueX, y);
        y += rowHeight;

        // to
        String to = (t.getToAccount() != null && !t.getToAccount().isEmpty()) 
                ? t.getToAccount() : t.getPurchaseName();
        addDetailRow(detailsPanel, "To:", to, labelX, valueX, y);
        y += rowHeight;

        // account type
        addDetailRow(detailsPanel, "Account Type:", t.getAccountType(), labelX, valueX, y);
        y += rowHeight;

        // yung amount
        addDetailRow(detailsPanel, "Amount:", transactionService.formatAmount(t.getAmount()), labelX, valueX, y);
        y += rowHeight;

        // status
        addDetailRow(detailsPanel, "Status:", t.getStatus(), labelX, valueX, y);
        y += rowHeight;

        // date
        addDetailRow(detailsPanel, "Date:", t.getDate(), labelX, valueX, y);

        // closing button
        closeBtn = new JButton("Close");
        closeBtn.setBounds(300, 440, 150, 40);
        closeBtn.setBackground(cs.darkPurple);
        closeBtn.setForeground(Color.WHITE);
        closeBtn.setFont(new Font("Arial", Font.BOLD, 14));
        closeBtn.setFocusPainted(false);
        closeBtn.setBorderPainted(false);
        closeBtn.addActionListener(this);
        mainPanel.add(closeBtn);
    }

    private void addDetailRow(JPanel panel, String labelText, String valueText, int labelX, int valueX, int y) {
        JLabel label = new JLabel(labelText);
        label.setBounds(labelX, y, 170, 25);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(cs.darkPurple);
        panel.add(label);

        JLabel value = new JLabel(valueText);
        value.setBounds(valueX, y, 420, 25);
        value.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(value);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == closeBtn){
            TransactUI tu = new TransactUI();
            tu.setVisible(true);
            dispose();
        }
    }
}