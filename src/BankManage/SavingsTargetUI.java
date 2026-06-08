package BankManage;
 
import BankManage.AppService.SavingsService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class SavingsTargetUI extends JFrame implements ActionListener {
 
    ColorScheme cs = new ColorScheme();
 
    private JPanel mainContentPanel, linePanel, formPanel;
 
    private final JLabel headerLbl, goalTitlelbl, goalAmountlbl;
    private final JTextField goalTitletf, goalAmounttf;
    private final JButton confirmBtn, cancelBtn;
    private String userId;
 
    public SavingsTargetUI(String setUser) {
        setTitle("Set Savings Goal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(960, 670);
        setLocationRelativeTo(null);
        setResizable(false);
 
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
 
        headerLbl = new JLabel("Set Savings Goal");
        headerLbl.setBounds(30, 20, 450, 30);
        headerLbl.setFont(new Font("", Font.BOLD, 24));
        headerLbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(headerLbl);
 
        linePanel = new JPanel();
        linePanel.setBounds(30, 65, 885, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
 
        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(30, 100, 885, 495);
        formPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        formPanel.setBackground(cs.white);
        mainContentPanel.add(formPanel);
 
        // fields
 
        // goal title
        goalTitlelbl = new JLabel("Goal Title: ");
        goalTitlelbl.setBounds(15, 20, 150, 30);
        goalTitlelbl.setFont(new Font("", Font.BOLD, 16));
        goalTitlelbl.setForeground(cs.gray);
        formPanel.add(goalTitlelbl);
 
        goalTitletf = new JTextField();
        goalTitletf.setBounds(15, 55, 855, 40);
        goalTitletf.setFont(new Font("", Font.PLAIN, 16));
        goalTitletf.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        goalTitletf.setBackground(cs.lightgray);
        formPanel.add(goalTitletf);
 
        // goal amount
        goalAmountlbl = new JLabel("Goal Amount: ");
        goalAmountlbl.setBounds(15, 115, 150, 30);
        goalAmountlbl.setFont(new Font("", Font.BOLD, 16));
        goalAmountlbl.setForeground(cs.gray);
        formPanel.add(goalAmountlbl);
 
        goalAmounttf = new JTextField();
        goalAmounttf.setBounds(15, 150, 855, 40);
        goalAmounttf.setFont(new Font("", Font.PLAIN, 16));
        goalAmounttf.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        goalAmounttf.setBackground(cs.lightgray);
        formPanel.add(goalAmounttf);
 
        // botons
        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(535, 430, 160, 45);
        confirmBtn.setBackground(cs.darkPurple);
        confirmBtn.setForeground(cs.white);
        confirmBtn.setFocusPainted(false);
        confirmBtn.setBorderPainted(false);
        confirmBtn.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(confirmBtn);
 
        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(710, 430, 160, 45);
        cancelBtn.setBackground(cs.darkPurple);
        cancelBtn.setForeground(cs.white);
        cancelBtn.setFocusPainted(false);
        cancelBtn.setBorderPainted(false);
        cancelBtn.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(cancelBtn);
 
        mainContentPanel.setBounds(0, 0, 960, 670);
        add(mainContentPanel);
 
        confirmBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
        
        userId = setUser;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmBtn) {
            submitSavingsGoal();
        } 
        else if (e.getSource() == cancelBtn) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to quit?",
                    "Confirm Exit", JOptionPane.YES_NO_OPTION);
 
            if (confirm == JOptionPane.YES_OPTION) {
                System.out.println("CANCEL - disposing SavingsTargetUI");
                dispose();
                new SavingsUI().setVisible(true);
                
            }
        }
    }
 
    private void submitSavingsGoal() {
        String title = goalTitletf.getText().trim();
        String amountText = goalAmounttf.getText().trim();
 
        SavingsService SavingsService = new SavingsService();
 
        // validate title
        if (!SavingsService.isTitleValid(title)) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid goal title.",
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        // validate amount
        if (!SavingsService.isAmountValid(amountText)) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid goal amount greater than 0.",
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }
 
        boolean success = SavingsService.createSavingsGoal(title, amountText, userId);
 
        if (success) {
            JOptionPane.showMessageDialog(this,
                    "Your savings goal \"" + title + "\" has been set successfully!",
                    "Goal Set", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new SavingsUI().setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(this,
                    "Failed to set savings goal. Please try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
