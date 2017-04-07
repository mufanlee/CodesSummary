/**
 * LeetCode
 * 450. Delete Node in a BST
 */
public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            TreeNode p = root.right;
            while (p.left != null) p = p.left;
            root.val = p.val;
            root.right = deleteNode(root.right, p.val);
        }
        return root;
    }
}
