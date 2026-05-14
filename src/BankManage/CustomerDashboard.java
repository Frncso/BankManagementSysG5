package BankManage; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CustomerDashboard extends JFrame implements ActionListener {

    private JPanel contentArea;
    public CustomerDashboard() {
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

        String[] menu = {"Home", "Transact", "Balance", "Savings", "History", "Summaries", "Logout"};

        for (String name : menu) {
            JButton btn = new JButton(name);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.setForeground(Color.WHITE);
            btn.setBackground(name.equals("Home") ? new Color(80, 65, 140) : new Color(60, 45, 120));
            
            btn.setActionCommand(name); // Very important!
            btn.addActionListener(this);
            naviPanel.add(btn);
        }
        sidebar.add(naviPanel);
        contentArea = new JPanel();
        contentArea.setBounds(250, 0, 1190, 960);
        contentArea.setLayout(null);
        contentArea.setOpaque(false);
        add(contentArea);

        JLabel greetLabel = new JLabel("Welcome", SwingConstants.CENTER);
        greetLabel.setFont(new Font("Arial", Font.BOLD, 96));
        greetLabel.setBounds(0, 300, 1190, 120);
        contentArea.add(greetLabel);

        setVisible(true);
    }

    @Override
   public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("Transact")) {
            new TransactUI(this);
            this.setVisible(false);
        } else if (cmd.equals("Summaries")) {
            new SummaryTransactUI(this);
            this.setVisible(false);
        } else if (cmd.equals("Logout")) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new CustomerDashboard();
    }
}