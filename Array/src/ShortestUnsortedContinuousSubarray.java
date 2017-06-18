import java.util.Arrays;
import java.util.Stack;

/**
 * 581. Shortest Unsorted Continuous Subarray
 * @author LiPeng
 * @since 2017/6/1718:56
 */
public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0;
        for (; l < nums.length - 1 && nums[l] <= nums[l+1]; l++);
        if (l == nums.length - 1) return 0;
        int r = nums.length - 1;
        for (; r > 0 && nums[r] >= nums[r-1]; r--);
        if (l < r) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = l; i <= r; i++) {
                if (nums[i] > max) max = nums[i];
                if (nums[i] < min) min = nums[i];
            }
            for (;l >= 0 && nums[l] > min; l--);
            for (;r < nums.length && nums[r] < max; r++);
        }
        return r - l + 1;
    }

    public int findUnsortedSubarray1(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n-1], max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-1-i]);
            if (nums[i] < max) end = i;
            if (nums[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }

    public int findUnsortedSubarray2(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start >= 0 ? end - start + 1 : 0;
    }

    public int findUnsortedSubarray3(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }

    //Time Limit Exceeded
    //O(n^2)
    public int findUnsortedSubarray4(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
