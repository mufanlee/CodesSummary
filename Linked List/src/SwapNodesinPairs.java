/**
 * 24. Swap Nodes in Pairs
 * @author LiPeng
 * @since 2017/6/1022:29
 */
public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head, pre = dummy;
        while (p != null && p.next != null) {
            pre.next = p.next;
            p.next = p.next.next;
            pre.next.next = p;
            pre = p;
            p = p.next;
        }
        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = head.next;
        head.next = swapPairs2(p.next);
        p.next = head;
        return p;
    }
}
