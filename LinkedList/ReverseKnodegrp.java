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

public class ReverseKnodegrp {

    public static Node reversegrp(Node head, int k) {
        Node temp = head;
        int cnt = 0;
        while (temp != null && cnt < k) {
            temp = temp.next;
            cnt++;
        }
        if (cnt < k) {
            return head;
        }
        Node curr = head;
        Node prev = null;
        Node front = null;
        cnt=0;
        while (curr != null && cnt < k) {
            
                front = curr.next;
                curr.next = prev;
                prev = curr;
                curr = front;
                cnt++;
        
            }
            
            if (front != null) {
                head.next = reversegrp(front, k);
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
        head = reversegrp(head, 2);
        System.out.println("Reversed ll");
        printll(head);
    }
}
