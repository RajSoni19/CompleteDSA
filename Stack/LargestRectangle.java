package Stack;

import java.util.Stack;

public class LargestRectangle {
//  s.peek()+1 and s.peek()-1 convert the index of a smaller neighbor into the inclusive start/end indices of the maximal span where arr[i] is the minimum.

    public static int getlarge(int arr[]){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();

        int leftsmall[]=new int[n];
        int rightsmall[]=new int[n];
         
        //pse
        for(int i=0;i<n;i++){
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            leftsmall[i]=s.isEmpty() ? 0:s.peek()+1;
            s.push(i);
        }

        s.clear();

        //nse
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                s.pop();
            }
            rightsmall[i]=s.isEmpty()?n-1:s.peek()-1;
            s.push(i);
        }

        int maxarea=0;
        for(int i=0;i<n;i++){
            int width=rightsmall[i]-leftsmall[i]+1;
            maxarea=Math.max(maxarea,arr[i]*width);
        }
           
        return maxarea;


    }
    public static void main(String[] args) {
        int arr[]={2,4};
        int n=arr.length;
        System.out.println(getlarge(arr));
        //BRUTE
        //  int maxarea=0;
        //  for(int i=0;i<n;i++){
        //     int minheight=Integer.MAX_VALUE;
        //     for(int j=i;j<n;j++){
        //         minheight=Math.min(minheight,arr[j]);
        //         int area=minheight* (j-i+1);//width
        //         maxarea=Math.max(maxarea, area);
        //     }
        //  }
        //  System.out.println(maxarea);
    }
}
