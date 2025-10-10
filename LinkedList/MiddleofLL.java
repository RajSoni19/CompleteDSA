package LinkedList;
class Node{
    int data;
    Node next;
    Node(int data,Node next){
        this.data=data;
        this.next=next;
    }
    Node(int data){
        this.data=data;
    }
}
public class MiddleofLL {

    // static Node findMiddle(Node head){
    //        if(head==null || head.next==null) return head;
    //        Node temp=head;
    //        int cnt=0;
    //        while(temp!=null){
    //         cnt++;
    //            temp=temp.next;
    //        }

    //        int mid=(cnt/2)+1;
    //        temp=head;
    //        while(temp!=null){
    //         mid--;
    //         if(mid==0){
    //             break;
    //         }
    //         temp=temp.next;
    //        }

    //        return temp;
    // }

    static Node findMiddle(Node head){
            Node slow=head;
            Node fast=head;
            while(fast!=null && fast.next!=null){  //for even and odd length ll
                slow=slow.next;
                fast=fast.next.next;
            }

            return slow;

    }


    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        Node middlNode=findMiddle(head);
        System.out.println("The middle value is " + middlNode.data);

    }
}
