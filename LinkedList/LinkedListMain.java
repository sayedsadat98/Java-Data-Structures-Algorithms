package LinkedList;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    public Node head;
    public int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public Node getHead() {
        return head;
    }

    public int length() {
        return size;
    }

    public void printList() {
        Node current = head;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print("]");
        System.out.println();
    }

    public Node findTail() {
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

    public void insert(int data, int position) {

        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = newNode;
            return;
        }
        // insert at head
        if (position == 0) {
            Node prevHead = head;
            head = newNode;
            newNode.next = prevHead;
        }
        // insert at tail
        else if (position >= length()) {
            findTail().next = newNode;
        }
        // insert in the middle
        else {
            Node current = head;
            int counter = 1;
            while (counter <= position - 1) {
                current = current.next;
                counter++;
            }
            Node nextNode = current.next;
            current.next = newNode;
            newNode.next = nextNode;

        }
    }

    public void delete(int data) {
        if (length() == 0) {
            return;
        }
        Node current = head;
        Node prev = null;
        Node nextNode = null;
        while (true) {
            if (current.data == data) {
                nextNode = current.next;
                break;
            }
            prev = current;
            current = current.next;
        }
        prev.next = nextNode;
    }

    public void remove(int position) {
        Node current = head;
        while (current == null) {
            return;
        }
        if (position == 0) {
            head = head.next;
        }
        int counter = 0;
        while (counter < position - 1) {
            current = current.next;
            counter++;
        }
        current.next = current.next.next;

    }

    public boolean search(int data) {
        Node current = head;
        while (current.next != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;

        }
        return false;
    }
}

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(1, 0);
        ll.insert(2, 1);
        ll.insert(3, 2);
        ll.insert(4, 3);
        ll.insert(5, 4);
        ll.insert(-1, 2);
        System.out.println("Length of the List before deletion: " + ll.length());
        ll.printList();
        System.out.println("Previous Tail: " + ll.findTail().data);
        ll.delete(-1);

        System.out.println("Length of the List after deletion: " + ll.length());
        ll.printList();
        System.out.println("New Tail: " + ll.findTail().data);
        System.out.println("Operations Completed!");
    }
}
