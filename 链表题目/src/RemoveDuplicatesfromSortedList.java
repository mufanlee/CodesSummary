/**
 * 83. Remove Duplicates from Sorted List
 * @author LiPeng
 * @since 2017/6/520:53
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.next.val == p.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return head;
    }
}
