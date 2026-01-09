package Stack;

import java.util.*;

public class PostfixtoInfix {

    public static String postfixintoIn(String postfix){
        Stack<String> s=new Stack<>();
        int n=postfix.length();
        for(int i=0;i<n;i++){
            char c=postfix.charAt(i);
            if(Character.isLetterOrDigit(c)){
                s.push(String.valueOf(c)); //converted into string
            }else{
                String op2=s.pop();
                String op1=s.pop();
                s.push("(" +  op1 + c + op2 + ")");
            }
        }
        return s.peek();
    }
    public static void main(String[] args) {
         String postfix = "AB*C+";
         System.out.println(postfixintoIn(postfix));

    }
}
