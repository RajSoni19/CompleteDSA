package BitManipulation;

public class countnoofsetbit {
    public static void main(String[] args) {
        int n=13;
        int cnt=0;
        // while(n>0){ //Brute
        //     cnt+=n&1;
        //     n=n>>1;
        // }

        while(n!=0){  //Optimal
            n=n&(n-1);
            cnt++;
        }
        System.out.println(cnt);
    }
}
