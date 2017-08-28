import java.util.*;

/**
 * 652. Find Duplicate Subtrees
 * @author LiPeng
 * @since 2017/7/3019:27
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) return "#";
        String str = root.val + postorder(root.left, map, res) + postorder(root.right, map, res);
        if (map.getOrDefault(str, 0) <= 1) {
            if (map.getOrDefault(str, 0) == 1)
                res.add(root);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return str;
    }

    // Time Limit Exceeded
    public static boolean isSameRec(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSameRec(root1.left, root2.left) && isSameRec(root1.right, root2.right);
    }

    public static boolean hasSubTree(TreeNode root, TreeNode node) {
        boolean res = false;
        if (root != null && node != null && root != node)
        {
            if (root.val == node.val) {
                res = isSameRec(root, node);
            }
            if (res != true) {
                res = hasSubTree(root.left, node);
            }
            if (res != true) {
                res = hasSubTree(root.right, node);
            }
        }
        return res;
    }

    public List<TreeNode> findDuplicateSubtrees2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            boolean flag = true;
            for (int i = 0; i < list.size(); i++) {
                if (isSameRec(list.get(i), node)) {
                    flag = false;
                }
            }
            if (flag) {
                if (hasSubTree(root, node)) {
                    list.add(node);
                }
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }
}
