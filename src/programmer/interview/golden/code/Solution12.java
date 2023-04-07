package programmer.interview.golden.code;

/**
 * 删除中间节点
 */
public class Solution12 {

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

}
