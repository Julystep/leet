package practice;

/**
 * 验证回文串
 */
public class Solution125 {

    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item >= 'A' && item <= 'Z') {
                char word = (char) (item - 'A' + 'a');
                builder.append(word);
            } else if (item >= 'a' && item <= 'z' || item >= '0' && item <= '9') {
                builder.append(item);
            }
        }
        String onlyWord = builder.toString();
        int left = 0, right = onlyWord.length() - 1;
        while (left < right) {
            if (onlyWord.charAt(left) != onlyWord.charAt(right)) return false;
            left ++;
            right --;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println('a' - 1);
    }

}
