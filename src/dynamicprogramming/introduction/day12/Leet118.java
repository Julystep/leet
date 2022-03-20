package dynamicprogramming.introduction.day12;

// 杨辉三角

import java.util.ArrayList;
import java.util.List;

public class Leet118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i ++) {
            List<Integer> item = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == i || j == 0) {
                    item.add(1);
                } else {
                    item.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(item);
        }
        return ans;
    }

}
