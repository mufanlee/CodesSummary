import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode
 * 513. Find Bottom Left Tree Value
 */
public class FindBottomLeftTreeValue {
    public static int getDepthRec(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
    }

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        int lh = getDepthRec(root.left);
        int rh = getDepthRec(root.right);
        if (lh == 0 && rh == 0) return root.val;
        if (lh >= rh) return findBottomLeftValue(root.left);
        else return findBottomLeftValue(root.right);
    }

    // 层次遍历，先向队列添加右节点
    public static int findBottomLeftValue2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
        }
        return node.val;
    }

    // 递归解法
    int ans=0, h=0;
    public int findBottomLeftValue3(TreeNode root) {
        findBottomLeftValueCore(root, 1);
        return ans;
    }
    public void findBottomLeftValueCore(TreeNode root, int depth) {
        if (h < depth) {ans = root.val; h = depth;}
        if (root.left != null) findBottomLeftValueCore(root.left, depth+1);
        if (root.right != null) findBottomLeftValueCore(root.right, depth+1);
    }
}
