package Stack;

import java.util.Stack;

public class OnlineStockSpan {

    public static int[] findpge(int[] arr){
        int n=arr.length;
        int ans[]=new int[n];

        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            int current=arr[i];
            while(!s.isEmpty()&&arr[s.peek()]<=current){
               s.pop();
            }
            if(s.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=s.peek();
            }
            s.push(i);
        }
        return ans;
    }

    public static int[] getmaxstock(int arr[],int n){
        int ans[]=new int[n];

        int pge[]=findpge(arr);
        for(int i=0;i<n;i++){
            ans[i]=i-pge[i];
        }

        return ans;

 
        //BRUTE
        // for(int i=0;i<n;i++){
        //     int cnt=0;
        //     for(int j=i;j>=0;j--){
        //         if(arr[j]<=arr[i]){
        //             cnt++;
        //         }
        //         else{
        //             break;
        //         }
        //     }
        //     ans[i]=cnt;
        // }
        // return ans;
    }
    public static void main(String[] args) {
       int[] arr = {120, 100, 60, 80, 90, 110, 115};
       int n=arr.length;
       int  ans[]=getmaxstock(arr,n);
       for(int i=0;i<n;i++){
         System.out.print(ans[i]+ " ");
       }
    }
}
