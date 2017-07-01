import java.util.Arrays;

/**
 * 628. Maximum Product of Three Numbers
 * @author LiPeng
 * @since 2017/7/122:32
 */
public class MaximumProductofThreeNumbers {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] <= min2) {
                min2 = nums[i];
            }
            if (nums[i] >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] >= max2) {
                max3 =  max2;
                max2 = nums[i];
            } else if (nums[i] >= max3) {
                max3 = nums[i];
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }

    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int b = nums[0] * nums[1] * nums[nums.length - 1];
        return a > b ? a : b;
    }
}
