package BankManage;

import BankManage.AppService.Encryption;

public class Main {

    Encryption en = new Encryption();
    
    String testingmuch = "coolguy123";
    String encrypted = en.encrypt(testingmuch);
    String decrypted = en.decrypt(testingmuch);
    
    public static void main(String[] args) {
        // for testing purposes
        
        // open register form
        RegisterUI reg = new RegisterUI();
        reg.setVisible(true);

    }
    
}
