package BankManage;

import BankManage.AccountModels.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Register extends JFrame implements ActionListener{
    
    ColorScheme cs = new ColorScheme();
    // RegisterService rs = new RegisterService();
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
    
    private final String[] staffType = {
        "Select Position",
        "Employee",
        "Administrator"
    };
    
    private final CardLayout regSwitch;
    private final JPanel regFormCus, regFormStf, regFormContainer;
    private final JButton btnCus, btnStf, btnReg, btnCusS, btnStfS, btnStfReg, btnLog;
    
    private final JLabel lblFName, lblLName, lblAddress, lblDofB, lblOccu, lblSalary, lblIDType, lblIDNo, lblBottom; // for customer panel
    private final JTextField txtFName, txtLName, txtAddress, txtDofB, txtIDNo;// for custoner panel, date of birth temporary
    private final JComboBox<String> cbxOccu, cbxSalary, cbxIDType; // for customer panel
    
    private JLabel lblFNameS, lblLNameS, lblAddressS, lblDofBS, lblStaffType, lblAccess, lblBottomS; // for staff panel
    private JButton btnLogS; // for staff panel
    
    Register(){
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setTitle("Banking System Prototype");
        setSize(1440, 960);
        
        Container c = this.getContentPane(); // bg color
        c.setBackground(cs.bgColor);

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
        
        btnStf = new JButton("Staff");
        btnStf.setBounds(220, 40, 175, 30);
        btnStf.setBackground(cs.btnColorUnselect);
        btnStf.setForeground(cs.gray);
        btnStf.setFocusPainted(false);
        btnStf.setBorderPainted(false);
        
        lblFName = new JLabel("First Name");
        lblFName.setBounds(45, 80, 150, 30);
        lblFName.setForeground(cs.gray);
        
        txtFName = new JTextField("");
        txtFName.setBounds(45, 110, 350, 35);
        txtFName.setBackground(cs.white);
        
        lblLName = new JLabel("Last Name");
        lblLName.setBounds(45, 150, 150, 30);
        lblLName.setForeground(cs.gray);
        
        txtLName = new JTextField("");
        txtLName.setBounds(45, 180, 350, 35);
        txtLName.setBackground(cs.white);
        
        lblAddress = new JLabel("Address");
        lblAddress.setBounds(45, 220, 150, 30);
        lblAddress.setForeground(cs.gray);
        
        txtAddress = new JTextField("");
        txtAddress.setBounds(45, 250, 350, 35);
        txtAddress.setBackground(cs.white);
        
        lblDofB = new JLabel("Date of Birth");
        lblDofB.setBounds(45, 290, 150, 30);
        lblDofB.setForeground(cs.gray);
        
        txtDofB = new JTextField(); // temporary as txtbox
        txtDofB.setBounds(45, 320, 165, 35);
        txtDofB.setBackground(cs.white);
        
        lblOccu = new JLabel("Occupation");
        lblOccu.setBounds(230, 290, 150, 30);
        lblOccu.setForeground(cs.gray);
        
        cbxOccu = new JComboBox<>(occuList);
        cbxOccu.setBounds(230, 320, 164, 35);
        cbxOccu.setSelectedIndex(0);
        cbxOccu.setBackground(cs.white);
        
        lblSalary = new JLabel("Income Range");
        lblSalary.setBounds(45, 360, 150, 30);
        lblSalary.setForeground(cs.gray);
        
        cbxSalary = new JComboBox<>(salaryRange);
        cbxSalary.setBounds(45, 390, 164, 35);
        cbxSalary.setSelectedIndex(0);
        cbxSalary.setBackground(cs.white);
        
        lblIDType = new JLabel("ID Type");
        lblIDType.setBounds(230, 360, 150, 30);
        lblIDType.setForeground(cs.gray);
        
        cbxIDType = new JComboBox<>(idType);
        cbxIDType.setBounds(230, 390, 164, 35);
        cbxIDType.setSelectedIndex(0);
        cbxIDType.setBackground(cs.white);
        
        
        lblIDNo = new JLabel("ID Number");
        lblIDNo.setBounds(45, 430, 150, 30);
        lblIDNo.setForeground(cs.gray);
        
        txtIDNo = new JTextField("");
        txtIDNo.setBounds(45, 460, 350, 35);
        txtIDNo.setBackground(cs.white);
        
        btnReg = new JButton("Sign Up");
        btnReg.setBounds(45, 510, 350, 30);
        btnReg.setBackground(cs.btnColorSelect);
        btnReg.setForeground(cs.white);
        btnReg.setFocusPainted(false);
        btnReg.setBorderPainted(false);
        
        lblBottom = new JLabel("Already have an account?");
        lblBottom.setBounds(110, 550, 200, 30);
        lblBottom.setForeground(cs.gray);
        
        btnLog = new JButton("Login here");
        btnLog.setBounds(240, 545, 100, 40);
        btnLog.setBorderPainted(false);
        btnLog.setContentAreaFilled(false);
        btnLog.setFocusPainted(false);
        btnLog.setForeground(cs.bgColor);
        
        regFormCus.add(lblFName);
        regFormCus.add(txtFName);
        regFormCus.add(txtLName);
        regFormCus.add(lblLName);
        regFormCus.add(lblAddress);
        regFormCus.add(txtAddress);
        regFormCus.add(lblDofB);
        regFormCus.add(txtDofB);
        regFormCus.add(lblOccu);
        regFormCus.add(cbxOccu);
        regFormCus.add(lblSalary);
        regFormCus.add(cbxSalary);
        regFormCus.add(lblIDType);
        regFormCus.add(cbxIDType);
        regFormCus.add(lblIDNo);
        regFormCus.add(txtIDNo);
        regFormCus.add(btnCus);
        regFormCus.add(btnStf);
        regFormCus.add(btnReg);
        regFormCus.add(lblBottom);
        regFormCus.add(btnLog);
        
        regFormCus.setBackground(cs.white);
        
        // staff section

        btnCusS = new JButton("Customer");
        btnCusS.setBounds(45, 40, 175, 30);
        btnCusS.setBackground(cs.btnColorUnselect);
        btnCusS.setForeground(cs.gray);
        btnCusS.setFocusPainted(false);
        btnCusS.setBorderPainted(false);
        
        btnStfS = new JButton("Staff");
        btnStfS.setBounds(220, 40, 175, 30);
        btnStfS.setBackground(cs.btnColorSelect);
        btnStfS.setForeground(cs.white);
        btnStfS.setFocusPainted(false);
        btnStfS.setBorderPainted(false);
        
        btnStfReg = new JButton("Sign Up");
        btnStfReg.setBounds(45, 510, 350, 30);
        btnStfReg.setBackground(cs.btnColorSelect);
        btnStfReg.setForeground(cs.white);
        btnStfReg.setFocusPainted(false);
        btnStfReg.setBorderPainted(false);
        
        lblBottomS = new JLabel("Already have an account?");
        lblBottomS.setBounds(110, 550, 200, 30);
        lblBottomS.setForeground(cs.gray);
        
        btnLogS = new JButton("Login here");
        btnLogS.setBounds(240, 545, 100, 40);
        btnLogS.setBorderPainted(false);
        btnLogS.setContentAreaFilled(false);
        btnLogS.setFocusPainted(false);
        btnLogS.setForeground(cs.bgColor);
        
        regFormStf.add(btnCusS);
        regFormStf.add(btnStfS);
        regFormStf.add(btnStfReg);
        regFormStf.add(lblBottomS);
        regFormStf.add(btnLogS);
        
        //
        
        regFormStf.setBackground(cs.white);
        
        regFormContainer.setBounds(500, 225, 445, 610);
        
        add(regFormContainer);
        
        btnCusS.addActionListener(this); // staff customer button
        btnStf.addActionListener(this); // customer staff button
        btnReg.addActionListener(this); // customer reg button
        btnStfReg.addActionListener(this); // staff reg button
        btnLog.addActionListener(this);
        btnLogS.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnCusS){
            
            btnCus.setBackground(cs.btnColorSelect);
            btnCus.setForeground(cs.white);
            btnStf.setForeground(cs.gray);
            btnStf.setBackground(cs.btnColorUnselect);
            
            regSwitch.show(regFormContainer, "customer");
            
        }
        else if(e.getSource() == btnStf){

            btnStf.setBackground(cs.btnColorSelect);
            btnStf.setForeground(cs.white);
            btnCus.setForeground(cs.gray);
            btnCus.setBackground(cs.btnColorUnselect);
            
            regSwitch.show(regFormContainer, "staff");
            
        }
        else if(e.getSource() == btnLog || e.getSource() == btnLogS){
            System.out.println("LOGGING IN"); // debug purposes
            /* 
            Login ln = new Login();
            ln.setVisible(true);
            dispose();
            */
        }
        else if(e.getSource() == btnReg){
            /* 
            
            Staff staff = new Staff{
                StFName = stFName,
                StLName = stLName,
                ... fields
                StPos = stPos
            };
            
            rs.AddAccount(staff);
            
            JOptionPane.showMessageDialog(this, "Successfully Created Account.", "Registration Complete", INFORMATION_MESSAGE);
            
            Login ln = new Login();
            ln.setVisible(true);
            dispose();
            */
        }
    }
    
}
