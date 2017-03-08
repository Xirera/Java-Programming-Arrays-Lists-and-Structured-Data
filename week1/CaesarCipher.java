
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarCipher {
    public static void replaceCaseSensetive(char currChar, String alphabet, StringBuilder encrypted, String shiftedAlphabet, int i) {
        if (Character.isLowerCase(currChar)){
                currChar = Character.toUpperCase(currChar);
                int index = alphabet.indexOf(currChar);
                if(index != -1){
                    char newChar = shiftedAlphabet.charAt(index);
                    newChar = Character.toLowerCase(newChar);
                    encrypted.setCharAt(i, newChar);
                }

            }else{
                int index = alphabet.indexOf(currChar);
                if(index != -1){
                    char newChar = shiftedAlphabet.charAt(index);
                    encrypted.setCharAt(i, newChar);
                }
            } 

    }
    
    public static boolean isEven (int n) {
        return (n %2 == 0);
    }
    
    public static String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for(int i = 0; i < encrypted.length(); ++i){
            char currChar = encrypted.charAt(i);              
            replaceCaseSensetive(currChar, alphabet, encrypted, shiftedAlphabet, i);
        }
        return encrypted.toString();
    }
    
    public static String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        for (int i = 0; i < encrypted.length(); ++i) {
            char currChar = encrypted.charAt(i);
            if ( isEven(i) ) {
               replaceCaseSensetive(currChar, alphabet, encrypted, shiftedAlphabet1, i); 
            }
            else {
                replaceCaseSensetive(currChar, alphabet, encrypted, shiftedAlphabet2, i);
            }
        }
        return encrypted.toString();
    } 
}
