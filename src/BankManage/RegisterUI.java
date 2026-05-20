package BankManage;

import BankManage.AppService.RegisterService;
import BankManage.AccountModels.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class RegisterUI extends JFrame implements ActionListener{
    
    ColorScheme cs = new ColorScheme();
    RegisterService rs = new RegisterService();
    // Account Models
    
    private final String[] occuList = {
        "Select Occupation", 
        "Employed (Full-Time)", 
        "Employed (Part-Time)", 
        "Self-Employed", 
        "Student", 
        "Unemployed", 
        "Retired", 
        "Unable to Work"
    };
    
    private final String[] salaryRange = {
        "Select Range",
        "Less than 10,000", 
        "10,000 - 20,000", 
        "20,000 - 30,000", 
        "30,000 - 50,000", 
        "50,000 - 75,000", 
        "75,000 - 100,000", 
        "100,000 - 150,000", 
        "150,000 - 200,000", 
        "Greater than 200,000"
    };
    
    private final String[] idType = {
        "Select ID",
        "PhilID",
        "ePhilID",
        "Passport",
        "Driver's License",
        "UMID",
        "SSS ID"
    };
    
    private final String[] months = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"
    };
    
    private final String[] day = new String[31];
    private int daysInAMonth = 31;
    
    private final String[] year = new String[127];
    private final int startYear = 1900;
    private int accInt = 0;
    
    private final String[] staffType = {
        "Select Position",
        "Customer Service",
        "Administrator"
    };
    
    private String accountNumber;
    
    // logo
    
    java.net.URL logoImgURL = CustomerDashboard.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));;
    private final JPanel logoPanel;
    private final JLabel logoFont;
    
    java.net.URL imgURL = RegisterUI.class.getResource("resources/gradientBackground.png"); // classpath to img
    
    // BG
    
    private final ImageIcon image = new ImageIcon(imgURL);
    private final JLabel background = new JLabel(image);
    
    private final CardLayout regSwitch;
    private final JPanel regFormCus, regFormStf, regFormContainer;
    
    // CUSTOMER SECTION
    
    private final JButton btnCus, btnStf, btnReg, btnCusS, btnStfS, btnStfReg, btnLog;
    private final JLabel lblFName, lblLName, lblPIN, lblDofB, lblOccu, lblSalary, lblIDType, lblIDNo, lblBottom; // for customer panel
    private final JTextField txtFName, txtLName, txtIDNo;//
    private final JPasswordField passField;
    private final JComboBox<String> cbxOccu, cbxSalary, cbxIDType, cbxMonth, cbxDay, cbxYear; // for customer panel

    // STAFF SECTION
    
    private final JButton btnLogS; // for staff panel
    private final JLabel lblFNameS, lblLNameS, lblPassword, lblDofBS, lblStaffType, lblAccess, lblBottomS; // for staff panel
    private final JTextField txtFNameS, txtLNameS, txtAccess;
    private final JPasswordField passFieldS;
    private final JComboBox<String> cbxStaffType;
    
    RegisterUI(){
        
        setSize(1440, 960);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); 
        setResizable(false);
        setTitle("VaultBank Register");

        logoPanel = new JPanel();
        logoPanel.setLayout(null);
        logoPanel.setBounds(472, 80, 500, 200);
        logoPanel.setOpaque(false);
        
        logoFont = new JLabel("VaultBank");
        logoFont.setBounds(125, 60, 400, 50);
        logoFont.setForeground(cs.white);
        logoFont.setFont(new Font("Cascadia Code", Font.BOLD, 64));
        
        logo.setBounds(25, 50, 75, 75);
        
        logoPanel.add(logoFont);
        logoPanel.add(logo);
        add(logoPanel);

        //background
        background.setBounds(0, 0, 1440, 960);        
        
        regSwitch = new CardLayout();
        regFormContainer = new JPanel(regSwitch);
        
        regFormCus = new JPanel(); // reg panel customer
        regFormCus.setLayout(null);
        
        regFormStf = new JPanel(); // reg panel staff
        regFormStf.setLayout(null);
        
        regFormContainer.add(regFormCus, "customer");
        regFormContainer.add(regFormStf, "staff");
        
        // components inside panel customer
        
        btnCus = new JButton("Customer");
        btnCus.setBounds(45, 40, 175, 30);
        btnCus.setBackground(cs.btnColorSelect);
        btnCus.setForeground(cs.white);
        btnCus.setFocusPainted(false);
        btnCus.setBorderPainted(false);
        regFormCus.add(btnCus);
        
        btnStf = new JButton("Staff");
        btnStf.setBounds(220, 40, 175, 30);
        btnStf.setBackground(cs.btnColorUnselect);
        btnStf.setForeground(cs.gray);
        btnStf.setFocusPainted(false);
        btnStf.setBorderPainted(false);
        regFormCus.add(btnStf);
        
        lblFName = new JLabel("First Name");
        lblFName.setBounds(45, 80, 150, 30);
        lblFName.setForeground(cs.gray);
        regFormCus.add(lblFName);
        
        txtFName = new JTextField("");
        txtFName.setBounds(45, 110, 350, 35);
        txtFName.setBackground(cs.white);
        regFormCus.add(txtFName);
        
        lblLName = new JLabel("Last Name");
        lblLName.setBounds(45, 150, 150, 30);
        lblLName.setForeground(cs.gray);
        regFormCus.add(lblLName);
        
        txtLName = new JTextField("");
        txtLName.setBounds(45, 180, 350, 35);
        txtLName.setBackground(cs.white);
        regFormCus.add(txtLName);
        
        lblPIN = new JLabel("Password");
        lblPIN.setBounds(45, 220, 150, 30);
        lblPIN.setForeground(cs.gray);
        regFormCus.add(lblPIN);
        
        passField = new JPasswordField("");
        passField.setBounds(45, 250, 350, 35);
        passField.setBackground(cs.white);
        regFormCus.add(passField);
        
        lblDofB = new JLabel("Date of Birth");
        lblDofB.setBounds(45, 290, 150, 30);
        lblDofB.setForeground(cs.gray);
        regFormCus.add(lblDofB);
        
        cbxMonth = new JComboBox<>(months);
        cbxMonth.setSelectedItem("Jan");
        cbxMonth.setBounds(45, 320, 55, 35);
        cbxMonth.setBackground(cs.white);
        cbxMonth.setForeground(cs.gray);
        cbxMonth.setFocusable(false);
        regFormCus.add(cbxMonth);
        
        // auto fill year and day (default)
        
        for(int y = 0; y < year.length; y++){
            year[y]=String.valueOf(startYear+y);
        }
        
        daysInAMonth = 31;
        for(int d = 1; d <= daysInAMonth; d++){
            day[d-1]=String.valueOf(d);
        }
        
        cbxDay = new JComboBox<>(day);
        cbxDay.setSelectedIndex(0);
        cbxDay.setBounds(98, 320, 45, 35);
        cbxDay.setBackground(cs.white);
        cbxDay.setForeground(cs.gray);
        cbxDay.setFocusable(false);
        regFormCus.add(cbxDay);
        
        cbxYear = new JComboBox<>(year);
        cbxYear.setSelectedIndex(year.length-1);
        cbxYear.setBounds(140, 320, 69, 35);
        cbxYear.setBackground(cs.white);
        cbxYear.setForeground(cs.gray);
        cbxYear.setFocusable(false);
        regFormCus.add(cbxYear);
        
        //
        
        lblOccu = new JLabel("Occupation");
        lblOccu.setBounds(230, 290, 150, 30);
        lblOccu.setForeground(cs.gray);
        regFormCus.add(lblOccu);
        
        cbxOccu = new JComboBox<>(occuList);
        cbxOccu.setBounds(230, 320, 164, 35);
        cbxOccu.setSelectedIndex(0);
        cbxOccu.setBackground(cs.white);
        cbxOccu.setForeground(cs.gray);
        regFormCus.add(cbxOccu);
        
        lblSalary = new JLabel("Income Range");
        lblSalary.setBounds(45, 360, 150, 30);
        lblSalary.setForeground(cs.gray);
        lblSalary.setForeground(cs.gray);
        regFormCus.add(lblSalary);
        
        cbxSalary = new JComboBox<>(salaryRange);
        cbxSalary.setBounds(45, 390, 164, 35);
        cbxSalary.setSelectedIndex(0);
        cbxSalary.setBackground(cs.white);
        cbxSalary.setForeground(cs.gray);
        regFormCus.add(cbxSalary);
        
        lblIDType = new JLabel("ID Type");
        lblIDType.setBounds(230, 360, 150, 30);
        lblIDType.setForeground(cs.gray);
        regFormCus.add(lblIDType);
        
        cbxIDType = new JComboBox<>(idType);
        cbxIDType.setBounds(230, 390, 164, 35);
        cbxIDType.setSelectedIndex(0);
        cbxIDType.setBackground(cs.white);
        cbxIDType.setForeground(cs.gray);
        regFormCus.add(cbxIDType);
        
        lblIDNo = new JLabel("ID Number");
        lblIDNo.setBounds(45, 430, 150, 30);
        lblIDNo.setForeground(cs.gray);
        regFormCus.add(lblIDNo);
        
        txtIDNo = new JTextField("");
        txtIDNo.setBounds(45, 460, 350, 35);
        txtIDNo.setBackground(cs.white);
        regFormCus.add(txtIDNo);
        
        btnReg = new JButton("Sign Up");
        btnReg.setBounds(45, 510, 350, 30);
        btnReg.setBackground(cs.btnColorSelect);
        btnReg.setForeground(cs.white);
        btnReg.setFocusPainted(false);
        btnReg.setBorderPainted(false);
        regFormCus.add(btnReg);
        
        lblBottom = new JLabel("Already have an account?");
        lblBottom.setBounds(110, 550, 200, 30);
        lblBottom.setForeground(cs.gray);
        regFormCus.add(lblBottom);
        
        btnLog = new JButton("Login here");
        btnLog.setBounds(240, 545, 100, 40);
        btnLog.setBorderPainted(false);
        btnLog.setContentAreaFilled(false);
        btnLog.setFocusPainted(false);
        btnLog.setForeground(cs.purple);
        regFormCus.add(btnLog);
        
        regFormCus.setBackground(cs.white);
        
        // staff section

        btnCusS = new JButton("Customer");
        btnCusS.setBounds(45, 40, 175, 30);
        btnCusS.setBackground(cs.btnColorUnselect);
        btnCusS.setForeground(cs.gray);
        btnCusS.setFocusPainted(false);
        btnCusS.setBorderPainted(false);
        regFormStf.add(btnCusS);
        
        btnStfS = new JButton("Staff");
        btnStfS.setBounds(220, 40, 175, 30);
        btnStfS.setBackground(cs.btnColorSelect);
        btnStfS.setForeground(cs.white);
        btnStfS.setFocusPainted(false);
        btnStfS.setBorderPainted(false);
        regFormStf.add(btnStfS);
        
        lblFNameS = new JLabel("First Name");
        lblFNameS.setBounds(45, 80, 150, 30);
        lblFNameS.setForeground(cs.gray);
        regFormStf.add(lblFNameS);
        
        txtFNameS = new JTextField("");
        txtFNameS.setBounds(45, 110, 350, 35);
        txtFNameS.setBackground(cs.white);
        regFormStf.add(txtFNameS);
        
        lblLNameS = new JLabel("Last Name");
        lblLNameS.setBounds(45, 150, 150, 30);
        lblLNameS.setForeground(cs.gray);
        regFormStf.add(lblLNameS);
        
        txtLNameS = new JTextField("");
        txtLNameS.setBounds(45, 180, 350, 35);
        txtLNameS.setBackground(cs.white);
        regFormStf.add(txtLNameS);
        
        lblPassword = new JLabel("Password");
        lblPassword.setBounds(45, 220, 150, 30);
        lblPassword.setForeground(cs.gray);
        regFormStf.add(lblPassword);
        
        passFieldS = new JPasswordField("");
        passFieldS.setBounds(45, 250, 350, 35);
        passFieldS.setBackground(cs.white);
        regFormStf.add(passFieldS);
        
        lblDofBS = new JLabel("Date of Birth");
        lblDofBS.setBounds(45, 290, 150, 30);
        lblDofBS.setForeground(cs.gray);
        regFormStf.add(lblDofBS);
        
        // transferring the same combo boxes
        
        //
        
        lblStaffType = new JLabel("Staff Type");
        lblStaffType.setBounds(230, 290, 150, 30);
        lblStaffType.setForeground(cs.gray);
        regFormStf.add(lblStaffType);
        
        cbxStaffType = new JComboBox<>(staffType);
        cbxStaffType.setBounds(230, 320, 164, 35);
        cbxStaffType.setSelectedIndex(0);
        cbxStaffType.setBackground(cs.white);
        cbxStaffType.setForeground(cs.gray);
        regFormStf.add(cbxStaffType);
        
        lblAccess = new JLabel("Access Code");
        lblAccess.setBounds(45, 360, 150, 30);
        lblAccess.setForeground(cs.gray);
        lblAccess.setForeground(cs.gray);
        regFormStf.add(lblAccess);
        
        txtAccess = new JTextField("");
        txtAccess.setBounds(45, 390, 350, 35);
        txtAccess.setBackground(cs.white);
        txtAccess.setForeground(cs.gray);
        regFormStf.add(txtAccess);
        
        btnStfReg = new JButton("Sign Up");
        btnStfReg.setBounds(45, 510, 350, 30);
        btnStfReg.setBackground(cs.btnColorSelect);
        btnStfReg.setForeground(cs.white);
        btnStfReg.setFocusPainted(false);
        btnStfReg.setBorderPainted(false);
        regFormStf.add(btnStfReg);
        
        lblBottomS = new JLabel("Already have an account?");
        lblBottomS.setBounds(110, 550, 200, 30);
        lblBottomS.setForeground(cs.gray);
        regFormStf.add(lblBottomS);
        
        btnLogS = new JButton("Login here");
        btnLogS.setBounds(240, 545, 100, 40);
        btnLogS.setBorderPainted(false);
        btnLogS.setContentAreaFilled(false);
        btnLogS.setFocusPainted(false);
        btnLogS.setForeground(cs.purple);
        regFormStf.add(btnLogS);

        //
        
        regFormStf.setBackground(cs.white);
        
        regFormContainer.setBounds(500, 250, 445, 610);
        
        add(regFormContainer);
        
        btnStf.addActionListener(this); // customer staff button
        btnReg.addActionListener(this); // customer reg button
        cbxMonth.addActionListener(this); // customer month button
        cbxYear.addActionListener(this); // customer year button
        btnLog.addActionListener(this); // customer login button
        
        btnCusS.addActionListener(this); // staff customer button
        btnStfReg.addActionListener(this); // staff reg button
        btnLogS.addActionListener(this); // staff login button
        
        add(background);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedMonth = (String) cbxMonth.getSelectedItem();
                
        if(e.getSource() == btnCusS){ // card switch staff to customer
            
            // reusing date of birth
            
            btnCus.setBackground(cs.btnColorSelect);
            btnCus.setForeground(cs.white);
            btnStf.setForeground(cs.gray);
            btnStf.setBackground(cs.btnColorUnselect);
            
            regFormCus.add(cbxMonth);
            regFormCus.add(cbxDay);
            regFormCus.add(cbxYear);
            
            regSwitch.show(regFormContainer, "customer");
            
        }
        else if(e.getSource() == btnStf){ // card switch customer to staff

            btnStf.setBackground(cs.btnColorSelect);
            btnStf.setForeground(cs.white);
            btnCus.setForeground(cs.gray);
            btnCus.setBackground(cs.btnColorUnselect);
            
            regFormStf.add(cbxMonth);
            regFormStf.add(cbxDay);
            regFormStf.add(cbxYear);
            
            regSwitch.show(regFormContainer, "staff");
            
        }
        else if(e.getSource() == btnLog){
     
            LoginUI ln = new LoginUI();
            ln.setVisible(true);
            dispose();
            
        }
        else if(e.getSource() == btnLogS){
            
            LoginUI ln = new LoginUI();
            ln.setVisible(true);
            ln.staffRegister(true); // ensures it switches to staff tab upon olgin
            dispose();
            
        }
        else if(e.getSource() == cbxMonth){
            // day logic
        
            boolean monthCheck = monthDayCheck(selectedMonth);
            if(monthCheck){
                daysInAMonth = 31;
                cbxDay.removeAllItems();
                for(int d = 1; d <= daysInAMonth; d++){
                    cbxDay.addItem(String.valueOf(d));
                }
            }
            else{
                if(FebruaryCheck(selectedMonth)){
                    if(Integer.parseInt((String) cbxYear.getSelectedItem()) % 4 == 0){
                        System.out.println("UPDATE LEAP"); // test out
                        daysInAMonth = 29;
                        cbxDay.removeAllItems();
                        for(int d = 1; d <= daysInAMonth; d++){
                            cbxDay.addItem(String.valueOf(d));
                        }
                    }
                    else{
                        System.out.println("UPDATE NOT"); // test out
                        daysInAMonth = 28;
                        cbxDay.removeAllItems();
                        for(int d = 1; d <= daysInAMonth; d++){
                            cbxDay.addItem(String.valueOf(d));
                        }
                    }
                }
                else{
                    daysInAMonth = 30;
                    cbxDay.removeAllItems();
                    for(int d = 1; d <= daysInAMonth; d++){
                        cbxDay.addItem(String.valueOf(d));
                    }
                }
            }
        }
        else if(e.getSource() == cbxYear){
            if(FebruaryCheck(selectedMonth)){
                if(Integer.parseInt((String) cbxYear.getSelectedItem()) % 4 == 0){
                    System.out.println("UPDATE LEAP"); // test out
                    daysInAMonth = 29;
                    cbxDay.removeAllItems();
                    for(int d = 1; d <= daysInAMonth; d++){
                        cbxDay.addItem(String.valueOf(d));
                    }
                }
                else{
                    System.out.println("UPDATE NOT"); // test out
                    daysInAMonth = 28;
                    cbxDay.removeAllItems();
                    for(int d = 1; d <= daysInAMonth; d++){
                        cbxDay.addItem(String.valueOf(d));
                    }
                }
            }
        }
        else if(e.getSource() == btnReg){
            /* 
            
            Customer customer = new Customer{
                CusName = cusName,
                CusName = cusName,
                ... fields
                accType = user
            };
            
            */
            
            // rs.AddAccount(customer);
            
            // TEST CONCATENATION FOR ACC NO. (must have try catch soon)

            JOptionPane.showMessageDialog(this, "Successfully Created Account.", "Registration Complete", JOptionPane.INFORMATION_MESSAGE);
            
            LoginUI ln = new LoginUI();
            ln.setVisible(true);
            dispose();
            
        }
        else if(e.getSource() == btnStfReg){
            /* 
            
            if pos == staff,
            
            Employee staff = new Employee{
                StFName = stFName,
                StLName = stLName,
                ... fields
                accType = admin
            };
            
            rs.AddAccount(staff);
            
            */
            
            JOptionPane.showMessageDialog(this, "Successfully Created Account.", "Registration Complete", JOptionPane.INFORMATION_MESSAGE);
            
            LoginUI ln = new LoginUI();
            ln.setVisible(true);
            ln.staffRegister(true); // ensures it switches to staff tab upon registration
            dispose();
            
        }
    }
    
    public final boolean monthDayCheck(String month){
        boolean isThirtyOne;
        
        switch(month){
            case "Jan":
                isThirtyOne = true;
                break;
            case "Mar":
                isThirtyOne = true;
                break;
            case "May":
                isThirtyOne = true;
                break;
            case "Jul":
                isThirtyOne = true;
                break;
            case "Aug":
                isThirtyOne = true;
                break;
            case "Oct":
                isThirtyOne = true;
                break;
            case "Dec":
                isThirtyOne = true;
                break;
            default:
                isThirtyOne = false;
                break;
        }
        
        return isThirtyOne;
    }
    
    public final boolean FebruaryCheck(String month){
        boolean isFeb;
        
        isFeb = month.equals("Feb");
        
        return isFeb;
    }
    
}
