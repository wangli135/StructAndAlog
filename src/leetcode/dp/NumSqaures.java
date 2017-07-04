package leetcode.dp;

/**
 * Created by Xingfeng on 2017-04-01.
 */
public class NumSqaures {

    public int numSquares(int n) {

        if (n < 4)
            return n;

        if (n == 4)
            return 1;

        //dp[i]表示和为i的最小完美数数目
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;
        for (int i = 5; i <= n; i++) {

            int j = (int) Math.sqrt(i);
            if (j * j == i) {
                dp[i] = 1;
            } else {

                dp[i] = Integer.MAX_VALUE;
                for (; j >= 1; j--) {

                    dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);

                }

            }

        }

        return dp[n];

    }

    public static void main(String[] args) {
        NumSqaures demo = new NumSqaures();
        System.out.println(demo.numSquares(4));
    }
}
