package Arrays;


public class SecondLargSmall{

    public static void SecondSmall(int arr[],int n){
        int small=arr[0];
        int ssmall=-1;
        for(int i=0;i<n;i++){
              if(arr[i]<small){
                ssmall=small;
                small=arr[i];
              }
              else if(arr[i]!=small&&arr[i]<ssmall){
                ssmall=arr[i];
              }
        }
        System.out.println(ssmall);
    }
    public static void Secondlarge(int arr[],int n){
        int large=arr[0];
        int slarge=-1;
        for(int i=0;i<n;i++){
            if(arr[i]> large ){
                slarge=large;
                large=arr[i];
            }
            else if(arr[i]!=large && arr[i]>slarge){
                slarge=arr[i];
            }
        }
     System.out.println(slarge);  
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int n=arr.length;
        Secondlarge(arr, n);
        SecondSmall(arr, n);
    }
}