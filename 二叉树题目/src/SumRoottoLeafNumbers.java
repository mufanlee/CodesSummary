import java.util.Stack;

/**
 * LeetCode
 * 129. Sum Root to Leaf Numbers
 */
public class SumRoottoLeafNumbers {
    public int sumNumbersRec(TreeNode root) {
        return preorder(root, 0);
    }

    public int preorder(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) return sum;
        return preorder(root.left, sum) + preorder(root.right, sum);
    }

    // 后序遍历
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        int sum = 0;
        int total = 0;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                sum = sum * 10 + p.val;
                p = p.left;
            }
            p = stack.peek();
            if (p.right != null && p.right != pre)
                p = p.right;
            else {
                if (p.left == null && p.right == null) total+=sum;
                sum /= 10;
                pre = stack.pop();
                p = null;
            }
        }
        return total;
    }
}
