package BankManage;
 
import BankManage.AccountModels.savingsModels;
import BankManage.AppService.SavingsService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
 
public class SavingsViewGoalsUI extends JFrame implements ActionListener {
 
    ColorScheme cs = new ColorScheme();
 
    private JPanel mainContentPanel, linePanel, cardsWrapperPanel;
 
    private final JLabel headerLbl;
    private final JButton returnBtn;
    private String getReturnWindow;
    private JScrollPane cardsScrollPane;
    String userId;
    // current total savings balance - used for percentage calculation
    private double currentBalance = 0.0;
 
    public SavingsViewGoalsUI(String setUser, double setSavings, String returnWindow) {
        setTitle("View Savings Goals");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(960, 700);
        setLocationRelativeTo(null);
        setResizable(false);
 
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
 
        // head
        headerLbl = new JLabel("My Savings Goals");
        headerLbl.setBounds(30, 20, 450, 30);
        headerLbl.setFont(new Font("", Font.BOLD, 24));
        headerLbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(headerLbl);
 
        linePanel = new JPanel();
        linePanel.setBounds(30, 65, 885, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
 
        // scrollable cards area - vertical stacking
        cardsWrapperPanel = new JPanel();
        cardsWrapperPanel.setLayout(new BoxLayout(cardsWrapperPanel, BoxLayout.Y_AXIS));
        cardsWrapperPanel.setBackground(cs.white);
 
        cardsScrollPane = new JScrollPane(cardsWrapperPanel);
        cardsScrollPane.setBounds(30, 90, 885, 480);
        cardsScrollPane.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        cardsScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        cardsScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        cardsScrollPane.getVerticalScrollBar().setUnitIncrement(16);
        mainContentPanel.add(cardsScrollPane);
 
        // return btn
        returnBtn = new JButton("Return");
        returnBtn.setBounds(755, 590, 160, 35);
        returnBtn.setBackground(cs.darkPurple);
        returnBtn.setForeground(cs.white);
        returnBtn.setFocusPainted(false);
        returnBtn.setBorderPainted(false);
        returnBtn.setFont(new Font("Arial", Font.BOLD, 14));
        mainContentPanel.add(returnBtn);
 
        mainContentPanel.setBounds(0, 0, 960, 700);
        add(mainContentPanel);
 
        returnBtn.addActionListener(this);
 
        // load goals on open
        userId = setUser;
        currentBalance = setSavings;
        getReturnWindow = returnWindow;
        loadGoalCards(userId);
    }
 
    // builds and populates goal cards from database
    private void loadGoalCards(String userId) {
        SavingsService savingsViewService = new SavingsService();
        List<savingsModels> goals = savingsViewService.getAllGoals(userId);
 
        cardsWrapperPanel.removeAll();
 
        if (goals.isEmpty()) {
            JLabel emptyLbl = new JLabel("No savings goals found.");
            emptyLbl.setFont(new Font("Arial", Font.PLAIN, 16));
            emptyLbl.setForeground(cs.gray);
            cardsWrapperPanel.add(emptyLbl);
        } else {
            for (savingsModels goal : goals) {
                JPanel card = buildGoalCard(goal, savingsViewService);
                cardsWrapperPanel.add(card);
            }
        }
 
        cardsWrapperPanel.revalidate();
        cardsWrapperPanel.repaint();
    }
 
    // builds a single horizontally laid out goal card
    private JPanel buildGoalCard(savingsModels goal, SavingsService savingsViewService) {
        JPanel card = new JPanel();
        card.setLayout(null);
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 100));
        card.setPreferredSize(new Dimension(840, 100));
        card.setBackground(cs.white);
        card.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
 
        // goal title
        JLabel titleLbl = new JLabel(goal.getTargetTitle());
        titleLbl.setBounds(15, 10, 200, 25);
        titleLbl.setFont(new Font("Arial", Font.BOLD, 15));
        titleLbl.setForeground(cs.darkerPurple);
        card.add(titleLbl);
 
        // vertical divider
        JPanel cardLine = new JPanel();
        cardLine.setBounds(220, 10, 1, 80);
        cardLine.setBackground(cs.darkPurple);
        card.add(cardLine);
 
