package BankManage;

import java.util.Scanner;

/**
 *
 * @author Ezekiel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String fname;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter your First Name: ");
        fname = sc.nextLine();
        
        melvinPrint.melvin(fname);
        
    }
    
}
