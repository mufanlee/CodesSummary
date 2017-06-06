/**
 * 61. Rotate List
 * @author LiPeng
 * @since 2017/6/219:47
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) return head;
        // 得出链表长度和末尾节点
        ListNode p = head;
        int len = 1;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        ListNode tail = p;
        // 找到len - k % len之前一个节点（带旋转位置之前一个节点）
        p = head;
        for (int i = 0; i < len - k % len - 1; i++)
            p = p.next;
        // 旋转
        tail.next = head;
        head = p.next;
        p.next = null;
        return head;
    }
}
