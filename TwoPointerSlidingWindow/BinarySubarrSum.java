package TwoPointerSlidingWindow;

public class BinarySubarrSum {

    public static int atmostK(int arr[],int goal){
        return greatequalk(arr, goal)-greatequalk(arr, goal-1); //to get final ans
    }

    public static int greatequalk(int arr[],int goal){


        //code for sum<=goal
        if(goal<0) return 0;
  int left=0;
        int cnt=0;
        int sum=0;
        for(int right=0;right<arr.length;right++){
            sum+=arr[right];
            while(sum>goal){ //Shrink window false condition
                sum-=arr[left];
                left++;
            }
            cnt+=(right-left+1); //add current window size bcs counting subarr as always every ele
        }
        return cnt;
    }
    public static void main(String[] args) {
        int arr[]={1,0,1,0,1};
        int goal=2;
        int n=arr.length;
        System.out.println(atmostK(arr, goal));

        // int cnt=0;
        // for(int i=0;i<n;i++){
        //     int sum=0;
        //     for(int j=i;j<n;j++){
        //         sum+=arr[j];
        //         if(sum==goal){
        //             cnt++;
        //         }
        //     }
        // }
        // System.out.println(cnt);

      

    }
}
