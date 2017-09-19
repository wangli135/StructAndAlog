package ofo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-09-14.
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int n = scanner.nextInt();
//            System.out.println(minStep2OneDp(n));
            //data[i]表示(i+1)变成1所需的最少次数
            minStep2One(n);

        }

    }


    /**
     * 转化为n的最小步数
     * data[i]表示(i)变成1所需的最少次数
     *
     * @param n
     * @return
     */
    private static int minStep2One(int n) {

        if (n == 1)
            return 0;

        if (n == 2)
            return 1;


        int step;

        if ((n & 0x1) == 0) {
            step = 1 + minStep2One(n >>> 2);
        } else {

            step = 1 + Math.min(minStep2One(n + 1), minStep2One(n - 1));

        }

        return step;

    }


    /**
     * 转化为n的最小步数
     * 使用动态规划解
     *
     * @param n
     * @return
     */
    private static int minStep2OneDp(int n) {

        if (n == 1)
            return 0;

        if (n == 2)
            return 1;

        //dp[i]表示从i变成1所需的最少步数
        //dp[i]=1+dp[i/2],i==偶数
        //dp[i]=1+Math.min(dp[i-1],dp[i+1]),i==奇数
        //dp[i-1]=1+dp[(i-1)/2],dp[i+1]=1+dp[(i+1)/2]
        int[] dp = new int[n + 2];

        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {

            if (i % 2 == 0) {
                dp[i] = 1 + dp[i / 2];
            } else {
                dp[i + 1] = 1 + dp[(i + 1) / 2];
                dp[i] = 1 + Math.min(dp[i - 1], dp[i + 1]);

            }

        }


        return dp[n];


    }

}
