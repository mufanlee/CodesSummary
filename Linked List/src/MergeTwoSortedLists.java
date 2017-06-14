/**
 * @author LiPeng
 * @since 2017/6/521:05
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode font = new ListNode(0);
        ListNode tail = font;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
            tail.next = null;
        }
        if (l1 != null)
            tail.next = l1;
        if (l2 != null)
            tail.next = l2;
        return font.next;
    }
}
