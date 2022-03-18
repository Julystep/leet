package swordfingeroffer.day2;

/**
 * @Author: liml28084
 * @Date: 2022/3/18
 * @Description:
 */
public class LeetReverseList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode ans = new ListNode(0);
        while (head != null) {
            ListNode item = new ListNode(head.val);
            item.next = ans.next;
            ans.next = item;
            head = head.next;
        }
        return ans.next;
    }

}
