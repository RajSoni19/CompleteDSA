package TwoPointerSlidingWindow;

public class NiceSubarr {

    public static int subarr(int arr[],int k){
        // int n=arr.length;
        // int left=0;
        // int res=0;
        // for(int right=0;right<n;right++){
        //     if(arr[right]%2!=0){
        //         k--;
        //     }
        //     while(k<0){
        //         if(arr[left]%2!=0) k++;
        //         left++;
        //     }
        //     res+=(right-left+1);
        // }
        // return res;


         int cnt=0;
         int left=0;
        int sum=0;
        for(int right=0;right<arr.length;right++){
            sum+=(arr[right]%2);
            while(sum>k){ //Shrink window false condition
                sum-=(arr[left]%2);
                left++;
            }
            cnt+=(right-left+1); //add current window size bcs counting subarr as always every ele
        }
        return cnt;
    }

    public static int numberofsub(int arr[],int k){
        return subarr(arr,k)-subarr(arr,k-1);
    }
    public static void main(String[] args) {
        int arr[]={1,1,2,1,1};
        int k=3;

        System.out.println(numberofsub(arr,k));
    //    int n=arr.length;
    //    int cnt=0;
    //    for(int i=0;i<n;i++){

    //        int oddcnt=0;
    //         for(int j=i;j<n;j++){
    //             if(arr[j]%2!=0){
    //                oddcnt++;
    //             }
    //             if(oddcnt==k){
    //                cnt++;
    //             }
    //         }
    //     }
    //     System.out.println(cnt);

    }
}
