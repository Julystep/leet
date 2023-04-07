package programmer.interview.golden.code;

import java.util.Objects;
import java.util.Stack;

/**
 * 链表相交
 */
public class Solution16 {

    /**
     * 邪路堆栈解决
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode result = null;
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        ListNode pointA = headA, pointB = headB;
        while (pointA != null) {
            stackA.push(pointA);
            pointA = pointA.next;
        }
        while (pointB != null) {
            stackB.push(pointB);
            pointB = pointB.next;
        }
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (Objects.equals(stackA.peek(), stackB.pop())) {
                result = stackA.pop();
            } else {
                break;
            }
        }
        return result;
    }


    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
