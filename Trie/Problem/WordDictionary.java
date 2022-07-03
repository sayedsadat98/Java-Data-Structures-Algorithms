package Trie.Problem;

import java.util.HashMap;

/* Leetcode: 211. Design Add and Search Words Data Structure */
public class WordDictionary {

    class NodeTrie {
        char data;
        HashMap<Character, NodeTrie> map;
        boolean isWord;

        public NodeTrie(char data) {
            this.data = data;
            map = new HashMap<>();
            isWord = false;
        }
    }

    class Trie {

        NodeTrie root;

        public Trie() {
            root = new NodeTrie('\0');
        }

        public void insert(String word) {
            NodeTrie current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!current.map.containsKey(ch)) {
                    NodeTrie newNode = new NodeTrie(ch);
                    current.map.put(ch, newNode);
                }
                current = current.map.get(ch);
            }
            current.isWord = true;

        }

        public boolean search(String word) {
            NodeTrie current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!current.map.containsKey(ch)) {
                    return false;
                }
            }
            return true;
        }
    }

    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return search(word);
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True

    }
}




