/**
 * 143. Reorder List
 * @author LiPeng
 * @since 2017/6/30:19
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // 找到链表中间位置
        ListNode p = head, q = head;
        while (p != null && p.next != null && p.next.next != null) {
            p = p.next.next;
            q = q.next;
        }
        // 反转后半部分链表
        p = q.next;
        q.next = null;
        ListNode pre = null;
        ListNode next = null;
        while (p != null) {
            next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        // 合并两个链表
        p = head;
        q = pre;
        while (p != null && q != null) {
            next = p.next;
            p.next = q;
            q = q.next;
            p.next.next = next;
            p = next;
        }
    }
}
