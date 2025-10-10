package Arrays;

public class RemoveDuplicate {

    public static int Removeele(int arr[],int n){
        int i=0;
        for(int j=0;j<n;j++){
            if(arr[i]!=arr[j]){
                arr[i+1]=arr[j];
                i++;
            }
        }
        return i+1;
    }
    
    public static void main(String[] args) {
        int arr[]={1,3,3,4,4};
        int n=4;
        int k=Removeele(arr,n);
        System.out.println("After removal");
        for(int i=0;i<k;i++){
            System.out.println(arr[i]+ " ");
        }
        
        
    }
}
