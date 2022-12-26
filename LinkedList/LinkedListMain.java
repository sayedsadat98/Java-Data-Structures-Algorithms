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

    public LinkedList() {
        this.head = null;
    }

    public int length() {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
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

    public void insert(int data, int position) {
        Node newNode = new Node(data);
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
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = newNode;

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
        ll.printList();
        ll.delete(-1);

        ll.printList();
        System.out.println("Length of the List: " + ll.length());

        System.out.println("Operations Completed!");
    }
}
