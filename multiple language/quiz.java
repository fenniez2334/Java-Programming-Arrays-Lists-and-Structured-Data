
/**
 * Write a description of quiz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.HashSet;

import edu.duke.FileResource;


public class quiz {
    public void main() {
		// Quiz 1
		VigenereBreaker v = new VigenereBreaker();
		FileResource fr = new FileResource("messages/secretmessage2.txt");
		String message = fr.asString();
		FileResource fr2 = new FileResource("dictionaries/English");
		HashSet<String> dictionary = v.readDictionary(fr2);
		String decrypt = v.breakForLanguage(message, dictionary);
		
		// Quiz 2
		int count = v.countWords(decrypt, dictionary);
		System.out.println(count + " valid words are in the decrypted String.");
		
		// Quiz 3
		String [] lines = decrypt.split("\\r?\\n");
		System.out.println("The first line of text is " + lines[0]);
		
		// Quiz 4
		int [] key = v.tryKeyLength(message, 38, 'e');
		VigenereCipher vc = new VigenereCipher(key);
    	decrypt = vc.decrypt(message);
    	count = v.countWords(decrypt, dictionary);
    	System.out.println(count + " valid words are in the decrypted String.");
    	
	}
}
