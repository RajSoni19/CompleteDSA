package TwoPointerSlidingWindow;

public class MaxavgSubarr {
    public static void main(String[] args) {
        int nums[] = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        int n = nums.length;
        int sum = 0;
        // Step 1: sum of first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxsum = sum;
        // Step 2: slide the window
        // When the window moves one step right:

        // One element enters the window → nums[i]

        // One element leaves the window → nums[i - k]
        for (int i = k; i < n; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxsum = Math.max(maxsum, sum);
        }
        // Step 3: return avg
        System.out.println(maxsum / k);

    }
}
