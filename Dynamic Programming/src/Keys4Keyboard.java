/**
 * 651. 4 Keys Keyboard
 * @author LiPeng
 * @since 2017/7/3019:00
 */
public class Keys4Keyboard {
    public int maxA(int N) {
        int []dp = new int[N+1];
        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = i-3; j >= 1; j--) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }
        return dp[N];
    }

    public int maxA2(int N) {
        if (N <= 6)
            return N;
        int []dp = new int[N+1];
        for (int i = 0; i < 7; i++)
            dp[i] = i;
        for (int i = 7; i <= N; i++) {
            int max = i;
            for (int j = i-3, t = 1; j > 1; j--) {
                max = Math.max(max, dp[j] * (t+1));
                t++;
            }
            dp[i] = max;
        }
        return dp[N];
    }
}
