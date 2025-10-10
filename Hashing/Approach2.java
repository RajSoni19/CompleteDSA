  package Hashing;

  import java.util.*;

  public class Approach2 {
    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int n=sc.nextInt();
      int arr[]=new int[n];
      for(int i=0;i<n;i++){
          arr[i]=sc.nextInt();
      }

      //precompute
      java.util.HashMap<Integer,Integer> mp=new java.util.HashMap<>();
      for(int i=0;i<n;i++){
          int key=arr[i];
          int freq=0;
          if(mp.containsKey(key)) freq=mp.get(key);
          freq++;
          mp.put(key,freq);
      }

      for (Map.Entry<Integer, Integer> it : mp.entrySet()) {
        System.out.println(it.getKey() + "->" + it.getValue());
    }

      int q;
      q=sc.nextInt();
      while(q-->0){
          int number=sc.nextInt();
          if(mp.containsKey(number)) System.out.println(mp.get(number));
          else System.out.println(0);
      }

    }
  }
