package BankManage;

import java.security.NoSuchAlgorithmException;

public class Main{

    public static void main(String[] args) throws NoSuchAlgorithmException {

        // initialize idgen check for increments
        
        //IdGenerator.initialize();
        
        // open login
        
        LoginUI log = new LoginUI();
        log.setVisible(true);
        

    }
    
}
