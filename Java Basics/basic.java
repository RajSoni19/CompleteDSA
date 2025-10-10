

public class basic {
    public static void main(String[] args) {

        // FULL BASIC JAVA (input,output,dataypes,typecasting)
        // Output
        // System.out.println("I will master Dsa");

        // Input
        // Scanner input =new Scanner(System.in);
        // System.out.print("Enter roll no");
        // int rollno=input.nextInt();
        // System.out.println("Your roll number is " + rollno);
        // String name=input.nextLine();
        // System.out.println(name);

        // Datatypes:
        // int rollno=64;
        // char letter='r';
        // float marks=83.22f;
        // double largeDecimal=55556.33333;
        // long large=2534445555542999900L;
        // boolean check=true;
        // System.out.println(large);

        // Type casting
        // float d=33;
        // System.out.println(d);

        // int s=(int)(3.4);
        // System.out.println(s);

        // automatic type promotion in expression
        // int a=257;
        // byte b=(byte)(a);
        // System.out.println(b); // 257%256=1

        // byte a=40;
        // byte b=50;
        // byte c=100;
        // int d=a*b/c;
        // System.out.println(d);

        // byte s=50;
        // s=s*1; // error bcs evalution always happen in int and it is in byte
        // s=(byte)(s*1); // solution
        // System.out.println(s);

        // int num='A';
        // System.out.println(num); // Automatic type casting

        // float a=(float)3333.33;
        // System.out.println(a); // Explicit type casting

        // Temperature converter
        // Scanner sc=new Scanner(System.in);
        // System.out.println("Enter temp in celcius");
        // float c=sc.nextFloat();
        // float f=(c*9/5)+32;
        // System.out.println(f);

        // FULL BASIC JAVA(Conditional and loops)
        // Conditional
        // int salary=1000;
        // if(salary>500){
        // salary=salary+200;

        // }
        // else{
        // salary=salary+100;
        // }
        // System.out.println(salary);

        // Loops
        // Scanner sc=new Scanner(System.in);
        // System.out.println("Enter number to print ");
        // int n=sc.nextInt();
        // for(int num=1;num<=n;num++){
        // System.out.println(num);
        // }

        // Maximum number
        // int a=222;
        // int b=55;
        // int c=22;
        // if(a>b && a>c){
        // System.out.println(a);
        // }
        // else if(b>a && b>c){
        // System.out.println(b);
        // }
        // else{
        // System.out.println(c);
        // }

        // Fibonaci series
        // Scanner s=new Scanner(System.in);
        // System.out.println("Enter number");
        // int n=s.nextInt();
        // int a=0;
        // int b=1;
        // int count=2;
        // while(count<=n){
        // int temp=b;
        // b=b+a;
        // a=temp;
        // count++;
        // }
        // System.out.println(b);

        // Counting Number
        // int n=453363;
        // int count=0;
        // while(n>0){
        // int rem=n%10;
        // if(rem==3){
        // count++;
        // }
        // n=n/10;
        // }
        // System.out.println(count);

        // Reverse the given number
        int num=123450;
        int ans=0;
        while(num>0){
        int rem=num%10;
        num=num/10;
        ans=ans*10+rem;
    }
    System.out.print(ans);

        // Multplication table
        // Scanner sc=new Scanner(System.in);
        // System.out.println("Enter number");
        // int a=sc.nextInt();
        // for(int i=1;i<=10;i++){
        // int mul=i*a;
        // System.out.println(mul);
        // }

        // Factorial Number
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter a number: ");
        // int number = scanner.nextInt();
        // if (number < 0) {
        // System.out.println("Factorial is not defined for negative numbers.");
        // } else {
        // long factorial = 1;
        // for (int i = 1; i <= number; i++) {
        // factorial *= i;
        // }
        // System.out.println("Factorial of " + number + " is: " + factorial);
        // }

        // Switch
        // Scanner sc = new Scanner(System.in);
        // System.out.println("enter weekday");
        // int weekday = sc.nextInt();
        // Simple Switch
        // switch (weekday) {
        // case 1:
        // System.out.println("Sunday");
        // break;
        // case 2:
        // System.out.println("Monday");
        // break;
        // case 3:
        // System.out.println("Tuesday");
        // break;
        // case 4:
        // System.out.println("Thurday");
        // break;
        // case 5:
        // System.out.println("Friday");
        // break;
        // case 6:
        // System.out.println("Saturday");
        // break;

        // default:
        // System.out.println("No Weekday");
        // }

        // Enhanced Switch
        // switch(weekday){
        // case 1 -> System.out.println("Monday");
        // case 2 -> System.out.println("Tuesday");
        // case 3 -> System.out.println("Wednesday");
        // case 4 -> System.out.println("Thursday");
        // case 5 -> System.out.println("Friday");
        // case 6 -> System.out.println("Saturday");
        // case 7 -> System.out.println("Sunday");
        // }

        // Unary Operator
        // int a = 2;
        // int b = a++;
        // System.out.println(a);
        // System.out.println(b);

        // int a = 2;
        // int b = ++a;
        // System.out.println(a);
        // System.out.println(b);
        
        // int x, y, z;
        // x = y = z = 2;
        // x += y;
        // y -= z;
        // z /= x + y;
        // System.out.println(x + " " + y + " " + z);

    }
}
