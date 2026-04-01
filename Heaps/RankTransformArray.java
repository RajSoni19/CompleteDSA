package Heaps;
import java.util.*;
import javax.swing.text.StyleContext;
public class RankTransformArray {

    //brute (Time limit exceed)
    // public static List<Integer> getrank(int arr[]){
    //     List<Integer> ans=new ArrayList<>();
    //     for(int i=0;i<arr.length;i++){
    //         Set<Integer> smaller=new HashSet<>();
    //         for(int j=0;j<arr.length;j++){
    //             if(arr[j]<arr[i]){
    //                 smaller.add(arr[j]);
    //             }
    //         }

    //         int rank=smaller.size()+1;
    //         ans.add(rank);
    //     }
    //     return ans;

    // }

    public static int[] getrank(int arr[]){ // map contains like value(Arr)-->rank
        int sorted[]=arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer,Integer> hm=new HashMap<>();
        int rank=1;
        for(int num:sorted){
            while(!hm.containsKey(num)){
                hm.put(num,rank);
                rank++;
            }
        }

        int result[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            result[i]=hm.get(arr[i]);
            
        }
        return result;
    }



    public static void main(String[] args) {
        int arr[]={40,10,20,30};
        int ans[]=getrank(arr);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
        

    }
}
