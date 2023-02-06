package practice;

/**
 * 链表的中间结点
 */
public class Solution876 {

    public ListNode middleNode(ListNode head) {
        ListNode preNode = head, nextNode = head;
        while (preNode != null && preNode.next != null) {
            preNode = preNode.next.next;
            nextNode = nextNode.next;
        }
        return nextNode;
    }

}