        // target amount label
        JLabel amountLbl = new JLabel("Target Amount:");
        amountLbl.setBounds(235, 10, 130, 20);
        amountLbl.setFont(new Font("Arial", Font.PLAIN, 12));
        amountLbl.setForeground(cs.gray);
        card.add(amountLbl);
 
        // target amount value
        JLabel amountValueLbl = new JLabel("₱" + String.format("%,.2f", goal.gettargetAmnt()));
        amountValueLbl.setBounds(235, 35, 200, 25);
        amountValueLbl.setFont(new Font("Arial", Font.BOLD, 16));
        amountValueLbl.setForeground(cs.darkerPurple);
        card.add(amountValueLbl);
 
        // percentage calculation
        double percentage = savingsViewService.calculatePercentage(goal.gettargetAmnt(), currentBalance);
        String percentageText = savingsViewService.formatPercentage(percentage);
 
        // percentage label
        JLabel percentageLbl = new JLabel("Progress:");
        percentageLbl.setBounds(470, 10, 100, 20);
        percentageLbl.setFont(new Font("Arial", Font.PLAIN, 12));
        percentageLbl.setForeground(cs.gray);
        card.add(percentageLbl);
 
        // percentage value
        JLabel percentageValueLbl = new JLabel(percentageText);
        percentageValueLbl.setBounds(470, 35, 100, 25);
        percentageValueLbl.setFont(new Font("Arial", Font.BOLD, 13));
        percentageValueLbl.setForeground(percentage >= 100 ? new Color(34, 139, 34) : cs.darkerPurple);
        card.add(percentageValueLbl);
 
        // status badge
        JLabel statusLbl = new JLabel(goal.getgoalStatus());
        statusLbl.setBounds(30, 32, 240, 35);
        statusLbl.setFont(new Font("Arial", Font.BOLD, 18));
        statusLbl.setForeground(cs.darkPurple);
        card.add(statusLbl);
 
        // complete btn - hidden if already completed
        JButton completeBtn = new JButton("Mark Complete");
        completeBtn.setBounds(590, 35, 120, 25);
        completeBtn.setBackground(new Color(34, 139, 34));
        completeBtn.setForeground(cs.white);
        completeBtn.setFocusPainted(false);
        completeBtn.setBorderPainted(false);
        completeBtn.setFont(new Font("Arial", Font.BOLD, 10));
        completeBtn.setVisible(!goal.getgoalStatus().equalsIgnoreCase("Completed"));
        card.add(completeBtn);
 
        // remove btn
        JButton removeBtn = new JButton("Remove");
        removeBtn.setBounds(730, 35, 100, 25);
        removeBtn.setBackground(new Color(180, 30, 30));
        removeBtn.setForeground(cs.white);
        removeBtn.setFocusPainted(false);
        removeBtn.setBorderPainted(false);
        removeBtn.setFont(new Font("Arial", Font.BOLD, 10));
        card.add(removeBtn);
 
        // complete btn action
        completeBtn.addActionListener(ev -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Mark \"" + goal.getTargetTitle() + "\" as completed?",
                    "Confirm Complete", JOptionPane.YES_NO_OPTION);
 
            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = savingsViewService.completeGoal(goal.getgsavingsId(), userId);
 
                if (success) {
                    JOptionPane.showMessageDialog(this,
                            "Goal marked as completed!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadGoalCards(userId); // refresh cards
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Failed to update goal. Please try again.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
 
        // remove btn action
        removeBtn.addActionListener(ev -> {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to remove \"" + goal.getTargetTitle() + "\"?",
                    "Confirm Remove", JOptionPane.YES_NO_OPTION);
 
            if (confirm == JOptionPane.YES_OPTION) {
                boolean success = savingsViewService.removeGoal(goal.getgsavingsId(), userId);
 
                if (success) {
                    JOptionPane.showMessageDialog(this,
                            "Goal removed successfully!",
                            "Removed", JOptionPane.INFORMATION_MESSAGE);
                    loadGoalCards(userId); // refresh cards
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Failed to remove goal. Please try again.",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
 
        return card;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnBtn) {
            String choice = getReturnWindow;
            switch(choice){
                case "SaveUI":
                    SavingsUI su = new SavingsUI();
                    su.setVisible(true);
                    dispose();
                    break;
                case "BalUI":
                    BalanceUI bu = new BalanceUI();
                    bu.setVisible(true);
                    dispose();
                    break;
            }
        }
    }
}
