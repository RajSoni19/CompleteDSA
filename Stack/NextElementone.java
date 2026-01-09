package Stack;
import java.util.*;
public class NextElementone {
    public static void main(String[] args) {
        int num1[]={4,1,2};
        int num2[]={1,3,4,2};
        Stack<Integer> s=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();


        for(int num:num2){
            while(!s.isEmpty()&&s.peek()<num){
                map.put(s.pop(), num);
            }

            s.push(num);
        }

        while(!s.isEmpty()){
            map.put(s.pop(),-1);
        }

        int result[]=new int[num1.length];
        for(int i=0;i<num1.length;i++){
            result[i]=map.get(num1[i]);
        }

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }



    }
}
