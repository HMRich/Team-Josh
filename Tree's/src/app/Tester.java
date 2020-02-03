package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	
	public static void main(String[] args) throws IOException {
		
		Trie2 myTrie = new Trie2();
		myTrie.insertString("apple");
		myTrie.insertString("bike");
		myTrie.insertString("bake");
		myTrie.insertString("pen");
		myTrie.insertString("did");
		myTrie.insertString("ape");
		myTrie.insertString("child");
		myTrie.insertString("cat");
		myTrie.insertString("file");
		myTrie.insertString("hello");
		myTrie.insertString("he");
		myTrie.insertString("hell");
		
		ArrayList<String> stuff = myTrie.wordsPrefixedBy("ap");
		ArrayList<String> stuff2 = myTrie.wordsPrefixedBy("he");
		
		Trie2 dictionary = new Trie2();
		
		try {
			String fileName = "src/dictionary.txt";
			File dictionaryFile = new File(fileName);
			Scanner dictionaryFileSacnner = new Scanner(dictionaryFile);
			while(dictionaryFileSacnner.hasNextLine()) {
				String line = dictionaryFileSacnner.nextLine().replaceAll("[0-9]| |,", "");
				dictionary.insertString(line);
			}
			dictionaryFileSacnner.close();
		} catch(Exception e) {
			e.printStackTrace();
			throw new IOException("Something went wrong.");
		}
		
		int[] numbers2 = {2, 6, 4, 8, 9, 7, 2, 4, 5, 3, 2, 5, 7};
		Trie tree = new Trie();
		tree.buildTrie(numbers2);
		ArrayList<String> strings = tree.getAllPaths();
		
		System.out.println(tree.toString());
	}

}
