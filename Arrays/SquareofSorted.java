package Arrays;

public class SquareofSorted {
    public static void main(String[] args) {
        int nums[]={-4,-1,0,3,10};
        int n=nums.length;
        int ans[]=new int[n];
        int left=0;
        int right=n-1;
        int idx=n-1;
        while(left<=right){
           int leftsq=nums[left]*nums[left];
           int rightsq=nums[right]*nums[right];
           if(leftsq>rightsq){
              ans[idx]=leftsq;
              left++;
           }else{
             ans[idx]=rightsq;
             right--;
           }
           idx--;
        }
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
