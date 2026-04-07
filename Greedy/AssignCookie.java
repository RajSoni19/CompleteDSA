package Greedy;
import java.util.*;
public class AssignCookie {

    public static int getcount(int g[],int s[]){
        Arrays.sort(g);
        Arrays.sort(s);
        int l=0,r=0;
        int n=g.length;
        int m=s.length;
        while(r<n && l<m){
            if(s[l]>=g[r]){  // If the cookie satisfies the student's greed
                r++; //move to next student
            }
            l++;  // Move to next cookie in both cases // Whether the cookie was eaten, or it was too small to feed the child,
        }
        return r;
    }
    public static void main(String[] args) {
        int g[]={1,2,3}; //students
        int s[]={1,1}; //cookies
        System.out.println(getcount(g,s));
    }
}
