package Trie.Problem;

/*

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Input: strs = ["flower","flow","flight"]
Output: "fl"

*/

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
    public static boolean longestCommonPrefix(String[] strs) {
        TrieClass tc = new TrieClass();
        for (String str : strs) {
            tc.insert(str);
        }
//        String ans = tc.getCount();
        boolean ans = tc.contains("flower");

        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
//        String ans = longestCommonPrefix(strs);
        boolean ans = longestCommonPrefix(strs);
        System.out.println(ans);

    }
}

class Node {
    char data;
    Map<Character, Node> m;

    public Node(char data) {
        this.data = data;
        m = new HashMap<>();

    }
}

class TrieClass {
    static Node root;

    public TrieClass() {

        root = new Node('\0');
    }

    public static void insert(String word) {
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!current.m.containsKey(ch)) {
                Node newNode = new Node(ch);
                current.m.put(ch, newNode);

            }
            current = current.m.get(ch);
        }
    }

    public boolean contains(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.m.get(ch) == null) {
                return false;
            }
        }
        return true;
    }

    public static String getCount() {
        Node current = root;
        if (current.m.size() > 1) {
            return "";
        }
        String ansCh = "";

        while (true) {
            ansCh += current.data;
            if (current.m.size() > 1) {
                return ansCh;
            }
        }


//        while (current.m.size() != 0) {
//            if (current.m.size() == 1) {
//                ansCh += current.data;
//            } else {
//                return ansCh;
//            }
//            char currChar = current.data;
//            current = current.m.get(currChar);
//
//        }
//        return "";
    }


}
