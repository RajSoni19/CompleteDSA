package TwoPointerSlidingWindow;
import java.util.*;
public class LongestSubstringwithoutRepeatingChar{
    public static void main(String[] args) {
        String s="abcabcbb";
        int n=s.length();

        //optimal
        // int left=0;

        // int maxlen=0;
        // HashSet<Character> hs=new HashSet<>();
        // for(int right=0;right<n;right++){
        //     char c=s.charAt(right);
        //     while(hs.contains(c)){
        //        hs.remove(s.charAt(left));
        //        left++;
        //     }
        //     hs.add(c);
        //     maxlen=Math.max(maxlen,right-left+1);
        // }
        // System.out.println(maxlen);


        //brute
        int maxlen=0;
        for(int i=0;i<n;i++){
            int[] hash=new int[256];
            Arrays.fill(hash,0);

            for(int j=i;j<n;j++){
               if(hash[s.charAt(j)]==1) break;
               hash[s.charAt(j)]=1;
               int len=j-i+1;
               maxlen=Math.max(maxlen, len);
            }
        }
        System.out.println(maxlen);


    }
}