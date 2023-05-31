package practice;

/**
 * 旋转链表
 */
public class Solution61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode point  = head;
        int len = 0;
        while (point != null) {
            len++;
            point = point.next;
        }
        k = k % len;
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        right.next = head;
        head = left.next;
        left.next = null;
        return head;
    }

}
