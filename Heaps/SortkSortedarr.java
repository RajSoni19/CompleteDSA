package Heaps;
import java.util.*;
public class SortkSortedarr {

    public static List<Integer> sortnear(List<Integer> arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        List<Integer> result=new ArrayList<>();
        int limit = Math.min(k, arr.size() - 1); //What happens if the input array is [1, 2] (size 2) but k = 3
        for(int i=0;i<=limit;i++){ //like maintaining window
          pq.add(arr.get(i));
        }
        for(int i=k+1;i<arr.size();i++){
            result.add(pq.poll());
            pq.add(arr.get(i));
        }
        while(!pq.isEmpty()){
            result.add(pq.poll());   
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> arr=Arrays.asList(2,3,1,4);
        int k=2;
        List<Integer> ans=sortnear(arr,k);
        System.out.println(ans);
        
    }
}
