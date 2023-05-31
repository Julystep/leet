package practice;

/**
 * K 个一组翻转链表
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while(head != null) {
            ListNode tail = pre;

            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] nodes = traverse(head, tail);
            head = nodes[0];
            tail = nodes[1];
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    private ListNode[] traverse(ListNode head, ListNode tail) {

        ListNode prev = tail.next;
        ListNode p = head;
        while (tail != prev) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

}
