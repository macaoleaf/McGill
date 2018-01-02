package Users.zisheng.GitHub.McGill_COMP250.a3.out.production.a3;

//COMP 250 - Introduction to Computer Science - Fall 2017
/*
Name: Zisheng Ye
McGill ID: 260714548
Discussions with Ian Tsai. He gave me some hints in getListPrefixMatches method about using recursion.
There were still some bugs yesterday based on his idea, but I did not come up with an idea to solve this.
Today I finally solve it, hand my work in again and I will receive a penalty, but I think it is worthy.

When it comes to the toString method, I thought the letter at the end is missing,
but it went wrong when I added some parts of codes, while worked when I deleted them.
I don't know why still but I know I should not keep this. I'll keep this part for reviewing.
 */
//Assignment #3 - Question 1

import java.util.*;

/*
 *  WordTree class.  Each node is associated with a prefix of some word 
 *  stored in the tree.   (Any string is a prefix of itself.)
 */

public class WordTree
{
	WordTreeNode root;

	// Empty tree has just a root node.  All the children are null.

	public WordTree()
	{
		root = new WordTreeNode();
	}


	/*
	 * Insert word into the tree.  First, find the longest 
	 * prefix of word that is already in the tree (use getPrefixNode() below). 
	 * Then, add TreeNode(s) such that the word is inserted 
	 * according to the specification in PDF.
	 */
	public void insert(String word)
	{
		//  ADD YOUR CODE BELOW HERE
		WordTreeNode current = getPrefixNode(word);
		for (int n = current.toString().length(); n < word.length(); n++) {
			char letter = word.charAt(n);
			if (current.getChild(letter) == null) {
				current = current.createChild(letter); //create a new child and assign it as current
			} else {
				current = current.getChild(letter); //go to next node
			}
		}
		current.endOfWord = true; //after all letters are added, it reaches the end of the word
		//  ADD YOUR ABOVE HERE
	}

	// insert each word in a given list 

	public void loadWords(ArrayList<String> words)
	{
		for (int i = 0; i < words.size(); i++)
		{
			insert(words.get(i));
		}
		return;
	}

	/*
	 * Given an input word, return the TreeNode corresponding the longest prefix that is found. 
	 * If no prefix is found, return the root. 
	 * In the example in the PDF, running getPrefixNode("any") should return the
	 * dashed node under "n", since "an" is the longest prefix of "any" in the tree. 
	 */
	WordTreeNode getPrefixNode(String word)
	{
		//   ADD YOUR CODE BELOW HERE
		WordTreeNode prefixNode = root;
		for (int n = 0; n < word.length(); n++) { //when length is 0, return root
			char letter = word.charAt(n);
			if (prefixNode.children[letter] == null) {
				n = word.length();
			} else {
				prefixNode = prefixNode.children[letter]; //or try getChild later
			}
		}
		return prefixNode;
		//   ADD YOUR CODE ABOVE HERE

	}

	/*
	 * Similar to getPrefixNode() but now return the prefix as a String, rather than as a TreeNode.
	 */

	public String getPrefix(String word)
	{
		return getPrefixNode(word).toString();
	}


	/*
	 *  Return true if word is contained in the tree (i.e. it was added by insert), false otherwise.
	 *  Hint:  any string is a prefix of itself, so you can use getPrefixNode().
	 */
	public boolean contains(String word)
	{
		//   ADD YOUR CODE BELOW HERE
		WordTreeNode ruler = this.getPrefixNode(word);
		boolean contains = false;
		if (ruler.toString().length() == word.length() && ruler.isEndOfWord()) {
			contains = true;
		}
		return contains;
		//   ADD YOUR CODE ABOVE HERE
	}

	/*
	 *  Return a list of all words in the tree that have the given prefix. 
	 *  For example,  getListPrefixMatches("") should return all words in the tree.
	 */
	public ArrayList<String> getListPrefixMatches( String prefix )
	{
		//  ADD YOUR CODE BELOW 
		ArrayList<String> result = new ArrayList<String>();
		WordTreeNode begin = getPrefixNode(prefix);
		if (begin.toString().length() != prefix.length()) {
			begin = null;
		}
		if (begin != null) { //if prefix is null, return the empty list
			String buffer = "";
			for (int n = 65; n < 123; n++) {
				if (begin.children[n] != null) {
					String newPrefix = prefix + begin.children[n].charInParent;
					result.addAll(getListPrefixMatches(newPrefix));
				} else {
					String current = begin.toString();
					if (!current.equals(buffer) && begin.endOfWord) {
						result.add(current);
						buffer = current;
					}
				}
			}
		}
		return result;
		//  ADD YOUR CODE ABOVE HERE
	}


