package TwoPointerSlidingWindow;
import java.util.*;
public class Permutation {

    public static boolean usefreq(String s1,String s2){
        if(s1.length()>s2.length()) return false;
        int[] freq1=new int[26]; //freq array for s1
        int[] freq2=new int[26] ; //freq array for s2
        for(char c:s1.toCharArray()){
            freq1[c-'a']++;
        }
        int k=s1.length();
        for(int i=0;i<k;i++){
            freq2[s2.charAt(i)-'a']++;
        } //in s2 couting freq for total number of element present in s1
        if(Arrays.equals(freq1, freq2)) return true; //if frequency of two character is same then return true because permuate
        for(int i=k;i<s2.length();i++){
            freq2[s2.charAt(i)-'a']++; //adding new character (right side)
            freq2[s2.charAt(i-k)-'a']--; //removing old character (left side)

            if(Arrays.equals(freq1,freq2)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String s1="ab";
        String s2="eidbaooo";
        System.out.println(usefreq(s1,s2));
    }
}
