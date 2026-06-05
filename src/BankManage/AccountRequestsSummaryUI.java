package BankManage;

import BankManage.AccountModels.EmployeeModel;
import BankManage.AccountModels.RequestModel;
import BankManage.AppService.ActivityLogService;
import BankManage.AppService.SessionManage;
import BankManage.DataService.BankAccountDataService;
import BankManage.DataService.RequestDataService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountRequestsSummaryUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();

    private JPanel mainContentPanel, linePanel, formPanel;

    private JLabel headerLbl, forAccountlbl, accountIDlbl, accountTypelbl, accountTypeActuallbl;
    private JLabel requestlbl, requestActionlbl, datelbl, dateActuallbl, purposelbl;
    private JTextArea purposetxa;
    private JButton acceptBtn, rejectBtn, returnBtn;

    private String currentRequestId;
    private RequestModel currentRequest;

    public AccountRequestsSummaryUI(String requestID) {
        this.currentRequestId = requestID;

        setTitle("Account Request Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(960, 670);
        setLocationRelativeTo(null);
        setResizable(false);

        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);

        headerLbl = new JLabel("Request Account Closure");
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

        loadRequestDetails();

        forAccountlbl = new JLabel("For Account: ");
        forAccountlbl.setBounds(15, 20, 150, 30);
        forAccountlbl.setFont(new Font("", Font.BOLD, 16));
        forAccountlbl.setForeground(cs.gray);
        formPanel.add(forAccountlbl);

        accountIDlbl = new JLabel(currentRequest != null ? currentRequest.getAccountNumber() : "N/A");
        accountIDlbl.setBounds(155, 20, 300, 30);
        accountIDlbl.setFont(new Font("", Font.BOLD, 16));
        accountIDlbl.setForeground(cs.darkerPurple);
        formPanel.add(accountIDlbl);

        accountTypelbl = new JLabel("Account Type: ");
        accountTypelbl.setBounds(15, 50, 150, 30);
        accountTypelbl.setFont(new Font("", Font.BOLD, 16));
        accountTypelbl.setForeground(cs.gray);
        formPanel.add(accountTypelbl);

        accountTypeActuallbl = new JLabel(currentRequest != null ? currentRequest.getAccountType() : "N/A");
        accountTypeActuallbl.setBounds(155, 50, 150, 30);
        accountTypeActuallbl.setFont(new Font("", Font.BOLD, 16));
        accountTypeActuallbl.setForeground(cs.darkerPurple);
        formPanel.add(accountTypeActuallbl);

        requestlbl = new JLabel("Request Type: ");
        requestlbl.setBounds(15, 80, 150, 30);
        requestlbl.setFont(new Font("", Font.BOLD, 16));
        requestlbl.setForeground(cs.gray);
        formPanel.add(requestlbl);

        requestActionlbl = new JLabel(currentRequest != null ? currentRequest.getRequestType() : "N/A");
        requestActionlbl.setBounds(155, 80, 200, 30);
        requestActionlbl.setFont(new Font("", Font.BOLD, 16));
        requestActionlbl.setForeground(cs.darkerPurple);
        formPanel.add(requestActionlbl);

        datelbl = new JLabel("Date Applied: ");
        datelbl.setBounds(15, 110, 150, 30);
        datelbl.setFont(new Font("", Font.BOLD, 16));
        datelbl.setForeground(cs.gray);
        formPanel.add(datelbl);

        dateActuallbl = new JLabel(currentRequest != null ? currentRequest.getTimestamp() : "N/A");
        dateActuallbl.setBounds(155, 110, 350, 30);
        dateActuallbl.setFont(new Font("", Font.BOLD, 16));
        dateActuallbl.setForeground(cs.darkerPurple);
        formPanel.add(dateActuallbl);

        purposelbl = new JLabel("Purpose: ");
        purposelbl.setBounds(15, 140, 150, 30);
        purposelbl.setFont(new Font("", Font.BOLD, 16));
        purposelbl.setForeground(cs.gray);
        formPanel.add(purposelbl);

        purposetxa = new JTextArea();
        purposetxa.setBounds(15, 180, 855, 180);
        purposetxa.setFont(new Font("", Font.PLAIN, 16));
        purposetxa.setLineWrap(true);
        purposetxa.setWrapStyleWord(true);
        purposetxa.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        purposetxa.setBackground(cs.lightgray);
        purposetxa.setFocusable(false);
        purposetxa.setEditable(false); // display only nlng ung textarea
        if (currentRequest != null) {
            purposetxa.setText(currentRequest.getPurpose());
        }
        formPanel.add(purposetxa);

        // buttons
        acceptBtn = new JButton("Accept");
        acceptBtn.setBounds(360, 430, 160, 45);
        acceptBtn.setBackground(cs.lime);
        acceptBtn.setForeground(cs.white);
        acceptBtn.setFocusPainted(false);
        acceptBtn.setBorderPainted(false);
        acceptBtn.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(acceptBtn);

        rejectBtn = new JButton("Reject");
        rejectBtn.setBounds(535, 430, 160, 45);
        rejectBtn.setBackground(cs.red);
        rejectBtn.setForeground(cs.white);
        rejectBtn.setFocusPainted(false);
        rejectBtn.setBorderPainted(false);
        rejectBtn.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(rejectBtn);

        returnBtn = new JButton("Return");
        returnBtn.setBounds(710, 430, 160, 45);
        returnBtn.setBackground(cs.darkPurple);
        returnBtn.setForeground(cs.white);
        returnBtn.setFocusPainted(false);
        returnBtn.setBorderPainted(false);
        returnBtn.setFont(new Font("Arial", Font.BOLD, 14));
        formPanel.add(returnBtn);

        mainContentPanel.setBounds(0, 0, 960, 670);
        add(mainContentPanel);

        acceptBtn.addActionListener(this);
        rejectBtn.addActionListener(this);
        returnBtn.addActionListener(this);
        
        if (SessionManage.isStaffLoggedIn()){
            EmployeeModel staff = SessionManage.getCurrentStaff();
            
            System.out.println("Logged in as: " + staff.getEmployeeFName()); // debug
            
        }
        
    }

    private void loadRequestDetails() {
        RequestDataService requestDataService = new RequestDataService();
        currentRequest = requestDataService.findByReqID(currentRequestId);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RequestDataService requestDataService = new RequestDataService();
        ActivityLogService ls = new ActivityLogService();
        EmployeeModel staff = SessionManage.getCurrentStaff();

        if (e.getSource() == acceptBtn) {
            // accept request
            boolean updated = requestDataService.updateRequestStatus(currentRequestId, "Accepted");
            SessionManage.incrementProcessedCount();

            // pasok saactivity as accept
            ls.logActivity(
                currentRequestId,
                currentRequest.getCustomerId(),
                currentRequest.getAccountNumber(),
                "Accepted - Account Closing",
                staff.getEmployeeFName()
            );
            
            if (updated && currentRequest.getAccountNumber() != null) {
                BankAccountDataService accountDataService = new BankAccountDataService();
                accountDataService.closeStatus(currentRequest.getAccountNumber(), "Closed", 0.00);
            }

            JOptionPane.showMessageDialog(this, "Request Accepted. Account has been closed.");
            
            AccountRequestsUI ar = new AccountRequestsUI();
            ar.setVisible(true);
            dispose();

        } else if (e.getSource() == rejectBtn) {
            // reject
            
            SessionManage.incrementProcessedCount();
            
            // pasok saactivity as rejected
            ls.logActivity(
                currentRequestId,
                currentRequest.getCustomerId(),
                currentRequest.getAccountNumber(),
                "Rejected - Account Closing",
                staff.getEmployeeFName()
            );
            
            requestDataService.updateRequestStatus(currentRequestId, "Rejected");
            JOptionPane.showMessageDialog(this, "Request Rejected.");
            
            AccountRequestsUI ar = new AccountRequestsUI();
            ar.setVisible(true);
            dispose();

        } else if (e.getSource() == returnBtn) {
            AccountRequestsUI ar = new AccountRequestsUI();
            ar.setVisible(true);
            dispose();
        }
    }
}