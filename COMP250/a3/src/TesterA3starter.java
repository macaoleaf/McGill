package Users.zisheng.GitHub.McGill_COMP250.a3.out.production.a3;

//  COMP 250 - Introduction to Computer Science - Fall 2017
//  Assignment #3 - Question 1

import java.io.*;
import java.util.*;

// Performs lookups and word completion using the WordTree class. 
// Also provides method to read from a file.

public class TesterA3starter
{
	public static ArrayList<String> readWordsFromFile(String filename)
	{
		ArrayList<String> words = new ArrayList<String>();
		try
		{
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			
			/* Strip non-alphanumeric \\W  characters
			 * That is,  remove any characters other than a to z,  A to Z, and 0 to 9
			 * 
			 * See https://regexone.com/lesson/character_ranges
			 * which lists the '\W' symbol in the right panel as any non alphanumeric character
			 * and lists the '+' symbols as meaning any non-zero number of repetitions  
			 */
			scanner.useDelimiter("\\W+");
			
			while (scanner.hasNext())
			{
				words.add(scanner.next());
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		}
		return words;
	}

	public static void main(String[] args)
	{	   
		ArrayList<String> list = new ArrayList<String>();

/*    
 *    You can test your code with the input file below.
 *	  For example, if you wish to share your outputs on the discussion board 
 *    that you obtained using the given text file, that's fine. 
 *		
 *	  You will need to put a different pathname in here.
 */ 		
 	//	String fileName = "C:\\Users\\Michael\\Dropbox\\Eclipse (Yoga)\\250\\src\\assignments2017\\a3\\bodybuilding.txt";
    //	list = readWordsFromFile(fileName);
 
 	// String fileName = "//home//ramchalamkr//bodybuilding.txt";
	// list = readWordsFromFile(fileName);

    //    For debugging, we suggest you use a smaller set of words such as the ones shown in the PDF.      
		
		Collections.addAll(list, "a", "and", "ax", "dog", "door", "dot");

		WordTree   WordTree = new WordTree();
		WordTree.loadWords(list);

		System.out.println("list contains " + list.size() + " words");

		// Test if the contains() method works, print input and output
		//
		//  e.g.: try door, an, cat (should return true, false, and false respectively)

		System.out.println();
		System.out.println("---  Test contains() method.   Correct answer shown in brackets. -----" );
		System.out.println("WordTree contains 'door' = " + WordTree.contains("door") + " (true)" );
		System.out.println("WordTree contains 'and' = " + WordTree.contains("and")   + " (true)");
		System.out.println("WordTree contains 'cat' = " + WordTree.contains("cat")   + " (false)");
		System.out.println("WordTree contains 'dog' = " + WordTree.contains("dog")   + " (true)");
		System.out.println("WordTree contains 'ax' = " + WordTree.contains("ax")     + " (true)");
		System.out.println("WordTree contains 'dot' = " + WordTree.contains("dot")   + " (true)");
		System.out.println("WordTree contains 'a' = " + WordTree.contains("a")       + " (true)");
		System.out.println("WordTree contains 'an' = " + WordTree.contains("an")     + " (false)");      

		/*  Test if getPrefix works, print input and output
		 *    ex: "door", "any", "cat" should return "door", "an", and "" respectively
		 *    
		 */    
		
		System.out.println("");
		System.out.println("-----  Test getPrefix()");		
		System.out.println("longest prefix of door = " + WordTree.getPrefix("door"));
		System.out.println("longest prefix of any = " + WordTree.getPrefix("any"));
		System.out.println("longest prefix of cat = " + WordTree.getPrefix("cat"));

		/* Test getListPrefixMatches, print input and output
		 * Try prefixes "a", "do", "c" (should return [a, and, ax], [dog, door, dot], [ ] respectively)
	     */
		
		System.out.println("");
		System.out.println("-----  Test getListPrefixMatches()  i.e. autocomplete ");		
		System.out.println("a = " + WordTree.getListPrefixMatches("a"));
		System.out.println("do = " + WordTree.getListPrefixMatches("do"));
		System.out.println("c = " + WordTree.getListPrefixMatches("c"));
		System.out.println("all = " + WordTree.getListPrefixMatches(""));

	}
}