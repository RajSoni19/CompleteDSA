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
public class CycleInLL2 {
    public static Node detectLoop(Node head){

        //BRUTE
        // Node temp=head;
        // HashMap<Node,Integer> nodeMap=new HashMap<>();
        // while(temp!=null){
        //     if(nodeMap.containsKey(temp)){
        //         return temp;
        //     }
        //     nodeMap.put(temp,1);
        //     temp=temp.next;

        // }
        // return null;

        //BETTER
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }
        }
        return null;
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

        Node loopNode=detectLoop(head);
        if(loopNode!=null){
            System.out.println(loopNode.data);
        }
        else{
            System.out.println("No");
        }

    }
}
