package practice;

/**
 * 两数相加
 */
public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = new ListNode();
        ListNode p = head;
        while (l1 != null && l2 != null) {
            ListNode item = new ListNode();
            item.val = (l1.val + l2.val + flag) % 10;
            flag = (l1.val + l2.val + flag) / 10;
            l1 = l1.next;
            l2 = l2.next;
            p.next = item;
            p = item;
        }
        while (l1 != null) {
            ListNode item = new ListNode();
            item.val = (l1.val + flag) % 10;
            flag = (l1.val + flag) / 10;
            l1 = l1.next;
            p.next = item;
            p = item;
        }
        while (l2 != null) {
            ListNode item = new ListNode();
            item.val = (l2.val + flag) % 10;
            flag = (l2.val + flag) / 10;
            l2 = l2.next;
            p.next = item;
            p = item;
        }
        if (flag != 0) {
            ListNode item = new ListNode();
            item.val = flag;
            p.next = item;
        }
        return head.next;
    }

}
