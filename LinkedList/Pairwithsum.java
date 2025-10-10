package LinkedList;

import java.util.ArrayList;
import java.util.List;

class DNode {
    int data;
    DNode next;
    DNode back;

    // Constructor with all parameters
    DNode(int data1, DNode next1, DNode back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    // Constructor with just data
    DNode(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class Pairwithsum {

    // Convert an array to a doubly linked list
    public static DNode convertArr2DLL(int arr[]) {
        DNode head = new DNode(arr[0]);
        DNode prev = head;
        for (int i = 1; i < arr.length; i++) {
            DNode temp = new DNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    // Print the doubly linked list
    public static void PrintNode(DNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    // BRUTE
    // Find all pairs with the given sum in the doubly linked list
    // public static List<int[]> Pairsum(DNode head, int sum) {
    // DNode temp1 = head;
    // List<int[]> result = new ArrayList<>();

    // while (temp1 != null) {
    // DNode temp2 = temp1.next;
    // while (temp2 != null) {
    // if (temp1.data + temp2.data == sum) {
    // result.add(new int[]{temp1.data, temp2.data}); // Store the pair as an array
    // }
    // temp2 = temp2.next;
    // }
    // temp1 = temp1.next; // Move to the next node
    // }

    // return result;
    // }
    public static DNode findtail(DNode head) {
        DNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public static List<int[]> Pairsum(DNode head, int sum) {
        DNode left = head;
        DNode right = findtail(head);
        List<int[]> result = new ArrayList<>();
        while(left.data<right.data){
            if(left.data+right.data==sum){
                result.add(new int[]{left.data,right.data});
                left=left.next;
                right=right.back;
            }
            else if(left.data+right.data<sum){
                left=left.next;
            }
            else{
                right=right.back;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 6, 8 };
        // Create doubly linked list
        DNode head = convertArr2DLL(arr);

        // Print original list
        System.out.println("Original List:");
        PrintNode(head);

        // Find pairs with the given sum
        int sum = 10;
        List<int[]> pairs = Pairsum(head, sum);

        // Print the pairs
        System.out.println("Pairs with sum " + sum + ":");
        for (int[] pair : pairs) {
            System.out.println(pair[0] + ", " + pair[1]);
        }
    }
}