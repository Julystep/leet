package programmer.interview.golden.code;

/**
 * 插入
 */
public class Solution28 {

    public int insertBits(int N, int M, int i, int j) {
        int left = N>>j>>1; //把最左边的部分调整好了，即抛弃了替换部分和低位部分
        left = left<<j<<1;  //因此最后要进行或运算，所以把他再移到原来的高位上。
        int middle = M<<i;  //替换N的j<-----i位，那么只需要将M左移i位即可
        int right = N&((1<<i)-1);//只需要N的低位，将高位置零,(1<<2)-1 = (11)2
        return left | middle | right;
    }

    public static void main(String[] args) {
        int x = 3;
        System.out.println(x>>1);
    }

}
