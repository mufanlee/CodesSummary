/**
 * @author LiPeng
 * @since 2017/6/1023:20
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode font = l1;
        ListNode last = null;
        int c = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val;
            l1.val = (val + c) % 10;
            c = (val + c) / 10;
            last = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            l1 = l2;
            last.next = l1;
        }
        while (l1 != null) {
            int val = l1.val + c;
            l1.val = val % 10;
            c = val / 10;
            last = l1;
            l1 = l1.next;
        }
        if (c != 0)
            last.next = new ListNode(c);
        return font;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
