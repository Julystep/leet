package practice;

import java.util.*;

/**
 * 第三大的数
 */
public class Solution414 {

    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Collections.reverse(list);
        return list.size() >=3 ? list.get(2) : list.get(0);
    }

    public static void main(String[] args) {
        Solution414 solution414 = new Solution414();
        System.out.println(solution414.thirdMax(new int[]{1, -2147483648}));

        int[] i = {6,5,7,1,2,4,9,3,2,0};
        List<Integer> list = new ArrayList<>();
        for (int n : i) list.add(n);
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }

}
