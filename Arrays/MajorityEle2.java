package Arrays;

import java.util.*;

public class MajorityEle2{

    // Function to find all elements that appear more than n/3 times in the array
    public static List<Integer> major(int arr[]){
        List<Integer> ls = new ArrayList<>();
        int ele1 = Integer.MIN_VALUE; // First potential majority element
        int ele2 = Integer.MIN_VALUE; // Second potential majority element
        int cnt1 = 0; // Count for ele1
        int cnt2 = 0; // Count for ele2

        // First pass: Find potential candidates using Boyer-Moore Voting Algorithm
        for(int i = 0; i < arr.length; i++){
            if(cnt1 == 0 && ele2 != arr[i]){
                ele1 = arr[i];
                cnt1 = 1;
            }
            else if(cnt2 == 0 && ele1 != arr[i]){
                ele2 = arr[i];
                cnt2 = 1;
            }
            else if(arr[i] == ele1){
                cnt1++;
            }
            else if(arr[i] == ele2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        // Second pass: Verify the candidates
        int mini = (int)(arr.length / 3) + 1; // Minimum occurrences needed
        cnt1 = 0; cnt2 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == ele1){
                cnt1++;
            }
            if(arr[i] == ele2){
                cnt2++;
            }
        }
        // Add to result if count is sufficient
        if(cnt1 >= mini){
            ls.add(ele1);
        }
        if(cnt2 >= mini && ele2 != ele1){
            ls.add(ele2);
        }
        return ls;
    }

    public static void main(String[] args) {
        int arr[] = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = major(arr);
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}