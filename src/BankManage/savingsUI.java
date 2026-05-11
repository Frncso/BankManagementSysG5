
package BankManage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class savingsUI extends JFrame implements ActionListener {

    private JPanel contentArea;
    private JPanel barGraphPanel;

    public JLabel lblBal, lblBalNum, lblSav, lblSavPer, lblInv, lblInvPer, lblExp, lblExpPer;
    
    savingsUI(){
        setTitle("Customer Dashboard");
        setSize(1440, 960);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null); 

        JPanel sidebar = new JPanel();
        sidebar.setBounds(0, 0, 250, 960);
        sidebar.setBackground(new Color(60, 45, 120)); 
        sidebar.setLayout(null); 
        add(sidebar);

        JPanel naviPanel = new JPanel();
        naviPanel.setBounds(20, 150, 210, 400);
        naviPanel.setOpaque(false); 
        naviPanel.setLayout(new GridLayout(7, 1, 0, 15));

        String[] menu = {"Home", "Transact", "Balance", "Savings", "History Summary", "Summaries", "Logout"};
        
        for (String name : menu) {
            JButton btn = new JButton(name);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            
            if (name.equals("Savings")) {
                btn.setBackground(new Color(80, 65, 140)); 
            } else {
                btn.setBackground(new Color(60, 45, 120));
            }
            
            btn.addActionListener(e -> switchInterface(name));
            naviPanel.add(btn);
        }
        
        sidebar.add(naviPanel);
        contentArea = new JPanel();
        contentArea.setBounds(250, 0, 1190, 960);
        contentArea.setLayout(null);
        contentArea.setOpaque(false);
        add(contentArea);

        // Labels
        lblBal = new JLabel("Current Balance:");
        lblBal.setFont(new Font("Serif", Font.BOLD, 48));
        lblBal.setBounds(400, 625, 540, 80);
        lblBal.setForeground(new Color(60, 45, 120)); 
        add(lblBal);

        lblBalNum = new JLabel("120,000.00 Php");
        lblBalNum.setFont(new Font("Arial", Font.BOLD, 50));
        lblBalNum.setBounds(800, 620, 400, 100); 
        lblBalNum.setForeground(new Color(100, 100, 100));
        add(lblBalNum);

        lblSav = new JLabel("Savings:");
        lblSav.setFont(new Font("Arial", Font.BOLD, 35));
        lblSav.setBounds(400, 700, 400, 100); 
        lblSav.setForeground(new Color(100, 100, 100));
        add(lblSav);

        lblSavPer = new JLabel("40%");
        lblSavPer.setFont(new Font("Arial", Font.BOLD, 35));
        lblSavPer.setBounds(800, 700, 400, 100); 
        lblSavPer.setForeground(new Color(100, 100, 100));
        add(lblSavPer);

        lblInv = new JLabel("Investments:");
        lblInv.setFont(new Font("Arial", Font.BOLD, 35));
        lblInv.setBounds(400, 750, 400, 100); 
        lblInv.setForeground(new Color(100, 100, 100));
        add(lblInv);    
        
        lblInvPer = new JLabel("35%");
        lblInvPer.setFont(new Font("Arial", Font.BOLD, 35));
        lblInvPer.setBounds(800, 750, 400, 100); 
        lblInvPer.setForeground(new Color(100, 100, 100));
        add(lblInvPer);

        lblExp = new JLabel("Expenses:");
        lblExp.setFont(new Font("Arial", Font.BOLD, 35));
        lblExp.setBounds(400, 800, 400, 100); 
        lblExp.setForeground(new Color(100, 100, 100));
        add(lblExp);

        lblExpPer = new JLabel("25%");
        lblExpPer.setFont(new Font("Arial", Font.BOLD, 35));
        lblExpPer.setBounds(800, 800, 400, 100); 
        lblExpPer.setForeground(new Color(100, 100, 100));
        add(lblExpPer);

        barGraphPanel = new BarGraph();
        barGraphPanel.setBounds(350, 90, 1000, 500);
        barGraphPanel.setBackground(Color.WHITE);
        add(barGraphPanel);

        setVisible(true);
    }
   //for now yan muna yung bar graph, pwedeng tanggalen or palitan...

    class BarGraph extends JPanel {
        
    public BarGraph() {
        setPreferredSize(new Dimension(800, 500));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        String[] categories = {"Savings", "Investments", "Expenses"};
        double[] percentages = {40, 35, 25};
        Color[] colors = {new Color(60, 45, 120), new Color(60, 45, 120), new Color(60, 45, 120)};
        
        int width = getWidth();
        int height = getHeight();
        
        int topMargin = 40;
        int bottomMargin = 60;
        int leftMargin = 60;
        int rightMargin = 20;
        
        int chartWidth = width - leftMargin - rightMargin;
        int chartHeight = height - topMargin - bottomMargin;
        
        int barCount = categories.length;
        int barWidth = (chartWidth / barCount) - 30;
        int startX = leftMargin + (chartWidth / barCount - barWidth) / 2;
        
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.setFont(new Font("Arial", Font.PLAIN, 14));
        
        for (int i = 0; i <= 4; i++) {
            int y = topMargin + chartHeight - (i * chartHeight / 4);
            g2d.drawLine(leftMargin, y, width - rightMargin, y);
            g2d.setColor(Color.BLACK);
            String label = (i * 25) + "%";
            g2d.drawString(label, leftMargin - 45, y + 5);
            g2d.setColor(Color.LIGHT_GRAY);
        }
        
        for (int i = 0; i < barCount; i++) {
            int x = startX + i * (chartWidth / barCount);
            int barHeight = (int) ((percentages[i] / 100) * chartHeight);
            int y = topMargin + chartHeight - barHeight;
            
            g2d.setColor(colors[i]);
            g2d.fillRect(x, y, barWidth, barHeight);

            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(2));
            g2d.drawRect(x, y, barWidth, barHeight);

            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            String percentageText = String.format("%.0f%%", percentages[i]);
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(percentageText);
            g2d.drawString(percentageText, x + (barWidth - textWidth) / 2, y - 10);

            g2d.setFont(new Font("Arial", Font.PLAIN, 14));
            fm = g2d.getFontMetrics();
            textWidth = fm.stringWidth(categories[i]);
            g2d.drawString(categories[i], x + (barWidth - textWidth) / 2, bottomMargin + chartHeight + 25);
        }

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawLine(leftMargin, topMargin, leftMargin, topMargin + chartHeight);
        g2d.drawLine(leftMargin, topMargin + chartHeight, leftMargin + chartWidth, topMargin + chartHeight);
        
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        String title = "Financial Distribution";
        FontMetrics fm = g2d.getFontMetrics();
        int titleWidth = fm.stringWidth(title);
        g2d.drawString(title, (width - titleWidth) / 2, 35);
    }
}

    private void switchInterface(String name) {
        if (name.equals("Transact")) {
            
        } else if (name.equals("History Summary")) { 
            
        } else if (name.equals("Logout")) { 
            this.dispose();  
            System.exit(0);
            return;
        }
        
        contentArea.removeAll();
        if (name.equals("Home")) {
            JLabel greet = new JLabel("Welcome", SwingConstants.CENTER);
            greet.setBounds(0, 300, 1190, 120);
            greet.setFont(new Font("Arial", Font.BOLD, 96));
            contentArea.add(greet);
        }
        
        contentArea.revalidate();
        contentArea.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}