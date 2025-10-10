package BitManipulation;
//refer leetcode
public class DividetwoInt {

    public static int divideit(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;
        boolean sign = true;
        if (dividend >= 0 && divisor < 0)
            sign = false;
        if (dividend < 0 && divisor > 0) sign = false;
           
            if (dividend == Integer.MIN_VALUE && divisor == -1)
                return Integer.MAX_VALUE;
            if (divisor == 1)
                return dividend;
        long n = Math.abs(dividend);
        long d = Math.abs(divisor);
        int q = 0;
        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }
            q += 1 << cnt;
            n -= (d << cnt);
        }

        if (q == (1 << 31) && sign) {
            return Integer.MAX_VALUE;
        }

        if (q == (1 << 31) && !sign) {
            return Integer.MIN_VALUE;
        }

        return sign ? q : -q;
    }

    public static void main(String args[]) {
        int dividend = 22;
        int divisor = 3;
        int ans = divideit(dividend, divisor);
        System.out.println(ans);
    }
}