package LinkedList;




class Node {
    int data;
    Node next;

    Node(int data1, Node next1) {
        this.data = data1;
        this.next = next1;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveKelement {

    private static Node convertArr2LL(int[] arr) {
        Node head = new Node(arr[0]);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    // public static Node DeleteHead(Node head) {
    //    if(head==null) return head;
    //     head = head.next;

    //     return head;
    // }

    // public static Node DeleteTail(Node head){
    //     if(head==null || head.next==null) return null;
    //     Node temp=head;
    //     while(temp.next.next!=null){
    //         temp=temp.next;
    //     }

    //     temp.next=null;
    //     return head;
        
    // }


    private static Node removeK(Node head,int k){
        if(head==null) return head;
        if(k==1){
            return head.next;
        }
        int cnt=0;
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }

    
    private static Node removeEle(Node head,int k){
        if(head==null) return head;
        if(head.data==k){
            return head.next;
        }
       
        Node temp=head;
        Node prev=null;
        while(temp!=null){
            
            if(temp.data==k){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }

    
    public static void main(String[] args) {

        int arr[] = { 2, 5, 6, 8 };
        Node head = convertArr2LL(arr);
        // head=DeleteTail(head);
        // head = DeleteHead(head);
        head=removeK(head, 3); //Base on Position

        // head=removeEle(head, 5);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
