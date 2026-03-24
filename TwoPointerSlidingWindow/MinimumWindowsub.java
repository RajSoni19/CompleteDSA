package TwoPointerSlidingWindow;

public class MinimumWindowsub {
    public static void main(String[] args) {

        // Source string in which we need to find the minimum window
        String s = "ddaaabbca";

        // Target string whose all characters must be present in the window
        String t = "abc";

        // Edge case: if either string is empty, nothing meaningful to process
        // (Current code prints empty line, then continues execution)
        if (s.isEmpty() || t.isEmpty()) System.out.println("");

        // Left and right pointers for sliding window [l, r)
        int l = 0;
        int r = 0;

        // Track minimum valid window length and its starting index
        int minlen = Integer.MAX_VALUE;
        int startind = -1;

        // count = number of required characters matched so far in current window
        int count = 0;

        int n = s.length();
        int m = t.length();

        // Frequency array for required characters (ASCII-based)
        int hash[] = new int[256];

        // Build frequency map of target string
        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        // Expand window using right pointer
        while (r < n) {

            // If this character is still needed, increase matched count
            if (hash[s.charAt(r)] > 0) {
                count++;
            }

            // Include current right character in window:
            // decrement its needed frequency
            hash[s.charAt(r)]--;
            r++;

            // If all target characters matched, try shrinking from left
            while (count == m) { // valid window found; attempt to minimize it

                // Update best answer if current window is smaller
                if (r - l < minlen) {
                    minlen = r - l;
                    startind = l;
                }

                // Remove left character from window:
                // restore frequency in hash
                hash[s.charAt(l)]++;

                // If restored frequency becomes > 0, window is now missing this char
                // so matched count decreases
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }

                // Move left pointer ahead to continue shrinking
                l++;
            }
        }

        // If no valid window found, print a space
        if (startind == -1) {
            System.out.println(" ");
        } else {
            // Print minimum window substring
            System.out.println(s.substring(startind, startind + minlen));
        }
    }
}
