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
public class LengthofLLCycle {

    public static int lenghtofllc(Node slow,Node fast){
         int cnt=1;
         fast=fast.next;
         while(slow!=fast){
            cnt++;
            fast=fast.next;
         }
        return cnt;

    }

    public static int findcyclell(Node head){
        // Node temp=head;
        // HashMap<Node,Integer> mp=new HashMap<>();
        // int timer=0;
        // while(temp!=null){
        //     if(mp.containsKey(temp)){
        //         int loopll=timer-mp.get(temp);
        //         return loopll;
        //     }
        //     mp.put(temp,timer);
        //     temp=temp.next;
        //     timer++;
        // }
        // return 0;

        Node slow=head;
        Node fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return lenghtofllc(slow,fast);
            }

        }
        return 0;
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
         int lengthll=findcyclell(head);
         System.out.println(lengthll);
    }
}
