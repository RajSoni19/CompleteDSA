package TwoPointerSlidingWindow;

public class MaxConsecutivethree {
    public static void main(String[] args) {
        int arr[]={1,1,1,0,0,0,1,1,1,1,0};
        int n=arr.length;
        int k=2;
        //MAIN LOGIC IF NO. OF ZEROS GREATER THAN K THEN SHRINK WINDOW OR STOP GENERATE SUBARR

        //brute
        // int maxlen=0;
        // for(int i=0;i<n;i++){
        //     int cntzeros=0;
        //     for(int j=i;j<n;j++){
        //         if(arr[j]==0) cntzeros++;
        //         if(cntzeros>k) break;
        //         maxlen=Math.max(maxlen, j-i+1);
        //     }
        
        // }
        // System.out.println(maxlen);

        //optimal

        int left=0;
        int right=0;
        int maxlen=0;
        int cnt=0;
        while(right<n){
            if(arr[right]==0) cnt++; 


            while(cnt>k){ //shrink window if exceed k size to stay in range 
                if(arr[left]==0) cnt--; // we are using this because want to set cnt as same as k to get valid window or subarr
                left++;
            }

            
            maxlen=Math.max(maxlen, right-left+1);
            right++;
        }
        System.out.println(maxlen);
    }
}
