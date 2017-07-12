import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree
 * @author LiPeng
 * @since 2017/7/921:01
 */
public class AverageofLevelsinBinaryTree {
    // Depth First Search
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();
        dfs(root, 0, res, cnt);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / cnt.get(i));
        }
        return res;
    }

    public void dfs(TreeNode root, int depth, List<Double> res, List<Integer> cnt) {
        if (root == null) return;
        if (depth < res.size()) {
            res.set(depth, res.get(depth) + root.val);
            cnt.set(depth, cnt.get(depth) + 1);
        } else {
            res.add(0.0 + root.val);
            cnt.add(1);
        }
        if (root.left != null) {
            dfs(root.left, depth+1, res, cnt);
        }
        if (root.right != null) {
            dfs(root.right, depth+1, res, cnt);
        }
    }
    // Breadth First Search
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            double sum = 0.0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                sum += p.val;
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }
}
