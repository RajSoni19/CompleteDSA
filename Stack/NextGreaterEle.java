package Stack;
import java.util.*;
public class NextGreaterEle{
    public static void main(String[] args) {
         int arr[]={1,3,2,4};
         int n=arr.length;
        //  int ans[]=new int[n];
        //  for(int i=0;i<n;i++){
        //      int neg=-1;
        //     for(int j=i+1;j<n;j++){
        //         if(arr[j]>arr[i]){
        //             neg=arr[j];
        //             break;
        //         }
        //     }
        //     ans[i]=neg;
        //  }

        //  for(int i=0;i<n;i++){
        //     System.out.println(ans[i]);
        //  }
         
        Stack<Integer> st=new Stack<>();
        int res[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }

            if(st.isEmpty()) res[i]=-1;

            else res[i]=st.peek();

            st.push(arr[i]);

        }

        for(int i=0;i<n;i++){
            System.out.println(res[i]);
        }
         
    }
}