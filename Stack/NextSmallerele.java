package Stack;
import java.util.*;
public class NextSmallerele {
    public static void main(String[] args) {
        int arr[]={4,8,5,2,25};
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty()&&s.peek()>arr[i]){
                s.pop();
            }

            if(s.isEmpty()) ans[i]=-1;
            else ans[i]=s.peek();

            s.push(arr[i]);
        }

        for(int i=0;i<n;i++){
            System.out.println(ans[i]);
        }
    }
}
