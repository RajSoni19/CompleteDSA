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


public class InsertLL {
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

    private static Node Inserthead(Node head,int val){
        Node temp=new Node(val,head);
        return temp;
    }

    private static Node insertTail(Node head,int val){
        if(head==null) return new Node(val,head);
        Node temp=head;
        Node n=new Node(val);
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=n;
        return head;
    }


    private static Node insertAtK(Node head,int ele,int k){
        Node n=new Node(ele);
        if(head==null){
            if(k==1){
                return n;    
            }
            else{
                return head;
            }
        }

        if(k==1){
            return new Node(ele,head);
        }

        int cnt=0;
        Node temp=head;
        while(temp!=null){
            cnt++;
            if(cnt==(k-1)){
                n.next=temp.next;
                temp.next=n;
                break;
            }
            temp=temp.next;
        }
        return head;

    }
    private static Node insertbeforeVal(Node head,int ele,int val){
        Node n=new Node(ele);
        if(head==null){
        return null;
        }

        if(head.data==val){
            return new Node(ele,head);
        }

       
        Node temp=head;
        while(temp.next!=null){
        
            if(temp.next.data==val){
                n.next=temp.next;
                temp.next=n;
                break;
            }
            temp=temp.next;
        }
        return head;

    }
    public static void main(String[] args) {
        int arr[] = { 2, 5, 6, 8 };
        Node head = convertArr2LL(arr);
        // head=Inserthead(head, 1);
        // head=insertTail(head, 1);
        // head=insertAtK(head, 10, 2);
        head=insertbeforeVal(head, 15, 6);

         Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
