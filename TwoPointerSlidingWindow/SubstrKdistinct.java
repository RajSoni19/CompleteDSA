package TwoPointerSlidingWindow;

import java.util.*;

public class SubstrKdistinct {
    public static void main(String[] args) {
        String s = "aba";
        int k = 2;
        int n = s.length();
        int maxlen = 0;

        // for(int i=0;i<n;i++){
        // HashMap<Character,Integer> map=new HashMap<>();
        // for(int j=i;j<n;j++){
        // map.put(s.charAt(j),map.getOrDefault(s.charAt(j), 0)+1);
        // if(map.size()>k){
        // break;
        // }
        // maxlen=Math.max(maxlen, j-i+1);
        // }
        // }
        // System.out.println(maxlen);
    if (k == 0 || s.length() == 0)System.out.println(0);
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right=0;right<n;right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right), 0)+1);
            if(map.size()>k){ //sliding window if map size exceed k size then decrement freq of element and if freq is 0 then remove from map and move left pointer ahead
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            maxlen=Math.max(maxlen, right-left+1);
        }
        System.out.println(maxlen);

    }
}
