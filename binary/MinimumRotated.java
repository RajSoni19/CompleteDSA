package binary;

public class MinimumRotated {
    public static void SearchIn(int nums[]){
        int low=0;
        int high=nums.length-1;
        int ans=Integer.MAX_VALUE;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[low]<=nums[mid]){
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
            else{
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
        }
        System.out.println(ans);

    }
    public static void main(String[] args) {
       int  nums[] = {3,4,5,1,2};
       SearchIn(nums);
    }
}
