package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

public class DirectChaining {

    LinkedList<String>[] hashTable;
    int maxChainSize = 5;

    public DirectChaining(int size) {
        hashTable = new LinkedList[size];

    }

    public int hashFunction(String word, int cellNumber) {
        char[] wordArray = word.toCharArray();
        int sum = 0;
        for (int i = 0; i < wordArray.length; i++) {
            sum += wordArray[i];
        }
        return sum % cellNumber;
    }

    public void HashTable(String word) {
        int newIndex = hashFunction(word, hashTable.length);
        if (hashTable[newIndex] == null) {
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(word);
        } else {
            hashTable[newIndex].add(word);
        }
    }
}
