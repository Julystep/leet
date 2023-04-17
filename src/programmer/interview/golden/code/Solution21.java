package programmer.interview.golden.code;

import java.util.*;

/**
 * 特定深度节点链表
 */
public class Solution21 {

    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        List<ListNode> list = new ArrayList<>();

        while(!queue.isEmpty()){

            int sz = queue.size();
            ListNode listNode = new ListNode(-1);
            ListNode head = listNode;

            while( sz-- > 0 ){
                TreeNode node = queue.poll();

                if( node.left != null ){
                    queue.add(node.left);
                }
                if( node.right != null ){
                    queue.add(node.right);
                }

                listNode.next = new ListNode(node.val);
                listNode = listNode.next;
            }

            list.add(head.next);
        }

        //封装返回数据格式
        ListNode[] res = new ListNode[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
