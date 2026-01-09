package BitManipulation;
import java.util.*;
public class PrintAllDivisor {
    public static void main(String[] args) {
        int n=36;
        ArrayList<Integer> ans=new ArrayList<>();

        //Brute
        // for(int i=1;i<=n;i++){
        //   if(n%i==0) ans.add(i);
        // }

        //Optimal
        for(int i=1;i<=(int)Math.sqrt(n);i++){
            if(n%i==0){
             ans.add(i);
             if(n/i!=i) ans.add(n/i);
            }    
        }
        Collections.sort(ans);

        System.out.println(ans);
    }
}
