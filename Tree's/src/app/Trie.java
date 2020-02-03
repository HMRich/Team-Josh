package app;

import java.util.*;

public class Trie {

	// ----------------------------------------------------------------------------------------------------

	private static Character[][] keypad = { //
			{}, // 0 empty
			{}, // 1 empty
			{ 'a', 'b', 'c' }, // 2
			{ 'd', 'e', 'f' }, // 3
			{ 'g', 'h', 'i' }, // 4
			{ 'j', 'k', 'l' }, // 5
			{ 'm', 'n', 'o' }, // 6
			{ 'p', 'q', 'r', 's' }, // 7
			{ 't', 'u', 'v' }, // 8
			{ 'w', 'x', 'y', 'z' } // 9
	};

	// ----------------------------------------------------------------------------------------------------

	private class Node {
		Character data;
		Node[] chars;

		private Node() {
			data = null;
			chars = new Node[4];
		}

		private Node(Character ch) {
			this();
			data = ch;
		}

		private void putChar(Character ch, int index) {
			switch (index) {
			case 0:
				chars[0] = new Node(ch);
				break;
			case 1:
				chars[1] = new Node(ch);
				break;
			case 2:
				chars[2] = new Node(ch);
				break;
			case 3:
				chars[3] = new Node(ch);
				break;
			default:
				throw new IllegalStateException("index was below 1 or above 4.");
			}
		}

		private Node getCharNode(int index) {
			switch (index) {
			case 0:
				return chars[0];
			case 1:
				return chars[1];
			case 2:
				return chars[2];
			case 3:
				return chars[3];
			default:
				throw new IllegalStateException("index was below 1 or above 4.");
			}
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	// ----------------------------------------------------------------------------------------------------

	private Node root;
	private ArrayList<String> paths;

	public Trie() {
		this.root = new Node();
		this.paths = new ArrayList<String>();
	}

	// ----------------------------------------------------------------------------------------------------

	public void buildTrie(int[] input) {
		ArrayList<Integer> cleanedInput = cleanInput(input);
		if (!inputIsValid(cleanedInput)) {
			throw new IllegalArgumentException("Input cannot have a value less that one or greater than 9.");
		}
		ArrayList<Character> path = new ArrayList<Character>();
		buildTrie(cleanedInput, root, path);
	}
	
	public ArrayList<String> getAllPaths() {
		return paths;
	}

	private void buildTrie(ArrayList<Integer> input, Node node, ArrayList<Character> path) {
		if (input.size() == 0) {
			paths.add(arrayListToString(path));
			return;
		}
		if(node.data != null) {
			path.add(node.data);
		}
		Character[] possibleCharacters = keypad[input.get(0)];
		input.remove(0);
		int index = 0;
		for (Character data : possibleCharacters) {
			node.putChar(data, index);
			buildTrie(new ArrayList<Integer>(input), node.getCharNode(index), new ArrayList<Character>(path));
			index++;
		}
	}

	private boolean inputIsValid(ArrayList<Integer> input) {
		for (Integer data : input) {
			if (data < 2 || data > 9) {
				return false;
			}
		}
		return true;
	}
	
	private ArrayList<Integer> cleanInput(int[] input) {
		ArrayList<Integer> cleanedInput = new ArrayList<Integer>();
		for(int data : input) {
			cleanedInput.add(data);
		}
		return cleanedInput;
	}
	
	private String arrayListToString(ArrayList<Character> path) {
		String convertedPath = "";
		for(Character data : path) {
			convertedPath = convertedPath.concat(data.toString());
		}
		return convertedPath;
	}

}