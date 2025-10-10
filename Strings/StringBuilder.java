package Strings;
public class StringBuilder {
  public static void main(String[] args) {
    java.lang.StringBuilder sb=new java.lang.StringBuilder("Hello");
    for(char c='a';c<='z';c++){
        sb.append(c);
    }
    System.out.println(sb);
    System.out.println(sb.length());
  }
    
}
