package TwoPointerSlidingWindow;

public class NoofSubstr3 {
    public static void main(String[] args) {
        String s="abcabc";
        int n=s.length();

        int cnt=0;

        // for(int i=0;i<n;i++){
        //    int freq[]=new int[3];
        //    for(int j=i;j<n;j++){
        //      freq[s.charAt(j)-'a']++;

        //      if(freq[0]>0&&freq[1]>0&&freq[2]>0){
        //           cnt++;
        //      }
        //    }
        // }

        // System.out.println(cnt);

        int freq[]=new int[3];
        int left=0;
        int res=0;
        for(int right=0;right<s.length();right++){
          freq[s.charAt(right)-'a']++;
          while(freq[0]>0&&freq[1]>0&&freq[2]>0){
            res+=(s.length()-right);
            freq[s.charAt(left)-'a']--;
            left++;
          }
        }
        System.out.println(res);

    }
}
