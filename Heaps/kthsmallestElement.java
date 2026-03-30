package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthsmallestElement {

    public static int getsmall(int arr[],int k){
        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:arr){
            maxheap.add(num);
            if(maxheap.size()>k){
                maxheap.poll();
            }
        }
        return maxheap.peek();
    }
    public static void main(String[] args) {
        int arr[]={5,2,3,1,4,6};
        int n=arr.length;
        int k=2;
        System.out.println(getsmall(arr,k));
    }
}
