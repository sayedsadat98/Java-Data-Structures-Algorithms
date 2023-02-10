package LinkedList;

import java.util.Scanner;
import java.util.Stack;

public class ListReverse {
    // Sample Data : 16->12->4->2->5
    // outpur: 5 2 4 12 16

    public static void reverse(LinkedList ll) {
        Stack<Integer> stack = new Stack<>();
        Node current = ll.getHead();
        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }
        LinkedList revList = new LinkedList();
        while (!stack.isEmpty()) {
            revList.insert(stack.pop(), Integer.MAX_VALUE);
        }
        Node newCurrent = revList.getHead();
        System.out.println("Reversed List:");
        while (newCurrent != null) {
            System.out.print(newCurrent.data + " ");
            newCurrent = newCurrent.next;
        }
        System.out.println();


    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            ll.insert(sc.nextInt(), Integer.MAX_VALUE);
        }
        ll.printList();
        reverse(ll);
        System.out.println("===============");
    }
}
