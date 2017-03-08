
/**
 * Write a description of class CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;

public class CaesarBreaker {
    public static int[] countLetters(String input) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int counts[] = new int[26];
        for (int i = 0; i < input.length(); ++i) {
            char ch = Character.toUpperCase(input.charAt(i));
            int index = alphabet.indexOf(ch);
            if (index != -1) {
                counts[index]++;
            }
        }
        return counts;
    }
    
    public static int maxIndex(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }
    
    public static String decrypt(String encrypted, int key) {
        CaesarCipher cipher = new CaesarCipher();
        return cipher.encrypt(encrypted, 26 - key);
    }
    
     public static String halfString(String input, int start){
        String answer = "";   
        for (int i = start; i < input.length() ; i += 2) {
            answer += input.charAt(i);    	
        }
        return answer;
    }
    
   public static int getKey(String s) {
        int [] freqs = countLetters(s);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex-4;
        if (dkey < 0) { 
            dkey = 26 - (4 - maxDex);
        }
        return dkey;
    }
    
   public  static String decryptTwoKeys(String encrypted){
         String s1 = halfString(encrypted, 0);
         String s2 = halfString(encrypted, 1);
         int key1 = getKey(s1);
         int key2 = getKey(s2);
         CaesarCipher cipher = new CaesarCipher();
         return cipher.encryptTwoKeys(encrypted, 26-key1, 26-key2);
    }

}
