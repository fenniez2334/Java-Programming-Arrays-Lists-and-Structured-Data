
/**
 * Write a description of WordLengths here.
 * Figure out the most common word length of words from a file.
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.lang.*;
import edu.duke.*;


public class WordLengths {
    //this method read in the words from resource and count the number of words
    //of each length for all the words in resource,store the counts
    public void countWordLengths(FileResource Resource, int[] counts) { 
  
        for (String word : Resource.words()){
            int Wordlength = word.length();
            for (int i=0; i<word.length();i++){
                char currChar = word.charAt(i);
                if ((i==0) || (i==word.length()-1)){
                    //use Character.isLetter method that returns true if a character is a letter
                    if (!Character.isLetter(currChar)) Wordlength--;
                }
            }  
            counts[Wordlength]++;   
            System.out.println(" Words of length "+ Wordlength +" "+ word);
        }
        
    }
    
    //returns the index position of the largest element in values
    public void indexOfMax(int[] values) {

        int max = 0;
        int position = 0;
            for (int i = 0; i <values.length;i++) 
              {
                  if (values[i] > max) 
                    {
                        max = values[i];
                        position = i;
                    } 
        }
        
        System.out.println("The most common word is :"+ position); 
        
    }
    
    public void testCountWordLengths(){
      FileResource Resource = new FileResource("lotsOfWords.txt");
      int [] counts = new int[31];
      countWordLengths(Resource,counts);     
      indexOfMax(counts);    
    }              
    
}   
    
    
    
    

