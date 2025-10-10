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

public class IntersectionLL {
  static void printList(Node head) {
        for (Node curr = head; curr != null; curr = curr.next)
            System.out.print(curr.data + "-->");
        System.out.println("null");
    }
    static Node insertNode(Node head,int val) {
    Node newNode = new Node(val);
    
    if(head == null) {
        head = newNode;
        return head;
    }
    
    Node temp = head;
    while(temp.next != null) temp = temp.next;
    
    temp.next = newNode;
    return head;
}
   
    // BRUTE Force
    //   static Node intersectionPresent(Node head1,Node head2){
    //     HashSet<Node> st=new HashSet<>();
    //     while(head1!=null){
    //         st.add(head1);
    //         head1=head1.next;
    //     }
    //     while(head2!=null){
    //         if(st.contains(head2)) return head2;
    //         head2=head2.next;
    //     }
    //     return null;

    //   }

    //OPTIMAL
    // static int getDiff(Node head1,Node head2){
    //     int len1=0,len2=0;
    //     while(head1!=null || head2!=null){
    //         if(head1!=null){
    //             ++len1;
    //             head1=head1.next;
    //         }
    //         if(head2!=null){
    //             ++len2;
    //             head2=head2.next;
    //         }
    //     }
    //     return len1-len2;
    // }
    // static Node intersecNode(Node head1,Node head2){
    //     int diff=getDiff(head1,head2);
    //     if(diff<0)
    //         while(diff++!=0) head2=head2.next;
    //         else while(diff-- != 0) head1=head1.next;
    //         while(head1!=null){
    //             if(head1==head2) return head1;
    //             head2=head2.next;
    //             head1=head1.next;
    //         }
    //         return head1;
        
    // }
 

    //optimal
    static Node interesNode(Node head1,Node head2){
        if(head1==null || head2==null) return null;
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=temp2){
            temp1=temp1.next;
            temp2=temp2.next;
            if(temp1==temp2) return temp1;
            if(temp1==null) temp1=head2;
            if(temp2==null) temp2=head1;

        }
        return temp1;
    }

    public static void main(String[] args) {
         Node head = null;
    head=insertNode(head,1);
    head=insertNode(head,3);
    head=insertNode(head,1);
    head=insertNode(head,2);
    head=insertNode(head,4);
    Node head1 = head;
    head = head.next.next.next;
    Node headSec = null;
    headSec=insertNode(headSec,3);
    Node head2 = headSec;
    headSec.next = head;
    //printing of the lists
    System.out.print("List1: "); printList(head1);
    System.out.print("List2: "); printList(head2);
    //checking if intersection is present
    Node answerNode = interesNode(head1,head2);
    if(answerNode == null)  
    System.out.println("No intersection\n");
    else
    System.out.println("The intersection point is "+answerNode.data);
    
    }
}
