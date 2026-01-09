package TwoPointerSlidingWindow;

public class MinimumWindowsub {
    public static void main(String[] args) {
        String s="ddaaabbca";
        String t="abc";
        if(s.isEmpty()||t.isEmpty()) System.out.println("");
        int l=0;
        int r=0;
        int minlen=Integer.MAX_VALUE;
        int startind=-1;
        int count=0;
        int n=s.length();
        int m=t.length();
        int hash[]=new int[256];
        for(int i=0;i<m;i++){
            hash[t.charAt(i)]++;
        }
        while(r<n){
            if(hash[s.charAt(r)]>0){
                count++;
            }
            hash[s.charAt(r)]--;
            r++;

            while(count==m){ //sliding window target string length match in original string so find minimum one
                if(r-l<minlen){
                    minlen=r-l;
                    startind=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0){
                    count--;
                }
                l++;
            }
        }
        if(startind==-1) {
            System.out.println(" ");
        }
            else{
                System.out.println(s.substring(startind, startind+minlen));
            }
    }
}
