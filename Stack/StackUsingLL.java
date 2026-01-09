package Stack;

class StackNode {
    int data;
    StackNode next;

    StackNode(int data, StackNode next) {
        this.data = data;
        this.next = next;
    }

    StackNode(int data) {
        this.data = data;
    }
    
}
class StackLL{
 StackNode top;
 int size;
 
 StackLL() {
    this.top = null;
    this.size = 0;
  }

 public void push(int ele){
    StackNode element=new StackNode(ele);
    element.next=top;
    top=element;
    System.out.println("Element push");
    size++;
    
 }
  
 public int stackPop(){
    if(top==null) return -1;
    int topdata=top.data;
    StackNode temp=top;
    top=top.next;
    return topdata;
 }

 public void printStack() {
    
    StackNode current = top;
    while (current != null) {
      System.out.print(current.data + " ");
      current = current.next;
    }
    System.out.println();
  }

}

public class StackUsingLL{
    public static void main(String[] args) {
        StackLL s=new StackLL();
        s.push(2);
        s.push(4);
        s.push(1);
        s.stackPop();
        s.printStack();


    }
}