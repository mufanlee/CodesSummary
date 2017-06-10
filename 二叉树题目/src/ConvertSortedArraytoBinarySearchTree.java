/**
 * 108. Convert Sorted Array to Binary Search Tree
 * @author LiPeng
 * @since 2017/6/1012:46
 */
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return sortedArrayToBSTCore(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTCore(int []nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTCore(nums, start, mid-1);
        root.right = sortedArrayToBSTCore(nums, mid+1, end);
        return root;
    }
}
