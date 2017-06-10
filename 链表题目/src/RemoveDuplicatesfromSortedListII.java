/**
 * 82. Remove Duplicates from Sorted List II
 * @author LiPeng
 * @since 2017/6/1014:41
 */
public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        head = pre;
        ListNode p = head.next;
        while (p != null) {
            if (p.next != null && p.next.val == p.val) {
                while (p.next != null && p.next.val == p.val)
                    p = p.next;
                pre.next = p.next;
            } else {
                pre = p;
            }
            p = p.next;
        }
        return head.next;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;

        if (head.next != null && head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
