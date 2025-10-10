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

public class LinkedList {
    public static void main(String[] args) {
        int arr[]={2,5,6,8};
        Node y=new Node(arr[2]);
        System.out.println(y.data);
    }
}
