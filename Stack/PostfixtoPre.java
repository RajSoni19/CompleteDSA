package Stack;
import java.util.*;
public class PostfixtoPre {

    public static String postintopre(String postfix){
        Stack<String> s=new Stack<>();
        int n=postfix.length();
        for(int i=0;i<n;i++){
            char c=postfix.charAt(i);
            if(Character.isLetterOrDigit(c)){
                s.push(String.valueOf(c));
            }
            else{
                String op1=s.pop();
                String op2=s.pop();
                s.push(c+op2+op1);
            }
        }

        return s.peek();

    }
    public static void main(String[] args) {
        String postfix="ab+";
        System.out.println(postintopre(postfix));
    }
}
