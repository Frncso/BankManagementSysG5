
package BankManage;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class historyUI extends JFrame implements ActionListener {

    private JPanel contentArea;
    private JPanel barGraphPanel;

    public JLabel lblTitle, 
    lblH1, lblH2, lblH3, lblH4,
    lblV1, lblV2, lblV3, lblV4,
    line1, line2, line3, line4;
    
    historyUI(){
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
        lblTitle = new JLabel("TRANSACTION HISTORY");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 40));
        lblTitle.setBounds(300, 50, 540, 80);
        lblTitle.setForeground(new Color(100, 100, 100)); 
        add(lblTitle);

        lblH1 = new JLabel("April 2, 2026(Deposit)");
        lblH1.setFont(new Font("Serif", Font.BOLD, 35));
        lblH1.setBounds(350, 150, 500, 70);
        lblH1.setForeground(new Color(60, 45, 120)); 
        add(lblH1);

        lblV1 = new JLabel("= ₱5,000.00");
        lblV1.setFont(new Font("Arial", Font.BOLD, 30));
        lblV1.setBounds(350, 200, 500, 70);
        lblV1.setForeground(new Color(60, 45, 120)); 
        add(lblV1);

        line1 = new JLabel("________________________________________________________");
        line1.setFont(new Font("Arial", Font.BOLD, 30));
        line1.setBounds(350, 210, 1000, 70);
        line1.setForeground(new Color(100, 100, 100)); 
        add(line1);

        lblH2 = new JLabel("March 26, 2026(Withdrawal)");
        lblH2.setFont(new Font("Serif", Font.BOLD, 35));
        lblH2.setBounds(350, 300, 500, 70);
        lblH2.setForeground(new Color(60, 45, 120)); 
        add(lblH2);

        lblV2 = new JLabel("= ₱2,500.00");
        lblV2.setFont(new Font("Arial", Font.BOLD, 30));
        lblV2.setBounds(350, 350, 500, 70);
        lblV2.setForeground(new Color(60, 45, 120)); 
        add(lblV2);

        line2 = new JLabel("________________________________________________________");
        line2.setFont(new Font("Arial", Font.BOLD, 30));
        line2.setBounds(350, 360, 1000, 70);
        line2.setForeground(new Color(100, 100, 100)); 
        add(line2);

        lblH3 = new JLabel("March 24, 2026(Withdrawal)");
        lblH3.setFont(new Font("Serif", Font.BOLD, 35));
        lblH3.setBounds(350, 450, 500, 70);
        lblH3.setForeground(new Color(60, 45, 120)); 
        add(lblH3);

        lblV3 = new JLabel("= ₱7,000.00");
        lblV3.setFont(new Font("Arial", Font.BOLD, 30));
        lblV3.setBounds(350, 500, 500, 70);
        lblV3.setForeground(new Color(60, 45, 120)); 
        add(lblV3);

        line3 = new JLabel("________________________________________________________");
        line3.setFont(new Font("Arial", Font.BOLD, 30));
        line3.setBounds(350, 510, 1000, 70);
        line3.setForeground(new Color(100, 100, 100)); 
        add(line3);

        lblH4 = new JLabel("March 5, 2026(Withdrawal)");
        lblH4.setFont(new Font("Serif", Font.BOLD, 35));
        lblH4.setBounds(350, 600, 500, 70);
        lblH4.setForeground(new Color(60, 45, 120)); 
        add(lblH4);

        lblV4 = new JLabel("= 1,300.00");
        lblV4.setFont(new Font("Arial", Font.BOLD, 30));
        lblV4.setBounds(350, 650, 500, 70);
        lblV4.setForeground(new Color(60, 45, 120)); 
        add(lblV4);

        line4 = new JLabel("________________________________________________________");
        line4.setFont(new Font("Arial", Font.BOLD, 30));
        line4.setBounds(350, 660, 1000, 70);
        line4.setForeground(new Color(100, 100, 100)); 
        add(line4);


        setVisible(true);
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