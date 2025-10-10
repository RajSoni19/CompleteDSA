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

public class SortLL {

     //     //BRUTE 
    // static Node sortN(Node head){

    //     //    ArrayList<Integer> ans=new ArrayList<>();
    //     //    Node temp=head;
    //     //    while(temp!=null){
    //     //     ans.add(temp.data);
    //     //     temp=temp.next;
    //     //    }
    //     //    Collections.sort(ans);
    //     //    temp=head;
    //     //    for(int i=0;i<ans.size();i++){
    //     //     temp.data=ans.get(i);
    //     //     temp=temp.next;
    //     //    }
    //     //    return head;
       
    // }

    // Function to find the middle of the linked list
    static Node findmiddle(Node head) {
        Node slow = head; // Slow pointer moves one step at a time
        Node fast = head.next; // Fast pointer moves two steps at a time
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer
            fast = fast.next.next; // Move fast pointer
        }
        return slow; // Slow pointer will point to the middle node
    }

    // Function to merge two sorted linked lists into one sorted list
    static Node mergeSorted(Node list1, Node list2) {
        Node dummy = new Node(-1); // Dummy node to simplify merging
        Node temp = dummy; // Temp pointer to build the merged list

        // Merge the two lists by comparing their data
        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                temp.next = list1; // Add list1's node to the merged list
                list1 = list1.next; // Move list1 pointer
            } else {
                temp.next = list2; // Add list2's node to the merged list
                list2 = list2.next; // Move list2 pointer
            }
            temp = temp.next; // Move temp pointer
        }

        // If any nodes are left in list1, add them to the merged list
        if (list1 != null) {
            temp.next = list1;
        }
        // If any nodes are left in list2, add them to the merged list
        else {
            temp.next = list2;
        }

        return dummy.next; // Return the merged list (skipping the dummy node)
    }

    // Function to sort the linked list using merge sort
    static Node sortN(Node head) {
        // Base case: If the list is empty or has only one node, it's already sorted
        if (head == null || head.next == null) return head;

        // Find the middle of the list
        Node middle = findmiddle(head);

        // Split the list into two halves
        Node right = middle.next; // Right half starts from the node after the middle
        middle.next = null; // Break the list into two halves
        Node left = head; // Left half starts from the head

        // Recursively sort the left and right halves
        left = sortN(left);
        right = sortN(right);

        // Merge the two sorted halves
        return mergeSorted(left, right);
    }

    // Function to print the linked list
    static void PrintList(Node head) {
        for (Node curr = head; curr != null; curr = curr.next)
            System.out.print(curr.data + "-->");
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 9 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(9);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Sort the linked list
        head = sortN(head);

        // Print the sorted linked list
        PrintList(head);
    }
}