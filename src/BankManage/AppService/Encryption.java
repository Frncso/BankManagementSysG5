package BankManage.AppService;

// code from https://youtu.be/wD-hic1Up64

import java.util.ArrayList;
import java.util.List;

public class Encryption {
    
    private final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=" + " ";
    private final String superkey = "!D3C0DEM3!";
    
    public Encryption() {}
    
    private List<Integer> getCharPositions(String str){

        List<Integer> charsAtPos = new ArrayList<Integer>();
        
        for(int i = 0; i < str.length(); i++){
            
            int index = chars.indexOf(str.charAt(i));
            
            if(index == -1){
                throw new IllegalArgumentException(
                    "Unsupported character: '" + str.charAt(i) + "' at position " + i
                );
            }
            
            charsAtPos.add(index);
            
        }
        
        return charsAtPos;
    }
    
    public String encrypt(String text){
        
        List<Integer> textCharAtPos = getCharPositions(text);
        List<Integer> keyCharAtPos = getCharPositions(superkey);
        
        int textLength = text.length();
        int keyLength = superkey.length();
        
        String cipher = "";
        int letter;
        
        for(int i = 0; i < textLength; i++){
            letter = (textCharAtPos.get(i) + keyCharAtPos.get(i % keyLength));
            letter %= chars.length();
            cipher += chars.charAt(letter);
        }
        
        return cipher;
    }
    
    public String decrypt(String cipher){
        
        List<Integer> cipherCharAtPos = getCharPositions(cipher);
        List<Integer> keyCharAtPos = getCharPositions(superkey); 
        
        int cipherLength = cipher.length();
        int keyLength = superkey.length();
        
        String plain = "";
        int letter;
        
        for(int i = 0; i < cipherLength; i++){
            letter = (cipherCharAtPos.get(i) - keyCharAtPos.get(i % keyLength));
            letter += chars.length();
            letter %= chars.length();
            plain += chars.charAt(letter);
        }
        
        return plain;
    }
    
}
