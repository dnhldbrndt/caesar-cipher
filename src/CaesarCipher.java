
public class CaesarCipher {
    public String encrypt (String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet_a = alphabet.toLowerCase();
        String shiftedAlphabet = alphabet.substring(key) + alphabet;
        String shiftedAlphabet_a = shiftedAlphabet.toLowerCase();
        
        for (int i = 0; i < encrypted.length(); i++) {
            char currChar = encrypted.charAt(i);
            int idx = currChar == Character.toUpperCase(currChar) ? alphabet.indexOf(currChar) : alphabet_a.indexOf(currChar);
            if (idx != -1) {
                char newChar = currChar == Character.toUpperCase(currChar) ? shiftedAlphabet.charAt(idx) : shiftedAlphabet_a.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        
        return encrypted.toString();
    }
    public String encryptTwoKeys (String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet_a = alphabet.toLowerCase();
        String shiftedAlphabetK1 = alphabet.substring(key1) + alphabet;
        String shiftedAlphabetK1_a = shiftedAlphabetK1.toLowerCase();
        String shiftedAlphabetK2 = alphabet.substring(key2) + alphabet;
        String shiftedAlphabetK2_a = shiftedAlphabetK2.toLowerCase();
        
        for (int i = 0; i < encrypted.length(); i++) {
            if (i % 2 == 0) {
                char currChar = encrypted.charAt(i);
                int idx = currChar == Character.toUpperCase(currChar) ? alphabet.indexOf(currChar) : alphabet_a.indexOf(currChar);
                if (idx != -1) {
                    char newChar = currChar == Character.toUpperCase(currChar) ? shiftedAlphabetK1.charAt(idx) : shiftedAlphabetK1_a.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            } else {
                char currChar = encrypted.charAt(i);
                int idx = currChar == Character.toUpperCase(currChar) ? alphabet.indexOf(currChar) : alphabet_a.indexOf(currChar);
                if (idx != -1) {
                    char newChar = currChar == Character.toUpperCase(currChar) ? shiftedAlphabetK2.charAt(idx) : shiftedAlphabetK2_a.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
            }
        }
        
        return encrypted.toString();
    }
    public String encryptTwoKeys2 (String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet_a = alphabet.toLowerCase();
        String shiftedAlphabetK1 = alphabet.substring(key1) + alphabet;
        String shiftedAlphabetK1_a = shiftedAlphabetK1.toLowerCase();
        String shiftedAlphabetK2 = alphabet.substring(key2) + alphabet;
        String shiftedAlphabetK2_a = shiftedAlphabetK2.toLowerCase();
        
        for (int i = 0; i < encrypted.length(); i++) {
            
                char currChar = encrypted.charAt(i);
                int idx = currChar == Character.toUpperCase(currChar) ? alphabet.indexOf(currChar) : alphabet_a.indexOf(currChar);
                if (idx != -1) {
                    char newChar;
                    if (i % 2 == 0) {
                         newChar = currChar == Character.toUpperCase(currChar) ? shiftedAlphabetK1.charAt(idx) : shiftedAlphabetK1_a.charAt(idx);
                        
                    } else {
                         newChar = currChar == Character.toUpperCase(currChar) ? shiftedAlphabetK2.charAt(idx) : shiftedAlphabetK2_a.charAt(idx);
                        
                    }
                    encrypted.setCharAt(i, newChar);
                }

        }
        
        return encrypted.toString();
    }
    public void testCaesar() {
        String message = "FIRST LEGION ATTACK EAST FLANK!"; 
        int key = 23;
        System.out.println(message);
        System.out.println("Encrypted: " + encrypt(message, key));
        String message2 = "Single White Female";
        String encrypted = encrypt(message2, key);
        System.out.println("key is " + key + "\n" + encrypted);
        String encrypted2 = encryptTwoKeys("First Legion", 23, 17);
        System.out.println("key is 23 "+ " key2 is 17 " + "\n" + encrypted2);
        String encrypted3 = encryptTwoKeys2("First Legion", 23, 17);
        System.out.println("key is " + key + "\n" + encrypted3);

        String msg = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        System.out.println(msg);
        String encrypted4 = encrypt(msg, 15);
        System.out.println(encrypted4);
        String message_new = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        System.out.println(message_new);
        String encrypted5 = encryptTwoKeys(message_new, 8, 21);
        System.out.println(encrypted5);
    }
}
