package practice;


public class Solution1894 {

    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        if (chalk[0] > k) return 0;
        for (int i = 1; i < n; i++) {
            chalk[i] += chalk[i-1];
            if (chalk[i] > k) return i;
        }
        k %= chalk[n-1];
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (chalk[mid] <= k) l = mid + 1;
            else r = mid;
        }
        return l;
    }

}
