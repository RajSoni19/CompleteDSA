package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Rearrangeelesign {
    public static void Rearrange(ArrayList<Integer> arr){
             int n=arr.size();
             ArrayList<Integer> ans=new ArrayList<>(Collections.nCopies(n,0));
             int pos=0;
             int neg=1;
             for(int i=0;i<n;i++){
                if(arr.get(i)<0){
                    ans.set(neg,arr.get(i));
                    neg+=2;
                }
                else{
                    ans.set(pos, arr.get(i));
                    pos+=2;
                }
             }

             System.out.println(ans);

    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(1,4,-2,-5));
        Rearrange(arr);
      

    }
}
