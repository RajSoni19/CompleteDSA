package Arrays;

public class MaxSubarrsum {

    public static void maxsubSum(int arr[],int n){
        int max=arr[0];
        int sum=0;
        // int start=0;
        // int astart=-1;
        // int aEnd=-1;
        for(int i=0;i<n;i++){
            // if(sum==0) start=i; //Commented code is to return subarray
            sum+=arr[i];
            if(sum>max){
                max=sum;
                // astart=start;
                // aEnd=i;
            }
            if(sum<0){
                sum=0;
            }
        }
        System.out.println(max);
      
        // System.out.println(arr[astart]+ " " +arr[aEnd]);
    }
    public static void main(String[] args) {
        int arr[]={-2,1,-3,4,-1,2,1,-5,4};
        int n=arr.length;
        maxsubSum(arr,n);

    }
}
