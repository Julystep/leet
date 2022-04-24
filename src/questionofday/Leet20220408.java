package questionofday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liml28084
 * @Date: 2022/4/8
 * @Description:
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class Leet20220408 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(root);

        while (nodeList.size() != 0) {
            List<Node> children = new ArrayList<>();
            List<Integer> itemAns = new ArrayList<>();
            for (Node node : nodeList) {
                itemAns.add(node.val);
                children.addAll(node.children);
            }
            ans.add(itemAns);
            nodeList = children;
        }
        return ans;
    }

}
