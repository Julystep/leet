package practice;

public class Solution779 {

    /*
    做题的时候，需要找到一定的规律
     */

    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        int parentK = (k + 1) / 2;
        int result = kthGrammar(n - 1, parentK);
        if (result == 0) {
            if (k % 2 != 0) return 0;
            else return 1;
        } else {
            if (k % 2 != 0) return 1;
            else return 0;
        }
    }


    public static void main(String[] args) {
       Solution779 solution779 = new Solution779();

       /*
       0
       0 1
       0 1 1 0
       0 1 1 0 1 0 0 1
       0 1 1 0 1 0 0 1 1 0 0 1 0 1 1 0
        */

       System.out.println(solution779.kthGrammar(5, 5));
    }

}
