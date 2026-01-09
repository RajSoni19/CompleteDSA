package Stack;
import java.util.*;

// class Pair{
//     int x,y;
//     Pair(int x,int y){
//         this.x=x;
//         this.y=y;
//     }
// }
// public class MinStack {
  
//     Stack<Pair> st;

//     public MinStack(){
//         st=new Stack<>();
//     }

//     public void push(int x){
//         int min=x;
//         if(st.isEmpty()){
//             min=x;
//         }
//         else{
//             min=Math.min(st.peek().y, x);
//         }
//         st.push(new Pair(x, min));
//     }

//     public void pop(){
//         st.pop();
//     }

//     public int top(){
//         return st.peek().x;
//     }

//     public int getMin(){
//         return st.peek().y;
//     }

//     public static void main(String[] args) {
//         MinStack s = new MinStack();
//         s.push(3);
//         s.push(5);
//         System.out.println("Top element: " + s.top());
//         System.out.println("Minimum element: " + s.getMin());
//     }
// }


// SOL2
public class MinStack{

    Stack<Long> st=new Stack<Long>();
    Long mini;

    public MinStack(){
        mini=Long.MAX_VALUE;
    }

    public void push(int value){
        Long val=Long.valueOf(value);
        if(st.isEmpty()){
            mini=val;
            st.push(val);
        }else{
            if(val<mini){
                st.push(2*val-mini); //if new value to be inserted is smaller then min then insert updated value as per formula
                mini=val;
            }else{
                st.push(val);
            }
        }

    }

    public void pop(){
        if(st.isEmpty()) return ;
        Long val=st.pop();
        if(val<mini){
            mini=2*mini-val; //After poping out value (here 8) , then update mini to previous min by using formula(here 12)
        }
    }

    public int top(){
        Long val=st.peek();
        if(val<mini){
            return mini.intValue(); //if value is less than min then return min value(here 12)
        }
        return val.intValue();
    }

    public int getMin(){
        return mini.intValue();
    }

    

    public static void main(String[] args) {
        MinStack s=new MinStack();
        s.push(12);
        s.push(15);
        s.push(10);
        s.pop();
        System.out.println(s.getMin());
    }
}
