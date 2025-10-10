package Arrays;

public class MaxConsecutiveOnes {
    public static void MaxOne(int arr[],int n){
        int cnt=0;
        int maxi=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                cnt++;
                
            }
            else{
                cnt=0;
            }
            maxi=Math.max(maxi,cnt);
        }
        System.out.println("Most ones are " + maxi);

    }
    public static void main(String[] args) {
        int arr[]={1,1,0,0,1};
        int n=arr.length;
        MaxOne(arr,n);
    }
}
