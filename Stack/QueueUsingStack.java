package Stack;
import java.util.*;

class MyQueue{
    Stack<Integer> input=new Stack();
    Stack<Integer> output=new Stack<>();
    public void push(int x){
        System.out.println("The element to be push is"+x);
        input.push(x);
    }

    public int pop(){
        // if(output.empty()){
        //     while(input.empty()==false){
        //         output.push(input.peek());
        //         input.pop();
        //     }

          
        // }

        //   int x=output.peek();
        //     output.pop();
        //     return x;
        peek();
        return output.pop();
    }


    public int peek(){
        if(output.empty()){
            while(input.empty()==false){
                output.push(input.peek());
                input.pop();
            }
        }
        return output.peek();
    }

    int size(){
        return (output.size()+input.size());
    }
}
public class QueueUsingStack {
    public static void main(String[] args) {
        MyQueue q=new MyQueue();
        q.push(3);
        q.push(8);
        q.push(3);
        q.pop();
        System.out.println(q.size());
    }
}
