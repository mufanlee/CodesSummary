import java.util.HashMap;
import java.util.Map;

/**
 * 523. Continuous Subarray Sum
 * @author LiPeng
 * @since 2017/7/1921:22
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum %= k;
            Integer pre = map.get(sum);
            if (pre != null) {
                if (i - pre > 1)
                    return true;
            } else map.put(sum, i);
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return false;
        int []dp = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+2; j <= nums.length; j++) {
                if (k == 0) {
                    if ((dp[j] - dp[i]) == 0)
                        return true;
                } else if ((dp[j] - dp[i]) % k == 0)
                    return true;
            }
        }
        return false;
    }
}
