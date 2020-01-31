package app;

import java.util.*;

public class Trie {
	
	private static char[][] digists = {['a', 'b', 'c'],
			['d', 'e', 'f'],
			['g', 'h', 'i']};

	private class Node {
		char char1;
		char char2;
		char char3;
		char char4;
		boolean aword;
		
		private Node(char[]chars) {
			char1 = chars[0];
			char2 = chars[1];
			char3 = chars[2];
			char4 = chars.length == 4 ? chars[3] : null;
		}
	}

	private Node root;

	public Trie() {
		this.root = null;
	}

	public void insertString(String s) {
		insertString(root, s);
	}

	private void insertString(Node root, String s) {
		Node cur = root;
		for (char ch : s.toCharArray()) {
			Node next = cur.children.get(ch);
			if (next == null)
				cur.children.put(ch, next = new Node());
			cur = next;
		}
		cur.aword = true;
	}

	public void printSorted() {
		printSorted(root, "");
	}

	private void printSorted(Node node, String s) {
		if (node.aword) {
			System.out.println(s);
		}
		for (Character ch : node.children.keySet()) {
			printSorted(node.children.get(ch), s + ch);
		}
	}

	public boolean findWord(String s) {
		return findWord(root, s);
	}

	private boolean findWord(Node node, String s) {
		if (s != null) {
			String rest = s.substring(1); // rest is a substring of s, by excluding the first character in s
			char ch = s.charAt(0); // ch is the first letter of s
			Node child = node.children.get(ch); // return the child that ch associated with.
			if (s.length() == 1 && child != null) // if s contains only one letter, and current node has a child
													// associated with that letter, we find the prefix in Trie!
				return true; // base case
			if (child == null)
				return false;
			else
				return findWord(child, rest); // recursive, In this way, we follow the path of the trie from root down
												// towards leaf
		}
		return false;
	}

	// Usage example
	public static void main(String[] args) {

		Trie2 tr = new Trie2();

		tr.insertString("hello");
		tr.insertString("world");
		tr.insertString("hi");
		tr.insertString("ant");
		tr.insertString("an");

		System.out.println(tr.findWord("ant"));
		System.out.println(tr.findWord("an"));
		System.out.println(tr.findWord("hello"));
		System.out.println(tr.findWord("cant"));
		System.out.println(tr.findWord("hig"));
		System.out.println(tr.findWord("he"));

		tr.printSorted();
	}
}
