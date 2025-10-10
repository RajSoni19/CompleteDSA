package LinkedList;

class LNode {
    // Data stored in the node
    int data;
    // Pointer to the next node
    LNode next;
    // Pointer to a random node in the list
    LNode random;

    // Constructors for Node class
    LNode() {
        this.data = 0;
        this.next = null;
        this.random = null;
    }

    LNode(int x) {
        this.data = x;
        this.next = null;
        this.random = null;
    }

  LNode(int x, LNode nextNode, LNode randomNode) {
        this.data = x;
        this.next = nextNode;
        this.random = randomNode;
    }
}

public class CopyLLwithrandomnext {

    // public static LNode cloneLL(LNode head){
    //     LNode temp=head;
    //     HashMap<LNode,LNode> map=new HashMap<>();
    //     while(temp!=null){
    //         LNode newnode=new LNode(temp.data);
    //         map.put(temp,newnode);
    //         temp=temp.next;
    //     }
    //     temp=head;
    //     while(temp!=null){
    //         LNode copyNode=map.get(temp);
    //         copyNode.next=map.get(temp.next);
    //         copyNode.random=map.get(temp.random);
    //         temp=temp.next;
    //     }
    //     return map.get(head);
    // }

     static void insertcopy(LNode head){
      LNode temp=head;
      while(temp!=null){
        LNode nextElement=temp.next;
        LNode copy=new LNode(temp.data);
        copy.next=nextElement;
        temp.next=copy;
        temp=nextElement;
      }    
    }

     static  void connectradom(LNode head){
        LNode temp=head;
        while(temp!=null){
            LNode copynode=temp.next;
            if(temp.random!=null){
                copynode.random=temp.random.next;
            }else{
                copynode.random=null;
            }
            temp=temp.next.next;
        }
    }

    static  LNode deepcopy(LNode head){
        LNode temp=head;
        LNode dumm=new LNode(-1);
        LNode res=dumm;
        while(temp!=null){
            res.next=temp.next;
            res=res.next;

            temp.next=temp.next.next;
            temp=temp.next;
        }
        return dumm.next;
    }

    static LNode cloneLL(LNode head){
        if(head==null) return null;
        insertcopy(head);
        connectradom(head);
        return deepcopy(head);
    }

    public static void printOriginalLinkedList(LNode head){
        while(head!=null){
            System.out.print("Data: " + head.data);
            if(head.random != null){
                System.out.println("Random " +head.random.data);
            }
            head=head.next;
        }
    }
    public static void main(String[] args) {
        LNode head = new LNode(7);
        head.next = new LNode(14);
        head.next.next = new LNode(21);
        head.next.next.next = new LNode(28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        System.out.println("Original Linked List with Random Pointers:");
       printOriginalLinkedList(head);

        // Clone the linked list
        LNode clonedList = cloneLL(head);

        System.out.println("\nCloned Linked List with Random Pointers:");
       printOriginalLinkedList(clonedList);
    }
}
