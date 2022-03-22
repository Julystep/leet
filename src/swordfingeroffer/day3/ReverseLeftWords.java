package swordfingeroffer.day3;


public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        char[] sArray = s.toCharArray();
        // 先反转数组
        int l = 0, r = s.length() - 1;
        reverse(sArray, l, r);
        reverse(sArray, l, s.length() - n - 1);
        reverse(sArray, s.length() - n, r);
        return new String(sArray);
    }

    private void reverse(char[] sArray, int l, int r) {
        while (l < r) {
            char item = sArray[l];
            sArray[l] = sArray[r];
            sArray[r] = item;
            l ++;
            r --;
        }
    }

}
