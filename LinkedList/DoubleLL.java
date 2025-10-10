package  LinkedList;

class Node {
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1) {
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.back = null;
    }
}

public class DoubleLL {

    private static Node convertArr2DLL(int arr[]) {
        Node head = new Node(arr[0]);
        Node prev=head;
        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i],null,prev);
            prev.next=temp;
            prev=temp;
        }
        return head;
    }

    private static void PrintNode(Node head){
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }

    private static Node deletehead(Node head){
        if(head==null || head.next==null) return null;
        
        Node prev=head;
        head=head.next;
        head.back=null;
        prev.next=null;
        return head;
    }
    
    private static Node deleteTail(Node head){

        if(head==null || head.next==null) return null;
        Node tail=head;
        while(tail.next!=null){
           tail= tail.next;
        }
        Node prev=tail.back;
        prev.next=null;
        tail.back=null;
        return head;
    

      
    }

    private static Node deleteKNode(Node head,int k){
        if(head==null) return head;
        int cnt=0;
        Node temp=head;
        while(temp!=null){
            cnt++;
            if(cnt==k) break;
            temp=temp.next;
        }

        Node prev=temp.back;
        Node front=temp.next;
        if(prev==null && front==null){
            return null;
        }

        else if(prev==null){
           return deletehead(head);
        }

        else if(front==null){
            return deleteTail(head);
        }
         
        prev.next=front;
        front.back=prev;
        temp.next=null;
        temp.back=null;

        return head;

    }

    private static void deleteNode(Node temp){
        Node prev=temp.back;
        Node front=temp.next;
        if(front==null){
            prev.next=null;
            temp.back=null;
            return;
        }

        prev.next=front;
        front.back=prev;
        temp.next=null;
        temp.back=null;
    }

    private static Node insertHeadDll(Node head,int val){
        Node temp=new Node(val);
        temp.next=head;
        temp.back=null;
        head.back=temp;
        return temp;

    }

    private static Node insertBeforeTailDll(Node head ,int val){
        if(head.next==null){
            return insertHeadDll(head, val);
        }
        Node temp=new Node(val);
        Node tail=head;
        while(tail.next!=null){
            tail=tail.next;
        }
        
        Node prev=tail.back;
        prev.next=temp;
        temp.next=tail;
        temp.back=prev;
        tail.back=temp; 
       
        return head;

    }

    private static Node insertAtkNodeDll(Node head,int ele,int k){
        if(k==1){
            return insertHeadDll(head, k);
        }
        int cnt=0;
        Node temp=head;
        
        while(temp!=null){
            cnt++;
            if(cnt==k) break;
            temp=temp.next;
        }

        Node prev=temp.back;
        Node n=new Node(ele);
        prev.next=n;
        n.back=prev;
        n.next=temp;
        temp.back=n;
        return head;

    }

    private static void insertBeforeVal(Node node,int ele){
            Node prev=node.back;
            Node n=new Node(ele);
            node.back=n;
            n.next=node;
            prev.next=n;
            n.back=prev;
            // return Node;
            // return Node;
            

    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 6, 8 };
        Node head = convertArr2DLL(arr);
        // head=deletehead(head);
        // head=deleteTail(head);
        // head=deleteKNode(head, 2);
        // deleteNode(head.next);
        // head=insertHeadDll(head, 1);
        // head=insertBeforeTailDll(head, 7);
        // head=insertAtkNodeDll(head,1 , 3);
        insertBeforeVal(head.next, 6);
        PrintNode(head);
    } 
}
