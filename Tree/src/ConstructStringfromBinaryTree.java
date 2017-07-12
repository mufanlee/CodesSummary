/**
 * 606. Construct String from Binary Tree
 * @author LiPeng
 * @since 2017/7/1221:44
 */
public class ConstructStringfromBinaryTree {
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        String s = t.val + "";
        if(t.left != null || t.right != null)
            s += "(" + tree2str(t.left) + ")";
        if(t.right != null)
            s += "(" + tree2str(t.right) + ")";
        return s;
    }
}
