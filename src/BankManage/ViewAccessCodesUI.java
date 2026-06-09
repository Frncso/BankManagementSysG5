package BankManage; 
import BankManage.AccountModels.EmployeeModel;
import BankManage.AccountModels.OneTimeCode;
import BankManage.AppService.OneTimeCodeService;
import BankManage.AppService.SessionManage;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewAccessCodesUI extends JFrame implements ActionListener {

    ColorScheme cs = new ColorScheme();
    
    private JPanel mainContentPanel, linePanel, requestsTablePanel;
    
    private JButton viewPenReqbtn;
    
    private final JLabel dashboardTitle, pendinglbl;
    private JTable requestsTable;
    private JScrollPane tableScrollPane;
    
    protected String[] columnHeaders = {
        "Employee ID", "Access Code", "Status", "Created At"
    };
    
    public ViewAccessCodesUI() {
         
        setTitle("Admin Dashboard - Generated Access Codes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1260, 960);
        setLocationRelativeTo(null); 
        setResizable(false);
        
        mainContentPanel = new JPanel();
        mainContentPanel.setLayout(null);
        
        dashboardTitle = new JLabel("Generated Codes");
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
        
        pendinglbl = new JLabel("List of Generated Codes"); 
        pendinglbl.setBounds(20, 20, 300, 30);
        pendinglbl.setFont(new Font("", Font.BOLD, 18));
        pendinglbl.setForeground(cs.darkerPurple);
        requestsTablePanel.add(pendinglbl);
        
        tableScrollPane = new JScrollPane(requestsTable);
        tableScrollPane.setBorder(BorderFactory.createLineBorder(cs.darkPurple, 1));
        tableScrollPane.setBounds(20, 60, 1145, 710);
        requestsTablePanel.add(tableScrollPane);
        
        mainContentPanel.add(requestsTablePanel);
        
        viewPenReqbtn = new JButton("Return to Account Controls");
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
            AccountRoleUI ar = new AccountRoleUI();
            ar.setVisible(true);
            dispose();
        }
    }
    
    private void loadRequestData() {
        OneTimeCodeService otcService = new OneTimeCodeService();
        List<OneTimeCode> codes = otcService.getAllCodes();

        String[][] data = new String[codes.size()][5];

        for (int i = 0; i < codes.size(); i++) {
            OneTimeCode o = codes.get(i);

            data[i][0] = o.getEmployeeId() != null ? o.getEmployeeId() : "No Claimer Yet."; ;
            data[i][1] = o.getAccessCode();
            data[i][2] = o.getStatus();
            data[i][3] = o.getCreatedAt();
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