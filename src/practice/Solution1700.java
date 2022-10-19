package practice;

import java.util.Arrays;

public class Solution1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int sandwich : sandwiches) {
            if (sandwich == 0 && s0 > 0) {
                s0--;
            } else if (sandwich == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }

    public static void main(String[] args) {

        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        Solution1700 solution1700 = new Solution1700();
        System.out.println(solution1700.countStudents(students, sandwiches));

    }

}
