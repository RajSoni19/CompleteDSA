package TwoPointerSlidingWindow;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s="ABAB";
        int k=2;

        // int maxlength=0;
        // for(int i=0;i<s.length();i++){
        //     int freq[]=new int[26];
        //     int maxfreq=0;
        //     for(int j=i;j<s.length();j++){
        //         freq[s.charAt(j)-'A']++;
        //         maxfreq=Math.max(maxfreq,freq[s.charAt(j)-'A']);
        //         
        //         int windowsize=j-i+1;
        //         int change=windowsize-maxfreq;
        
        //         if(change<=k){
            //             maxlength=Math.max(maxlength,windowsize);
        //         }
        //     }
        // }
        // System.out.println(maxlength);
        

        //BETTER
        // int left=0;
        // int maxlen=0;
        // int maxfreq=0;
        // int freq[]=new int[26];
        // for(int right=0;right<s.length();right++){
        //     freq[s.charAt(right)-'A']++;
        //     maxfreq=Math.max(maxfreq,freq[s.charAt(right)-'A']);
        //     while((right-left+1)-maxfreq>k){
        //         freq[s.charAt(left)-'A']--;
        //         left++;
        //     }
        //     maxlen=Math.max(maxlen,right-left+1);
        // }
        // System.out.println(maxlen)
        // 
        
        //OPTIMAL
          // int left=0;
        // int maxlen=0;
        // int maxfreq=0;
        // int freq[]=new int[26];
        // for(int right=0;right<s.length();right++){
        //     freq[s.charAt(right)-'A']++; //counting frequency of every character
        //     maxfreq=Math.max(maxfreq,freq[s.charAt(right)-'A']);
        //     if((right-left+1)-maxfreq>k){ //shrinking window due false condition
        //         freq[s.charAt(left)-'A']--;
        //         left++;
        //     }
        //     maxlen=Math.max(maxlen,right-left+1);
        // }
        // System.out.println(maxlen)
    }
}
