package practice;

/**
 * 二分查找：用一个标签分割该字符串，后面的根据分割来查找符合的数据
 * 双指针：最优解
 */
public class Solution167 {

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public int[] twoSum22(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] < target) l++;
            else if (numbers[l] + numbers[r] > target) r--;
            else return new int[]{++l, ++r};
        }

        return new int[]{-1, -1};
    }
}
