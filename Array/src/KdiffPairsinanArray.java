import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 532. K-diff Pairs in an Array
 * @author LiPeng
 * @since 2017/6/1519:52
 */
public class KdiffPairsinanArray {
    public int findPairs(int[] nums, int k) {
        if (nums == null) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == k) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public int findPairs2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2)
                    res++;
            }
            else {
                if (map.containsKey(entry.getKey() + k))
                    res++;
            }
        }
        return res;
    }
}
