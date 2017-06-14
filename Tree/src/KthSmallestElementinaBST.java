import java.util.Stack;

/**
 * LeetCode
 * 230. Kth Smallest Element in a BST
 */
public class KthSmallestElementinaBST {

    // 中序遍历递归解法
    private int n = 0;
    private int result = 0;
    public int kthSmallestRec(TreeNode root, int k) {
        if (root == null) return -1;
        inorder(root, k);
        return result;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) return ;
        inorder(root.left, k);
        n++;
        if (n == k) {
            result = root.val;
        }
        inorder(root.right, k);
    }

    // 中序遍历迭代解法
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.empty()) {
                p = stack.pop();
                k --;
                if (k == 0) return p.val;
                p = p.right;
            }
        }
        return -1;
    }

    /**
     * 1.计算左子树元素个数l
     * 2.l+1=k，则根节点即为第k个元素
     *   l>=k，则第k个元素在左子树中
     *   l+1<k，则第k个元素在右子树中
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        if (root == null) return -1;
        int l = getNodeNum(root.left);
        if (l + 1 == k) return root.val;
        else if (l >= k) return kthSmallest2(root.left, k);
        else return kthSmallest2(root.right, k - l - 1);
    }

    public int getNodeNum(TreeNode root) {
        if (root == null) return 0;
        return getNodeNum(root.left) + getNodeNum(root.right) + 1;
    }
}
