package Stack;

class stack{
    int size=100;
    int arr[]=new int[size];
    int top=-1;
    void push(int x){
        top++;
        arr[top]=x; 
    }
    int pop(){
        int x=arr[top];
        top--;
        return x;
    }
    int top(){
        return arr[top];
    }
    int size(){
        return top+1;

    }
}
public class StackusingArray {
    public static void main(String[] args) {
        stack s=new stack();
        s.push(2);
        s.push(0);
        System.out.println(s.size() );
    }
}
