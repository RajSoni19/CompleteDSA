import java.util.*;

public class Wordbreak {

    public static boolean wordb(String s,List<String> wordDict){
        int n=s.length();
        Set<String> dict=new HashSet<>(wordDict);
        boolean dp[]=new boolean[n+1];
        dp[0]=true;
        int maxlen=0;
        for(String word:wordDict){
            maxlen=Math.max(maxlen,word.length());
        }

        for(int i=1;i<=n;i++){
            for(int j=Math.max(0,i-maxlen);j<i;j++){
                if(dp[j] && dict.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];

    }
    public static void main(String[] args) {
        String s="leetcode";
        List<String> wordDict=Arrays.asList("leet","code");
        boolean a=wordb(s,wordDict);
        System.out.println(a);
    }
}
