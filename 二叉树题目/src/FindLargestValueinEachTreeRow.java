import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode
 * 515. Find Largest Value in Each Tree Row
 */
public class FindLargestValueinEachTreeRow {
    // 递归解法
    public List<Integer> largestValuesRec(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        dfs(root, 0, ret);
        return ret;
    }

    private static void dfs(TreeNode root, int level, List<Integer> ret) {
        if (root == null) return;
        if (level >= ret.size())
            ret.add(root.val);
        else
            ret.set(level, Math.max(ret.get(level), root.val));
        dfs(root.left, level+1, ret);
        dfs(root.right, level+1, ret);
    }

    // 迭代解法
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int curLevelNodes = 1;
        int nextLevelNode = 0;
        int max = 0;
        boolean flag = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (flag) {
                max = node.val;
                flag = false;
            }
            else max = node.val > max ? node.val : max;
            curLevelNodes--;
            if (node.left != null) {
                queue.add(node.left);
                nextLevelNode++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelNode++;
            }
            if (curLevelNodes == 0) {
                ret.add(max);
                flag = true;
                curLevelNodes = nextLevelNode;
                nextLevelNode = 0;
            }
        }
        return ret;
    }

    // 迭代解法（简洁版）
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) return ret;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                max = Math.max(node.val, max);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ret.add(max);
        }
        return ret;
    }
}
