package TwoPointerSlidingWindow;

public class longestsumk{
    public static void main(String[] args) {
        int arr[]={2,5,1,10,10};
        int k=14;

        int l=0;
        int r=0;
        int maxlen=0;
        int sum=0;
        int n=arr.length;
        //better
        // while(r<n){ //window size till max can expand
        //     sum=sum+arr[r];
        //     while(sum>k){ //condition become false then shrink window by moving l ahead
        //         sum=sum-arr[l];
        //         l++;
        //     }
        //     if(sum<=k) maxlen=Math.max(maxlen, r-l+1); //if condition become true then find length
        //     r++; //window expasion 
        // }
        // System.out.println(maxlen);

        //optimal
        while(r<n){ //window size till max can expand
            sum=sum+arr[r];
            if(sum>k){ //if condition become false then shrink window by moving l ahead(done optimized no need shrink window such maxlen go with beyond maxvalue)
                sum=sum-arr[l];
                l++;
            }
            if(sum<=k) maxlen=Math.max(maxlen, r-l+1); //if condition become true then find length
            r++; //window expasion 
        }
        System.out.println(maxlen);

    }
}