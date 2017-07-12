/**
 * 91. Decode Ways
 * @author LiPeng
 * @since 2017/7/1221:13
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (null == s || 0 == s.length())
            return 0;
        int first = 1, second = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            int tmp = second;
            if (s.charAt(i) == '0') {
                second = 0;
            }
            if ((s.charAt(i-1) == '1') || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
                second += first;
            }
            first = tmp;
        }
        return second;
    }

    public int numDecodings2(String s) {
        if (null == s || 0 == s.length())
            return 0;
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                dp[i+1] = dp[i];
            }

            if ((s.charAt(i-1) == '1') || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
                dp[i+1] += dp[i-1];
            }
        }
        return dp[s.length()];
    }
}
