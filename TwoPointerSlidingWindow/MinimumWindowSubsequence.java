package TwoPointerSlidingWindow;

public class MinimumWindowSubsequence {

    // public static boolean issub(String sub,String s2){
    //     int i=0;
    //     int j=0;
    //     while(i<sub.length()&&j<s2.length()){
    //         if(sub.charAt(i)==s2.charAt(j)) j++;
    //         i++;
    //     }
    //     return j==s2.length();
    // }

    // public static String minwindow(String s1,String s2){
    //       int n=s1.length();
    //       String ans=" ";
    //       int minlen=Integer.MAX_VALUE;
    //       for(int start=0;start<n;start++){
    //         for(int end=start;end<n;end++){
    //             String sub=s1.substring(start,end+1);
    //             if(issub(sub, s2)){
    //                 if(sub.length()<minlen){
    //                     minlen=sub.length();
    //                     ans=sub;
    //                 }
    //                 break;
    //             }
    //         }
    //       }
    //       return ans;
    // }

    public static String minwindow(String s,String t){
        int n=s.length();
        int m=t.length();
          if (m == 0 || m > n) return "";
        int minlen=Integer.MAX_VALUE;
        int i=0;
        int start=-1;
        while(i<n){

                  // Step 1: forward scan to find t as subsequence
            int j=0;
               while (i < n && j < m) {
                if(s.charAt(i)==t.charAt(j)){
                    j++;
               
                }
                i++;
            }

            if(j<m) break;  // t not found
          // Step 2: backward shrink to find minimal window
            int end = i - 1; // last matched char index
            j=m-1;
            i=end;

            while(j>=0){
                if(s.charAt(i)==t.charAt(j)){
                    j--;
                 
                }
                i--;
            }

            i++; // i now = start of minimal windowq

            int curr=end-i+1;
            if(curr<minlen){
                  minlen=curr;
                  start=i;
            }
            i++; // move to next position to find next window
        }
        return start==-1?"":s.substring(start,start+minlen);
    }


    public static void main(String[] args) {
        String s1="abcdebdde";
        String s2="bde";
        System.out.println(minwindow(s1,s2));


    }
}
