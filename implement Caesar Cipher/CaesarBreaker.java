
/**
 * Write a description of CaesarBreaker here.
 * You should start by writing the decryption method explained in the
 * lesson that decrypts a message that was encrypted with one Key, using 
 * statistical letter frequencies of English text. Then you will add code 
 * to be able to decrypt a message that was encrypted with two Keys, using
 * ideas from the Single key decryption method and the encryption with two
 * keys method from the program you wrote in the last course.
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import java.io.*;
import java.lang.*;

public class CaesarBreaker {
    public int[] CountLetters(String message) {
         String alph = "abcdefghijklmnopqrstuvwxyz";
         int[] counts = new int[26];
         for(int k=0; k < message.length();k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex!=-1) {
                counts[dex]++;
            }

            }
        return counts;
    }
    //maxIndex
    public int maxIndex(int[] values) {
        
        int max = 0;
        int indexOfMax = 0;
        for(int k = 0;k<values.length;k++) {
            if (values[k]> max) {
               max = values[k];
               indexOfMax = k;
            }
        
        }
        //System.out.println("The Array maxIndex is :"+ indexOfMax);
        return indexOfMax; 
    }
    
    public String decrypt(String encrypted, int Key) {
       CaesarCipher cc = new CaesarCipher();
       String decrypted = cc.encrypt(encrypted, 26 - Key);
       return decrypted;
    
    }
    
    public String decryptTwoKeys(String encrypted){
        
       CaesarCipher cc = new CaesarCipher();
       String message1 = halfOfString(encrypted,0);
       String message2 = halfOfString(encrypted,1);
       
       int key1= getKey(message1);
       int key2= getKey(message2);
       
       //String encrypt_message1=cc.encrypt(message1,(26-key1));
       //String encrypt_message2=cc.encrypt(message2,(26-key2));
       
       //build up the final answer
       String decrypt_two = "";
       decrypt_two=cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
           
       System.out.println("The first key is "+key1+"\n"+"The second Key is: "+ key2); 
       System.out.println("The message decrypted with two keys :"+"\n" + decrypt_two.toString());
       return decrypt_two.toString();    
    
    
    }
    
    public String halfOfString(String message, int start){
        String result = new String();
        for (int k = start; k< message.length();k = k+2) {
          result = result + message.charAt(k);
        }
        return result;
    }
    
    public int getKey(String s) {
       int[] freqs = CountLetters(s);
       int maxDex = maxIndex(freqs);
       int dKey = maxDex - 4;
       if (maxDex < 4) {
           dKey = 26 - (4 -maxDex);
       }
       return dKey;
        
    }
    
    public void halfOfStringTest() {
        
       FileResource resource = new FileResource("data/wordsLotsOfEs.txt");
       String message = resource.asString();
       //System.out.println(message);
       System.out.println("half of String starts with 0"+ halfOfString(message, 0));
       System.out.println("half of String starts with 1"+ halfOfString(message, 1));
       
       CaesarCipher cc = new CaesarCipher();
       String encrypted = cc.encrypt(halfOfString(message, 0), 20);
       String decrypted = decrypt(encrypted,26 - 20);
       System.out.println(encrypted);
       System.out.println(decrypted);
    
    }
    
    public void testDecrypt() {
        int key = 23;
        FileResource fr = new FileResource("wordsLotsOfEs.txt");
        String message = fr.asString();
        CaesarCipher cc = new CaesarCipher();
        String decrypted = cc.encrypt(message, 26 - key);
        System.out.println("Key is"+ key+"\n"+decrypted);
    
    }
    
    public void decryptTwoKeysTest() {
        
       FileResource resource = new FileResource("mysteryTwoKeysPractice.txt");
       String message = resource.asString();
       
       //String message = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
       String decrypted_message = decryptTwoKeys(message); 
       System.out.println(message);
       System.out.println(decrypted_message);
    }
    
     public String encryptTwoKeys(String input, int key1, int key2) {
        // Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder (input);
        // Write down the alphabet 
        String Alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        // Compute the shifted alphabet
        String ShiftedAlphabet1 = Alphabet.substring(key1)+ Alphabet.substring(0,key1);
        String shiftedAlphabet1 = alphabet.substring(key1)+ alphabet.substring(0,key1);
        String ShiftedAlphabet2 = Alphabet.substring(key2)+ Alphabet.substring(0,key2);
        String shiftedAlphabet2 = alphabet.substring(key2)+ alphabet.substring(0,key2);
        
        // Count from 0 to < length of encrypted,(call it i)
        for (int i = 0; i <encrypted.length();i+=2){
            // Look at the ith character of encrypted ( call it currchar)
            char currChar = encrypted.charAt(i);
            if ((i %2 == 0) && (Character.isLowerCase(currChar))) {
                // Find the index of currChar in the alphabet (call it idx)
                int idx = alphabet.indexOf(currChar);
                // If currChar is in the alphabet
                if (idx!= 0)
                {
                   // Get the idxth character of shiftedAlphabet (newChar)
                   char newChar = shiftedAlphabet1.charAt(idx);
                   // Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i,newChar);
                }
            }
        
            else if ((i %2 == 0) && (Character.isUpperCase(currChar)))
            {
                // Find the index of currChar in the alphabet (call it idx)
                int idx = Alphabet.indexOf(currChar);
                // If currChar is in the alphabet
                if (idx != 0)
                {
                    // Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = ShiftedAlphabet1.charAt(idx);
                    // Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i,newChar);
                }
            }
        
        }
    
       for (int i = 1; i <encrypted.length();i+=2){
            // Look at the ith character of encrypted ( call it currchar)
            char currChar = encrypted.charAt(i);
            if ((i %2 != 0) && (Character.isLowerCase(currChar)))
            {
                // Find the index of currChar in the alphabet (call it idx)
                int idx = alphabet.indexOf(currChar);
                // If currChar is in the alphabet
                if (idx != 0)
                {
                    // Get the idxth character of shiftedAlphabet (newChar)
                    char newChar = shiftedAlphabet2.charAt(idx);
                    // Replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i,newChar);
                }
            }
        
            else if ((i %2 != 0) && (Character.isUpperCase(currChar))) {
               // Find the index of currChar in the alphabet (call it idx)
               int idx = Alphabet.indexOf(currChar);
               // If currChar is in the alphabet
               if (idx != 0)
                {
                  // Get the idxth character of shiftedAlphabet (newChar)
                  char newChar = ShiftedAlphabet2.charAt(idx);
                  // Replace the ith character of encrypted with newChar
                  encrypted.setCharAt(i,newChar);
                }
            }
                
        } 
    
       return encrypted.toString();
 
   } 
   
    public void decipher(){
        int key1=2;
        int key2=20;
        String encrypted1 = "Top ncmy qkff vi vguv vbg ycpx";        
        String decrypted = encryptTwoKeys(encrypted1, 26-key1, 26-key2);
        System.out.println(decrypted);
    }
}
