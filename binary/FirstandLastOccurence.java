package binary;
public class FirstandLastOccurence{

    //BRUTE FORCE
    public static void targets(int arr[],int N,int target){
        int first=-1;
        int last=-1;
        for(int i=0;i<N;i++){
            if (arr[i]==target){
                if(first==-1) first=i;
                last=i;
            }
            }
          System.out.println(first);
          System.out.println(last);
        }

    public static void searchRange(int arr[],int target){
        int result[]={-1,-1};
        result[0]=findfirst(arr, target);
        result[1]=findlast(arr, target);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
        }
    }

    public static int findfirst(int arr[],int target){
        int low=0;
        int high=arr.length-1;
        int index=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                    index=mid;
                    high=mid-1;
            } 
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }
        return index;
    }
    public static int findlast(int arr[],int target){
        int low=0;
        int high=arr.length-1;
        int index=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target){
                    index=mid;
                    low=mid+1;
            } 
            else if(arr[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }

        }
        return index;
    }
    
    public static void main(String[] args) {
        int arr[] = {3,4,13,13,13,20,40};
        int N = 7;
        int target=13;
        // targets(arr, N, target);
        searchRange(arr, target);
    }
}