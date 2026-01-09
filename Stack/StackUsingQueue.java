package Stack;

import java.util.*;

class mystack{
  Queue <Integer> q=new LinkedList<>();
  void push(int x){
    q.add(x);
    for(int i=0;i<q.size()-1;i++){
        q.add(q.remove());
    }
  }

  int pop(){
    return q.remove();
  }

  int top(){
    return q.peek();
  }

  int size(){
    return q.size();
  }
}
public class StackUsingQueue {
    public static void main(String[] args) {
        mystack s=new mystack();
        s.push(3);
        s.push(1);
        s.push(4);
       System.out.println(s.size()); 

        
    }
}
