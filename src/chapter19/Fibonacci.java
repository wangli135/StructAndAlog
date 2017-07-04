package chapter19;

/**
 * 斐波拉切数
 * Created by Xingfeng on 2016-11-17.
 */
public class Fibonacci {

    public int recursiveFibonacci(int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);

    }

    int fib[] = new int[20];

    /**
     * 动态规划，自底向上
     *
     * @param n
     * @return
     */
    public int fibB2T(int n) {

        if (n == 0 || n == 1)
            return n;

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {

            fib[i] = fib[i - 1] + fib[i - 2];

        }

        return fib[n];


    }

    /**
     * 动态规划，自顶向下
     *
     * @param n
     * @return
     */
    public int fibT2B(int n) {

        if (n == 1)
            return 1;
        if (n == 2)
            return 1;

        if (fib[n] != 0)
            return fib[n];

        return fib[n] = fibT2B(n - 1) + fibT2B(n - 2);

    }

    int first = 0;
    int sencond = 1;

    public int fibImprove(int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        int result = 0;
        for (int i = 2; i <= n; i++) {

            result = first + sencond;
            first = sencond;
            sencond = result;

        }

        return result;

    }

    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();

        System.out.println(fibonacci.recursiveFibonacci(10));

        System.out.println(fibonacci.fibT2B(11));

        System.out.println(fibonacci.fibImprove(10));
    }

}
