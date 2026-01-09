package BitManipulation;

import java.util.ArrayList;

public class SieveofEratosthenes {

    public static boolean isprime(int x) {

        if (x <= 1)
            return false;
        for (int j = 2; j * j <= x; j++) {
            if (x % j == 0)
                return false;
        }

        return true;

    }

    public static void main(String[] args) {
        int N = 10;
        ArrayList<Integer> ans = new ArrayList<>();

        // Brute
        // for(int i=2;i<=N;i++){
        // if(isprime(i)){
        // ans.add(i);
        // }
        // }
        int cnt = 0;
        int prime[] = new int[N];
        for (int i = 2; i < N; i++) {
            prime[i] = 1;
        }

        for (int i = 2; i * i < N; i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j < N; j += i) {
                    prime[j] = 0;
                }
            }
        }

        for (int i = 2; i < N; i++) {
            if (prime[i] == 1) {
                cnt++;
                ans.add(i);
            }
        }

        System.out.println(ans);
        System.out.println(cnt);
    }
}
