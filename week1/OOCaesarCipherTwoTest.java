
/**
 * Write a description of class OOCaesarCipherTwoTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class OOCaesarCipherTwoTest {
    
    private int[] countLetters(String message){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] counts = new int[26];
        for (int i = 0; i < message.length(); ++i) {
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
    
    private String decrypt(String encrypted, int key){
        CaesarCipher cipher = new CaesarCipher();
        String message = cipher.encrypt(encrypted, 26-key);
        return message;
    }
    
    private String halfOfString(String message, int start){
        String answer = "";   
        for (int i = start; i < message.length() ; i += 2) {
            answer +=  message.charAt(i);    	
        }
        return answer;
    }
    
    private int getKey(String s){
        int[] letterFreqs = countLetters(s);
        int maxindex = maxIndex(letterFreqs);
        int dkey = maxindex - 4;
        if (maxindex < 4) {
            dkey = 26 - (4-maxindex);
        }
        return dkey;
    }
    
    public void breakCaesarCipher(String input){
        String s1 = halfOfString(input, 0);
        String s2 = halfOfString(input, 1);
        int key1 = getKey(s1);
        int key2 = getKey(s2);
        OOCaesarCipherTwo c = new OOCaesarCipherTwo(key1,key2);
        System.out.println("\nEncrypted message:" + input);
        System.out.println("Two keys found: key1= " + key1 + ", key2= " + key2);
        System.out.println("Decrypted message:" + c.decrypt(input));
    }
    
    
  public void simpleTest() {
         FileResource fr = new FileResource();
         String message = fr.asString();
         OOCaesarCipherTwo c = new OOCaesarCipherTwo(17,3);
         String encrypted = c.encrypt(message);
         System.out.println(encrypted);
         System.out.println(c.decrypt(encrypted));
         breakCaesarCipher("Akag tjw Xibhr awoa aoee xakex znxag xwko");
         breakCaesarCipher("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!");
    }

}
