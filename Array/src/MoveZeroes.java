/**
 * 283. Move Zeroes
 * @author LiPeng
 * @since 2017/6/1718:29
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && i != k)
                nums[k++] = nums[i];
        }
        while (k < nums.length)
            nums[k++] = 0;
    }

    public void moveZeroes2(int[] nums) {
        for (int i = 0, k = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k++] = tmp;
            }
        }
    }
}
