/**
 * 最后的代码的长度
 *
 * @author <a href="mailto:liml28084@hundsun.com">liml28084</a>
 * @since v
 * @since 2022/11/22
 */
public class Solution58 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] ss = s.split(" ");
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].equals("")) continue;
            return ss[i].length();
        }
        return 0;
    }

}
