package Arrays;

public class FindMissnum {

    //BRUTE FORCE 
    // public static int Miss(int arr[],int N) {
    //     // int flag;
    //     // int i;
    //     for (int i = 1; i <= N; i++) {

    //         // flag variable to check
    //         //if an element exists
    //         int flag = 0;

    //         //Search the element using linear search:
    //         for (int j = 0; j < N - 1; j++) {
    //             if (arr[j] == i) {

    //                 // i is present in the array:
    //                 flag = 1;
    //                 break;
    //             }
    //         }

    //         // check if the element is missing
    //         //i.e flag == 0:

    //         if (flag == 0) return i;
    //     }

    //     // The following line will never execute.
    //     // It is just to avoid warnings.
    //     return -1;
       
    // }

    //OPTIMAL
     public static int missing(int arr[],int N){
    //     int xor1=0,xor2=0;
    //     for(int i=0;i<N-1;i++){
    //         xor2=xor2^arr[i];
    //         xor1=xor1^(i+1); //XOR all numbers from 1 to N-1)
    //     }
    //     xor1=xor1^N; // xor1 with N to include the last number.
    //     return (xor1^xor2);


    int xor=0;
    for(int i=0;i<=N;i++){
        xor=xor^i;
    }

    for(int i=0;i<N-1;i++){
        xor=xor^arr[i];
    }

    return xor;
     }

    
    public static void main(String[] args) {
        int arr[]={3, 2 ,4 ,6, 1 };
        int N=6;
        int m=missing(arr,N);
        System.out.println(m);
        
    }
}