	/*
	 *  Below is the inner class defining a node in a Tree (prefix) tree.  
	 *  A node contains an array of children: one for each possible character.  
	 *  The children themselves are nodes.
	 *  The i-th slot in the array contains a reference to a child node which corresponds 
	 *  to character  (char) i, namely the character with  ASCII (and UNICODE) code value i. 
	 *  Similarly the index of character c is obtained by "casting":   (int) c.
	 *  So children[97] = children[ (int) 'a']  would reference a child node corresponding to 'a' 
	 *  since (char)97 == 'a'   and  (int)'a' == 97.
	 * 
	 *  To learn more:
	 * -For all unicode charactors, see http://unicode.org/charts
	 *  in particular, the ascii characters are listed at http://unicode.org/charts/PDF/U0000.pdf
	 * -For ascii table, see http://www.asciitable.com/
	 * -For basic idea of converting (casting) from one type to another, see 
	 *  any intro to Java book (index "primitive type conversions"), or google
	 *  that phrase.   We will cover casting of reference types when get to the
	 *  Object Oriented Design part of this course.
	 */

	public class WordTreeNode
	{
		/*  
		 *   Highest allowable character index is NUMCHILDREN-1
		 *   (assuming one-byte ASCII i.e. "extended ASCII")
		 *   
		 *   NUMCHILDREN is constant (static and final)
		 *   To access it, write "TreeNode.NUMCHILDREN"
		 *   
		 *   For simplicity,  we have given each WordTree node 256 children. 
		 *   Note that if our words only consisted of characters from {a,...,z,A,...,Z} then
		 *   we would only need 52 children.   The WordTree can represent more general words
		 *   e.g.  it could also represent many special characters often used in passwords.
		 */

		public static final int NUMCHILDREN = 256;

		WordTreeNode     parent;
		WordTreeNode[]   children;
		int              depth;            // 0 for root, 1 for root's children, 2 for their children, etc..

		char             charInParent;    // Character associated with the tree edge from this node's parent 
		// to this node.
		// See comment above for relationship between an index in 0 to 255 and a char value.

		boolean endOfWord;   // Set to true if prefix associated with this node is also a word.


		// Constructor for new, empty node with NUMCHILDREN children.  
		//  All the children are automatically initialized to null. 

		public WordTreeNode()
		{
			children = new WordTreeNode[NUMCHILDREN];

			//   These assignments below are unnecessary since they are just the default values.

			endOfWord = false;
			depth = 0;
			charInParent = (char)0;
		}


		/*
		 *  Add a child to current node.  The child is associated with the character specified by
		 *  the method parameter.  Make sure you set as many fields in the child node as you can.
		 *  
		 *  To implement this method, see the comment above the inner class TreeNode declaration.  
		 *  
		 */

		public WordTreeNode createChild(char  c)
		{
			WordTreeNode child       = new WordTreeNode();

			// ADD YOUR CODE BELOW HERE
			this.children[c] = child;
			child.parent = this;
			child.charInParent = c;
			child.depth = this.depth + 1;
			// ADD YOUR CODE ABOVE HERE

			return child;
		}

		// Get the child node associated with a given character, i.e. that character is "on" 
		// the edge from this node to the child.  The child could be null.  

		public WordTreeNode getChild(char c)
		{
			return children[ c ];
		}

		// Test whether the path from the root to this node is a word in the tree.  
		// Return true if it is, false if it is prefix but not a word.

		public boolean isEndOfWord()
		{
			return endOfWord;
		}

		// Set to true for the node associated with the last character of an input word

		public void setEndOfWord(boolean endOfWord)
		{
			this.endOfWord = endOfWord;
		}

		/*  
		 *  Return the prefix (as a String) associated with this node.  This prefix
		 *  is defined by descending from the root to this node.  However, you will
		 *  find it is easier to implement by ascending from the node to the root,
		 *  composing the prefix string from its last character to its first.  
		 *
		 *  This overrides the default toString() method.
		 */

		public String toString()
		{
			// ADD YOUR CODE BELOW HERE
			WordTreeNode oneNode = this;
			String result = "";
			//result = result + oneNode.createChild('c').charInParent;
			//oneNode.children['a'] = null; //getting letter at the end
			while (oneNode.parent != null) {
				result = oneNode.charInParent + result;
				oneNode = oneNode.parent;
			}
			return result;
			// ADD YOUR CODE ABOVE HERE
		}
	}

}