/**
 * Binary Search Tree
 */
public class BinarySearchTree {

    /**
     * 二叉搜索树的搜索（递归）
     * (1)如果根结点为空，返回空。
     * (2)如果x小于root的值，则递归搜索左子树。
     * (3)如果x大于root的值，则递归搜索右子树。
     * (4)如果x等于root的值，则返回该结点。
     * @param root 根结点
     * @param x 要搜索的值
     * @return 等于x的结点
     */
    TreeNode search(TreeNode root, final int x) {
        if (root == null) return null;
        if (root.val > x) return search(root.left, x);
        else if (root.val < x) return search(root.right, x);
        else return root;
    }

    /**
     * 二叉搜索树的插入（递归）
     * (1)如果根结点为空，这新建结点。
     * (2)如果x小于root的值，则递归插入左子树。
     * (3)如果x大于root的值，则递归插入右子树。
     * (4)如果x等于root的值，则返回假。
     * @param root 根结点
     * @param x 要插入的值
     * @return 插入是否成功
     */
    boolean insert(TreeNode root, final int x) {
        if (root == null) return false;
        if (root.val > x) {
            if (root.left == null)
                root.left = new TreeNode(x);
            else return insert(root.left, x);
        }
        if (root.val < x) {
            if (root.right == null)
                root.right = new TreeNode(x);
            return insert(root.right, x);
        }
        return false;
    }

    /**
     * 二叉搜索树的插入（递归）
     * (1)如果根结点为空，这新建结点。
     * (2)如果x小于root的值，则递归插入左子树。
     * (3)如果x大于root的值，则递归插入右子树。
     * (4)如果x等于root的值，则返回假。
     * @param root 根结点
     * @param x 要插入的值
     * @return 插入值的节点
     */
    TreeNode insert2(TreeNode root, final int x) {
        if (root == null) return new TreeNode(x);
        if (root.val > x) root.left = insert2(root.left, x);
        if (root.val < x) root.right =  insert2(root.right, x);
        return root;
    }

    /**
     * 二叉搜索树的删除（递归）
     * (1)如果被删除结点左、右子女结点都不为空，在它的右子树中寻找中序下的第一个结点（最小），用它的值来填补要删除的结点中，再处理这个结点的删除问题。
     * (2)如果要删除叶结点，只需将其父结点指针清零
     * (3)如果要删除结点右子树为空，可以拿它的左子女结点顶替它的位置
     * (4)如果要删除结点左子树为空，可以拿它的右子女结点顶替它的位置
     * @param root 根结点
     * @param x 要删除的值
     * @return 删除是否成功
     */
    boolean remove(TreeNode root, final int x) {
        if (root == null) return false;
        if (root.val > x) return remove(root.left, x);         // 在左子树中执行删除
        else if (root.val < x) return remove(root.right, x);   // 在右子树中执行删除
        else {                                          // root指向x结点，它有两个子女，搜索右子树中序下的第一个结点
            if (root.left != null && root.right != null) {
                TreeNode p = root.right;
                while (p.left != null) p = p.left;
                root.val = p.val;                       // 用该结点值代替root结点值
                remove(root.right, p.val);
            } else {                                    // root指向x结点，只有一个子女或者没有子女
                if (root.left == null) {
                    root.val = root.right.val;
                    root.left = root.right.left;
                    root.right = root.right.right;
                }
                else {
                    root.val = root.left.val;
                    root.right = root.left.right;
                    root.left = root.left.left;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 二叉搜索树的删除（递归）
     * (1)如果被删除结点左、右子女结点都不为空，在它的左子树中寻找中序下的最后一个结点（最大），用它的值来填补要删除的结点中，再处理这个结点的删除问题。
     * (2)如果要删除叶结点，只需将其父结点指针清零
     * (3)如果要删除结点右子树为空，可以拿它的左子女结点顶替它的位置
     * (4)如果要删除结点左子树为空，可以拿它的右子女结点顶替它的位置
     * @param root 根结点
     * @param x 要删除的值
     * @return 删除是否成功
     */
    boolean remove2(TreeNode root, final int x) {
        if (root == null) return false;
        if (root.val > x) return remove2(root.left, x);         // 在左子树中执行删除
        else if (root.val < x) return remove2(root.right, x);   // 在右子树中执行删除
        else {                                          // root指向x结点，它有两个子女，搜索左子树中序下的最后一个结点
            if (root.left != null && root.right != null) {
                TreeNode p = root.left;
                while (p.right != null) p = p.right;
                root.val = p.val;                       // 用该结点值代替root结点值
                remove2(root.left, p.val);
            } else {                                    // root指向x结点，只有一个子女或者没有子女
                if (root.left == null) {
                    root.val = root.right.val;
                    root.left = root.right.left;
                    root.right = root.right.right;
                }
                else {
                    root.val = root.left.val;
                    root.right = root.left.right;
                    root.left = root.left.left;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 二叉搜索树的删除（递归）
     * (1)如果被删除结点左、右子女结点都不为空，在它的左子树中寻找中序下的最后一个结点（最大），用它的值来填补要删除的结点中，再处理这个结点的删除问题。
     * (2)如果要删除叶结点，只需将其父结点指针清零
     * (3)如果要删除结点右子树为空，可以拿它的左子女结点顶替它的位置
     * (4)如果要删除结点左子树为空，可以拿它的右子女结点顶替它的位置
     * @param root 根结点
     * @param x 要删除的值
     * @return 返回值不为空，则删除成功
     */
    TreeNode remove3(TreeNode root, final int x) {
        if (root == null) return null;
        if (root.val > x) root.left = remove3(root.left, x);
        else if (root.val < x) root.right = remove3(root.right, x);
        else {
            if (root.right == null) return root.left;
            if (root.left == null) return root.right;
            TreeNode p = root.right;
            while (p.left != null) p = p.left;
            root.val = p.val;
            root.right = remove3(root.right, p.val);
        }
        return root;
    }
}

/*
                 4 
                / \ 
               2   5 
              / \   \ 
             1   3   7 
*/

class TestBST {

    public static void main(String []args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(7);

        BinarySearchTree bst = new BinarySearchTree();
        //TreeNode p = bst.search(root, 3);
        //System.out.println(p.val);

        //bst.insert2(root, 6);
        //Solution.inorder(root);

        //System.out.println();

        System.out.println(bst.remove3(root, 2).val);
        Solution.inorder(root);
        System.out.println("\n" + root.right.val);
    }
}
