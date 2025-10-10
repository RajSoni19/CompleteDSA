package Arrays;

public class longSubarrsumk {

    //BETTER WAY
    // public static int getLong(int arr[],long k){
    //     Map<Long, Integer> preSumMap = new HashMap<>();
    //     long sum=0;
    //     int maxlen=0;
    //     int n=arr.length;
    //     for(int i=0;i<n;i++){
    //         sum+=arr[i];

    //     if(sum==k){
    //         maxlen=Math.max(maxlen,i+1);
    //     }

    //     long rem=sum-k;
    //     if(preSumMap.containsKey(rem)){
    //       int len=i-preSumMap.get(rem);
    //       maxlen=Math.max(maxlen,len);
    //     }
    //     if(!preSumMap.containsKey(sum)){
    //         preSumMap.put(sum,i);
    //     }
    //     }
    //     return maxlen;
    // }
    public static int getLong(int arr[],long k){
        int left=0;
        int right=0;
        int sum=arr[0];
        int n=arr.length;
        int maxlen=0;
        while(right<n){  
             // shrink from left if sum is too big
            while(left<=right&&sum>k){
                sum -= arr[left];
                left++;
            }
               // check for match
            if(sum==k) maxlen=Math.max(maxlen,right-left+1);

            // move right forward
            right++;
            if(right<n) sum+=arr[right];
        }
         return maxlen;
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,1,1,1,4,2,3};
        long k=3;
        int ans=getLong(arr, k);
        System.out.println(ans);

    }
}
