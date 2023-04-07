package programmer.interview.golden.code;

import java.util.Stack;

/**
 * 回文链表
 */
public class Solution15 {

    public boolean isPalindrome(ListNode head) {
        ListNode reverseHead = new ListNode(-1);
        ListNode point = head;
        while (point != null) {
            ListNode item = new ListNode(point.val);
            item.next = reverseHead.next;
            reverseHead.next = item;
            point = point.next;
        }
        point = head;
        ListNode reversePoint = reverseHead.next;
        while (point != null && reversePoint != null) {
            if (point.val != reversePoint.val) return false;
            point = point.next;
            reversePoint = reversePoint.next;
        }
        return true;
    }

    /**
     *
     * 通过递归制造出头尾比较的情况，类似于堆栈
     *
     */
   private ListNode frontNode;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (frontNode.val != currentNode.val) {
                return false;
            }
            frontNode = frontNode.next;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        frontNode = head;
        return recursivelyCheck(head);
    }

    public boolean isPalindrome2(ListNode head) {
        ListNode frontNode = head;
        Stack<Integer> stack = new Stack<>();
        ListNode point = head;
        while (point != null) {
            stack.push(point.val);
            point = point.next;
        }
        while (frontNode != null) {
            if (frontNode.val != stack.pop()) return false;
            frontNode = frontNode.next;
        }
        return true;
    }


}
