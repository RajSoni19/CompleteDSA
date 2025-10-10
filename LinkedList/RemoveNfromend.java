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

public class RemoveNfromend {
  
    static Node removeend(Node head,int N){

        //BRUTE force
    //   if(head==null) return null;
    //   int cnt=0;
    //   Node temp=head;
    //   while(temp!=null){
    //     cnt++;
    //     temp=temp.next;
    //   }
    //   if(cnt==N){
    //     Node newhead=head.next;
    //     head=null;
    //     return newhead;
    //   }
    //   int res=cnt-N;
    //   temp=head;
    //   while(temp!=null){
    //     res--;
    //     if(res==0){
    //         break;
    //     }
    //     temp=temp.next;
    //   }
    //   Node deln=temp.next;
    //   temp.next=temp.next.next;
    //   deln=null;
    //   return head;


    //OPTIMAL
    Node fast=head;
    Node slow=head;
    for(int i=0;i<N;i++) fast=fast.next;
    if(fast==null) return head.next;
    while(fast.next!=null){
        fast=fast.next;
        slow=slow.next;
    }
    Node delNode=slow.next;
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
        int N=2;
          head=removeend(head,N);
         PrintList(head);
    }
}
