package BankManage; 
import BankManage.AccountModels.EmployeeModel;
import BankManage.AccountModels.RequestModel;
import BankManage.AppService.Encryption;
import BankManage.AppService.SessionManage;
import BankManage.DataService.RequestDataService;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProcessedRequestsUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    Encryption en = new Encryption();
    
    java.net.URL eyeImgURL = CustomerDashboard.class.getResource("resources/eye.png");
    private ImageIcon eyeRaw = new ImageIcon(eyeImgURL);
    private Image eyeScale = eyeRaw.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    private ImageIcon eyeIcon = new ImageIcon(eyeScale);
    
    private JPanel mainContentPanel, linePanel, requestsTablePanel;
    
    private JButton viewPenReqbtn;
    
    private final JLabel dashboardTitle, pendinglbl;
    private JTable requestsTable;
    private JScrollPane tableScrollPane;
    
    protected String[] columnHeaders = {
        "Request ID", "Customer ID", "Account ID", "Request Type", "Account Type", "Status", "Date Applied"
    };
    
    public ProcessedRequestsUI() {
         
        setTitle("Admin Dashboard - Processed Requests");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1260, 960);
        setLocationRelativeTo(null); 
        setResizable(false);
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        
        dashboardTitle = new JLabel("Processed Requests");
        dashboardTitle.setBounds(30, 15, 200, 20);
        dashboardTitle.setFont(new Font("", Font.BOLD, 16));
        mainContentPanel.add(dashboardTitle);
        
        linePanel = new JPanel();
        linePanel.setBounds(30, 50, 1185, 3);
        linePanel.setBackground(cs.darkPurple);
        mainContentPanel.add(linePanel);
        
        requestsTablePanel = new JPanel();
        requestsTablePanel.setLayout(null);
        requestsTablePanel.setBounds(30, 110, 1185, 790);
        requestsTablePanel.setBackground(cs.white);
        requestsTablePanel.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        
        pendinglbl = new JLabel("List of Processed Requests"); 
        pendinglbl.setBounds(20, 20, 300, 30);
        pendinglbl.setFont(new Font("", Font.BOLD, 18));
        pendinglbl.setForeground(cs.darkerPurple);
        requestsTablePanel.add(pendinglbl);
        
        tableScrollPane = new JScrollPane(requestsTable);
        tableScrollPane.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        tableScrollPane.setBounds(20, 60, 1145, 710);
        requestsTablePanel.add(tableScrollPane);
        
        mainContentPanel.add(requestsTablePanel);
        
        viewPenReqbtn = new JButton("View Pending Requests", eyeIcon);
        viewPenReqbtn.setBounds(985, 65, 230, 30);
        viewPenReqbtn.setBackground(cs.darkPurple);
        viewPenReqbtn.setForeground(cs.white);
        viewPenReqbtn.setFocusPainted(false);
        viewPenReqbtn.setBorderPainted(false);
        viewPenReqbtn.setFont(new Font("Arial", Font.BOLD, 13));
        viewPenReqbtn.addActionListener(this);
        mainContentPanel.add(viewPenReqbtn);
        
        mainContentPanel.setBounds(0, 0, 1260, 960);
        add(mainContentPanel);
        
        if (SessionManage.isStaffLoggedIn()){
            EmployeeModel staff = SessionManage.getCurrentStaff();
            
            loadRequestData();
            
            System.out.println("Logged in as: " + staff.getEmployeeFName()); // debug
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == viewPenReqbtn){
            AccountRequestsUI au = new AccountRequestsUI();
            au.setVisible(true);
            dispose();
        }
    }
    
    private void loadRequestData() {
        RequestDataService requestDataService = new RequestDataService();
        List<RequestModel> requests = requestDataService.getProcessedRequests();

        String[][] data = new String[requests.size()][7];

        for (int i = 0; i < requests.size(); i++) {
            RequestModel r = requests.get(i);

            data[i][0] = r.getRequestId();
            data[i][1] = r.getCustomerId();
            data[i][2] = r.getAccountNumber() != null ? r.getAccountNumber() : "N/A";
            data[i][3] = r.getRequestType();
            data[i][4] = r.getAccountType();
            data[i][5] = r.getStatus();
            data[i][6] = r.getTimestamp();
        }

        requestsTable = new JTable(data, columnHeaders);
        requestsTable.setRowHeight(40);
        requestsTable.setFont(new Font("Arial", Font.PLAIN, 14));
        requestsTable.setFocusable(false);
        requestsTable.getTableHeader().setReorderingAllowed(false);
        requestsTable.getTableHeader().setBackground(cs.darkPurple);
        requestsTable.getTableHeader().setForeground(cs.white);
        requestsTable.setSelectionBackground(cs.lightPurple);
        requestsTable.setSelectionForeground(cs.white);
        requestsTable.setShowGrid(false);
        requestsTable.setDefaultEditor(Object.class, null);

        requestsTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        requestsTable.getTableHeader().setPreferredSize(new Dimension(0, 45));

        tableScrollPane.setViewportView(requestsTable);
    }
    
}