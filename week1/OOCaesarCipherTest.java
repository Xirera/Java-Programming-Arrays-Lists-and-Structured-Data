
/**
 * Write a description of class OOCaesarCipherTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class OOCaesarCipherTest {
    
      private int[] countLetters(String message){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] counts = new int[26];
        for (int i = 0; i <message.length(); ++i) {
            char ch = Character.toUpperCase(message.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                counts[index]++;
            }
        }
        return counts;
    }    
    
    private int maxIndex(int[] values){
        int max = 0;
        for(int i = 0; i < values.length; ++i){
            if(values[i] > values[max]){
                max = i;
            }  
        }    
        return max;
    }
    
    public void breakCaesarCipher(String input){
        int[] letterFreqs = countLetters(input);
        int maxindex = maxIndex(letterFreqs);
        int dkey = maxindex - 4;
        if (maxindex < 4) {
            dkey = 26 - (4-maxindex);
        }
        OOCaesarCipher c = new OOCaesarCipher(dkey);
        System.out.println("Encrypted message:\n" + input);
        System.out.println("key:" + dkey);
        System.out.println("Decrypted message:\n" + c.decrypt(input));
    }
    
    public void simpleTests(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        OOCaesarCipher c = new OOCaesarCipher(18);
        String encrypted = c.encrypt(message);
        System.out.println(encrypted);
        System.out.println(c.decrypt(encrypted));
        breakCaesarCipher("XJWW USCW AF LZW UGFXWJWFUW JGGE!");
        
    }

}
