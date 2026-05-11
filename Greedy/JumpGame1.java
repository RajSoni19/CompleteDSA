package Greedy;

public class JumpGame1 {

    public static boolean getjump(int nums[]){
        int n=nums.length;
        int maxi=0;
        for(int i=0;i<n;i++){
            if(i>maxi){
                return false;
            }
            maxi=Math.max(maxi,i+nums[i]);
        }
        return true;
    }
    public static void main(String[] args) {
        int nums[]={2,3,1,0,4};

        System.out.println(getjump(nums));
    }
}
