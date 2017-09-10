package leetcode.dp;

/**
 * Created by wangl on 2017/7/30.
 */
public class UnglyNumber {

    public int nthUglyNumber(int n) {

        int[] base = {2, 3, 5};

        if (n <= 5)
            return n;
        else {

            int[] dp = new int[n + 1];
            dp[0] = Integer.MAX_VALUE / 5;
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= n; i++) {

                int k = i / 5;
                int prev = dp[i - 1];
                dp[i] = Integer.MAX_VALUE;
                for (int j = k; j < i; j++) {

                    for (int m = 0; m < base.length; m++) {

                        if (m * dp[j] > prev) {
                            dp[i] = Math.min(dp[i], m * dp[j]);
                        }

                    }

                }

            }

            return dp[n];

        }

    }

    public static void main(String[] args) {

        UnglyNumber number = new UnglyNumber();
        System.out.println(number.nthUglyNumber(6));

    }

}
