package BankManage;

import BankManage.AppService.Encryption;
import BankManage.AppService.Hashing;
import java.security.NoSuchAlgorithmException;

public class Main{

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Encryption en = new Encryption();
        Hashing hash = new Hashing();
        
        // open login
        
        LoginUI log = new LoginUI();
        log.setVisible(true);
        
        // HASHING AND ENCRYPTION TESTS
        
        String testingmuch = "coo";
        String passwordTest = "incredipass";
        String exampledatabase = "eaf5ac3f539fe326cfd095e6fe527f2c3c76ef14657dc943ed946700e9d01208";
        
        System.out.println("SHA-256: "+hash.hashString(passwordTest));
        
        if(hash.hashString(passwordTest).equals(exampledatabase)){
            System.out.println("Nice one!");
        }
        else{
            System.out.println("You're out bro");
        }
        
        try{
            String encrypted = en.encrypt(testingmuch);
            String decrypted = en.decrypt(encrypted);

            System.out.println("Plain Text: " + testingmuch);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        }
        catch(Exception e){
            System.out.println("An Exception Occured: "+ e);
        }
        
        // END OF HASHING AND ENCRYPTION TESTS
        

    }
    
}
