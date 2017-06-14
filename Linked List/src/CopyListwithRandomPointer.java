import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * @author LiPeng
 * @since 2017/6/621:00
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = head;
        while (p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if (head == null) return head;
        RandomListNode p = head;
        while (p != null) {
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node.next;
            p = node.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }
        p = head.next;
        RandomListNode q = head;
        RandomListNode ret = p;
        while (q != null && p != null) {
            q.next = q.next.next;
            if (p.next == null) { // 判断最后一个元素，初始链表的最后一个元素通过上一句，将其next设为空，而复制链表的则不用。
                break;
            }
            p.next = p.next.next;
            q = q.next;
            p = p.next;
        }
        return ret;
    }
}
