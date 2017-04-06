import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode
 * 199. Binary Tree Right Side View
 */
public class BinaryTreeRightSideView {
    // 递归解法
    public List<Integer> rightSideViewRec(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideViewRecCore(root, 0, list);
        return list;
    }

    public void rightSideViewRecCore(TreeNode root, int depth, List<Integer> list) {
        if (root == null) return;
        if (depth == list.size()) list.add(root.val);
        rightSideViewRecCore(root.right, depth+1, list);
        rightSideViewRecCore(root.left, depth+1, list);
    }

    // 层次遍历
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.remove();
                if (i == size - 1) list.add(p.val);
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
            }
        }
        return list;
    }
}
