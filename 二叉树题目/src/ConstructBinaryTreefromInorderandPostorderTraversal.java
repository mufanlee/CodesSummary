import java.util.HashMap;

/**
 * LeetCode
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) return null;
        return buildTreeCore(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    private TreeNode buildTreeCore(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int i = is;
        while (i <= ie && inorder[i] != postorder[pe]) i++;
        root.left = buildTreeCore(inorder, is, i-1, postorder, ps, ps+i-is-1);
        root.right = buildTreeCore(inorder, i+1, ie, postorder, ps+i-is, pe-1);
        return root;
    }

    // 使用Map降低复杂度
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTreeCore(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
    private TreeNode buildTreeCore(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> map) {
        if (is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int i = map.get(root.val);
        root.left = buildTreeCore(inorder, is, i-1, postorder, ps, ps+i-is-1, map);
        root.right = buildTreeCore(inorder, i+1, ie, postorder, ps+i-is, pe-1, map);
        return root;
    }
}
