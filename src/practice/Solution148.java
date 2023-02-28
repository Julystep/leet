package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 排序链表
 */
public class Solution148 {

    public ListNode sortList(ListNode head) {

        List<Integer> ans = new ArrayList<>();
        ListNode point = head;
        while (point != null) {
            ans.add(point.val);
            point = point.next;
        }
        Collections.sort(ans);
        ListNode ansHead = new ListNode();
        point = ansHead;
        for (int i = 0; i < ans.size(); i++) {
            ListNode item = new ListNode(ans.get(i));
            item.next = point.next;
            point.next = item;
            point = item;
        }
        return ansHead.next;



    }

}
