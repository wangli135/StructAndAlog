package leetcode.dp;

/**
 * Created by Xingfeng on 2017-04-02.
 */
public class Sqrt {

    public int mySqrt(int x) {


        int prev = 0;
        for (int i = 0; i <= x; i++) {

            int val = i * i;

            if (val>=0&&val <= x) {
                prev = i;
            } else {
                break;
            }
        }

        return prev;

    }

    public static void main(String[] args) {

        System.out.println(new Sqrt());

    }

}
