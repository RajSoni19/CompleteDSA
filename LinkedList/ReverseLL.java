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

public class ReverseLL {

    public static Node reversellist(Node head) {

        // Brute app
        // Node temp=head;
        // Stack<Integer> s=new Stack<>();
        // while(temp!=null){
        // s.push(temp.data);
        // temp=temp.next;
        // }
        // temp=head;
        // while(temp!=null){
        // temp.data=s.pop();
        // temp=temp.next;
        // }
        // return head;

        // Optimal (Iterative)
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            // Store the next node in
            // 'front' to preserve the reference
            Node front = temp.next;
            // Reverse the direction of the
            // current node's 'next' pointer
            // to point to 'prev'
            temp.next = prev;
            // Move 'prev' to the current
            // node for the next iteration
            prev = temp;
            // Move 'temp' to the 'front' node
            // advancing the traversal
            temp = front;
        }
        return prev;
    }

    public static void printll(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println("Original ll");
        printll(head);
        head = reversellist(head);
        System.out.println("Reversed ll");
        printll(head);
    }
}
