package practice;

/**
 * 删除排序链表中的重复元素 II
 */
public class Solution82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode hair = new ListNode(-101);
        hair.next = head;
        ListNode pre = hair;
        ListNode l = head;
        ListNode r = head.next;
        while (r != null) {
            if (l.val != r.val) {
                if (l.next == r) {
                    pre.next = l;
                    pre = l;
                }
                l = r;
            }
            r = r.next;
        }
        if (l.next == null) {
            pre.next = l;
        } else {
            pre.next = null;
        }
        return hair.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

}
