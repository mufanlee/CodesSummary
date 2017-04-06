/**
 * LeetCode
 * 206. Reverse Linked List
 */
public class ReverseLinkedList {
    // 前插法
    /*public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode rehead = new ListNode(0);
        ListNode p = head;
        while (p != null)
        {
            ListNode q = p;
            p = p.next;
            q.next = rehead.next;
            rehead.next = q;
        }
        return rehead.next;
    }*/
    // 递归法
    /*public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode rehead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return rehead;
    }*/
    // 迭代法
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null)
        {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return  pre;
    }
}
