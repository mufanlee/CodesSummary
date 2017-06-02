import java.util.HashMap;

/**
 * 单链表
 * @author LiPeng
 * @since 2017/5/3022:17
 */
public class SLinkedList {
    ListNode head = null;

    /**
     * 链表长度
     * @return 返回链表的长度
     */
    public int length() {
       int length = 0;
       ListNode tmp = head;
       while (tmp != null) {
           tmp = tmp.next;
           length ++;
       }
       return length;
    }

    /**
     * 向链表中插入数据
     * @param d:插入的数据内容
     */
    public void addNode(int d) {
        ListNode node = new ListNode(d);
        if (head == null) {
            head = node;
            return;
        }
        ListNode tmp = head;
        while (tmp.next != null)
            tmp = tmp.next;
        tmp.next = node;
    }

    /**
     * 删除第index个结点
     * @param index:第index个结点
     * @return 成功返回true，失败返回false
     */
    public boolean deleteNode(int index) {
        if (index < 1 || index > length()) {
            return false;
        }

        if (index == 1) {
            head = head.next;
            return true;
        }
        int i = 2;
        ListNode preNode = head;
        ListNode curNode = preNode.next;
        while (curNode != null) {
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = preNode.next;
            curNode = curNode.next;
            i++;
        }
        return true;
    }

    /**
     * 对链表进行排序（插入排序）
     * @return 返回排序后的头结点
     */
    public ListNode sort() {
        ListNode nextNode = null;
        int tmp = 0;
        ListNode curNode = head;
        while (curNode.next != null) {
            nextNode = curNode.next;
            while (nextNode != null) {
                if (curNode.val > nextNode.val) {
                    tmp = curNode.val;
                    curNode.val = nextNode.val;
                    nextNode.val = tmp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * 打印链表
     */
    public void print() {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    /**
     * 从链表中删除重复数据
     * @param head 链表头结点
     */
    public void deleteDuplecate(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode pre = null;
        while (head != null) {
            if (map.containsKey(head.val)) {
                pre.next = head.next;
            } else {
                map.put(head.val, 1);
                pre = head;
            }
            head = head.next;
        }
    }
    // 外循环当前遍历结点为p，内循环从头遍历至p，只要碰到与p值相同的节点就删除该结点，同时内循环结束。
    public void deleteDuplecate2(ListNode head) {
        ListNode p = head;
        while (p != null) {
            ListNode q = head;
            ListNode pre = null;
            while (q != p) {
                if (q.val == p.val) {
                    if (pre == null) {// 当头结点与p节点值相同时
                        head.val = head.next.val;
                        head.next = head.next.next;
                    } else
                        pre.next = q.next;
                    break;
                } else {
                    pre = q;
                    q = q.next;
                }
            }
            p = p.next;
        }
    }

    /**
     * 找出单链表中倒数第K个元素
     * @param head 链表头结点
     * @param k 第K个
     * @return 返回第K个元素
     */
    public ListNode findKth(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode p = head;
        for (int i = 0; i < k - 1; i++) {
            if (p.next != null)
                p = p.next;
            else
                return null;
        }
        ListNode q = head;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }

    /**
     * 反转链表
     * @param head 链表头结点
     */
    public void reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode nxt = cur.next;
            if (nxt == null) {
                this.head = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
    }

    /**
     * 从尾到头输出单链表
     * @param head 链表头结点
     */
    public void printReverse(ListNode head) {
        if (head == null) return;
        printReverse(head.next);
        System.out.print(head.val + " ");
    }

    /**
     * 寻找单链表的中间结点
     * @param head 链表头结点
     * @return 返回链表的中间结点
     */
    public ListNode searchMid(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while (q != null && q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        return p;
    }

    /**
     * 检测链表是否有环
     * @param head 链表头结点
     * @return 链表有环，返回true，反之，返回false
     */
    public boolean isLoop(ListNode head) {
        if (head == null) return false;
        ListNode p = head;
        ListNode q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q)
                return true;
        }
        return false;
    }

    /**
     * 找到环的入口
     * @param head 链表头结点
     * @return 返回环的入口结点
     */
    public ListNode findLoopPort(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        ListNode q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q)
                break;
        }
        if (q == null || q.next == null)
            return null;
        p = head;
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    /**
     * O(1)时间删除链表结点
     * @param head 链表头结点
     * @param n 要被删除的结点
     */
    public void deleteNode(ListNode head, ListNode n) {
        if (n == null || head == null) return ;
        if (n.next != null) {
            n.val = n.next.val;
            n.next = n.next.next;
        } else if (head == n) {
            head = null;
        } else {
            ListNode p = head;
            while (p.next != n)
                p = p.next;
            p.next = null;
        }
    }

    /**
     * 判断两个链表是否相交
     * @param h1 链表一头结点
     * @param h2 链表二头结点
     * @return 相交，返回true，反之，返回false
     */
    public boolean isIntersect(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) return false;
        ListNode p = h1;
        while (p != null)
            p = p.next;
        ListNode q = h2;
        while (q != null)
            q = q.next;
        return p == q;
    }

    /**
     * 找到相交链表的第一个公共结点
     * @param h1 链表一头结点
     * @param h2 链表二头结点
     * @return 返回第一个公共结点
     */
    public ListNode getFirstMeetNode(ListNode h1, ListNode h2) {
        if (h1 == null || h2 == null) return null;
        ListNode p = h1;
        int len1 = 0;
        while (p != null) {
            p = p.next;
            len1 ++;
        }
        ListNode q = h2;
        int len2 = 0;
        while (q != null) {
            q = q.next;
            len2 ++;
        }
        if (p != q)
            return null;
        p = h1;
        q = h2;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                p = p.next;
            }
        } else {
            for (int i = 0; i < len2 - len1; i++) {
                q = q.next;
            }
        }
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static void main(String []args) {
        SLinkedList list = new SLinkedList();
        list.addNode(5);
        list.addNode(3);
        list.addNode(2);
        list.addNode(1);
        list.addNode(3);
        //System.out.println("Length = " + list.length());
        //System.out.println("before order:");
        //list.print();
        //list.sort();
        //System.out.println("after order:");
        //list.print();
        //list.deleteDuplecate2(list.head);
        list.print();
        //ListNode node = list.findKth(list.head, 2);
        //System.out.println(node.val);
        //list.reverse(list.head);
        //list.print();
        //list.printReverse(list.head);
        //ListNode node = list.searchMid(list.head);
        //System.out.println(node.val);
        boolean is = list.isLoop(list.head);
        System.out.println(is);
    }
}
