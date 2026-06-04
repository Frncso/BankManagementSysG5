package BankManage;

import BankManage.AccountModels.CustomerModel;
import BankManage.AccountModels.RequestModel;
import BankManage.AppService.RequestService;
import BankManage.AppService.SessionManage;
import BankManage.AppService.GetDateAndTime;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RequestNewAccUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    GetDateAndTime dateToday = new GetDateAndTime();

    private JPanel mainContentPanel, linePanel, formPanel;

    private final JLabel headerLbl, userIdLbl, userIdValueLbl, accountTypelbl, accountTypeValueLbl;
    private final JLabel requestTypelbl, requestTypeValueLbl, datelbl, dateValueLbl, purposelbl;
    private final JTextArea purposetxa;
    private final JButton requestBtn, cancelBtn;

    private String selectedAccountType;

    public RequestNewAccUI(String accountType) {
        this.selectedAccountType = accountType;

        setTitle("Request New Account");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(960, 670);
        setLocationRelativeTo(null);
        setResizable(false);

        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);

        headerLbl = new JLabel("Request New Account");
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
        CustomerModel customer = SessionManage.getCurrentCustomer();

        // uid
        userIdLbl = new JLabel("User ID: ");
        userIdLbl.setBounds(15, 20, 150, 30);
        userIdLbl.setFont(new Font("", Font.BOLD, 16));
        userIdLbl.setForeground(cs.gray);
        formPanel.add(userIdLbl);

        userIdValueLbl = new JLabel(customer.getCustomerId());
        userIdValueLbl.setBounds(155, 20, 400, 30);
        userIdValueLbl.setFont(new Font("", Font.BOLD, 16));
        userIdValueLbl.setForeground(cs.darkerPurple);
        formPanel.add(userIdValueLbl);

        // acc type
        accountTypelbl = new JLabel("Account Type: ");
        accountTypelbl.setBounds(15, 55, 150, 30);
        accountTypelbl.setFont(new Font("", Font.BOLD, 16));
        accountTypelbl.setForeground(cs.gray);
        formPanel.add(accountTypelbl);

        accountTypeValueLbl = new JLabel(selectedAccountType);
        accountTypeValueLbl.setBounds(155, 55, 200, 30);
        accountTypeValueLbl.setFont(new Font("", Font.BOLD, 16));
        accountTypeValueLbl.setForeground(cs.darkerPurple);
        formPanel.add(accountTypeValueLbl);

        // req type
        requestTypelbl = new JLabel("Request Type: ");
        requestTypelbl.setBounds(15, 90, 150, 30);
        requestTypelbl.setFont(new Font("", Font.BOLD, 16));
        requestTypelbl.setForeground(cs.gray);
        formPanel.add(requestTypelbl);

        requestTypeValueLbl = new JLabel("Account Opening");
        requestTypeValueLbl.setBounds(155, 90, 200, 30);
        requestTypeValueLbl.setFont(new Font("", Font.BOLD, 16));
        requestTypeValueLbl.setForeground(cs.darkerPurple);
        formPanel.add(requestTypeValueLbl);

        // date applied sec
        datelbl = new JLabel("Date Applied: ");
        datelbl.setBounds(15, 125, 150, 30);
        datelbl.setFont(new Font("", Font.BOLD, 16));
        datelbl.setForeground(cs.gray);
        formPanel.add(datelbl);

        dateValueLbl = new JLabel(dateToday.currentTime());
        dateValueLbl.setBounds(155, 125, 350, 30);
        dateValueLbl.setFont(new Font("", Font.BOLD, 16));
        dateValueLbl.setForeground(cs.darkerPurple);
        formPanel.add(dateValueLbl);

        // purpose
        purposelbl = new JLabel("Purpose: ");
        purposelbl.setBounds(15, 160, 150, 30);
        purposelbl.setFont(new Font("", Font.BOLD, 16));
        purposelbl.setForeground(cs.gray);
        formPanel.add(purposelbl);

        purposetxa = new JTextArea(5, 20);
        purposetxa.setBounds(15, 195, 855, 180);
        purposetxa.setFont(new Font("", Font.PLAIN, 16));
        purposetxa.setLineWrap(true);
        purposetxa.setWrapStyleWord(true);
        purposetxa.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        purposetxa.setBackground(cs.lightgray);
        formPanel.add(purposetxa);

        // botons
        requestBtn = new JButton("Request");
        requestBtn.setBounds(535, 430, 160, 45);
        requestBtn.setBackground(cs.darkPurple);
        requestBtn.setForeground(cs.white);
        requestBtn.setFocusPainted(false);
        requestBtn.setBorderPainted(false);
        requestBtn.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(requestBtn);

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

        requestBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == requestBtn) {
            submitNewAccountRequest();
        } 
        else if (e.getSource() == cancelBtn) {
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Are you sure you want to quit?",
                    "Confirm Exit", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                new AccountMenuUI().setVisible(true);
                dispose();
            }
        }
    }

    private void submitNewAccountRequest() {
        CustomerModel customer = SessionManage.getCurrentCustomer();

        RequestModel request = new RequestModel();
        request.setCustomerId(customer.getCustomerId());
        request.setAccountType(selectedAccountType);
        request.setRequestType("Open Account");
        request.setPurpose(purposetxa.getText().trim());

        RequestService requestService = new RequestService();
        boolean success = requestService.createRequest(request);

        if (success) {
            JOptionPane.showMessageDialog(this,
                    "Your request to open a new " + selectedAccountType + " account has been submitted!",
                    "Request Submitted", JOptionPane.INFORMATION_MESSAGE);
            new AccountMenuUI().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Failed to submit request. Please try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}