package BitManipulation;

public class MinimumBitflips {
    public static void main(String[] args) {
        int cnt=0;
        int start=10;
        int end=7;

        //Brute
        // int ans=start^end;
        // String binary = Integer.toBinaryString(ans);
        // for(int i=0;i<binary.length();i++){
        //     if(binary.charAt(i)=='1'){
        //         cnt++;
        //     }
        // }
        // System.out.println(cnt);

        //Optimal
        int ans=start^end;
        while(ans!=0){
            ans=ans&(ans-1);
            cnt++;
        }
        System.out.println(cnt);

    }
}
