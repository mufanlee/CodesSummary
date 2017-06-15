/**
 * 27. Remove Element
 * @author LiPeng
 * @since 2017/6/1520:17
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[n++] = nums[i];
        }
        return n;
    }
}
