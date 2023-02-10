package LinkedList;

import java.util.List;

class NodeList {
    public int data;
    public NodeList prev;
    public NodeList next;

    public NodeList(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

class LList {
    public NodeList head;
    public NodeList tail;
    public int size;



    public void insert(int data) {
        NodeList newNode = new NodeList(data);

        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void delete(int data) {
        
    }

    public void printList() {
        NodeList current = head;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print("]");
        System.out.println();
    }
}

public class ListMain {
    public static void main(String[] args) {
        LList list = new LList();
        list.insert(1);
        list.insert(3);
        list.insert(2);
        list.insert(4);
        list.printList();

    }

}
