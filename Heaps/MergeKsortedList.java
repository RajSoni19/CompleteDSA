package Heaps;

import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val=val;
        this.next=next;
    }
}
public class MergeKsortedList {


    // Brute : 
    // public static ListNode mergeit(ListNode[] lists){
    //     List<Integer> allval=new ArrayList<>();

    //     //Traverse each linked list and store it
    //     for(ListNode head:lists){
    //         while(head!=null){
    //          allval.add(head.val);
    //          head=head.next;
    //         }
    //     }

    //     Collections.sort(allval); //then sort it

    //     ListNode dummy=new ListNode(0); //create linked list for sorted list
    //     ListNode curr=dummy;
    //     for(int val:allval){
    //         curr.next=new ListNode(val);
    //         curr=curr.next;
    //     }
    //     return dummy.next;
    // }

    //Optimal
    public static ListNode mergeit(ListNode[] lists){
        PriorityQueue<ListNode> pq=new PriorityQueue<>(  //minheap of ll
            (a,b)-> a.val - b.val
        );

        for(ListNode node:lists){
            if(node!=null) pq.add(node); //push head of non null list to heap
        }

        ListNode dummy=new ListNode(0); //create dummy node to build ans list 
        ListNode tail=dummy;
        while(!pq.isEmpty()){
         ListNode small=pq.poll(); //extract node with smallest val

         //add it to result list
         tail.next=small;
         tail=tail.next;

         //if there is next node,push it into heap
         if(small.next!=null){
            pq.add(small.next);
         }
        }
        return dummy.next; //return head

    }
    public static void main(String[] args) {
         ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);

        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);

        ListNode c = new ListNode(2);
        c.next = new ListNode(6);

        ListNode[] lists = new ListNode[]{a, b, c};

        ListNode ans=mergeit(lists);
        while(ans!=null){
           System.out.println(ans.val+" ");
           ans=ans.next;
        }
    }
}
