package Stack;

public class TrappingRainwater {

    public static int trapwater(int arr[]){

        //BRUTE
       int n=arr.length;
       int watertrap=0;
    //    for(int i=0;i<n;i++){
    //     int j=i;
    //     int leftmax=0;
    //     int rightmax=0;
    //      while(j>=0){
    //         leftmax=Math.max(leftmax,arr[j]);
    //         j--;
    //      }
    //      j=i;
    //      while(j<n){
    //        rightmax=Math.max(rightmax, arr[j]);
    //        j++;
    //      }
    //      watertrap+=Math.min(leftmax,rightmax)-arr[i];
    //    }
    //    return watertrap;


    //BETTER
    // int prefix[]=new int[n];
    // int suffix[]=new int[n];
    // prefix[0]=arr[0];
    // for(int i=1;i<n;i++){
    //     prefix[i]=Math.max(prefix[i-1],arr[i]);
    // }

    // suffix[n-1]=arr[n-1];
    // for(int i=n-2;i>=0;i--){
    //     suffix[i]=Math.max(suffix[i+1],arr[i]);
    // }

    // for(int i=0;i<n;i++){
    //     watertrap+=Math.min(prefix[i],suffix[i])-arr[i];
    // }
    // return watertrap;


    //OPTIMAL
    int left=0;
    int right=n-1;
    int maxleft=0,maxright=0,res=0;
    while(left<=right){
        if(arr[left]<=arr[right]){
            if(arr[left]>=maxleft){
                maxleft=arr[left];
            }
            else{
                res+=maxleft-arr[left];
            }
            left++;
        }

        else{
            if(arr[right]>=maxright){
                maxright=arr[right];
            }
            else{
                res+=maxright-arr[right];
            }
            right--;
        }


    }
    return res;
    }
    public static void main(String[] args) {
        int arr[]={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trapwater(arr));

    }
}
