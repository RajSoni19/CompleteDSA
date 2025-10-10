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

public class OddEvenLL {

    public static Node OddEvenidx(Node head){

        //BRUTE FORCE
        //   Node temp=head;
        //   ArrayList<Integer> arr=new ArrayList<>();
        //   while(temp!=null && temp.next!=null){
        //     arr.add(temp.data);
        //     temp=temp.next.next;

        //   }
        //   if(temp != null) arr.add(temp.data);
          
        //   temp=head.next;
        //   while(temp!=null && temp.next!=null){
        //       arr.add(temp.data);
        //       temp=temp.next.next;
        //     }
        //     if(temp != null) arr.add(temp.data);
        //    int i=0;
        //    temp=head;
        //    while(temp!=null){
        //     temp.data=arr.get(i);
        //     i++;
        //     temp=temp.next;
        //    }
        //    return head;

        //OPTIMAL 
        Node odd=head;
        Node even=head.next;
        Node evenhead=head.next;
        while(even!=null && even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        odd.next=evenhead;
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
        OddEvenidx(head);
        PrintList(head);
    }
}
