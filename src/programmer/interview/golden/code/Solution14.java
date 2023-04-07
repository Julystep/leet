package programmer.interview.golden.code;

/**
 * 链表求和
 */
public class Solution14 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode answer = new ListNode(-1);
        ListNode point  = answer;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + flag;
            flag = val / 10;
            ListNode item = new ListNode(val % 10);
            point.next = item;
            point = item;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int val = l1.val + flag;
            flag = val / 10;
            ListNode item = new ListNode(val % 10);
            point.next = item;
            point = item;
            l1 = l1.next;
        }
        while(l2 != null) {
            int val = l2.val + flag;
            flag = val / 10;
            ListNode item = new ListNode(val % 10);
            point.next = item;
            point = item;
            l2 = l2.next;
        }
        if (flag > 0) point.next = new ListNode(flag);
        return answer.next;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    

}
