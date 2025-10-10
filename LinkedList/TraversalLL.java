package LinkedList;


class Node{
    int data;
    Node next;

    Node(int data1,Node next1){
        this.data=data1;
        this.next=next1;
    }

    Node(int data){
        this.data=data;
        this.next=null;
    }
}



public class TraversalLL {

    private static Node convertArr2LL(int[] arr){
      Node head=new Node(arr[0]);
      Node mover=head;
      for(int i=1;i<arr.length;i++){
        Node temp=new Node(arr[i]);
        mover.next=temp;
        mover=temp;
      }
      return head;
    }

    private static int lenghtLL(Node head){
        int cnt=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            cnt++;
        }
        return cnt;
    }

    private static int Check(Node head,int val){
        Node temp=head;
        while(temp!=null){
            if(temp.data==val) return 1;
            temp=temp.next;
        }
        return 0;
    }
    public static void main(String[] args) {
        int arr[]={2,5,6,8};
        Node head=convertArr2LL(arr);
        System.out.println(lenghtLL(head));
        System.out.println(Check(head, 80));
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }   
    }
}
