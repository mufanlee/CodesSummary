/**
 * @author LiPeng
 * @since 2017/6/1013:12
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode cur = new ListNode(0);
        cur.next = head;
        head = cur;
        ListNode p = cur;
        while (p.next != null) {
            if (p.next.val < x) {
                if (p == cur) {
                    p = p.next;
                    cur = cur.next;
                } else {
                    ListNode q = p.next;
                    p.next = p.next.next;
                    q.next = cur.next;
                    cur.next = q;
                    cur = q;
                }
            } else
                p = p.next;
        }
        return head.next;
    }

    public ListNode partition2(ListNode head, int x) {
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        ListNode p1 = h1, p2 = h2;
        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = h2.next;
        return h1.next;
    }
}
