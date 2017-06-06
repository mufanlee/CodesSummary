/**
 * 203. Remove Linked List Elements
 * @author LiPeng
 * @since 2017/6/219:11
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            if (p.val == val)
            {
                if (pre == null) {
                    head = head.next;
                } else {
                    pre.next = p.next;
                }
            } else
                pre = p;
            p = p.next;
        }
        return head;
    }
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return head;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) p.next = p.next.next;
            else p = p.next;
        }
        return head.val == val ? head.next : head;
    }
}
