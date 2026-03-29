package BankManage;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class LoginUI extends JFrame implements ActionListener {
   
    ColorScheme cs = new ColorScheme();

    private CardLayout loginSwitch;
    private JPanel loginContainer, loginCus, loginStf;

    private JButton btnCus, btnStf, btnSignIn, btnRegister; //cus log
    private JButton btnCusS, btnStfS, btnSignInS, btnRegisterS; //stf log btnsignins -- open form

    private JTextField txtAccNo;
    private JPasswordField txtPin;

    LoginUI(){

        setTitle("Banking System Login ");
        setSize(1440,960);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container c = getContentPane();
        c.setBackground(cs.bgColor);

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
//        btnStf.setForeground(cs.);
//        btnStf.setBorderPainted(false);

        JLabel lblAcc = new JLabel("Account Number");
        lblAcc.setBounds(45,100,200,30);
        lblAcc.setForeground(cs.gray);

        txtAccNo = new JTextField();
        txtAccNo.setBounds(45,130,350,35);

        JLabel lblPin = new JLabel("PIN");
        lblPin.setBounds(45,180,200,30);
//        lblPin.setForeground(cs.);

        txtPin = new JPasswordField("1234");
        txtPin.setBounds(45,210,350,35);

        btnSignIn = new JButton("Sign In");
        btnSignIn.setBounds(45,270,350,35);
//        btnSignIn.setBackground(cs.btnColorSelect);
//        btnSignIn.setForeground(cs.);
//      btnSignIn.setBorderPainted(false);

        JLabel lblBottom = new JLabel("Don't have an account?");
        lblBottom.setBounds(120,320,200,30);
//        lblBottom.setForeground(cs.gray);

        btnRegister = new JButton("Register here");
        btnRegister.setBounds(240,320,120,30);
        btnRegister.setBorderPainted(false);
        btnRegister.setContentAreaFilled(false);
//        btnRegister.setForeground(cs.bgColor);

        loginCus.add(btnCus);
        loginCus.add(btnStf);
        loginCus.add(lblAcc);
        loginCus.add(txtAccNo);
        loginCus.add(lblPin);
        loginCus.add(txtPin);
        loginCus.add(btnSignIn);
        loginCus.add(lblBottom);
        loginCus.add(btnRegister);

//        loginCus.setBackground(cs.);

        // for cus panel
        btnCusS = new JButton("Customer");
        btnCusS.setBounds(45,40,175,30);
//        btnCusS.setBackground(cs.btnColorUnselect);
//        btnCusS.setForeground(cs.);
        btnCusS.setBorderPainted(false);
        
        // for staff panel
        btnStfS = new JButton("Staff");
        btnStfS.setBounds(220,40,175,30);
//        btnStfS.setBackground(cs.btnColorSelect);
//        btnStfS.setForeground(cs.);
        btnStfS.setBorderPainted(false);

        btnSignInS = new JButton("Sign In");
        btnSignInS.setBounds(45,270,350,35);
//        btnSignInS.setBackground(cs.btnColorSelect);
//        btnSignInS.setForeground(cs.);
        btnSignInS.setBorderPainted(false);

        JLabel lblBottomS = new JLabel("Don't have an account?");
        lblBottomS.setBounds(120,320,200,30);
        lblBottomS.setForeground(cs.gray);

        btnRegisterS = new JButton("Register here");
        btnRegisterS.setBounds(240,320,120,30);
        btnRegisterS.setBorderPainted(false);
        btnRegisterS.setContentAreaFilled(false);
        btnRegisterS.setForeground(cs.bgColor);

        loginStf.add(btnCusS);
        loginStf.add(btnStfS);
        loginStf.add(btnSignInS);
        loginStf.add(lblBottomS);
        loginStf.add(btnRegisterS);

//        loginStf.setBackground(cs.);

        loginContainer.setBounds(500,250,445,400);
        add(loginContainer);

        btnStf.addActionListener(this);
        btnCusS.addActionListener(this);
        btnRegister.addActionListener(this);
        btnRegisterS.addActionListener(this);
        btnSignIn.addActionListener(this);
        btnSignInS.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==btnStf){

//            btnStf.setBackground(cs.btnColorSelect);
//            btnStf.setForeground(cs.);
//
//            btnCus.setBackground(cs.btnColorUnselect);
//            btnCus.setForeground(cs.);

            loginSwitch.show(loginContainer,"staff");
        }

        else if(e.getSource()==btnCusS){

//            btnCus.setBackground(cs.btnColorSelect);
//            btnCus.setForeground(cs.);

            btnStf.setBackground(cs.btnColorUnselect);
//            btnStf.setForeground(cs.);

            loginSwitch.show(loginContainer,"customer");
        }

        else if (e.getSource() == btnSignIn) {
             String accNo = txtAccNo.getText().trim();
            String pin = new String(txtPin.getPassword()).trim();

            if (accNo.isEmpty() || pin.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please enter your Account Number and PIN.",
                    "Login Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // validate Cus
            JOptionPane.showMessageDialog(this, "Customer login not yet implemented.");

        } else if (e.getSource() == btnSignInS) {

            String accNo = txtAccNo.getText().trim();
            String pin = new String(txtPin.getPassword()).trim();

            if (accNo.isEmpty() || pin.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "Please enter your Account Number and PIN.",
                    "Login Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            //validate stf 
            JOptionPane.showMessageDialog(this, "Login for staff not yet implemented.");

        } else if (e.getSource() == btnRegister || e.getSource() == btnRegisterS) {

            RegisterUI rg = new RegisterUI();
            rg.setVisible(true);
            dispose();
     }
  }}

//NOTE: may possible changes pa 
//  1.purpleDark = Color(0x5B21B6);
//  2.purple  = Color(0x7C3AED);
//  3.purpleLight = Color(0xA78BFA);

    