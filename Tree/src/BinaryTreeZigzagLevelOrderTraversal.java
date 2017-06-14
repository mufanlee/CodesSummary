import java.util.*;

/**
 * LeetCode
 * 103. Binary Tree Zigzag Level Order Traversal
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    // 偶数层后插，奇数层前插
    // 递归解法
    public List<List<Integer>> zigzagLevelOrderRec(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        dfs(root, 0, lists);
        return lists;
    }

    private static void dfs(TreeNode root, int level, List<List<Integer>> ret) {
        if (root == null) return;
        if (level >= ret.size())
            ret.add(new ArrayList<Integer>());
        if (level % 2 == 0)
            ret.get(level).add(root.val);
        else ret.get(level).add(0, root.val);
        dfs(root.left, level+1, ret);
        dfs(root.right, level+1, ret);
    }

    // 迭代解法
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode p = queue.poll();
                if (level % 2 == 0)
                    list.add(p.val);
                else list.add(0, p.val);
                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
            }
            level ++;
            lists.add(list);
        }
        return lists;
    }

    // 两个栈
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        Stack<TreeNode> curStack = new Stack<>();
        Stack<TreeNode> nxtStack = new Stack<>();
        curStack.push(root);
        List<Integer> list = new ArrayList<>();
        int level = 0;
        while (!curStack.isEmpty()) {
            TreeNode p = curStack.pop();
            list.add(p.val);
            if (level % 2 == 0) {
                if (p.left != null) nxtStack.push(p.left);
                if (p.right != null) nxtStack.push(p.right);
            }else {
                if (p.right != null) nxtStack.push(p.right);
                if (p.left != null) nxtStack.push(p.left);
            }
            if (curStack.isEmpty()) {
                lists.add(list);
                list = new ArrayList<>();
                curStack = nxtStack;
                nxtStack = new Stack<>();
                level++;
            }
        }
        return lists;
    }
}
