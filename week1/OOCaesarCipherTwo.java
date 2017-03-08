
/**
 * Write a description of class OOCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OOCaesarCipherTwo {
    private static String alphabet; 
    private static String shiftedAlphabet1;
    private static String shiftedAlphabet2; 
    private int mainKey1;
    private int mainKey2;
    
    public OOCaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
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
    
    public static boolean isEven (int n) {
        return (n %2 == 0);
    }
        
    public static String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
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

    public String decrypt(String input) {
        OOCaesarCipherTwo cipher = new OOCaesarCipherTwo(26-mainKey1, 26-mainKey2);
        return cipher.encrypt(input);
    }
}
