package LinkedList;

import java.util.ArrayList;
import java.util.List;

class CicularNode {
    public int data;
    public CicularNode next;

    public CicularNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularList {
    public CicularNode head;
    public CicularNode tail;
    public int size; // Size is used to stop the list iteration

    public CircularList() {
        head = null;
        size = 0;
    }

    public int length() {
        return size;
    }

    public void printList() {
        CicularNode current = head;
        System.out.print("[ ");
        int nodeCounter = 0;
        while (nodeCounter < size) {
            System.out.print(current.data + " ");
            current = current.next;
            nodeCounter++;
        }
        System.out.print("]");
        System.out.println();
    }

    public void insert(int data, int position) {
        CicularNode newNode = new CicularNode(data);
        size++;
        if (head == null) {
            head = newNode;
            newNode.next = head;
            tail = newNode;
            return;
        }

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        } else if (position >= length()) {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        } else {
            int counter = 0;
            CicularNode temp = head;
            while (counter < position - 1) {
                temp = temp.next;
                counter++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void remove(int data) {
        CicularNode current = head;
        if (current == null) {
            System.out.println("List is empty");
        }
        if (search(data)) {
            if (current == head) {
                head = current.next;
                return;
            }


        }
        System.out.println("Data is not found");

    }

    public boolean search(int data) {
        CicularNode current = head;
        for (int i = 0; i < length(); i++) {
            if (current.data == data) {
                return true;
            }
        }
        return false;
    }
}

public class CircularLinkedListMain {
    public static void main(String[] args) {
        CircularList cll = new CircularList();
        cll.insert(1, 0);
        cll.insert(2, 1);
        cll.insert(3, 2);
        cll.insert(4, 3);
        cll.insert(5, 4);
        cll.insert(50, 2);
//        cll.insert(150, 0);
//        cll.remove(4);
        System.out.println(cll.length());
        cll.printList();
    }
}
