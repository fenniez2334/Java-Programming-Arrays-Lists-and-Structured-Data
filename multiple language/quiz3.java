
/**
 * Write a description of quiz3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

public class quiz3 {
    public void main() {
		// Quiz 1: French
		VigenereBreaker v = new VigenereBreaker();
		// 1. read secretmessage3.txt
		// 2. choose all the dictionaries
		v.breakVigenere();
		
		// Quiz 2: La chambre à coucher de Juliette.
		FileResource fr = new FileResource("messages/secretmessage3.txt");
		String message = fr.asString();
		FileResource fr2 = new FileResource("dictionaries/French");
		HashSet<String> dictionary = v.readDictionary(fr2);
		String decrypt = v.breakForLanguage(message, dictionary);
		String [] lines = decrypt.split("\\r?\\n");
		System.out.println("The first line of text is " + lines[0] + "\n");
		
		// Quiz 3: German
		// 1. read secretmessage4.txt
		// 2. choose all the dictionaries
		v.breakVigenere();
		
		// Quiz 4: Drei Hexen treten auf.
		fr = new FileResource("./src/assignment/week4/messages/secretmessage4.txt");
		message = fr.asString();
		fr2 = new FileResource("./src/assignment/week4/dictionaries/German");
		dictionary = v.readDictionary(fr2);
		decrypt = v.breakForLanguage(message, dictionary);
		lines = decrypt.split("\\r?\\n");
		System.out.println("The first line of text is " + lines[0] + "\n");
	}
}
