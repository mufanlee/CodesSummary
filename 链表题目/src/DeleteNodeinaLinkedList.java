/**
 * 237. Delete Node in a Linked List
 * @author LiPeng
 * @since 2017/6/219:08
 */
public class DeleteNodeinaLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
