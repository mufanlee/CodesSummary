/**
 * 485. Max Consecutive Ones
 * @author LiPeng
 * @since 2017/6/1519:57
 */
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1)
                cnt ++;
            else {
                res = Math.max(res, cnt);
                cnt = 0;
            }
        }
        res = Math.max(res, cnt);
        return res;
    }
}
