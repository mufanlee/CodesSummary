import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode
 * 501. Find Mode in Binary Search Tree
 */
public class FindModeinBinarySearchTree {
    // 使用Map存每个元素的个数
    Map<Integer, Integer> map = new HashMap<>();
    int maxnum = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        inorderRec(root);
        List<Integer> list = new ArrayList<>();
        for (int key : map.keySet())
        {
            if (map.get(key) == maxnum)
                list.add(key);
        }
        int []res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    public void inorderRec(TreeNode root) {
        if (root == null) return;
        inorderRec(root.left);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        maxnum = Math.max(maxnum, map.get(root.val));
        inorderRec(root.right);
    }

    // 不使用Map
    TreeNode pre = null;
    int count = 1;
    int max = 0;
    public int[] findMode2(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int []res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        if (pre != null)
            if (root.val == pre.val) {
                count++;
            }else {
                count = 1;
            }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        }else if (count == max) {
            list.add(root.val);
        }
        pre = root;
        inorder(root.right, list);
    }
}
