package Stack;
 //BRUTE FORCE
        // for(int i=0;i<n;i++){
        //     int maxi=arr[i];
            
        //     int mini=arr[i];
        //     for(int j=i;j<n;j++){
        //         maxi=Math.max(maxi,arr[j]);
        //         mini=Math.min(mini,arr[j]);
        //         int diff=maxi-mini;
        //         sum+=diff;
        //     }
        // }
        // return sum;

        //OPTIMAL
import java.util.Stack;

public class SumofSubarrayRanges {


    public static int[] findnge(int arr[]){
        int n=arr.length;
        int ans[]=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty()&&arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i]=n;
            }
            else{
                ans[i]=s.peek();
            }
            s.push(i);
        }
        return ans;
    }

    public static int[] findpge(int arr[]){
        int n=arr.length;
        int ans[]=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty()&&arr[s.peek()]<arr[i]){
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
 

    public static int[] findnse(int arr[]) {
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty())
                ans[i] = n;
            else
                ans[i] = s.peek();
            s.push(i);
        }
        return ans;
    }

    public static int[] findpse(int arr[]) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >arr[i]) {
                s.pop();
            }

            if (s.isEmpty())
                ans[i] = -1;
            else
                ans[i] = s.peek();

            s.push(i);
        }
        return ans;

    }

    public static int getmaxi(int arr[]){
        int n=arr.length;
        int sum=0;
        int []nge=findnge(arr);
        int []pge=findpge(arr);
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            int left=i-pge[i];
            int right=nge[i]-i;
            int freq=left*right;
            int val=freq*arr[i];
            sum+=val;
        }
        return sum;
    }
    public static int getmini(int arr[]){
        int n=arr.length;
        int sum=0;

       

            int []nse=findnse(arr);
        int []pse=findpse(arr);

         int mod = (int)1e9 + 7;
        for(int i=0;i<n;i++){ 
            int left=i-pse[i];
            int right=nse[i]-i;
            int freq=left*right;
            int val=freq*arr[i];
            sum+=val;
        }
        return sum;

    }

    public static int getsum(int arr[]){
        return getmaxi(arr)-getmini(arr);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3};
        System.out.println(getsum(arr));
    }
}
