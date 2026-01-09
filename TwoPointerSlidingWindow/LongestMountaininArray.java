package TwoPointerSlidingWindow;

public class LongestMountaininArray {
    public static void main(String[] args) {
        int arr[] = { 2, 1, 4, 7, 3, 2, 5 };
        int n = arr.length;
        if (n < 3){
            System.out.println(0);
            return;
        }
        int maxlen = 0;
        for (int i = 1; i < n - 1; i++) {

            // Step 1: check if arr[i] is a peak
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                int left = i;
                int right = i;

                // Step 2: expand left (strictly increasing)
                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }

                // Step 3: expand right (strictly decreasing)
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Step 4: update answer

                maxlen = Math.max(maxlen, right - left + 1);

            }
        }
        System.out.println(maxlen);

    }
}