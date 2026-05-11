package Greedy;

public class Jumpgame2 {

    public static int getjumps(int arr[]) {

        int n = arr.length;

        int jump = 0;
        int l = 0, r = 0;

        while(r < n - 1) {

            int farthest = 0;

            for(int ind = l; ind <= r; ind++) {
                farthest = Math.max(ind + arr[ind], farthest);
            }

            l = r + 1;
            r = farthest;

            jump++;
        }

        return jump;
    }

    public static void main(String[] args) {

        int arr[] = {2,3,1,4,1,1,1,2};

        System.out.println(getjumps(arr));
    }
}