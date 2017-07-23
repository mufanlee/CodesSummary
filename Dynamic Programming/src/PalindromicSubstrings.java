/**
 * 647. Palindromic Substrings
 * @author LiPeng
 * @since 2017/7/2321:14
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int sum = 0;
        // Loop across different middle points.
        for (int i = 0; i < s.length(); i++) {
            // Find all odd length palindrome with i as middle point.
            sum += findPalindromic(s, i, i);
            // Find all even length palindrome with i and i+1 as middle point.
            sum += findPalindromic(s, i, i + 1);
        }
        return sum;
    }

    // Expend from the current mid point to all of its low and high positions.
    private int findPalindromic(String s, int left, int right) {
        int count = 0;
        // Increase count if the substring is a validate palindrome.
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++))
            count++;
        return count;
    }

    //contest
    public int countSubstrings2(String s) {
        boolean [][]dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            res++;
        }
        for (int len = 2; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                if (s.charAt(i) == s.charAt(i+len-1)) {
                    if (len == 2 || dp[i+1][i+len-2] == true) {
                        dp[i][i+len-1] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
