import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CaesarBreaker {
    public int[] countLetters (String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for (int k = 0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if (dex != -1) {
                counts[dex] += 1;
            }
        }
        return counts;
    }    
    public int maxIndex (int[] values) {
        int maxDex = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > values[maxDex]) {
                maxDex = i;
            }
        }
        return maxDex;
    }
    public String decrypt (String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        String message = cc.encrypt(encrypted, 26 - dkey);
        return message;
    }
    
    public void testDecrypt () {
        CaesarCipher cc = new CaesarCipher();
        String m1 = cc.encrypt("Cake is a lie.", 3);
        System.out.println("Encrypted: " + m1);
        String m2 = decrypt(m1);
        System.out.println("Decrypted: " + m2);
        String m3 = cc.encrypt("No matter what you may have heard, there is no cake in the conference room.", 23);
        System.out.println("Encrypted: " + m3);
        String m4 = decrypt(m3);
        System.out.println("Decrypted: " + m4);
        String n = "First Legion";
        for (int i = 0; i < n.length(); i++) {
            System.out.println("["+i+"] : " + n.charAt(i)); 
        }
    }
    public String halfOfString (String message, int start) {
        StringBuilder half = new StringBuilder();
        for (int i = start; i < message.length(); i += 2){
                char a = message.charAt(i);
                half.append(a);
        }
        return String.valueOf(half);
    }
    public int getKey (String s) {
        int[] freqs = countLetters(s);
        int key = maxIndex(freqs);
        return key;
    }
    public String decryptTwoKeys (String encrypted) {
        System.out.println("First Key: " + getKey(halfOfString(encrypted, 0)));
        System.out.println("Second Key: " + getKey(halfOfString(encrypted, 1)));
        int firstKey = getKey(halfOfString(encrypted, 0));
        int secondKey  = getKey(halfOfString(encrypted, 1));
        String out = "";
        CaesarCipher cc = new CaesarCipher();
        out = cc.encryptTwoKeys(encrypted, 26 - firstKey, 26 - secondKey);
        return out;
    }
    public String decryptTwoKeys2 (String encrypted) {
        System.out.println("First Key: " + getKey(halfOfString(encrypted, 0)));
        System.out.println("Second Key: " + getKey(halfOfString(encrypted, 1)));
        String first = decrypt(halfOfString(encrypted, 0));
                String second  = decrypt(halfOfString(encrypted, 1));
        System.out.println("First Length: " + first.length());
                System.out.println("Second Length: " + second.length());

        StringBuilder out = new StringBuilder();
 
        for (int i = 0; i < first.length(); i++) {
            if (first.length() > second.length() && i == second.length()) {
                char c = first.charAt(i);
                out.append(c);
            } else {
                char c = first.charAt(i);
                out.append(c);
                c = second.charAt(i);
                out.append(c);
            
            }
        }
        return String.valueOf(out);
    }
    public String decryptTwoKeys3 (String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        String first = halfOfString(encrypted, 0);
        String second = halfOfString(encrypted, 1);
        String out = "";
        
        int keyFirst = getKey(first);
        int keySecond = getKey(second);
        int dkeyFirst = keyFirst - 4;
        int dkeySecond = keySecond - 4;
        
        if (keyFirst < 4) {
            dkeyFirst = 26 - (4 - keyFirst);
        }
        if (keySecond < 4) {
            dkeySecond = 26 - (4 - keySecond);
        }
        System.out.println ("1st Key : " + keyFirst + " dk: " + dkeyFirst); 
        System.out.println ("2nd Key : " + keySecond + " dk: " + dkeySecond); 
        out = cc.encryptTwoKeys(encrypted, 26 - dkeyFirst, 26 - dkeySecond);
        return out;
    }
    public String decryptTwoKeys (String encrypted, int k1, int k2) {
        CaesarCipher cc = new CaesarCipher();
        String first = halfOfString(encrypted, 0);
        String second = halfOfString(encrypted, 1);
        String out = "";
        out = cc.encryptTwoKeys(encrypted, 26 - k1, 26 - k2);
        return out;
    }
    public void testDecryptTwoKeys() {
        String message = "The cake is a lie."; 
        System.out.println("Message: "+ message);
        CaesarCipher cc = new CaesarCipher();
        String enc = cc.encryptTwoKeys(message, 4, 17);
        String message2 = "";
        System.out.println("Encrypted: "+ enc);
        System.out.println(decryptTwoKeys2(enc));
                System.out.println("-----------------");
        System.out.println("Encrypted: "+ enc);
        System.out.println(decryptTwoKeys3(enc));
    }
    public void testBreakCaesarCipher(String file) {
    	Path path = Paths.get(file);
    	String content = "";
        try {
            content = Files.readString(path, StandardCharsets.UTF_8);
            System.out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
  
        String message = content;
        //
        String m2 = "Top ncmy qkff vi vguv vbg ycpx";
        System.out.println("Message: "+ m2);
        System.out.println("Decrypted: " + decryptTwoKeys(m2, 2, 20));
        String m3 = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
        System.out.println("Message: "+ m3);
        System.out.println("Decrypted: " + decryptTwoKeys3(m3));
        System.out.println("-----------------------------");
        //
        System.out.println("Message: "+ message);
        System.out.println("Decrypt: " + decrypt(message));
        
        String to_encrypt = "Geometric computing research at Duke works under the common rationalization of the field of computational geometry, often given in the past, that the world around us is three-dimensional and questions how things in this world relate to each other are inherently geometric.";
        CaesarCipher cc = new CaesarCipher();
        String reverse_encrypt = cc.encryptTwoKeys(to_encrypt, 17, 4); 
        System.out.println("Encrypted: " + reverse_encrypt);
        
    }
    
}
