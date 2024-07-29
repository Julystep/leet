package practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 棒球比赛
 *
 * @author liminglei
 */
public class Solution682 {

    List<Integer> ops = new ArrayList<>();

    int size = 0;

    public int calPoints(String[] operations) {

        for (String  operation : operations) {
            switch (operation) {
                case "+":
                    ops.add(ops.get(size - 1) + ops.get(size - 2));
                    size++;
                    break;
                case "D":
                    ops.add(ops.get(size - 1) * 2);
                    size++;
                    break;
                case "C":
                    ops.remove(size - 1);
                    size--;
                    break;
                default:
                    ops.add(Integer.parseInt(operation));
                    size++;
            }
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += ops.get(i);
        }
        return sum;
    }

}
