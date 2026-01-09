package Stack;

import java.util.Stack;

public class MaxRectangle {

    public static int largemaxrect(int arr[]){
        int n=arr.length;
        Stack<Integer> s=new Stack<>();
        int largearea=0;
        int area,nse,pse;

        for(int i=0;i<n;i++){  //if max value find then compute area
            while(!s.isEmpty()&&arr[s.peek()]>=arr[i]){
                int ind=s.pop();
                pse=s.isEmpty()?-1:s.peek();
                nse=i;
                area=arr[ind]*(nse-pse-1);
                largearea=Math.max(largearea,area);
            }
            s.push(i);
        }

        //for remaining elements in stack
        while(!s.isEmpty()){
            nse=n;
            int ind=s.pop();
            pse=s.isEmpty()?-1:s.peek();
            area=arr[ind]*(nse-pse-1);
            largearea=Math.max(largearea, area);
        }

        return largearea;


    }

    public static int getmaxrect(int arr[][]){
        int n=arr.length;
        int m=arr[0].length;
        int[][] prefix=new int[n][m];

        for(int j=0;j<m;j++){
         int sum=0;
         for(int i=0;i<n;i++){
            sum+=arr[i][j];
            if(arr[i][j]==0){
                prefix[i][j]=0;
                sum=0;
            }else{
                prefix[i][j]=sum;   
            }
         }
        }

        int maxarea=0;

        for(int i=0;i<n;i++){
            int area=largemaxrect(prefix[i]);
            maxarea=Math.max(area, maxarea);
        }
        return maxarea;
    }
    public static void main(String[] args) {
        int[][] arr = {
            {1, 0, 1, 0, 0},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 0, 0, 1, 0}
        };

        System.out.println(getmaxrect(arr));
    }
}
