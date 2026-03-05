/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
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
        
        if(fname.equalsIgnoreCase("melvin")){
            System.out.println("langkiwa");
        }
        else{
            System.out.println("Hello, "+fname+"!");
        }
    }
    
}
