/**
 * 189. Rotate Array
 * @author LiPeng
 * @since 2017/7/119:10
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int cnt = 0;
        for (int start = 0; cnt < nums.length; start++) {
            int cur = start;
            int pre = nums[start];
            do {
                int next = (cur + k) % nums.length;
                int tmp = nums[next];
                nums[next] = pre;
                cur = next;
                pre = tmp;
                cnt++;
            } while (start != cur);
        }
    }

    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[]nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        int a[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public void rotate3(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) return;
        int len = k % nums.length;
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            tmp[len - i - 1] = nums[nums.length - i - 1];
        }
        for (int i = nums.length - 1; i >= len; i--) {
            nums[i] = nums[i - len];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = tmp[i];
        }
    }
}
