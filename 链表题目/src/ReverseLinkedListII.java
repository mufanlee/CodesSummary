/**
 * 92. Reverse Linked List II
 * @author LiPeng
 * @since 2017/6/30:51
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        ListNode p = head;
        ListNode tail1 = null;
        ListNode tail2 = head;
        if (m > 1) {
            for (int i = 1; i < m - 1; i++) {
                p = p.next;
            }
            tail1 = p;
            tail2 = p.next;
            p = p.next;
        }

        ListNode pre = null;
        for (int i = 0; i <= n - m; i++) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }

        if (m > 1)
            tail1.next = pre;
        else head = pre;
        if (p != null)
            tail2.next = p;
        return head;
    }
}
