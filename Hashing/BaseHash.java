package Hashing;

import java.util.Scanner;

public class BaseHash {
    public static void main(String[] args) {
        //Count freq elements in array(Hash)
        Scanner sc = new Scanner(System.in);

        // int n;
        // n = sc.nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        //     arr[i] = sc.nextInt();
        // }

        // //precompute:
        // int[] hash = new int[13];
        // for (int i = 0; i < n; i++) {
        //     hash[arr[i]] +=1;
        // }


        // //For How many time number appear
        // int q;
        // q = sc.nextInt();
        // while (q--!= 0) {
        //     int number;
        //     number = sc.nextInt();
        //     // f etching:
        //     System.out.print("Progress" + hash[number]);
        // }


        //Count freqency of strings
        // String s=sc.next();
        // //precompute
        // int hash[]=new int[256];
        // for(int i=0;i<s.length();i++){
        //      hash[s.charAt(i)]++;
        // }
        // int q=sc.nextInt();
        // while(q--!=0){
        //     char c=sc.next().charAt(0);
        //     //Fetch
        //     System.out.println(hash[c]);
        // }

        for (int i : hash) {
            System.out.println(i);
        }

    }
}