package programmer.interview.golden.code;

/**
 * 返回倒数第 k 个节点
 */
public class Solution11 {

    public int kthToLast(ListNode head, int k) {
        ListNode next = head;
        for (int i = 0; i < k; i++) {
            next = next.next;
        }
        ListNode pre = head;
        while (next != null) {
            pre = pre.next;
            next = next.next;
        }
        return pre.val;
    }

}
