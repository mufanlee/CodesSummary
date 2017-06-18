/**
 * 35. Search Insert Position
 * @author LiPeng
 * @since 2017/6/1718:43
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    public int searchInsert2(int[] nums, int target) {
        int i = 0;
        for (;i < nums.length && nums[i] < target; i++);
        return i;
    }
}
