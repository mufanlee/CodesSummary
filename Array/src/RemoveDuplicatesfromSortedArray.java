/**
 * 26. Remove Duplicates from Sorted Array
 * @author LiPeng
 * @since 2017/6/1520:12
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
}
