/**
 * LeetCode
 * 337. House Robber III
 */
public class HouseRobberIII {
    //  Time Limit Exceeded
    public int rob2(TreeNode root) {
        int x = travel(root, true);
        int y = travel(root, false);
        return Math.max(x, y);
    }

    public int travel(TreeNode root, boolean isrob) {
        if (root == null) return 0;
        if (isrob) {
            int l = travel(root.left, false);
            int r = travel(root.right, false);
            return l + r + root.val;
        }
        else {
            int l1 = travel(root.left, true);
            int r1 = travel(root.right, true);
            int l2 = travel(root.left, false);
            int r2 = travel(root.right, false);
            return Math.max(l1, l2) + Math.max(r1, r2);
        }
    }

    public int rob(TreeNode root) {
        int []res = travel(root);
        return Math.max(res[0], res[1]);
    }

    /**
     * (1)如果当前root节点被偷，则其子节点不能被偷
     * (2)如果当前root节点不被偷，则其子节点可以被偷也可以不被偷，要两者和的最大值
     * @param root 当前节点
     * @return 节点偷与不被偷的元组
     */
    public int[] travel(TreeNode root) {
        if (root == null) return new int[2];

        // 当前节点不被偷res[0]，当前节点被偷res[1]
        int []res = new int[2];
        int []l = travel(root.left);
        int []r = travel(root.right);
        res[0] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        res[1] = l[0] + r[0] + root.val;
        return res;
    }
    /*
                 1 
                / \ 
               2   3 
              / \   \ 
             4   5   6 
     */
    public static void main(String []args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);

        HouseRobberIII h = new HouseRobberIII();
        System.out.println(h.rob(root));
    }
}
