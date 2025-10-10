package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
    }
}

public class RotateLL {

    // Print the linked list
    public static void printll(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " "); // Print on the same line
            temp = temp.next;
        }
        System.out.println(); // Add a new line after printing the list
    }

    // Find the k-th node in the linked list
    public static Node findNnode(Node temp, int k) {
        int cnt = 1;
        while (temp != null) {
            if (cnt == k) {
                return temp;
            }
            cnt++;
            temp = temp.next;
        }
        return null; // Return null if k-th node is not found
    }

    // Rotate the linked list by k positions
    public static Node rotatelist(Node head, int k) {
        if (head == null || k == 0) return head; // No rotation needed

        // Find the length of the linked list
        Node tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // If k is a multiple of the length, no rotation is needed
        if (k % len == 0) return head;

        // Update k to handle cases where k > len
        k = k % len;

        // Make the list circular
        tail.next = head;

        // Find the new tail (len - k-th node)
        Node newTail = findNnode(head, len - k);

        // Update the head and break the circular link
        head = newTail.next;
        newTail.next = null;

        return head;
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println("Original Linked List:");
        printll(head);

        // Rotate the list by 2 positions
        head = rotatelist(head, 2);

        System.out.println("Rotated Linked List:");
        printll(head);
    }
}