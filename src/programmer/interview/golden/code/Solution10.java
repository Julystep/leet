package programmer.interview.golden.code;

import java.util.HashSet;
import java.util.Set;

/**
 * 移除重复节点
 */
public class Solution10 {

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode point = head;
        ListNode pre = new ListNode(-1);
        pre.next = point;
        while (point != null) {
            if (!set.add(point.val)) {
                pre.next = point.next;
                point = pre.next;
            } else {
                point = point.next;
                pre = pre.next;
            }
        }
        return head;
    }

}
