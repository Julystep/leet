package programmer.interview.golden.code;

import java.util.*;

/**
 * 汉诺塔问题
 */
public class Solution34 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlant(A.size(),A,B,C);
    }
    public void movePlant(int size, List<Integer> start, List<Integer> auxiliary, List<Integer> target){
        //当只剩一个盘子时，直接将它从第一个柱子移动到第三个柱子
        if(size == 1){
            target.add(start.remove(start.size()-1));
            return;
        }
        //首先将 n-1 个盘子，从第一个柱子移动到第二个柱子
        movePlant(size - 1,start,target,auxiliary);
        //然后将最后一个盘子移动到第三个柱子上
        target.add(start.remove(start.size()-1));
        //最后将第二个柱子上的 n-1 个盘子，移动到第三个柱子上
        movePlant(size - 1,auxiliary,start,target);

    }

    public static void main(String[] args) {
        Integer[] x = {2, 1, 0};
        Solution34 solution34 = new Solution34();
        solution34.hanota(new ArrayList<>(Arrays.asList(x)), new ArrayList<>(), new ArrayList<>());
    }

}
