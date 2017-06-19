/**
 * 53. Maximum Subarray
 * @author LiPeng
 * @since 2017/6/1921:41
 */
public class MaximumSubarray {
    // Dynamic Programming
    public int maxSubArray1(int[] nums) {
        int res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum <= 0)
                sum = nums[i];
            else
                sum += nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            if (sum > res) res = sum;
        }
        return res;
    }

    // Divide and Conquer
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        return maxSubArrayCore(nums, 0, nums.length - 1);
    }

    public int maxSubArrayCore(int[] nums, int l, int r) {
        if (l == r) return nums[l];
        int mid = (l + r) / 2;
        int x = maxSubArrayCore(nums, l, mid);
        int y = maxSubArrayCore(nums, mid + 1, r);
        int sum = nums[mid], lmax = nums[mid];
        for (int i = mid - 1; i >= l; i--) {
            sum += nums[mid];
            if (sum > lmax) lmax = sum;
        }
        int rmax = nums[mid+1];
        sum = nums[mid+1];
        for (int i = mid + 2; i <= r; i++) {
            sum += nums[mid];
            if (sum > rmax) rmax = sum;
        }
        return Math.max(lmax+rmax, Math.max(x, y));
    }
}
