/**
 * 109. Convert Sorted List to Binary Search Tree
 * @author LiPeng
 * @since 2017/6/720:14
 */
public class ConvertSortedListtoBinarySearchTree {
    public TreeNode sortedListToBST2(ListNode head) {
        if (head == null) return null;
        return sortedListToBSTCore2(head, null);
    }

    /**
     * 根据数组生成二叉搜索树的方法，找到中间节点作为二叉树的root节点，然后分别对左右链表递归调用分别生成左子树和右子树。
     * 时间复杂度O(NlogN)
     * @param head 头节点
     * @param tail 尾节点
     * @return 返回生成的二叉搜索树
     */
    private TreeNode sortedListToBSTCore2(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode fast = head, slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBSTCore2(head, slow);
        root.right = sortedListToBSTCore2(slow.next, tail);
        return root;
    }

    /**
     * 中序遍历
     * 先递归构建左子树，然后将当前节点作为根，迭代到下一个链表节点，最后递归求出右子树即可。
     * 整体过程就是一次中序遍历，时间复杂度为O(n)，空间复杂度是栈空间(logn)。
     */
    static ListNode curHead = null;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        curHead = head;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return sortedListToBSTCore(0, len-1);
    }

    private TreeNode sortedListToBSTCore(int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBSTCore(start, mid - 1);
        TreeNode root = new TreeNode(curHead.val);
        root.left = left;
        curHead = curHead.next;
        TreeNode right = sortedListToBSTCore(mid + 1, end);
        root.right = right;
        return root;
    }
}
