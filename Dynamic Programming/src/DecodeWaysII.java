/**
 * 639. Decode Ways II
 * @author LiPeng
 * @since 2017/7/1021:08
 */
public class DecodeWaysII {
    final int MOD = 1000000007;
    public int numDecodings(String s) {
        long dp[] = new long[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '*') {
            dp[1] = 9;
        } else {
            if (s.charAt(0) == '0') {
                dp[1] = 0;
            } else {
                dp[1] = 1;
            }
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                dp[i+1] = 9 * dp[i];
                if (s.charAt(i-1) == '1') {
                    dp[i+1] = (dp[i+1] + 9 * dp[i-1]) % MOD;
                } else if (s.charAt(i-1) == '2') {
                    dp[i+1] = (dp[i+1] + 6 * dp[i-1]) % MOD;
                } else if (s.charAt(i-1) == '*') {
                    dp[i+1] = (dp[i+1] + 15 * dp[i-1]) % MOD;
                }
            } else {
                if (s.charAt(i) != '0') {
                    dp[i + 1] = dp[i];
                } else {
                    dp[i + 1] = 0;
                }
                if (s.charAt(i-1) == '1') {
                    dp[i+1] = (dp[i+1] + dp[i-1]) % MOD;
                } else if (s.charAt(i-1) == '2' && s.charAt(i) <= '6') {
                    dp[i+1] = (dp[i+1] + dp[i-1]) % MOD;
                } else if (s.charAt(i-1) == '*') {
                    if (s.charAt(i) <= '6') {
                        dp[i+1] = (dp[i+1] + 2 * dp[i-1]) % MOD;
                    } else {
                        dp[i+1] = (dp[i+1] + dp[i-1]) % MOD;
                    }
                }
            }
        }
        return (int)dp[s.length()];
    }

    public int numDecodings2(String s) {
        long first = 1;
        long second = 0;
        if (s.charAt(0) == '*') {
            second = 9;
        } else if (s.charAt(0) == '0') {
            second = 0;
        } else {
            second = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            long tmp = second;
            if (s.charAt(i) == '*') {
                second = 9 * second;
                if (s.charAt(i-1) == '1') {
                    second = (second + 9 * first) % MOD;
                } else if (s.charAt(i-1) == '2') {
                    second = (second + 6 * first) % MOD;
                } else if (s.charAt(i-1) == '*') {
                    second = (second + 15 * first) % MOD;
                }
            } else {
                if (s.charAt(i) == '0') {
                    second = 0;
                }
                if (s.charAt(i-1) == '1') {
                    second = (second + first) % MOD;
                } else if (s.charAt(i-1) == '2' && s.charAt(i) <= '6') {
                    second = (second + first) % MOD;
                } else if (s.charAt(i-1) == '*') {
                    if (s.charAt(i) <= '6') {
                        second = (second + 2 * first) % MOD;
                    } else {
                        second = (second + first) % MOD;
                    }
                }
            }
            first = tmp;
        }
        return (int) second;
    }
}
