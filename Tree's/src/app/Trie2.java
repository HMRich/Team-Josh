package app;

import java.util.*;

public class Trie2 {

	private class TrieNode {
		Map<Character, TrieNode> children = new TreeMap<>();
		boolean aword = false;
	}

	private TrieNode root;

	public Trie2() {
		this.root = new TrieNode();
	}

	public void insertString(String s) {
		insertString(root, s);
	}

	private void insertString(TrieNode root, String s) {
		TrieNode cur = root;
		for (char ch : s.toCharArray()) {
			TrieNode next = cur.children.get(ch);
			if (next == null)
				cur.children.put(ch, next = new TrieNode());
			cur = next;
		}
		cur.aword = true;
	}

	public void printSorted() {
		printSorted(root, "");
	}

	private void printSorted(TrieNode node, String s) {
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

	private boolean findWord(TrieNode node, String s) {
		if (s != null) {
			String rest = s.substring(1);
			char ch = s.charAt(0);
			TrieNode child = node.children.get(ch);
			if (s.length() == 1 && child != null)
				return true;
			if (child == null)
				return false;
			else
				return findWord(child, rest);
		}
		return false;
	}

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
