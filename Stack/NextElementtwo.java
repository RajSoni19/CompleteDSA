package Stack;
import java.util.*;
public class NextElementtwo {
    public static void main(String[] args) {
        int []nums={1,2,1};
        int n=nums.length;
        int result[]=new int[n];
        // for(int i=0;i<n;i++){
        //    int curr=-1;
        //     for(int j=1;j<n;j++){
        //          int ind=(i+j)%n;
        //          if(nums[ind]>nums[i]){
        //             curr=nums[ind];
        //             break;
        //          }

        //     }
        //     result[i]=curr;
        // }


        Stack<Integer> s=new Stack<>();
       for(int i=2*n-1;i>=0;i--){
        int ind=i%n;
        int curr=nums[ind];
        while(!s.isEmpty()&&s.peek()<=curr){
            s.pop();
        }

        if(i<n){
            if(s.isEmpty()){
                result[ind]=-1;

            }else{
               result[ind]=s.peek();
            }
        }
        s.push(curr);
       }
       
        for(int i=0;i<n;i++){
            System.out.println(result[i]);
        }
    }
}
