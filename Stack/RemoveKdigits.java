package Stack;
import java.util.*;
public class RemoveKdigits {

    public static String getdigit(String num,int k){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<num.length();i++){
            char digit=num.charAt(i);
            while(!s.isEmpty()&&k>0&&s.peek()>digit){ //giving small digit more priority because want ouput as small number as possible  so remove large number from stack
                s.pop();
                k--;
            }

            s.push(digit);
        }

        while(k>0){ //if k forgot to remove then remove last k number of digit
            s.pop();
            k--;
        }
        

        //Edge case
        if(s.isEmpty()) return "0";
        
        StringBuilder res=new StringBuilder();
        while(!s.isEmpty()){
            res.append(s.pop());
        }

        //trim the leading zero
        while(res.length()>0 && res.charAt(res.length()-1)=='0'){
            res.deleteCharAt(res.length()-1);
        }

        res.reverse();

        if(res.length()==0) return "0";

        return res.toString();

    }
    public static void main(String[] args) {
        String num="541892";
        int k=2;
        System.out.println(getdigit(num,k));
    }
}
