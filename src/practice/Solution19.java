package practice;

/**
 * 删除链表的倒数第 N 个结点
 */
public class Solution19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode nex = head;
        for (int i = 0; i < n; i++) {
            nex = nex.next;
        }
        while (nex != null && nex.next != null) {
            nex = nex.next;
            pre = pre.next;
        }
        if (pre == head && nex == null) return head.next;
        pre.next = pre.next.next;
        return head;
    }

}
