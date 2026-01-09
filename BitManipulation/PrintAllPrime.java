package BitManipulation;

import java.util.ArrayList;

public class PrintAllPrime {

    public static boolean isprime(int x){
      
        if(x<=1) return false;
        for(int j=2;j*j<=x;j++){
            if(x%j==0) return false;
        }

        return true;

    }
    public static void main(String[] args) {
        ArrayList<Integer> ans=new ArrayList<>();
        int N=10;

        //Brute 
        // for(int i=2;i<=N;i++){
        //     if(N%i==0){
        //         if(isprime(i)){
        //             ans.add(i);
        //         }
        //     }
        // }

        //Better
        // for(int i=1;i<=Math.sqrt(N);i++){
        //     if(N%i==0){
        //         if(isprime(i)) ans.add(i);
        //         if(N/i!=i) if(isprime(N/i)) ans.add(N/i);
        //     }
        // }

        //optimal
        for(int i=2;i<=Math.sqrt((int)N);i++){
            if(N%i==0){
                ans.add(i);
            }
            while(N%i==0){
                N=N/i;
            }
        }
        if(N!=1) ans.add(N);


        // System.out.println(cnt);

        System.out.println(ans);
        


    }
}
