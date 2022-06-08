package Trie;

import java.util.HashMap;

class TrieNode {
    HashMap<Character, TrieNode> map;
    char data;
    boolean isWord;

    public TrieNode(char data) {
        this.map = new HashMap<>();
        this.data = data;
        this.isWord = false;
    }
}

public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!current.map.containsKey(ch)) {
                TrieNode newNode = new TrieNode(ch);
                current.map.put(ch, newNode);

            }
            current = current.map.get(ch);
        }
        current.isWord = true;
    }

    public boolean search(String target) {
        TrieNode current = root;
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            if (!current.map.containsKey(ch)) {
                return false;
            }
            current = current.map.get(ch);
        }
        return true;
    }

    public void printTrie() {

        TrieNode current = root;
        while (!current.map.isEmpty()) {
            System.out.println(current.data);
            current = current.map.get(current.data);
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("Hello");
        System.out.println(trie.search("lHelloo"));

//        trie.printTrie();

    }
}
