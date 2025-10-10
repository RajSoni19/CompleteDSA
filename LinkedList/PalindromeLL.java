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
public class PalindromeLL {
 public static Node reversell(Node head){
            Node temp=head;
            Node prev=null;
            while(temp!=null){
                Node front=temp.next;
                temp.next=prev;
                prev=temp;
                temp=front;
            }
            return prev;
        }

    public static boolean checkpaliLL(Node head){

       

        //BRUTE FORCE
        // Stack<Integer> st=new Stack<>();
        // Node temp=head;
        // while(temp!=null){
        //     st.push(temp.data);
        //     temp=temp.next;

        // }

        // temp=head;

        // while(temp!=null){
        //     if(temp.data!=st.peek()){
        //         return false;
        //     }
        //     st.pop();
        //     temp=temp.next;
        // }
        // return true;

        if(head==null || head.next==null) return true;
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null ){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node newhead=reversell(slow.next);
        Node first=head;
        Node second=newhead;
        while(second!=null){
            if(first.data!=second.data){
                reversell(newhead);
                return false;
            }
            first=first.next;
            second=second.next;

        }
        reversell(newhead);
        return true;

    } 
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        boolean a=checkpaliLL(head);
        System.out.println(a);

    }
}
