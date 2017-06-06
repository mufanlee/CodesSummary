/**
 * 160. Intersection of Two Linked Lists
 * @author LiPeng
 * @since 2017/6/520:57
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode p = headA;
        while (p != null) {
            lenA ++;
            p = p.next;
        }
        p = headB;
        while (p != null) {
            lenB ++;
            p = p.next;
        }
        ListNode longList = headA;
        ListNode shortList = headB;
        int dif = lenA - lenB;
        if (lenA < lenB) {
            longList = headB;
            shortList = headA;
            dif = lenB - lenA;
        }
        for (int i = 0; i < dif; i++) {
            longList = longList.next;
        }
        while (longList != null && shortList != null && longList != shortList) {
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;
    }
}
