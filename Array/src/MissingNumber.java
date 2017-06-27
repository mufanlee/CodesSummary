/**
 * 268. Missing Number
 * @author LiPeng
 * @since 2017/6/2721:22
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int res = 0, i = 0;
        for (; i < nums.length; i++)
            res = res ^ i ^ nums[i];
        return res ^ i;
    }

    public int missingNumber2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        return (1 + nums.length) * nums.length / 2 - sum;
    }
}
