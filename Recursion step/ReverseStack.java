import java.util.Stack;

public class ReverseStack {

    public static void reverseit(Stack<Integer> s,int element){
        if(s.isEmpty()){
            s.push(element);
        }
        else{
            int top=s.pop();
            reverseit(s, element);
            s.push(top);
        }
    }

    public static void reverseitStack(Stack<Integer> s){
        if(!s.isEmpty()){
            int top=s.pop();
            reverseitStack(s);
            reverseit(s,top);
        }
    }


    public static void main(String[] args) {
         Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s); // Print stack to avoid unuse(d variable warning

        reverseitStack(s);
for (int i = 0; i < s.size(); i++) {
    System.out.print(s.get(i) + " ");
}

    }
}
