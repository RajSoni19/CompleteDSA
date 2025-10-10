




public class functions {
  //   public static int sum(int a,int b){ // Parameter
  //   int c=a+b;
  //  return c;
  //   }

    // public static void call(int a){
    //   a=10;
      
    // }

    // public static int multi(int a,int b){
    //   int product=a*b;
    //   return product;
    // }

    // public static int factorial(int n){
    //   int f=1;
    //   for(int i=1;i<=n;i++){
    //     f=f*i;
    //   }
    //   return f;
    // }

    // public static int biCoeff(int n,int r){
    //     int fact_n=factorial(n);
    //     int fact_r=factorial(r);
    //     int fact_nmr=factorial(n-r);
    //     int bin=fact_n/(fact_r*fact_nmr);
    //     return bin;
    // }
    
    // Number having two factor such as 1 and number itself is prime==0
    // public static void primecheck(int n){
    //   if(n<=1){
    //     System.out.println("Not prime");
    //   }
    //   for(int i=2;i<=n-1;i++){
    //    if(n%i==0){ // number completery dividing 
    //     System.out.println("Not Prime");
    //     // return;
    //    }
       
    //   }
    //   System.out.println("Prime");
    // }
    // Prime number optimized solution
    public static boolean primecheck(int n){
      // boolean prime=true;
        if(n<=1){
          return false;
        }
        for(int i=2;i<=Math.sqrt(n);i++){
         if(n%i==0){ // number completery dividing 
              return false;
         }  
        }
        return true;
      }
     
      public static  void PrimeInRange(int n){
        for(int i=2;i<n;i++){
          if(primecheck(i)){
            System.out.print(i+" ");
          }
        }
        System.out.println();
      }

      public static void binaryToDecimal(int bin){
        int mynum=bin;
      int pow=0;
      int decNum=0;
      while(bin>0){
        int lastDigit=bin%10;
        decNum=decNum+(lastDigit*(int)Math.pow(2,pow));
        pow++;
        bin=bin/10;
      }
      System.out.println("decimal of " +  mynum +" = " + decNum);
      }

      public static void decToBinary(int n){
        int myNum=n;
         int pow=0;
         int binNum=0;
         while(n>0){
           int rem=n%2;
           binNum=binNum+(rem*(int)Math.pow(10,pow));
           pow++;
           n=n/2;
         }
         System.out.println("binary form of " +  myNum + " = " +binNum);
      }
    public static void main(String[] args) {
        
        // Scanner sc=new Scanner(System.in);
      //   System.out.println("Enter number 1");
      //   int c=sc.nextInt();
      //   System.out.println("Enter two number");
      //   int d=sc.nextInt();
      // int total=  sum(c,d); // Argument
      // System.out.println(total);
      

      // Java always use call by value (that is when you pass varaible in function it is copy of that variable)
      // int a=2;
      // call(2);
      // System.out.println(a);

      // int mul=multi(2, 3);
      // System.out.println(mul);

      //Factorail
      // System.out.println(factorial(4));

      //Binomial Coefficient
      //  System.out.println(biCoeff(5, 2));

      //Prime number or not
      // System.out.println("Enter number to check prime or not");
      // int n=sc.nextInt();
      // System.out.println(primecheck(n));
      // PrimeInRange(n);
      
      //Binaray to Decimal Converter
      // binaryToDecimal(1010);
      
      //Decimal to Binary Code
      // decToBinary(7);
      String n=args[0];
      System.out.println(n);
     
      
    } 
    
}
