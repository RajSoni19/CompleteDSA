package TwoPointerSlidingWindow;
import java.util.*;
public class FruitintoBasket {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        int n = arr.length;
        int maxfruit = 0;

        //BRUTE
        // for (int start = 0; start < n; start++) {
        //     Map<Integer, Integer> basket = new HashMap<>();
        
        //     int ans = 0;
        
        //     for (int end = start; end < n; end++) {
            //         basket.put(arr[end], basket.getOrDefault(arr[end], 0) + 1);
            
            //         if (basket.size() > 2) {
                //             break;
                //         }
                
                //         ans = end - start + 1;
                //     }
                //     maxfruit = Math.max(maxfruit, ans);
                
                // }
                // System.out.println(maxfruit);
                
                
                //BETTER
                    Map<Integer, Integer> basket = new HashMap<>();
                    int left=0;
                    for(int right=0;right<n;right++){
                        basket.put(arr[right], basket.getOrDefault(arr[right],0)+1);
                        while(basket.size()>2){
                            basket.put(arr[left],basket.get(arr[left])-1);

                            if(basket.get(arr[left])==0){
                                basket.remove(arr[left]);
                            }
                            left++;
                        }
                        maxfruit=Math.max(maxfruit, right-left+1);
                    }
                    System.out.println(maxfruit);

        
    }
}
