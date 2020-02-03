package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	
	public static void main(String[] args) {
		int[] numbers2 = {2, 6, 4, 8, 9, 7, 2, 4, 5, 3, 2, 5, 7};
		Trie tree = new Trie();
		tree.buildTrie(numbers2);
		ArrayList<String> strings = tree.getAllPaths();
		
		System.out.println(tree.toString());
	}

}
