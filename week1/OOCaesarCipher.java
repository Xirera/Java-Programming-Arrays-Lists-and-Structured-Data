
/**
 * Write a description of class OOCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class OOCaesarCipher {
    private static String alphabet;
    private static String shiftedAlphabet;
    private static int mainKey; 
    public OOCaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
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
    
    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length(); ++i){
            char currChar = encrypted.charAt(i);              
            replaceCaseSensetive(currChar, alphabet, encrypted, shiftedAlphabet, i);
        }
        return encrypted.toString();
    }
    
   public static String decrypt(String encrypted) {
        OOCaesarCipher cipher = new OOCaesarCipher(26 - mainKey);
        return cipher.encrypt(encrypted);
    }
}

