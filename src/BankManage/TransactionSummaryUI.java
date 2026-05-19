package BankManage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TransactionSummaryUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();

    private JPanel mainContentPanel, linePanel, summaryPanel;

    private final JLabel pageTitle;

    private JButton acceptBtn, declineBtn, returnBtn;

    private TransactionTrackerUI parentFrame;
    private Object[] txnData;

    public TransactionSummaryUI(Object[] txnData, TransactionTrackerUI parent) {
        this.txnData = txnData;
        this.parentFrame = parent;

        setTitle("Transaction Summary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1440, 960);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main---------------------------------------
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        mainContentPanel.setBounds(0, 0, 1440, 960);

        pageTitle = new JLabel("Transaction Summary");
        pageTitle.setBounds(30, 15, 300, 20);
        pageTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(pageTitle);

        linePanel = new JPanel();
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);

        // ================= SUMMARY PANEL =================
        summaryPanel = new JPanel();
        summaryPanel.setLayout(null);
        summaryPanel.setBounds(30, 80, 700, 480);
        summaryPanel.setBackground(cs.white);
        summaryPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));

        JLabel summaryTitle = new JLabel("Transaction Details");
        summaryTitle.setBounds(25, 20, 300, 30);
        summaryTitle.setFont(new Font("", Font.BOLD, 18));
        summaryTitle.setForeground(cs.darkerPurple);
        summaryPanel.add(summaryTitle);

        JPanel divider = new JPanel();
        divider.setBounds(25, 58, 650, 2);
        divider.setBackground(cs.darkPurple);
        summaryPanel.add(divider);

        String[] labels = {
            "Transaction ID",
            "Account ID",
            "Account Type",
            "First Name",
            "Purchase Name",
            "Date",
            "Amount",
            "Status"
        };

        int startY = 75;
        int rowHeight = 48;

        for (int i = 0; i < labels.length; i++) {
            int y = startY + (i * rowHeight);

            JLabel lbl = new JLabel(labels[i] + ":");
            lbl.setBounds(25, y, 200, 30);
            lbl.setFont(new Font("Arial", Font.BOLD, 14));
            summaryPanel.add(lbl);

            JLabel val = new JLabel(txnData[i] != null ? txnData[i].toString() : "—");
            val.setBounds(230, y, 430, 30);
            val.setFont(new Font("Arial", Font.PLAIN, 14));
            summaryPanel.add(val);
        }

        mainContentPanel.add(summaryPanel);

        //Buttons
        acceptBtn = new JButton("Accept");
        acceptBtn.setBounds(30, 590, 150, 45);
        acceptBtn.setBackground(new Color(34, 139, 34));
        acceptBtn.setForeground(cs.white);
        acceptBtn.addActionListener(this);
        mainContentPanel.add(acceptBtn);

        declineBtn = new JButton("Decline");
        declineBtn.setBounds(200, 590, 150, 45);
        declineBtn.setBackground(new Color(178, 34, 34));
        declineBtn.setForeground(cs.white);
        declineBtn.addActionListener(this);
        mainContentPanel.add(declineBtn);

        returnBtn = new JButton("Return");
        returnBtn.setBounds(370, 590, 150, 45);
        returnBtn.setBackground(cs.darkPurple);
        returnBtn.setForeground(cs.white);
        returnBtn.addActionListener(this);
        mainContentPanel.add(returnBtn);

        add(mainContentPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == acceptBtn) {
            JOptionPane.showMessageDialog(this, "Transaction Approved!");

        } else if (e.getSource() == declineBtn) {
            JOptionPane.showMessageDialog(this, "Transaction Declined.");

        } else if (e.getSource() == returnBtn) {
            parentFrame.setVisible(true);
            dispose();
        }
    }
}