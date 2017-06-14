/**
 * LeetCode
 * 222. Count Complete Tree Nodes
 */
public class CountCompleteTreeNodes {
    /**
     * 如果左子树的高度等于右子树的高度，则左子树为满二叉树
     * 如果左子树的高度大于右子树的高度，则右子树为满二叉树
     * @param root
     * @return
     */
    //  Time Limit Exceeded
    /*public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);
        if (lh == rh)
            return (1 << lh) + countNodes(root.right);
        else return (1 << rh) + countNodes(root.left);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return height(root.left) + 1;
    }*/

    /**
     * 如果某结点一直向左的高度=一直向右的高度，则以该结点为root的子树一定是满二叉树，结点数=2^h-1
     * 如果不相等，则递归调用1 + countNodes(root.left) + countNodes(root.right)
     * 时间复杂度为O(h^2)
     * @param root
     * @return
     */
    /*public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = 0, rh = 0;
        TreeNode p = root;
        while (p != null) {
            lh ++;
            p = p.left;
        }
        p = root;
        while (p != null) {
            rh ++;
            p = p.right;
        }
        if (lh == rh) return (1 << lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }*/
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = 0, rh = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (right != null) {
            lh ++;
            rh ++;
            right = right.right;
            left = left.left;
        }
        if (left == null) return (1 << lh) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes2(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1;
        int height = 0;
        int count = 0;
        TreeNode p = root;
        while (p != null) {
            count += (1 << height);
            height++;
            p = p.left;
        }
        return count + countLeaf(root, height);
    }

    private int countLeaf(TreeNode root, int height) {
        if (height == 1)
            if (root.right != null) return 2;
            else if (root.left != null) return 1;
            else return 0;
        TreeNode midNode = root.left;
        int h = 1;
        while (h < height) {
            h ++;
            midNode = midNode.right;
        }
        // 叶子结点在midNode的左子树
        if (midNode == null) return countLeaf(root.left, height-1);
        else return (1 << (height-1)) + countLeaf(root.right, height-1);
    }
}
