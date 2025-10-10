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
public class Add2LLnum {

        public static void printll(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }



    public static Node add2n(Node head1,Node head2){
       Node dum=new Node(-1);
       Node temp=dum;
       int carry=0;
       while(head1!=null || head2!=null || carry==1){
        int sum=0;
        if(head1!=null){
            sum+=head1.data;
            head1=head1.next;
        }
        if(head2!=null){
            sum+=head2.data;
            head2=head2.next;
        }
        sum+=carry;
        carry=sum/10; //This is for carry 
        Node node=new Node(sum%10);  // This is for unit digit to keep 
        temp.next=node;
        temp=temp.next;
       }
       return dum.next;
    }
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
       Node head2=new Node(1);
        head2.next = new Node(0);
        head2.next.next = new Node(3);
        head2.next.next.next = new Node(4);
         System.out.println("Original ll");
        printll(head1);
        head1=add2n(head1,head2);
        printll(head1);
    }
}
