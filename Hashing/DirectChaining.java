package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class DirectChaining {

    LinkedList<String>[] hashTable;
    int maxChainLimit = 5;

    DirectChaining(int maxSize) {
        hashTable = new LinkedList[maxSize];
    }

    public int modASCII(String word, int cell) {
        int total = 0;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i);
            total += ch;
        }

        return total % cell;
    }

    public void insertHashTable(String word) {
        int newIndex = modASCII(word, hashTable.length);

        if (hashTable[newIndex] == null) {
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(word);
        }

        else{
            hashTable[newIndex].add(word);
        }
    }

    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("EMPTY");
            return;
        }
        else {

        }
    }

    public static void main(String[] args) {
        DirectChaining dc = new DirectChaining(5);
        int ans = dc.modASCII("ABCD", 24);
        System.out.println(ans);

    }



}
