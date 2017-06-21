import java.util.HashMap;
import java.util.Map;

/**
 * 167. Two Sum II - Input array is sorted
 * @author LiPeng
 * @since 2017/6/2122:18
 */
public class TwoSumIIInputarrayissorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum < target)
                l++;
            else if (sum > target)
                r--;
            else
                return new int[] {l+1, r+1};
        }
        return null;
    }

    public int[] twoSum2(int[] numbers, int target) {
        if (numbers.length <= 1) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i]))
                return new int[]{map.get(target - numbers[i]), i + 1};
            map.put(numbers[i], i + 1);
        }
        return null;
    }
}
