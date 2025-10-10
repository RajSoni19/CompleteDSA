package LinkedList;

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
public class DeletealloccurenceDLL {

     public static DNode convertArr2DLL(int arr[]) {
        DNode head = new DNode(arr[0]);
        DNode prev = head;
        for(int i = 1; i < arr.length; i++) {
            DNode temp = new DNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }
    public static void PrintNode(DNode head) {
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static DNode deleteheadAll(DNode head,int key){
             DNode temp=head;
             while(temp!=null){
                if(temp.data==key){
                    if(temp==head){
                        head=temp.next;
                        
                    }                         
                
                DNode nextNode=temp.next;
                DNode prevNode=temp.back;
                if(nextNode!=null) nextNode.back=prevNode;
                if(prevNode!=null) prevNode.next=nextNode;
                temp=nextNode;
                }
                else{
                    temp=temp.next;
                }

             
             }
             return head;
    }
    public static void main(String[] args) {
         int arr[] = {2, 5, 6, 8};
        // Create doubly linked list
        DNode head = convertArr2DLL(arr);
        // Print original list
        System.out.println("Original List:");   
        PrintNode(head);
       
        head=deleteheadAll(head, 5);
        // Print reversed list
        System.out.println("\nUpdated List:");
        PrintNode(head);
    }   
}
