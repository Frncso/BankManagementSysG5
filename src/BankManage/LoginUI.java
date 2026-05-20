package BankManage;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class LoginUI extends JFrame  implements ActionListener {
   
    ColorScheme cs = new ColorScheme();

    // logo
    
    java.net.URL logoImgURL = CustomerDashboard.class.getResource("resources/bluewhiteLogo.png");
    
    private final ImageIcon logoRaw = new ImageIcon(logoImgURL);
    private final Image logoScale = logoRaw.getImage().getScaledInstance(75, 75, Image.SCALE_SMOOTH);
    private final JLabel logo = new JLabel(new ImageIcon(logoScale));;
    
    private final JLabel logoFont;
    
    java.net.URL imgURL = LoginUI.class.getResource("resources/gradientBackground.png"); // classpath to img

    private final ImageIcon image = new ImageIcon(imgURL);
    private final JLabel background = new JLabel(image);
    
    private CardLayout loginSwitch;
    private JPanel loginContainer, loginCus, loginStf;
    
    private JPanel logoPanel;

    private JButton btnCus, btnStf, btnSignIn, btnRegister; //cus log
    private JTextField txtAccNo;
    private JPasswordField txtPin;
    
    private JButton btnCusS, btnStfS, btnSignInS, btnRegisterS; //stf log btnsignins -- open form
    private JTextField txtAccNoS; 
    private JPasswordField txtPinS;
    
    private JLabel usrUandP, usrUandPs;

    LoginUI(){

        setTitle("VaultBank Login");
        setSize(1440,960);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setResizable(false);
        
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
        
        background.setBounds(0, 0, 1440, 960);
        
        
        loginSwitch = new CardLayout();
        loginContainer = new JPanel(loginSwitch);

        loginCus = new JPanel(null);
        loginStf = new JPanel(null);
        
        
        loginContainer.add(loginCus,"customer");
        loginContainer.add(loginStf,"staff");

        // for Customer panel

        btnCus = new JButton("Customer");
        btnCus.setBounds(45,40,175,30);
        btnCus.setBackground(cs.btnColorSelect);
        btnCus.setForeground(cs.white);
        btnCus.setBorderPainted(false);

        btnStf = new JButton("Staff");
        btnStf.setBounds(220,40,175,30);
        btnStf.setBackground(cs.btnColorUnselect);
        btnStf.setForeground(cs.gray);
        btnStf.setBorderPainted(false);

        JLabel lblAcc = new JLabel("Email");
        lblAcc.setBounds(45,100,200,30);
        lblAcc.setForeground(cs.gray);
        txtAccNo = new JTextField();
        txtAccNo.setBounds(45,130,350,35);

        JLabel lblPin = new JLabel("Password");
        lblPin.setBounds(45,180,200,30);
        lblPin.setForeground(cs.gray);
        txtPin = new JPasswordField("1234");
        txtPin.setBounds(45,210,350,35);

        btnSignIn = new JButton("Sign In");
        btnSignIn.setBackground(cs.btnColorSelect);
        btnSignIn.setForeground(cs.white);
        btnSignIn.setFocusPainted(false);
        btnSignIn.setBorderPainted(false);
        btnSignIn.setBounds(45,270,350,30);

        JLabel lblBottom = new JLabel("Don't have an account?");
        lblBottom.setBounds(110,320,200,30);
        lblBottom.setForeground(cs.gray);

        btnRegister = new JButton("Register here");
        btnRegister.setBounds(226,320,120,30);
        btnRegister.setBorderPainted(false);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setForeground(cs.purple);

        usrUandP = new JLabel("Email: 12345 Password: user123"); // para ma access ni sir
        usrUandP.setBounds(130, 350, 200, 30);
        
        loginCus.add(usrUandP);
        loginCus.add(btnCus);
        loginCus.add(btnStf);
        loginCus.add(lblAcc);
        loginCus.add(txtAccNo);
        loginCus.add(lblPin);
        loginCus.add(txtPin);
        loginCus.add(btnSignIn);
        loginCus.add(lblBottom);
        loginCus.add(btnRegister);

        // for CUS panel
        btnCusS = new JButton("Customer");
        btnCusS.setBounds(45,40,175,30);
        btnCusS.setBorderPainted(false);
        btnCusS.setBackground(cs.btnColorUnselect);
        btnCusS.setForeground(cs.gray);
        btnCusS.setFocusPainted(false);
        
        // for staff panel
        btnStfS = new JButton("Staff");
        btnStfS.setBounds(220,40,175,30);
        btnStfS.setBorderPainted(false);
        btnStfS.setBackground(cs.btnColorSelect);
        btnStfS.setForeground(cs.white);
        
        JLabel lblAccS = new JLabel("Account Name");
        lblAccS.setBounds(45, 100, 200, 30);
        lblAccS.setForeground(cs.gray);
        txtAccNoS = new JTextField();
        txtAccNoS.setBounds(45, 130, 350, 35);

        JLabel lblPinS = new JLabel("Password");
        lblPinS.setBounds(45, 180, 200, 30);
        lblPinS.setForeground(cs.gray);
        txtPinS = new JPasswordField("1234");
        txtPinS.setBounds(45, 210, 350, 35);

        btnSignInS = new JButton("Sign In");
        btnSignInS.setBackground(cs.btnColorSelect);
        btnSignInS.setForeground(cs.white);
        btnSignInS.setFocusPainted(false);
        btnSignInS.setBorderPainted(false);
        btnSignInS.setBounds(45,270,350,30);

        JLabel lblBottomS = new JLabel("Don't have an account?");
        lblBottomS.setBounds(110,320,200,30);
        lblBottomS.setForeground(cs.gray);

        btnRegisterS = new JButton("Register here");
        btnRegisterS.setBounds(226,320,120,30);
        btnRegisterS.setBorderPainted(false);
        btnRegisterS.setContentAreaFilled(false);
        btnRegisterS.setForeground(cs.purple);
        
        usrUandPs = new JLabel("Account: admin Password: admin123"); // para ma access ni sir
        usrUandPs.setBounds(115, 350, 250, 30);
        
        loginStf.add(usrUandPs);
        
        
        loginStf.setBackground(cs.white); // bg color white
        loginCus.setBackground(cs.white);
        
        loginStf.add(btnCusS);
        loginStf.add(btnStfS);
        loginStf.add(lblAccS);
        loginStf.add(txtAccNoS);
        loginStf.add(lblPinS);
        loginStf.add(txtPinS);
        loginStf.add(btnSignInS);
        loginStf.add(lblBottomS);
        loginStf.add(btnRegisterS);
        loginContainer.setBounds(500,250,445,400);
        add(loginContainer);

        btnStf.addActionListener(this);
        btnCusS.addActionListener(this);
        btnRegister.addActionListener(this);
        btnRegisterS.addActionListener(this);
        btnSignIn.addActionListener(this);
        btnSignInS.addActionListener(this);
        
        add(background);
        
    }

   @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==btnStf){
            loginSwitch.show(loginContainer,"staff");
        }

        else if(e.getSource()==btnCusS){
            btnStf.setBackground(cs.btnColorUnselect);
            loginSwitch.show(loginContainer,"customer");
        }
        //for CUS access
        else if (e.getSource() == btnSignIn) {
            String accNo = txtAccNo.getText().trim();
            String pin = new String(txtPin.getPassword()).trim();

            //Pass ng CUS
            if (accNo.equals("12345") && pin.equals("user123")) {
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome, Customer.");
                CustomerDashboard dash = new CustomerDashboard(); 
                dash.setVisible(true);
             dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Customer Account or PIN.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        //for STF
        else if (e.getSource() == btnSignInS) {
            String accNo = txtAccNoS.getText().trim();
            String pin = new String(txtPinS.getPassword()).trim();
            System.out.println(accNo+" "+pin);
            //Pass ng STF
            if (accNo.equals("admin") && pin.equals("admin123")) {
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome, Admin.");
                AdminDashboard admin = new AdminDashboard(); 
                admin.setVisible(true);
                dispose(); 
              //where/what? call for admin inter
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Staff Credentials.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == btnRegister || e.getSource() == btnRegisterS) {
            RegisterUI rg = new RegisterUI();
            rg.setVisible(true);
            dispose();
        }
  }
    
    protected void staffRegister(boolean isStaffReg){
        if(isStaffReg){
            loginSwitch.show(loginContainer,"staff");
        }
    }
    
}

//  1.purpleDark = Color(0x5B21B6);
//  2.purple  = Color(0x7C3AED);
//  3.purpleLight = Color(0xA78BFA);

    