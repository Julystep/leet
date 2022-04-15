package practice;

/**
 * 二分查找
 */

public class Solution744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (letters[mid] - target > 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return letters[r] > target ? letters[r] : letters[0];
    }

}
