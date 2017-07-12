/**
 * 633. Sum of Square Numbers
 * @author LiPeng
 * @since 2017/7/215:47
 */
public class SumofSquareNumbers {
    // Brute Force[Time Limit Exceeded]
    public boolean judgeSquareSum1(int c) {
        for (long a = 0; a * a <= c; a++) {
            for (long b = 0; b * b <= c; b++) {
                if (a * a + b * b == c)
                    return true;
            }
        }
        return false;
    }
    // Better Brute Force[Time Limit Exceeded]
    /**
     * 定理：第n个正整数的平方可以用前n个奇数的和表示。
     */
    public boolean judgeSquareSum2(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int) (a * a);
            // 判断b是否是平方数
            int i = 1, sum = 0;
            while (sum < b) {
                sum += i;
                i += 2;
            }
            if (sum == b) return true;
        }
        return false;
    }
    // Using sqrt function
    public boolean judgeSquareSum3(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b)
                return true;
        }
        return false;
    }
    // Using Binary Search
    public boolean judgeSquareSum4(int c) {
        for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binarySearch(0, b, b))
                return true;
        }
        return false;
    }
    public boolean binarySearch(long s, long e, int n) {
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        else if (mid * mid > n)
            return binarySearch(s, mid - 1, n);
        else return binarySearch(mid + 1, e, n);
    }
    // Fermat Theorem

    /**
     * 费马定理：任何正整数n能够表示为两个平方数的和，当且仅当n的质因素分解的每个(4k+3)形式的质数出现偶数次。
     */
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}
