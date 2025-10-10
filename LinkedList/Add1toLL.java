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

public class Add1toLL {

    // public static Node ReverseLL(Node head){
    //      Node temp = head;
    //     Node prev = null;
    //     while (temp != null) {
    //         // Store the next node in
    //         // 'front' to preserve the reference
    //         Node front = temp.next;
    //         // Reverse the direction of the
    //         // current node's 'next' pointer
    //         // to point to 'prev'
    //         temp.next = prev;
    //         // Move 'prev' to the current
    //         // node for the next iteration
    //         prev = temp;
    //         // Move 'temp' to the 'front' node
    //         // advancing the traversal
    //         temp = front;
    //     }
    //     return prev;
    // }

    public static void printll(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    //BRUTE
    // public static Node Add1LL(Node head){
    //     head=ReverseLL(head);
    //     Node temp=head;
    //     int carry=1;
    //     while(temp!=null){
    //         temp.data=temp.data+carry;
    //         if(carry<10){
    //           carry=0;
    //           break;
    //         }
    //         else{
    //             temp.data=0;
    //             carry=1;
    //         }
    //     }
    //     if(carry==1){
    //         Node newnode=new Node(1);
    //         head=ReverseLL(head);
    //         newnode.next=head;
    //         return newnode;
    //     }
    //     head=ReverseLL(head);
    //     return head;
    // }

    //OPTIMAL
   static int helper(Node head){
        Node temp=head;
        if(temp==null){
            return 1;
        }
        int carry=helper(temp.next);
        temp.data+=carry;
        if(temp.data<10) return 0;
        temp.data=0;
        return 1;
    }
   static  Node Add1LL(Node head){
        int carry=helper(head);
        if(carry==1){
            Node newnode =new Node(1);
            newnode.next=head;
            head=newnode;
        }
        return head;
    }
    public static void main(String[] args) {
         Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        System.out.println("Original ll");
        printll(head);
        head=Add1LL(head);
        printll(head);

    }
}
