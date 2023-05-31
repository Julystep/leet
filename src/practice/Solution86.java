package practice;

/**
 * 分隔链表
 */
public class Solution86 {

    public ListNode partition(ListNode head, int x) {
        ListNode little = new ListNode();
        ListNode pointLittle = little;
        ListNode bigger = new ListNode();
        ListNode pointBigger = bigger;
        while (head != null) {
            if (head.val < x) {
                pointLittle.next = head;
                pointLittle = pointLittle.next;
            } else {
                pointBigger.next = head;
                pointBigger = pointBigger.next;
            }
            head = head.next;
        }
        pointLittle.next = bigger.next;
        pointBigger.next = null;
        return little.next;
    }

}
