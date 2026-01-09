package BitManipulation;
import java.util.*;
public class PrintPrimeFactorization {

    // factor a single number
    // public static ArrayList<Integer> helper(int num){
    //     ArrayList<Integer> ans=new ArrayList<>();
    //     for(int j=2; (long)j*j<=num; j++){
    //         while(num % j == 0){
    //             ans.add(j);
    //             num = num / j;
    //         }
    //     }
    //     if(num > 1) ans.add(num);
    //     return ans;
    // }


    static final int max=100000;

    static int[] spf=new int[max+1];

   // ...existing code...
    public static void seive() {
        // initialize spf[i] = i                       
        for (int i = 0; i <= max; i++) spf[i] = i;
        spf[0] = 0;
        spf[1] = 1;

        for (int i = 2; (long) i * i <= max; i++) {
            if (spf[i] == i) { // i is prime
                for (int j = i * i; j <= max; j += i) { 
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }
    }
// ...existing code...


    public static List<Integer> primefact(int n){
        List<Integer> ans=new ArrayList<>();
        while(n!=1){
            ans.add(spf[n]);
            n=n/spf[n];
        }

        return ans;
    }

    public static  List<List<Integer>> primefactor(int queries[]){
     seive();
     
     List<List<Integer>> ans=new ArrayList<>();

     for(int query:queries){
        ans.add(primefact(query));
     }
     return ans;
    }

    public static void main(String[] args) {

        //BRUTE
        // ArrayList<Integer> query = new ArrayList<>(Arrays.asList(3, 12, 16, 60));
        // for(int x : query){
        //     ArrayList<Integer> factors = helper(x);
        //     System.out.println(x + " -> " + factors);
        // }

        //OPTIMAL

        int queries[]={3,12,16,60};
        List<List<Integer>> ans=primefactor(queries);
        for(int i=0;i<ans.size();i++){
              System.out.print("For " + queries[i] + ": ");
        for(int factor:ans.get(i)){
             System.out.print(factor);
        }
        System.out.println();
    }


    }
}