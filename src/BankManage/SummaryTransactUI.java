package BankManage;

import javax.swing.*;
import java.awt.*;

public class SummaryTransactUI extends JFrame {

    JLabel lblTitle, lblSub, lblBar, lblTable;
    JLabel lblInflows, lblOutflows, lblTransfers, lblNetFlow;
    JLabel lblInflowAmt, lblOutflowAmt, lblTransferAmt, lblNetAmt;

    public SummaryTransactUI() {
        setTitle("Transaction Summary");
        setSize(1440, 960);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(0xEEECF8));

        lblTitle = new JLabel("Transaction Summary");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 32));
        lblTitle.setBounds(40, 40, 500, 40);
        add(lblTitle);

        lblSub = new JLabel("Financial Overview");
        lblSub.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblSub.setForeground(new Color(0x64748B));
        lblSub.setBounds(40, 85, 300, 25);
        add(lblSub);

        JPanel cardInflows = new JPanel(null);
        cardInflows.setBackground(Color.WHITE);
        cardInflows.setBorder(BorderFactory.createLineBorder(new Color(0xE2E8F0)));
        cardInflows.setBounds(40, 130, 300, 90);
        lblInflows = new JLabel("Inflows");
        lblInflows.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblInflows.setForeground(new Color(0x64748B));
        lblInflows.setBounds(15, 12, 200, 25);
        cardInflows.add(lblInflows);
        lblInflowAmt = new JLabel("$239,691.12");
        lblInflowAmt.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblInflowAmt.setForeground(new Color(0x22C55E));
        lblInflowAmt.setBounds(15, 45, 270, 30);
        cardInflows.add(lblInflowAmt);
        add(cardInflows);

        JPanel cardOutflows = new JPanel(null);
        cardOutflows.setBackground(Color.WHITE);
        cardOutflows.setBorder(BorderFactory.createLineBorder(new Color(0xE2E8F0)));
        cardOutflows.setBounds(360, 130, 300, 90);
        lblOutflows = new JLabel("Outflows");
        lblOutflows.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblOutflows.setForeground(new Color(0x64748B));
        lblOutflows.setBounds(15, 12, 200, 25);
        cardOutflows.add(lblOutflows);
        lblOutflowAmt = new JLabel("$68,823.67");
        lblOutflowAmt.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblOutflowAmt.setForeground(new Color(0xEF4444));
        lblOutflowAmt.setBounds(15, 45, 270, 30);
        cardOutflows.add(lblOutflowAmt);
        add(cardOutflows);

        JPanel cardTransfers = new JPanel(null);
        cardTransfers.setBackground(Color.WHITE);
        cardTransfers.setBorder(BorderFactory.createLineBorder(new Color(0xE2E8F0)));
        cardTransfers.setBounds(680, 130, 300, 90);
        lblTransfers = new JLabel("Transfers");
        lblTransfers.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblTransfers.setForeground(new Color(0x64748B));
        lblTransfers.setBounds(15, 12, 200, 25);
        cardTransfers.add(lblTransfers);
        lblTransferAmt = new JLabel("$20,000.00");
        lblTransferAmt.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblTransferAmt.setForeground(new Color(0x3B82F6));
        lblTransferAmt.setBounds(15, 45, 270, 30);
        cardTransfers.add(lblTransferAmt);
        add(cardTransfers);

        JPanel cardNet = new JPanel(null);
        cardNet.setBackground(Color.WHITE);
        cardNet.setBorder(BorderFactory.createLineBorder(new Color(0xE2E8F0)));
        cardNet.setBounds(1000, 130, 300, 90);
        lblNetFlow = new JLabel("Net Flow");
        lblNetFlow.setFont(new Font("SansSerif", Font.PLAIN, 14));
        lblNetFlow.setForeground(new Color(0x64748B));
        lblNetFlow.setBounds(15, 12, 200, 25);
        cardNet.add(lblNetFlow);
        lblNetAmt = new JLabel("$170,867.45");
        lblNetAmt.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblNetAmt.setForeground(new Color(0x22C55E));
        lblNetAmt.setBounds(15, 45, 270, 30);
        cardNet.add(lblNetAmt);
        add(cardNet);

        lblBar = new JLabel("Inflow vs Outflow");
        lblBar.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblBar.setBounds(40, 245, 300, 30);
        add(lblBar);

        JPanel barGreen = new JPanel(null);
        barGreen.setBackground(new Color(0x22C55E));
        barGreen.setBounds(40, 285, 1040, 40);
        JLabel lblGreen = new JLabel("Inflow 77.7%");
        lblGreen.setForeground(Color.WHITE);
        lblGreen.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblGreen.setBounds(450, 10, 200, 20);
        barGreen.add(lblGreen);
        add(barGreen);

        JPanel barRed = new JPanel(null);
        barRed.setBackground(new Color(0xEF4444));
        barRed.setBounds(1080, 285, 280, 40);
        JLabel lblRed = new JLabel("22.3%");
        lblRed.setForeground(Color.WHITE);
        lblRed.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblRed.setBounds(100, 10, 100, 20);
        barRed.add(lblRed);
        add(barRed);

        lblTable = new JLabel("Monthly Breakdown");
        lblTable.setFont(new Font("SansSerif", Font.BOLD, 18));
        lblTable.setBounds(40, 345, 300, 30);
        add(lblTable);

        int col1 = 40, col2 = 300, col3 = 560, col4 = 820, col5 = 1080;

        JLabel lblMonth = new JLabel("Month");
        lblMonth.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblMonth.setForeground(new Color(0x64748B));
        lblMonth.setBounds(col1, 385, 250, 30);
        add(lblMonth);

        JLabel lblDeposits = new JLabel("Deposits");
        lblDeposits.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblDeposits.setForeground(new Color(0x64748B));
        lblDeposits.setBounds(col2, 385, 250, 30);
        add(lblDeposits);

        JLabel lblWithdrawals = new JLabel("Withdrawals");
        lblWithdrawals.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblWithdrawals.setForeground(new Color(0x64748B));
        lblWithdrawals.setBounds(col3, 385, 250, 30);
        add(lblWithdrawals);

        JLabel lblTransfers2 = new JLabel("Transfers");
        lblTransfers2.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblTransfers2.setForeground(new Color(0x64748B));
        lblTransfers2.setBounds(col4, 385, 250, 30);
        add(lblTransfers2);

        JLabel lblNet = new JLabel("Net");
        lblNet.setFont(new Font("SansSerif", Font.BOLD, 15));
        lblNet.setForeground(new Color(0x64748B));
        lblNet.setBounds(col5, 385, 250, 30);
        add(lblNet);

        JSeparator sep = new JSeparator();
        sep.setBounds(40, 413, 1320, 1);
        add(sep);

        JLabel r1c1 = new JLabel("Mar 2026");
        r1c1.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r1c1.setForeground(Color.BLACK);
        r1c1.setBounds(col1, 440, 250, 30);
        add(r1c1);

        JLabel r1c2 = new JLabel("$101,691.12");
        r1c2.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r1c2.setForeground(Color.BLACK);
        r1c2.setBounds(col2, 440, 250, 30);
        add(r1c2);

        JLabel r1c3 = new JLabel("$32,123.67");
        r1c3.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r1c3.setForeground(Color.BLACK);
        r1c3.setBounds(col3, 440, 250, 30);
        add(r1c3);

        JLabel r1c4 = new JLabel("$0.00");
        r1c4.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r1c4.setForeground(Color.BLACK);
        r1c4.setBounds(col4, 440, 250, 30);
        add(r1c4);

        JLabel r1c5 = new JLabel("$69,567.45");
        r1c5.setFont(new Font("SansSerif", Font.BOLD, 15));
        r1c5.setForeground(new Color(0x22C55E));
        r1c5.setBounds(col5, 440, 250, 30);
        add(r1c5);

        JLabel r2c1 = new JLabel("Feb 2026");
        r2c1.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r2c1.setForeground(Color.BLACK);
        r2c1.setBounds(col1, 495, 250, 30);
        add(r2c1);

        JLabel r2c2 = new JLabel("$63,000.00");
        r2c2.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r2c2.setForeground(Color.BLACK);
        r2c2.setBounds(col2, 495, 250, 30);
        add(r2c2);

        JLabel r2c3 = new JLabel("$3,200.00");
        r2c3.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r2c3.setForeground(Color.BLACK);
        r2c3.setBounds(col3, 495, 250, 30);
        add(r2c3);

        JLabel r2c4 = new JLabel("$20,000.00");
        r2c4.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r2c4.setForeground(Color.BLACK);
        r2c4.setBounds(col4, 495, 250, 30);
        add(r2c4);

        JLabel r2c5 = new JLabel("$59,800.00");
        r2c5.setFont(new Font("SansSerif", Font.BOLD, 15));
        r2c5.setForeground(new Color(0x22C55E));
        r2c5.setBounds(col5, 495, 250, 30);
        add(r2c5);

        JLabel r3c1 = new JLabel("Jan 2026");
        r3c1.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r3c1.setForeground(Color.BLACK);
        r3c1.setBounds(col1, 550, 250, 30);
        add(r3c1);

        JLabel r3c2 = new JLabel("$0.00");
        r3c2.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r3c2.setForeground(Color.BLACK);
        r3c2.setBounds(col2, 550, 250, 30);
        add(r3c2);

        JLabel r3c3 = new JLabel("$18,200.00");
        r3c3.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r3c3.setForeground(Color.BLACK);
        r3c3.setBounds(col3, 550, 250, 30);
        add(r3c3);

        JLabel r3c4 = new JLabel("$0.00");
        r3c4.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r3c4.setForeground(Color.BLACK);
        r3c4.setBounds(col4, 550, 250, 30);
        add(r3c4);

        JLabel r3c5 = new JLabel("-$18,200.00");
        r3c5.setFont(new Font("SansSerif", Font.BOLD, 15));
        r3c5.setForeground(new Color(0xEF4444));
        r3c5.setBounds(col5, 550, 250, 30);
        add(r3c5);

        JLabel r4c1 = new JLabel("Dec 2025");
        r4c1.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r4c1.setForeground(Color.BLACK);
        r4c1.setBounds(col1, 605, 250, 30);
        add(r4c1);

        JLabel r4c2 = new JLabel("$25,000.00");
        r4c2.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r4c2.setForeground(Color.BLACK);
        r4c2.setBounds(col2, 605, 250, 30);
        add(r4c2);

        JLabel r4c3 = new JLabel("$0.00");
        r4c3.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r4c3.setForeground(Color.BLACK);
        r4c3.setBounds(col3, 605, 250, 30);
        add(r4c3);

        JLabel r4c4 = new JLabel("$0.00");
        r4c4.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r4c4.setForeground(Color.BLACK);
        r4c4.setBounds(col4, 605, 250, 30);
        add(r4c4);

        JLabel r4c5 = new JLabel("$25,000.00");
        r4c5.setFont(new Font("SansSerif", Font.BOLD, 15));
        r4c5.setForeground(new Color(0x22C55E));
        r4c5.setBounds(col5, 605, 250, 30);
        add(r4c5);

        JLabel r5c1 = new JLabel("Nov 2025");
        r5c1.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r5c1.setForeground(Color.BLACK);
        r5c1.setBounds(col1, 660, 250, 30);
        add(r5c1);

        JLabel r5c2 = new JLabel("$25,000.00");
        r5c2.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r5c2.setForeground(Color.BLACK);
        r5c2.setBounds(col2, 660, 250, 30);
        add(r5c2);

        JLabel r5c3 = new JLabel("$9,800.00");
        r5c3.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r5c3.setForeground(Color.BLACK);
        r5c3.setBounds(col3, 660, 250, 30);
        add(r5c3);

        JLabel r5c4 = new JLabel("$0.00");
        r5c4.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r5c4.setForeground(Color.BLACK);
        r5c4.setBounds(col4, 660, 250, 30);
        add(r5c4);

        JLabel r5c5 = new JLabel("$15,200.00");
        r5c5.setFont(new Font("SansSerif", Font.BOLD, 15));
        r5c5.setForeground(new Color(0x22C55E));
        r5c5.setBounds(col5, 660, 250, 30);
        add(r5c5);

        JLabel r6c1 = new JLabel("Oct 2025");
        r6c1.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r6c1.setForeground(Color.BLACK);
        r6c1.setBounds(col1, 715, 250, 30);
        add(r6c1);

        JLabel r6c2 = new JLabel("$25,000.00");
        r6c2.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r6c2.setForeground(Color.BLACK);
        r6c2.setBounds(col2, 715, 250, 30);
        add(r6c2);

        JLabel r6c3 = new JLabel("$5,500.00");
        r6c3.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r6c3.setForeground(Color.BLACK);
        r6c3.setBounds(col3, 715, 250, 30);
        add(r6c3);

        JLabel r6c4 = new JLabel("$0.00");
        r6c4.setFont(new Font("SansSerif", Font.PLAIN, 15));
        r6c4.setForeground(Color.BLACK);
        r6c4.setBounds(col4, 715, 250, 30);
        add(r6c4);

        JLabel r6c5 = new JLabel("$19,500.00");
        r6c5.setFont(new Font("SansSerif", Font.BOLD, 15));
        r6c5.setForeground(new Color(0x22C55E));
        r6c5.setBounds(col5, 715, 250, 30);
        add(r6c5);
    }
}