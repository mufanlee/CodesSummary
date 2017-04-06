import java.util.Stack;

/**
 * LeetCode
 * 173. Binary Search Tree Iterator
 */
// O(n)空间复杂度
/*public class BSTIterator {

    public Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        inorderRec(root);
    }

    public void inorderRec(TreeNode root) {
        if (root == null) return;
        inorderRec(root.right);
        stack.push(root);
        inorderRec(root.left);
    }

    /** @return whether we have a next smallest number
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number
    public int next() {
        if (hasNext()) return stack.pop().val;
        return -1;
    }
}*/
// O(log(n))空间复杂度
public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (hasNext()) {
            TreeNode p = stack.pop();
            if (p.right != null)
                pushLeft(p.right);
            return p.val;
        }
        return -1;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */