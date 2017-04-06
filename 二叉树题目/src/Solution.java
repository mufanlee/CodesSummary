import java.util.*;

/**
  * TODO: 一定要能熟练地写出所有问题的递归和非递归做法！
  *
  * 1. 求二叉树中的节点个数: getNodeNumRec（递归），getNodeNum（迭代）
  * 2. 求二叉树的深度: getDepthRec（递归），getDepth 
  * 3. 前序遍历，中序遍历，后序遍历: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec
  * 4. 分层遍历二叉树（按层次从上往下，从左往右）: levelTraversal, levelTraversalRec（递归解法！）
  * 5. 将二叉查找树变为有序的双向链表: convertBST2DLLRec, convertBST2DLL
  * 6. 求二叉树第K层的节点个数：getNodeNumKthLevelRec, getNodeNumKthLevel
  * 7. 求二叉树中叶子节点的个数：getNodeNumLeafRec, getNodeNumLeaf
  * 8. 判断两棵二叉树是否相同的树：isSameRec, isSame
  * 9. 判断二叉树是不是平衡二叉树：isAVLRec
  * 10. 求二叉树的镜像（破坏和不破坏原来的树两种情况）：mirrorRec, mirrorCopyRec
  * 11. 判断两个树是否互相镜像：isMirrorRec
  * 12. 求二叉树中两个节点的最低公共祖先节点：getLastCommonParent, getLastCommonParentRec, getLastCommonParentRec2
  * 13. 求二叉树中节点的最大距离：getMaxDistanceRec
  * 14. 由前序遍历序列和中序遍历序列重建二叉树，由中序遍历序列和后序遍历序列重建二叉树：rebuildBinaryTreeRec, buildBinaryTreeRec
  * 15.判断二叉树是不是完全二叉树：isCompleteBinaryTree, isCompleteBinaryTreeRec
  * 
  */

/*class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}*/

public class Solution {

    /**
     * 1.求二叉树中的节点个数递归解法：O(n)
     * （1）如果二叉树为空，节点个数为0
     * （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
     * @param root 根结点
     * @return 节点个数
     */
    public static int getNodeNumRec(TreeNode root) {
        if (root == null) return 0;
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    /**
     * 1.求二叉树中的节点个数迭代解法O(n)：基本思想同LevelOrderTraversal，即用一个Queue，在Java里面可以用LinkedList来模拟
     * @param root 根结点
     * @return 节点个数
     */
    public static int getNodeNum(TreeNode root) {
        if (root == null) return 0;
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                queue.add(node.left);
                count++;
            }
            if (node.right != null) {
                queue.add(node.right);
                count++;
            }
        }
        return count;
    }

    /**
     * 2.求二叉树的深度（高度）递归解法：O(n)
     * （1）如果二叉树为空，二叉树的深度为0
     * （2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
     * @param root 根节点
     * @return 深度
     */
    public static int getDepthRec(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
    }

    /**
     * 2.求二叉树的深度（高度）迭代解法：O(n)
     * 基本思想同LevelOrderTraversal，还是用一个Queue
     * @param root 根节点
     * @return 深度
     */
    public static int getDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        int curLevelNodes = 1; // 当前level，node数量
        int nextLevelNodes = 0; // 下一level，node数量
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            curLevelNodes--;
            if (node.left != null) {
                queue.add(node.left);
                nextLevelNodes++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelNodes++;
            }
            if (curLevelNodes == 0) { // 遍历完当前层
                depth++;
                curLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
        return depth;
    }

    /**
     * 3.前序遍历递归解法：
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
     * @param root 根节点
     */
    public static void preorderRec(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorderRec(root.left);
        preorderRec(root.right);
    }

    /**
     * 3.前序遍历迭代解法
     * 用一个辅助stack，总是把右孩子放进栈
     * @param root 根节点
     */
    public static void preorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            // 关键点：要先压入右孩子，再压入左孩子，这样在出栈时会先打印左孩子再打印右孩子
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
    }

    /**
     * 3.中序遍历递归解法
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
     * @param root 根节点
     */
    public static void inorderRec(TreeNode root) {
        if (root == null) return;
        inorderRec(root.left);
        System.out.print(root.val + " ");
        inorderRec(root.right);
    }

    /**
     * 3.中序遍历迭代解法
     * 用栈先把根节点的所有左孩子都添加到栈内，然后输出栈顶元素，再处理栈顶元素的右子树
     * @param root 根节点
     */
    public static void inorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.empty()) {
                p = stack.pop();
                System.out.print(p.val + " ");
                p = p.right;
            }
        }
    }

    /**
     * 3.后序遍历递归解法
     * （1）如果二叉树为空，空操作
     * （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
     * @param root 根节点
     */
    public static void postorderRec(TreeNode root) {
        if (root == null) return;
        postorderRec(root.left);
        postorderRec(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 3.后序遍历迭代解法
     * @param root 根节点
     */
    public static void postorder(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.peek();
            if (p.right != null && p.right != pre)
                p = p.right;
            else {
                System.out.print(p.val + " ");
                pre = stack.pop();
                p = null;
            }
        }
    }

    /**
     * 4.分层遍历二叉树递归解法
     * 用一个大的ArrayList，里面包含了每一层的ArrayList
     * @param root 根节点
     */
    public static void levelTraversalRec(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        dfs(root, 0, ret);
        System.out.println(ret);
    }
    private static void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> ret) {
        if (root == null) return;
        if (level >= ret.size())
            ret.add(new ArrayList<Integer>());
        ret.get(level).add(root.val);
        dfs(root.left, level+1, ret);
        dfs(root.right, level+1, ret);
    }

    /**
     * 4.分层遍历二叉树（按层次从上往下，从左往右）迭代解法
     * @param root 根节点
     */
    public static void levelTraversal(TreeNode root) {
        if (root == null) return ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 5.将二叉查找树变为有序的双向链表递归解法
     * 要求不能创建新节点，只调整指针。
     * @param root 根节点
     * @return 双向链表的头节点
     */
    public static TreeNode convertBST2DLLRec(TreeNode root) {
        root = convertBST2DLLSubRec(root);
        // root会在链表的中间位置，因此要手动把root移到链表头
        if (root != null)
            while (root.left != null)
                root = root.left;
        return root;
    }

    public static TreeNode convertBST2DLLSubRec(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return root;
        TreeNode p = null;
        if (root.left != null) {
            // 1.将左子树构造成双向链表，并返回链表头结点
            p = convertBST2DLLSubRec(root.left);
            // 2.定位至左子树双向链表的最后一个节点
            while (p.right != null) // 寻找最右节点
                p = p.right;
            // 3.将root追加到左子树双向链表
            p.right = root;
            root.left = p;
        }
        if (root.right != null) {
            // 4.将右子树构造成双向链表，并返回头结点
            p = convertBST2DLLSubRec(root.right);
            // 5.将该双向链表追加到root之后
            while (p.left != null)
                p = p.left;
            p.left = root;
            root.right = p;
        }
        return root;
    }

    /**
     * 5.将二叉查找树变为有序的双向链表迭代解法
     * 核心是中序遍历的迭代解法，修改当前遍历节点与前一遍历节点的指针指向
     * @param root 根节点
     * @return 双向链表的头节点
     */
    public static TreeNode convertBST2DLL(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode pre = null;
        TreeNode head = null;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                if (pre != null)
                    pre.right = p;
                if (head == null)
                    head = p;
                p.left = pre;
                pre = p;
                p = p.right;
            }
        }
        return head;
    }

    /**
     * 6.求二叉树第K层的节点个数递归解法
     * （1）如果二叉树为空或者k<1返回0
     * （2）如果二叉树不为空并且k==1，返回1
     * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
     * @param root 根节点
     * @return 第K层的节点个数
     */
    public static int getNodeNumKthLevelRec(TreeNode root, int k) {
        if (root == null || k < 1) return 0;
        if (k == 1) return 1;
        return getNodeNumKthLevelRec(root.left, k-1) + getNodeNumKthLevelRec(root.right, k-1);
    }

    /**
     * 6.求二叉树第K层的节点个数迭代解法
     * 思想同分层遍历
     * @param root 根节点
     * @param k 第k层
     * @return 第K层的节点个数
     */
    public static int getNodeNumKthLevel(TreeNode root, int k) {
        if (root == null || k < 0) return 0;
        if (k == 1) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;
        int curLevelNodes = 1;
        int nextLevelNodes = 0;
        while (!queue.isEmpty() && level < k) {
            TreeNode p = queue.remove();
            curLevelNodes--;
            if (p.left != null) {
                queue.add(p.left);
                nextLevelNodes++;
            }
            if (p.right != null) {
                queue.add(p.right);
                nextLevelNodes++;
            }
            if (curLevelNodes == 0) {
                curLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
                level++;
            }
        }
        return curLevelNodes;
    }

    /**
     * 7.求二叉树中叶子节点的个数递归解法
     * @param root 根节点
     * @return 叶子节点的个数
     */
    public static int getLeafNumRec(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)
            return  1;
        return getLeafNumRec(root.left) + getLeafNumRec(root.right);
    }

    /**
     * 7.求二叉树中叶子节点的个数迭代解法
     * 基于分层遍历
     * @param root 根节点
     * @return 叶子节点的个数
     */
    public static int getLeafNum(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int leaf = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            if (node.left == null && node.right == null)
                leaf++;
        }
        return leaf;
    }

    /**
     * 8.判断两棵二叉树是否相同的树递归解法
     * （1）如果两棵二叉树都为空，返回真
     * （2）如果两棵二叉树一棵为空，另一棵不为空，返回假
     * （3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
     * @param root1 第一棵树
     * @param root2 第二棵树
     * @return 两棵二叉树是否相同
     */
    public static boolean isSameRec(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isSameRec(root1.left, root2.left) && isSameRec(root1.right, root2.right);
    }

    /**
     * 8.判断两棵二叉树是否相同的树迭代解法
     * @param root1 第一棵树
     * @param root2 第二棵树
     * @return 两棵二叉树是否相同
     */
    public static boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if (node1 == null && node2 == null)
                continue;
            else if (node1 != null && node2 != null && node1.val == node2.val) {
                stack1.push(node1.right);
                stack1.push(node1.left);
                stack2.push(node2.right);
                stack2.push(node2.left);
            }else return false;
        }
        return true;
    }

    /**
     * 9.判断二叉树是不是平衡树递归解法
     * （1）如果二叉树为空，返回真
     * （2）如果二叉树不为空，如果左子树和右子树都是AVL树并且左子树和右子树高度相差不大于1，返回真，其他返回假
     * @param root 根节点
     * @return 二叉树是不是平衡树
     */
    public static boolean isAVLRec(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getDepthRec(root.left) - getDepthRec(root.right)) > 1)
            return false;
        return isAVLRec(root.left) && isAVLRec(root.right);
    }

    /**
     * 10.求二叉树的镜像递归解法
     * （1）如果二叉树为空，返回空
     * （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左子树和右子树
     * @param root 根节点
     * @return 镜像树根节点
     */
    // 1.破坏原来的树，把原来的树改成其镜像递归解法
    public static TreeNode mirrorRec(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = mirrorRec(root.right);
        root.right = mirrorRec(left);
        return root;
    }

    // 2.不破坏原来的树，返回一个新的镜像树递归解法
    public static TreeNode mirrorCopyRec(TreeNode root) {
        if (root == null) return null;
        TreeNode node = new TreeNode(root.val);
        node.left = mirrorCopyRec(root.right);
        node.right = mirrorCopyRec(root.left);
        return node;
    }

    /**
     * 10.求二叉树的镜像迭代解法
     * @param root 根节点
     * @return 镜像树根节点
     */
    // 1.破坏原来的树，把原来的树改成其镜像迭代解法
    public static TreeNode mirror(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return root;
    }

    // 2.不能破坏原来的树，返回一个新的镜像树迭代解法
    public static TreeNode mirrorCopy(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        TreeNode newRoot = new TreeNode(root.val);
        stack2.push(newRoot);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            TreeNode newNode = stack2.pop();

            if (node.right != null) {
                stack1.push(node.right);
                newNode.left = new TreeNode(node.right.val);
                stack2.push(newNode.left);
            }
            if (node.left != null) {
                stack1.push(node.left);
                newNode.right = new TreeNode(node.left.val);
                stack2.push(newNode.right);
            }
        }
        return newRoot;
    }

    /**
     * 11.判断两个树是否互相为镜像递归解法
     * @param root1 第一棵树
     * @param root2 第二棵树
     * @return 两个树是否互相为镜像
     */
    public static boolean isMirrorRec(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val)
            return false;
        return isMirrorRec(root1.left, root2.right) && isMirrorRec(root1.right, root2.left);
    }

    /**
     * 12.求二叉树中两个节点的最低公共祖先节点递归解法
     * （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
     * （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
     * @param root 根节点
     * @param p 第一个节点
     * @param q 第二个节点
     * @return 两个节点的最低公共祖先节点
     */
    // 求二叉树中两个节点的最低公共祖先节点 （更加简洁版的递归）
    public static TreeNode getLowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // 如果有一个节点等于root，则说明当前的root是要找的最低公共祖先
        if (root == p || root == q) return root;
        TreeNode left = getLowestCommonAncestorRec2(root.left, p, q);
        TreeNode right = getLowestCommonAncestorRec2(root.right, p, q);

        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }

    public static TreeNode getLowestCommonAncestorRec2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) return root;
        if (root.left == null) {
            return getLowestCommonAncestorRec2(root.right, p, q);
        }
        if (root.right == null) {
            return getLowestCommonAncestorRec2(root.left, p, q);
        }
        if (findNodeRec(root.left, p)) {
            if (findNodeRec(root.right, q)) {
                return root;
            }else {
                return getLowestCommonAncestorRec2(root.left, p, q);
            }
        }else {
            if (findNodeRec(root.left, q)) {
                return root;
            } else {
                return getLowestCommonAncestorRec2(root.right, p, q);
            }
        }
    }

    private static boolean findNodeRec(TreeNode root, TreeNode node) {
        if (root == null || node == null) return false;
        if (root == node) return true;
        return findNodeRec(root.left, node) || findNodeRec(root.right, node);
    }

    /**
     * 12.求二叉树中两个节点的最低公共祖先节点迭代解法
     * 先求从根节点到两个节点的路径，然后再比较对应路径的节点就行，最后一个相同的节点也就是他们在二叉树中的最低公共祖先节点
     * @param root 根节点
     * @param p 第一个节点
     * @param q 第二个节点
     * @return 两个节点的最低公共祖先节点
     */
    public static TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        ArrayList<TreeNode> path1 = new ArrayList<>();
        boolean res1 = getNodePath(root, p, path1);
        ArrayList<TreeNode> path2 = new ArrayList<>();
        boolean res2 = getNodePath(root, q, path2);

        if (!res1 || !res2) return null;

        TreeNode ancestor = null;
        Iterator<TreeNode> it1 = path1.iterator();
        Iterator<TreeNode> it2 = path2.iterator();
        while (it1.hasNext() && it2.hasNext()) {
            TreeNode tmp1 = it1.next();
            TreeNode tmp2 = it2.next();
            if (tmp1 == tmp2)
                ancestor = tmp1;
            else break;
        }
        return ancestor;
    }

    public static boolean getNodePath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root == node) return true;
        boolean found = getNodePath(root.left, node, path);
        if (!found) found = getNodePath(root.right, node, path);
        if (!found) path.remove(root);
        return found;
    }

    /**
     * 13.求二叉树中节点的最大距离
     * 即二叉树中相距最远的两个节点之间的距离(distance / diameter)
     * （1）如果二叉树为空，返回0
     * （2）如果二叉树不为空，最大距离要么是左子树中的最大距离，要么是右子树中的最大距离，要么是左子树节点中到根节点的最大距离+右子树节点中到根节点的最大距离
     * @param root 根节点
     * @return 二叉树中节点的最大距离
     */
    public static int getMaxDistanceRec(TreeNode root) {
        if (root == null) return 0;
        int max = getDepthRec(root.left) + getDepthRec(root.right);
        int lmax = getMaxDistanceRec(root.left);
        int rmax = getMaxDistanceRec(root.right);
        return Math.max(max, Math.max(lmax, rmax));
    }

    /**
     * 14.由前序遍历序列和中序遍历序列重建二叉树递归解法
     * @param preorder 先序遍历数组
     * @param inorder 中序遍历数组
     * @return 二叉树根节点
     */
    public static TreeNode rebuildBinaryTreeRec(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) return null;
        return rebuildBinaryTreeCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    /**
     * 14.由前序遍历序列和中序遍历序列重建二叉树递归解法
     * @param preorder 先序遍历数组
     * @param ps 先序遍历数组第一个元素的位置
     * @param pe 先序遍历数组最后一个元素的位置
     * @param inorder 中序遍历数组
     * @param is 中序遍历数组第一个元素的位置
     * @param ie 中序遍历数组最后一个元素的位置
     * @return 二叉树根节点
     */
    public static TreeNode rebuildBinaryTreeCore(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(preorder[ps]);

        int i = is;
        while (i <= ie && inorder[i] != root.val) i++;

        root.left = rebuildBinaryTreeCore(preorder, ps+1, ps + i - is, inorder, is, i - 1);
        root.right = rebuildBinaryTreeCore(preorder, ps + i - is + 1, pe, inorder, i + 1, ie);
        return root;
    }

    public static TreeNode rebuildBinaryTreeRec2(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0 || inorder.size() == 0) return null;
        TreeNode root = new TreeNode(preorder.get(0));
        int pos = inorder.indexOf(root.val);

        root.left = rebuildBinaryTreeRec2(preorder.subList(1, pos+1), inorder.subList(0, pos));
        root.right = rebuildBinaryTreeRec2(preorder.subList(pos+1, preorder.size()), inorder.subList(pos+1, inorder.size()));
        return root;
    }

    /**
     * 14.由中序遍历序列和后序遍历序列重建二叉树递归解法
     * @param inorder 中序遍历数组
     * @param postorder 后序遍历数组
     * @return 二叉树根节点
     */
    public static TreeNode buildBinaryTreeRec(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) return null;
        return buildBinaryTreeCore(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public static TreeNode buildBinaryTreeCore(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int i = is;
        while (i <= ie && inorder[i] != postorder[pe]) i++;
        root.left = buildBinaryTreeCore(inorder, is, i-1, postorder, ps, ps+i-is-1);
        root.right = buildBinaryTreeCore(inorder, i+1, ie, postorder, ps+i-is, pe-1);
        return root;
    }

    /**
     * 14.由中序遍历序列和后序遍历序列重建二叉树递归解法
     * 利用HashMap保存中序序列
     * @param inorder 中序遍历数组
     * @param postorder 后序遍历数组
     * @return 二叉树根节点
     */
    public TreeNode buildBinaryTreeRec2(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildBinaryTreeCore(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }
    private TreeNode buildBinaryTreeCore(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> map) {
        if (is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int i = map.get(root.val);
        root.left = buildBinaryTreeCore(inorder, is, i-1, postorder, ps, ps+i-is-1, map);
        root.right = buildBinaryTreeCore(inorder, i+1, ie, postorder, ps+i-is, pe-1, map);
        return root;
    }

    /**
     * 15.判断二叉树是不是完全二叉树迭代解法
     * 对于完全二叉树，进行层序遍历，碰到空时，已经遍历完树，对于非完全二叉树，则遇到空之后还会有节点
     * @param root 根节点
     * @return 二叉树是不是完全二叉树
     */
    public static boolean isCompleteBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode p = root;
        queue.add(p);
        // 把每一层的节点入队
        while ((p = queue.remove()) != null) {
            queue.add(p.left);
            queue.add(p.right);
        }
        // 这时如果是完全二叉树，则队中全为空
        while (!queue.isEmpty()) {
            p = queue.remove();
            if (p != null) return false;
        }
        return true;
    }
    /**
     * 15.判断二叉树是不是完全二叉树迭代解法
     * 若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
     * 按层次（从上到下，从左到右）遍历二叉树，当遇到一个节点的左子树为空时，则该节点右子树必须为空，且后面遍历的节点左右子树都必须为空，否则不是完全二叉树。
     * @param root 根节点
     * @return 二叉树是不是完全二叉树
     */
    public static boolean isCompleteBinaryTree2(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean mustHaveNoChild = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (mustHaveNoChild){ // 已经出现了有空子树的节点了，后面出现的必须为叶节点（左右子树都为空）
                if (node.left != null || node.right != null)
                    return false;
            }else {
                if (node.left != null && node.right != null) { // 如果左子树和右子树都非空，则继续遍历
                    queue.add(node.left);
                    queue.add(node.right);
                } else if (node.left != null && node.right == null) { // 如果左子树非空但右子树为空，说明已经出现空节点，之后必须都为空子树
                    queue.add(node.left);
                    mustHaveNoChild = true;
                } else if (node.left == null && node.right != null) { // 如果左子树为空但右子树非空，说明这棵树已经不是完全二叉完全树
                    return false;
                } else { // 如果左右子树都为空，则后面的必须也都为空子树
                    mustHaveNoChild = true;
                }
            }
        }
        return true;
    }

    /**
     * 15.判断二叉树是不是完全二叉树递归解法
     * @param root 根节点
     * @return 二叉树是不是完全二叉树
     */
    public static boolean isCompleteBinaryTreeRec(TreeNode root) {
        return isCompleteBinaryTreeSubRec(root).height != -1;
    }

    /**
     * 判断是否满树（完美）递归解法
     * @param root 根节点
     * @return 是否满树
     */
    public static boolean isPerfactBinaryTreeRec(TreeNode root) {
        return isCompleteBinaryTreeSubRec(root).isFull;
    }

    public static Pair isCompleteBinaryTreeSubRec(TreeNode root) {
        if (root == null) return new Pair(0, true);
        Pair left = isCompleteBinaryTreeSubRec(root.left);
        Pair right = isCompleteBinaryTreeSubRec(root.right);
        // 左树满节点，而且左右树相同高度，则是唯一可能形成满树（若右树也是满节点）的情况
        if (left.isFull && left.height == right.height)
            return new Pair(left.height + 1, right.isFull);
        // 左树非满，但右树是满节点，且左树高度比右树高一 
        // 注意到如果其左树为非完全树，则它的高度已经被设置成-1， 
        // 因此不可能满足第二个条件！
        if (right.isFull && left.height == right.height + 1)
            return new Pair(left.height + 1, false);
        // 其他情况都是非完全树，直接设置高度为-1
        return new Pair(-1, false);
    }

    private static class Pair {
        int height;     // 树的高度
        boolean isFull; // 是否满树
        public Pair(int height, boolean isFull) {
            this.height = height;
            this.isFull = isFull;
        }
        public boolean equalsTo(Pair other) {
            return this.height == other.height && this.isFull == other.isFull;
        }
    }
}

class Test {
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
        //System.out.println(Solution.getNodeNumRec(root));
        //System.out.println(Solution.getNodeNum(root));
        //System.out.println(Solution.getDepthRec(root));
        //System.out.println(Solution.getDepth(root));
        //Solution.preorderRec(root);
        //System.out.println();
        //Solution.preorder(root);
        //System.out.println();
        //Solution.inorderRec(root);
        //System.out.println();
        //Solution.inorder(root);
        //System.out.println();
        //Solution.postorderRec(root);
        //System.out.println();
        //Solution.postorder(root);
        //System.out.println();
        //Solution.levelTraversalRec(root);
        //System.out.println();
        //Solution.levelTraversal(root);
        //System.out.println(Solution.getNodeNumKthLevelRec(root, 3));
        //System.out.println(Solution.getNodeNumKthLevel(root, 3));
        //System.out.println(Solution.getLeafNumRec(root));
        //System.out.println(Solution.getLeafNum(root));
        //Solution.mirrorRec(root);
        //Solution.preorder(root);
        //System.out.println();
        //Solution.preorder(Solution.mirrorCopyRec(root));
        //Solution.mirror(root);
        //Solution.preorder(root);
        //System.out.println();
        //Solution.preorder(Solution.mirrorCopy(root));
        System.out.println(Solution.isMirrorRec(root, Solution.mirrorCopy(root)));
        System.out.println(Solution.getMaxDistanceRec(root));
        System.out.println(Solution.isCompleteBinaryTree(root));
        System.out.println(Solution.isCompleteBinaryTree2(root));
        System.out.println(Solution.isCompleteBinaryTreeRec(root));
    }
}
