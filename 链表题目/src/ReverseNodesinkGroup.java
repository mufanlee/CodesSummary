/**
 * 25. Reverse Nodes in k-Group
 * @author LiPeng
 * @since 2017/6/1420:46
 */
public class ReverseNodesinkGroup {
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode res = new ListNode(0), tail = res;
        int len = getLength(head);
        while (len >= k) {
            ListNode tmp = head;
            for (int i = 0; i < k; i++) {
                ListNode p = head;
                head = head.next;
                p.next = tail.next;
                tail.next = p;
            }
            tail = tmp;
            len -= k;
        }
        tail.next = head;
        return res.next;
    }
}
