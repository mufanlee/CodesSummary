/**
 * 650. 2 Keys Keyboard
 * @author LiPeng
 * @since 2017/7/3018:38
 */
public class Keys2Keyboard {
    public int minSteps(int n) {
        int []dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i-1; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        return dp[n];
    }
    // contest
    public int minSteps2(int n) {
        int []dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            int min = i;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    min = Math.min(min, dp[j] + i / j);
                }
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
