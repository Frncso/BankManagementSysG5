package BankManage;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class LoginUI extends JFrame  implements ActionListener {
   
    public static void main(String[] args) {
        ///// nag-eensures run sa same thread
        SwingUtilities.invokeLater(() -> {
            LoginUI login = new LoginUI();
            login.setVisible(true);
        });
    }
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

        JLabel lblAcc = new JLabel("Account Number");
        lblAcc.setBounds(45,100,200,30);
        lblAcc.setForeground(cs.gray);

        txtAccNo = new JTextField();
        txtAccNo.setBounds(45,130,350,35);

        JLabel lblPin = new JLabel("PIN");
        lblPin.setBounds(45,180,200,30);

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
        
        // for staff panel
        btnStfS = new JButton("Staff");
        btnStfS.setBounds(220,40,175,30);
        btnStfS.setBorderPainted(false);

        btnSignInS = new JButton("Sign In");
        btnSignInS.setBounds(45,270,350,35);
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
            if (accNo.equals("12345") && pin.equals("1111")) {
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome, Customer.");
                CustomerDashboard dash = new CustomerDashboard(); 
                dash.setVisible(true);
    
             //CLOSE
             dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Customer Account or PIN.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }

        } 
        
        //for STF
        else if (e.getSource() == btnSignInS) {
            String accNo = txtAccNo.getText().trim();
            String pin = new String(txtPin.getPassword()).trim();

            //Pass ng STF
            if (accNo.equals("admin") && pin.equals("admin123")) {
                JOptionPane.showMessageDialog(this, "Login Successful! Welcome, Admin.");
                
              //where/what? call for admin inter
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Staff Credentials.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == btnRegister || e.getSource() == btnRegisterS) {
            RegisterUI rg = new RegisterUI();
            rg.setVisible(true);
            dispose();
        }
  }}

//  1.purpleDark = Color(0x5B21B6);
//  2.purple  = Color(0x7C3AED);
//  3.purpleLight = Color(0xA78BFA);

    