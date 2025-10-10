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

public class DeleteMiddle {

    public static Node DeleteNode(Node head){
         Node slow=head;
         Node fast=head;
         fast=fast.next.next;
         while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
         }
         Node tod=slow.next;
         slow.next=slow.next.next;
         return head;
    }
      static void PrintList(Node head) // Function to print the LinkedList
{
   
    for ( Node curr = head; curr != null; curr = curr.next)
        System.out.print(curr.data+"-->");
    System.out.println("null");
}
    public static void main(String[] args) {
          Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head=DeleteNode(head);
        PrintList(head);
    }
}
