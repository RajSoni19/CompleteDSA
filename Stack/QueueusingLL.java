package Stack;

class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data, QueueNode next) {
        this.data = data;
        this.next = next;
    }

    QueueNode(int data) {
        this.data = data;
    }
    
}

class QueueLL{


    QueueNode start;
    int size;
    QueueNode end;

    QueueLL(){
        int size=0;
        QueueLL start,end=null;
    }

    public void enque(int val){
        QueueNode temp;
        temp=new QueueNode(val);
        if(temp==null){
            System.out.println("Queue is full");
        }

        else{

            if(start==null){
                start=temp;
                end=temp;

            }
            else{
             end.next=temp;
             end=temp;
            }
            System.out.println(val+"Inserted into Queue");
            size++;
        }
    }

    public void dequeue(){
        if(start==null){
            System.out.println("Queue is empty");
        }

        else{
           
            System.out.println(start.data+"Removed from queue");
            QueueNode temp=start;
            start=start.next;
            size--;
        }
    }



    
}
public class QueueusingLL { 
    public static void main(String[] args) {
        QueueLL s=new QueueLL();
        s.enque(3);
        s.enque(1);
        s.enque(10);
        s.dequeue();
        System.out.println("Size of Queue is "+s.size);
    }
}
