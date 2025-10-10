package LinkedList;

import java.util.ArrayList;
import java.util.Collections;

class FNode {
    int data;
    FNode next;
    FNode child;

    // Constructors to initialize the
    // data, next, and child pointers
    FNode() {
        data = 0;
        next = null;
        child = null;
    }

    FNode(int x) {
        data = x;
        next = null;
        child = null;
    }

    FNode(int x, FNode nextNode, FNode childNode) {
        data = x;
        next = nextNode;
        child = childNode;
    }
}

public class FlattenLL {

    static FNode convertArrToLinkedList(ArrayList<Integer> arr) {
        // Create a dummy node to serve as
        // the head of the linked list
        FNode dummyNode = new FNode(-1);
        FNode temp = dummyNode;

        // Iterate through the ArrayList and
        // create nodes with elements
        for (int i = 0; i < arr.size(); i++) {
            // Create a new node with the element
            temp.child = new FNode(arr.get(i));
            // Move the temporary pointer
            // to the newly created node
            temp = temp.child;
        }
        // Return the linked list starting
        // from the next of the dummy node
        return dummyNode.child;
    }

    static void printOriginalLinkedList(FNode head, int depth) {
        while (head != null) {
            System.out.print(head.data);

            // If child exists, recursively
            // print it with indentation
            if (head.child != null) {
                System.out.print(" -> ");
                printOriginalLinkedList(head.child, depth + 1);
            }

            // Add vertical bars
            // for each level in the grid
            if (head.next != null) {
                System.out.println();
                for (int i = 0; i < depth; ++i) {
                    System.out.print("| ");
                }
            }
            head = head.next;
        }
    }

    static void printLinkedList(FNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.child;
        }
        System.out.println();
    }

    //Brute
    // public static FNode flattenLinkedList(FNode head) {
    //     if (head == null) {
    //         return null; // Handle empty linked list
    //     }

    //     ArrayList<Integer> arr = new ArrayList<>();
    //     while (head != null) {
    //        FNode t2 = head;
    //         while (t2 != null) {
    //             arr.add(t2.data);
    //             t2 = t2.child;
    //         }
    //         head = head.next;
    //     }

    //     Collections.sort(arr); // Sort the collected elements
    //     return convertArrToLinkedList(arr); // Convert sorted elements back to a linked list
    // }

    public static FNode merge(FNode list1,FNode list2){
        FNode dum=new FNode(-1);
        FNode res=dum;
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                res.child=list1;
                res=list1;
                list1=list1.child;
            }
            else{
                res.child=list2;
                res=list2;
                list2=list2.child;  
            }
            res.next=null;
        }
        if(list1!=null){
            res.child=list1;
        }
        else{
            res.child=list2;
        }

        if(dum.child!=null){
            dum.child.next=null;
        }
        return dum.child;

    }

    public static FNode flattenNode(FNode head){
        if(head==null || head.next==null){
            return head;
        }
        FNode mergehead=flattenNode(head.next);
        head=merge(head, mergehead);
        return head;
    }

    public static void main(String[] args) {
        FNode head = new FNode(5);
        head.child = new FNode(14);

        head.next = new FNode(10);
        head.next.child = new FNode(4);

        head.next.next = new FNode(12);
        head.next.next.child = new FNode(20);
        head.next.next.child.child = new FNode(13);

        head.next.next.next = new FNode(7);
        head.next.next.next.child = new FNode(17);

        // Print the original
        // linked list structure
        System.out.println("Original linked list:");
        printOriginalLinkedList(head, 0);

        // Flatten the linked list
        // and print the flattened list
        FNode flattened = flattenNode(head);
        System.out.println("\nFlattened linked list: ");
        printLinkedList(flattened);
    }
}