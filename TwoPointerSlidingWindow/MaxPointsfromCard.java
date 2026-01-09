package TwoPointerSlidingWindow;

public class MaxPointsfromCard {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,1};
        int k=3;

        int n=arr.length;

        int lsum=0,rsum=0,maxsum=0;
        for(int i=0;i<k;i++){
            lsum+=arr[i];
        }
        maxsum=lsum;

        int rind=n-1;
        for(int i=k-1;i>=0;i--){ //sliding window here we are removing elemennt front and adding from back step by step
           lsum-=arr[i];
           rsum+=arr[rind];
           rind--;
           maxsum=Math.max(maxsum, lsum+rsum);
        }
        System.out.println(maxsum);
    }
}
