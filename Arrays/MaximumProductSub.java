package Arrays;

public class MaximumProductSub {
      public static void MaxProduct(int arr[],int n){
        int ans=Integer.MIN_VALUE;
        int pre=1;
        int suff=1;
        for(int i=0;i<n;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre=pre*arr[i];
            suff=suff*arr[n-i-1];
            ans=Math.max(ans,Math.max(pre,suff));
        }
        System.out.println(ans);

      }
    public static void main(String[] args) {
        int arr[]={1, 2, -3, 0, -4, -5};
        int n=arr.length;
        MaxProduct(arr, n);

    }
    
}
