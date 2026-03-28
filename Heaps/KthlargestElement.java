package Heaps;

import java.util.Random;

public class KthlargestElement {
 //just tried on my own but not passing all test bcs does not work on sorted array
        // int n=nums.length;
        // int ans=1;
        // for(int i=0;i<n;i++){
        //     if(k+1==i){
        //      ans=nums[i];
        //      break;   
        //     }
        // }
        // return ans;
    public static int getele(int arr[],int k){

        //brute
        int n=arr.length;
        // Arrays.sort(arr);
        // return arr[n-k];

        //better(it works for interview)
        // PriorityQueue<Integer> minheap=new PriorityQueue<>();
        // for(int num:arr){
        //     minheap.add(num);
        //     if(minheap.size()>k){
        //         minheap.poll();
        //     }
        // }
        // return minheap.peek();


        //OPTIMAL
        if(k>arr.length) return -1;
        int left=0,right=n-1;
        while(true){
            int pivotindex=randomindex(left,right); //let pick random number as pivot
            pivotindex=partitionandReturnIndex(arr,pivotindex,left,right); //arrange pivot at correct place
            if(pivotindex==k-1) return arr[pivotindex];   // If Kth largest element is found, return
              // Else adjust the end pointers in array
            else if(pivotindex>k-1) right=pivotindex-1;
            else left=pivotindex+1;
        }

    }

    private static Random rand=new Random();
    private static  int randomindex(int left,int right){
        int len=right-left+1;
        return rand.nextInt(len)+left;
    }

        // Function to perform the partition and return the updated index of pivot

    private static int partitionandReturnIndex(int nums[],int pivotindex,int left,int right){
        int pivot=nums[pivotindex]; //get the pivot element

        //swap pivot with left element
        int temp=nums[left];
        nums[left]=nums[right];
        nums[pivotindex]=temp;

        int ind=left+1; //index to mark start of right portion

        for(int i=left+1;i<=right;i++){


               if(nums[i]>pivot){

                //place the current element in left portion
                temp=nums[ind];
                nums[ind]=nums[i];
                nums[i]=temp;
                 //move the right portion index
                ind++;
               }
        }

        //place the pivot at the correct index  
        temp=nums[left];
        nums[left]=nums[ind-1];
        nums[ind-1]=temp;

        return ind-1; //return the index of pivot now

    }
    public static void main(String[] args) {
        int arr[]={3,2,1,5,6,4};
        int k=2;
        System.out.println(getele(arr,k));
    }
}
