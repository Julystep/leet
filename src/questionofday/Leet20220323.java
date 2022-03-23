package questionofday;


import java.util.Arrays;
// 周末特供
public class Leet20220323 {




    public int findKthNumber(int n, int k) {
        long cur = 1;
        k--;
        while(k > 0) {
            // 以cur为根的子树节点有nodes个
            int nodes = getNodes(n, cur);
            // 如果个数比k少，那么这个部分都可以直接跳过
            if(k >= nodes) {
                // 跳过全部
                k = k -nodes;
                // 往右移一位
                cur++;
            }
            // 如果数量比k多，那么我们要找的结果就一定是以cur下的子节点
            else {
                // 跳过当前结点
                k = k - 1;
                // 往下走一层
                cur = cur * 10;
            }
        }
        return (int)cur;
    }

    // 获得以cur为根结点的子树节点数量
    private int getNodes(int n, long cur) {
        long next = cur + 1;
        long totalNodes = 0;
        while(cur <= n) {
            // 一次性求出下一层的节点个数和，要是没满就用n来减，要是满了就用next减
            totalNodes += Math.min(n - cur + 1, next - cur);
            // 进入下一层
            next = next * 10;
            cur = cur * 10;
        }
        return (int)totalNodes;
    }

}
