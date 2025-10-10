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

public class CycleinLL {

    // public static boolean detectCycle(Node head){
    //     Node temp=head;
    //     Map<Node,Integer> nodeMap=new HashMap<>();
    //     while(temp!=null){
    //         if(nodeMap.containsKey(temp)){
    //             return true;
    //         }
    //         nodeMap.put(temp,1);
    //         temp=temp.next;
    //     }
    //     return false;
    // }

    public static boolean detectCycle(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Node head=new Node(1);
        Node second=new Node(2);
        Node third=new Node(3);
        Node fourth=new Node(4);
        Node fifth=new Node(5);
        head.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        fifth.next=third;

        if(detectCycle(head)){
          System.out.println("True");
        }
        else{
            System.out.println("False");
        }

    }
}
