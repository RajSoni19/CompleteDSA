package Stack;

import java.util.*;

public class PrefixtoInfix {

    public static String pretoInfix(String prefix){
        Stack<String> s=new Stack<>();
        int n=prefix.length();
        for(int i=n-1;i>=0;i--){
            char c=prefix.charAt(i);
            if(Character.isLetterOrDigit(c)){
                s.push(String.valueOf(c));
            }
            else{
                String op1=s.pop();
                String op2=s.pop();
                s.push("("+op1+c+op2+")");
            }

        }
        return s.peek();
    }
    public static void main(String[] args) {
        String prefix="+ab";
        System.out.println(pretoInfix(prefix));
    }
}
