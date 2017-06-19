/**
 * 88. Merge Sorted Array
 * @author LiPeng
 * @since 2017/6/1922:06
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        while (m > 0  && n > 0) {
            if (nums1[m - 1] > nums2[n - 1])
                nums1[k--] = nums1[(m--) - 1];
            else
                nums1[k--] = nums2[(n--) - 1];
        }
        while (n > 0)
            nums1[k--] = nums2[(n--) - 1];
    }
}
