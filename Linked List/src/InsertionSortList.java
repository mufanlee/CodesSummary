/**
 * 147. Insertion Sort List
 * @author LiPeng
 * @since 2017/6/223:49
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = new ListNode(Integer.MAX_VALUE);
        p.next = head;
        head = p;
        p = head.next.next;
        ListNode pre = head.next;
        while (p != null) {
            ListNode q = head;
            while (p.val > q.next.val) {
                q = q.next;
            }
            if (q == pre) {
                pre = p;
                p = p.next;
                continue;
            }
            pre.next = p.next;
            p.next = q.next;
            q.next = p;
            p = pre.next;
        }
        return head.next;
    }
}
