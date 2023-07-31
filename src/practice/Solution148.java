package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序链表
 */
public class Solution148 {

    /**
     * 野鸡写法
     */
    public ListNode sortList1(ListNode head) {
        List<Integer> ans = new ArrayList<>();
        ListNode point = head;
        while (point != null) {
            ans.add(point.val);
            point = point.next;
        }
        Collections.sort(ans);
        ListNode ansHead = new ListNode();
        point = ansHead;
        for (Integer an : ans) {
            ListNode item = new ListNode(an);
            item.next = point.next;
            point.next = item;
            point = item;
        }
        return ansHead.next;
    }

    /**
     * 来一波分治
     */
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    private ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) return head;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode nodeLeft = sortList(head, slow);
        ListNode nodeRight = sortList(slow, tail);
        return sort(nodeLeft, nodeRight);
    }

    private ListNode sort(ListNode nodeLeft, ListNode nodeRight) {
        ListNode node = new ListNode(), point = node;
        ListNode leftPoint = nodeLeft;
        ListNode rightPoint = nodeRight;
        while (leftPoint != null && rightPoint != null) {
            if (leftPoint.val < rightPoint.val) {
                point.next = leftPoint;
                point = point.next;
                leftPoint = leftPoint.next;
            } else {
                point.next = rightPoint;
                point = point.next;
                rightPoint = rightPoint.next;
            }
        }
        if (leftPoint != null) {
            point.next = leftPoint;
        }
        if (rightPoint != null) {
            point.next = rightPoint;
        }
        return node.next;
    }

}
