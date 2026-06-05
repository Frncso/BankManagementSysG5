package BankManage;

import BankManage.AccountModels.EmployeeModel;
import BankManage.AccountModels.RequestModel;
import BankManage.AppService.ActivityLogService;
import BankManage.AppService.BankAccountService;
import BankManage.AppService.SessionManage;
import BankManage.DataService.RequestDataService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RequestOpenAccountSummaryUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();

    private JPanel mainContentPanel, linePanel, formPanel;
    private JLabel headerLbl, customerIdLbl, customerIdValueLbl;
    private JLabel accountTypelbl, accountTypeValueLbl;
    private JLabel requestTypelbl, requestTypeValueLbl;
    private JLabel datelbl, dateValueLbl, purposelbl;
    private JTextArea purposetxa;

    private JButton acceptBtn, rejectBtn, returnBtn;

    private String requestId;
    private RequestModel request;

    public RequestOpenAccountSummaryUI(String requestId) {
        this.requestId = requestId;

        setTitle("Account Opening Request Details");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        setSize(960, 670);
        setLocationRelativeTo(null);
        setResizable(false);

        // req data
        RequestDataService requestDataService = new RequestDataService();
        request = requestDataService.findByReqID(requestId);

        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);

        // head
        headerLbl = new JLabel("Request New Account");
        headerLbl.setBounds(30, 20, 450, 30);
        headerLbl.setFont(new Font("", Font.BOLD, 24));
        headerLbl.setForeground(cs.darkerPurple);
        mainContentPanel.add(headerLbl);

        linePanel = new JPanel();
        linePanel.setBounds(30, 65, 885, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);

        // form panel
        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setBounds(30, 100, 885, 495);
        formPanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        formPanel.setBackground(cs.white);
        mainContentPanel.add(formPanel);

        // fields na mahaba

        // cus id
        customerIdLbl = new JLabel("Customer ID: ");
        customerIdLbl.setBounds(15, 20, 150, 30);
        customerIdLbl.setFont(new Font("", Font.BOLD, 16));
        customerIdLbl.setForeground(cs.gray);
        formPanel.add(customerIdLbl);

        customerIdValueLbl = new JLabel(request != null ? request.getCustomerId() : "N/A");
        customerIdValueLbl.setBounds(155, 20, 400, 30);
        customerIdValueLbl.setFont(new Font("", Font.BOLD, 16));
        customerIdValueLbl.setForeground(cs.darkerPurple);
        formPanel.add(customerIdValueLbl);

        // acc type
        accountTypelbl = new JLabel("Account Type: ");
        accountTypelbl.setBounds(15, 55, 150, 30);
        accountTypelbl.setFont(new Font("", Font.BOLD, 16));
        accountTypelbl.setForeground(cs.gray);
        formPanel.add(accountTypelbl);

        accountTypeValueLbl = new JLabel(request != null ? request.getAccountType() : "N/A");
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

        // date applied
        datelbl = new JLabel("Date Applied: ");
        datelbl.setBounds(15, 125, 125, 30);
        datelbl.setFont(new Font("", Font.BOLD, 16));
        datelbl.setForeground(cs.gray);
        formPanel.add(datelbl);

        dateValueLbl = new JLabel(request != null ? request.getTimestamp() : "N/A");
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

        purposetxa = new JTextArea();
        purposetxa.setBounds(15, 190, 855, 180);
        purposetxa.setFont(new Font("", Font.PLAIN, 16));
        purposetxa.setLineWrap(true);
        purposetxa.setWrapStyleWord(true);
        purposetxa.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        purposetxa.setBackground(cs.lightgray);
        purposetxa.setFocusable(false);
        purposetxa.setEditable(false); // no edits
        if (request != null) {
            purposetxa.setText(request.getPurpose());
        }
        formPanel.add(purposetxa);

        // btns
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

            loadRequestDetails();

        }
        
    }

    private void loadRequestDetails() {
        RequestDataService requestDataService = new RequestDataService();
        request = requestDataService.findByReqID(requestId);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        RequestDataService requestDataService = new RequestDataService();
        ActivityLogService ls = new ActivityLogService();
        EmployeeModel staff = SessionManage.getCurrentStaff();
        
        if (e.getSource() == acceptBtn) {
        // update to accepted
        boolean requestUpdated = requestDataService.updateRequestStatus(requestId, "Accepted");
        SessionManage.incrementProcessedCount();

        if (requestUpdated && request != null) {
            // pag true, create acc
            BankAccountService accountService = new BankAccountService();
            boolean accountCreated = accountService.createNewAccount(request.getCustomerId(), request.getAccountType());

            // pasok saactivity as accept
            ls.logActivity(
                requestId,
                request.getCustomerId(),
                request.getAccountNumber(),
                "Accepted - Account Opening",
                staff.getEmployeeFName()
            );
            
            if (accountCreated) {
                JOptionPane.showMessageDialog(this, 
                    "Request Accepted! New " + request.getAccountType() + " account has been created.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Request marked as Accepted, but failed to create the account.", "Operation Interrupted", JOptionPane.WARNING_MESSAGE);
            }
        }

        AccountRequestsUI ar = new AccountRequestsUI();
        ar.setVisible(true);
        dispose();

        } else if (e.getSource() == rejectBtn) {
            // reject
            
            SessionManage.incrementProcessedCount();
            
            // pasok saactivity as accept
            ls.logActivity(
                requestId,
                request.getCustomerId(),
                request.getAccountNumber(),
                "Rejected - Account Opening",
                staff.getEmployeeFName()
            );
            
            requestDataService.updateRequestStatus(requestId, "Rejected");
            JOptionPane.showMessageDialog(this, "Request has been rejected.", "Rejected", JOptionPane.INFORMATION_MESSAGE);

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