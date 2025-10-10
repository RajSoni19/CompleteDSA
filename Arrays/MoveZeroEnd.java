package Arrays;

public class MoveZeroEnd {
    public static void Movezero(int arr[],int n){
        //ArrayList<Integer> temp=new ArrayList<>();
         int nonzero=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
              arr[nonzero]=arr[i];
              nonzero++;
            }
        }
       
        for(int i=nonzero;i<n;i++){
            arr[i]=0;
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
        }
    }
    public static void main(String[] args) {
        int arr[]={1,2,0,5,6,0,3};
        int n=arr.length;
        Movezero(arr, n);

    }
    
}
