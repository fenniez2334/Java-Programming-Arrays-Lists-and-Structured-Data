
/**
 * Write a description of Wordplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wordplay {
     /** Write a method isVowel that has one Char parameter named ch. This method
     *  returns true if ch is a vowel (one of 'a', 'e', 'i', 'o', or 'u' or the
     *  uppercase versions) and false otherwise. You should write a tester method
     *  to see if this method works correctly. For example, isVowel(‘F’) should
     *  return false, and isVowel(‘a’) should return true.
     *
     * @param ch    any character
     * @return true if `ch` is a vowel
     */
     public boolean isVowel(char ch){
         if (ch == 'a' || ch =='e' || ch =='i' || ch =='o'|| ch =='u' || ch == 'y'){   
             return true; 
         }
         else if (ch == 'A' || ch =='E' || ch =='I' || ch =='O'|| ch =='U' || ch =='Y'){
             return true;
         }
         else{
             return false; 
         }
     }
     
     public String replaceVowels(String phrase, char ch){
         StringBuilder original=new StringBuilder(phrase);
          //String replace = phrase;
          //char [] char2 = phrase.toCharArray();
         for (int i=0; i < original.length(); i++){
             char currChar=original.charAt(i);
              //int idx = phrase.indexOf(currChar);
             if (isVowel(currChar)){
                 original.setCharAt(i,ch);   
             }
             /*else {
                original.setCharAt(idx, currChar);
             }
             */ 
         }
         return original.toString();
     }
     
     public String emphasize(String phrase, char ch){
         StringBuilder emphasize= new StringBuilder(phrase);
         // Look at the ith character of original
         for (int i = 0; i < emphasize.length();i++) {
             char currChar= emphasize.charAt(i);
             if ((currChar == ch) && (i %2 == 0)){
                 emphasize.setCharAt(i,'*');   
             }
             else if ((currChar == ch) && (i %2 !=0)){
                 emphasize.setCharAt(i,'+');   
             }
         }
         return emphasize.toString();
     }
     
     public void WordPlay(){
         System.out.println("return value"+ " " + isVowel('F'));
         System.out.println("return value"+ " " + isVowel('a'));
         System.out.println("replace Vowels"+ " " + replaceVowels("Hello World",'*'));
         System.out.println("emphasize example1"+ " " + emphasize("dna ctgaaactga",'a'));
         System.out.println("emphasize example2"+ " " + emphasize("Mary Bella Abracadabra",'a'));   
     }
     
     /*public void testreplaceVowels () {
        StringBuilder original = new StringBuilder("Hello World");
        StringBuilder result = replaceVowels(original,'*');
        System.out.println(result);
     }
     */
}
