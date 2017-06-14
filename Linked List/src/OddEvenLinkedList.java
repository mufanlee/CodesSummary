/**
 * 328. Odd Even Linked List
 * @author LiPeng
 * @since 2017/6/1020:43
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        ListNode q = head;
        for (int i = 2; p.next != null; i++) {
            if (i % 2 != 0) {
                ListNode tmp = p.next;
                p.next = p.next.next;
                tmp.next = q.next;
                q.next = tmp;
                q = tmp;
            } else {
                p = p.next;
            }
        }
        return head;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
