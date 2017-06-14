/**
 * LeetCode
 * 234. Palindrome Linked List
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = slow.next;
        slow.next = null;
        while (p != null) {
            fast = p;
            p = p.next;
            fast.next = slow.next;
            slow.next = fast;
        }
        fast = head;
        slow = slow.next;
        while (slow != null) {
            if(slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        PalindromeLinkedList s = new PalindromeLinkedList();
        System.out.println(s.isPalindrome(head));
    }
}
