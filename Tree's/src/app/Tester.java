package app;

import java.util.ArrayList;

public class Tester {
	
	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(2);
		numbers.add(6);
		numbers.add(4);
		numbers.add(8);
		numbers.add(9);
		numbers.add(7);
		numbers.add(2);
		numbers.add(4);
		numbers.add(5);
		numbers.add(3);
		numbers.add(2);
		numbers.add(5);
		numbers.add(7);
		
		Trie tree = new Trie();
		tree.buildTrie(numbers);
		
		System.out.println(tree.toString());
	}

}
