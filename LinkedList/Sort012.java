package LinkedList;
class Node {
    int data;
    Node next;

    // Constructor to initialize a node with data and next pointer
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    // Constructor to initialize a node with only data
    Node(int data) {
        this.data = data;
    }
}

public class Sort012 {

    // Function to sort the linked list containing 0s, 1s, and 2s
    static Node Sort012N(Node head) {
        if (head == null || head.next == null) return head; // Handle empty or single-node list

        // Create dummy nodes for 0, 1, and 2 lists
        Node zerohead = new Node(-1);
        Node onehead = new Node(-1);
        Node twohead = new Node(-1);

        // Pointers to build the respective lists
        Node zero = zerohead;
        Node one = onehead;
        Node two = twohead;

        // Traverse the original list and segregate nodes into 0, 1, and 2 lists
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        // Merge the three lists
        zero.next = (onehead.next != null) ? onehead.next : twohead.next; // Connect 0 list to 1 or 2 list
        one.next = twohead.next; // Connect 1 list to 2 list
        two.next = null; // End the 2 list

        // Return the head of the merged list
        Node newhead = zerohead.next;
        return newhead;
    }

    // Function to print the linked list
    static void PrintList(Node head) {
        for (Node curr = head; curr != null; curr = curr.next)
            System.out.print(curr.data + "-->");
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a linked list: 0 -> 2 -> 0 -> 1 -> 0
        Node head = new Node(0);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(0);

        // Sort the linked list
        head = Sort012N(head);

        // Print the sorted linked list
        PrintList(head);
    }
}