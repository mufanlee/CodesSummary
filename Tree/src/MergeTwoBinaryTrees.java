/**
 * 617. Merge Two Binary Trees
 * @author LiPeng
 * @since 2017/7/1221:15
 */
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            t1.val += t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (null == t1 && null == t2) return null;
        TreeNode root = new TreeNode(0);
        if (null != t1)
            root.val += t1.val;
        if (null != t2)
            root.val += t2.val;
        root.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        root.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return root;
    }
}
