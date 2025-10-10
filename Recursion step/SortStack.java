import java.util.Stack;

public class SortStack {

    public static void sortrStack(Stack<Integer> s){
        if(!s.isEmpty()){
            int top=s.pop();
            sortrStack(s);
            insertSort(s,top);
        }
    }

    public static void insertSort(Stack<Integer> s,int element){
        if(s.isEmpty()  || s.peek()<=element){
            s.push(element);
        }
        else{
            int top=s.pop();
            insertSort(s, element);
            s.push(top);
        }
    }


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(6);
        s.push(1);
        s.push(2);
        System.out.println(s); // Print stack to avoid unuse(d variable warning

        sortrStack(s);

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
        System.out.println();
    }
}
