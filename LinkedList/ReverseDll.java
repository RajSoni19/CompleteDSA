package LinkedList;

class Node {
    int data;
    Node next;
    Node back;

    // Constructor with all parameters
    Node(int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    // Constructor with just data
    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class ReverseDll {
    // Convert array to Doubly Linked List
    private static Node convertArr2DLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    // Print the Doubly Linked List
    private static void PrintNode(Node head) {
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    // Reverse the Doubly Linked List
    private static Node reverseDll(Node head) {
        // If list is empty or has only one node
        if(head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node current = head;
        
        // Traverse and swap next and back pointers
        while(current != null) {
            // Store the back pointer
            prev = current.back;
            // Swap next and back pointers
            current.back = current.next;
            current.next = prev;
            // Move to next node (which is now at back)
            current = current.back;
        }
        
        // prev.back is the new head
        return prev.back;
    }

    public static void main(String[] args) {
        int arr[] = {2, 5, 6, 8};
        // Create doubly linked list
        Node head = convertArr2DLL(arr);
        // Print original list
        System.out.println("Original List:");
        PrintNode(head);
        // Reverse the list
        head = reverseDll(head);
        // Print reversed list
        System.out.println("\nReversed List:");
        PrintNode(head);
    }
}