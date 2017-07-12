/**
 * 367. Valid Perfect Square
 * @author LiPeng
 * @since 2017/7/216:26
 */
public class ValidPerfectSquare {
    /**
     * 定理：第n个平方数可以表示为前n个奇数的和。
     */
    public boolean isPerfectSquare1(int num) {
        long i = 1, sum = 0;
        while (sum < num) {
            sum += i;
            i += 2;
        }
        return sum == num;
    }

    public boolean isPerfectSquare2(int num) {
        for (long i = 1; i * i <= num; i++) {
            if (i * i == num) return true;
        }
        return false;
    }

    // Binary Search
    public boolean isPerfectSquare3(int num) {
        int l = 1, r = num;
        while ( l <= r) {
            long mid = (l + r) / 2;
            if (mid * mid == num)
                return true;
            else if (mid * mid > num)
                r = (int) mid - 1;
            else l = (int) mid + 1;
        }
        return false;
    }

    //Newton Method
    public boolean isPerfectSquare(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}
