import java.util.Arrays;

/**
 * 561. Array Partition I
 * @author LiPeng
 * @since 2017/6/1519:49
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i += 2)
            res += nums[i];
        return res;
    }
}
