import java.util.Stack;

/**
 * 445. Add Two Numbers II
 * @author LiPeng
 * @since 2017/6/1015:01
 */
public class AddTwoNumbersII {
    /**
     * 利用Stack
     * @param l1 链表1
     * @param l2 链表2
     * @return 返回两个链表的和
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        ListNode p = l1;
        while (p != null) {
            s1.push(p.val);
            p = p.next;
        }
        p = l2;
        while (p != null) {
            s2.push(p.val);
            p = p.next;
        }

        ListNode head = new ListNode(0);
        int c = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + c;
            p = new ListNode(sum % 10);
            c = sum / 10;
            p.next = head.next;
            head.next = p;
        }
        while (!s1.isEmpty()) {
            int sum = s1.pop() + c;
            p = new ListNode(sum % 10);
            c = sum / 10;
            p.next = head.next;
            head.next = p;
        }
        while (!s2.isEmpty()) {
            int sum = s2.pop() + c;
            p = new ListNode(sum % 10);
            c = sum / 10;
            p.next = head.next;
            head.next = p;
        }
        if (c > 0) {
            p = new ListNode(c);
            p.next = head.next;
            head.next = p;
        }
        return head.next;
    }

    /**
     * 递归的方法
     * @param l1 链表1
     * @param l2 链表2
     * @return 返回两个链表的和
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        if (len2 > len1) {
            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
            int len = len1;
            len1 = len2;
            len2 = len;
        }
        ListNode res = add(l1, len1, l2, len2);
        if (res.val > 9) {
            ListNode node = new ListNode(res.val / 10);
            res.val = res.val % 10;
            node.next = res;
            res = node;
        }
        return res;
    }

    private ListNode add(ListNode l1, int len1, ListNode l2, int len2) {
        if (len1 == 1) {
            return new ListNode(l1.val + l2.val);
        }
        ListNode node = new ListNode(0);
        if(len1 > len2) {
            node.next = add(l1.next, len1 - 1, l2, len2);
            int c = node.next.val / 10;
            node.next.val = node.next.val % 10;
            node.val = l1.val + c;
        } else if(len1 == len2) {
            node.next = add(l1.next, len1 - 1, l2.next, len2 - 1);
            int c = node.next.val / 10;
            node.next.val = node.next.val % 10;
            node.val = l1.val + l2.val + c;
        }
        return node;
    }
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len ++;
        }
        return len;
    }
}
