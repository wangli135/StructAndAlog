package chapter19;

/**
 * 阶乘
 * Created by Xingfeng on 2016-11-17.
 */
public class Fact {

    public int factRecursive(int n) {

        if (n == 0)
            return 1;
        if (n == 1)
            return 1;

        return n * factRecursive(n - 1);

    }



}
