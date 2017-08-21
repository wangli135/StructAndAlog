package lianjia;

import java.util.Scanner;

/**
 * Created by wangl on 2017/8/21.
 */
public class Test3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String x = scanner.nextLine();
            String y = scanner.nextLine();

            System.out.println(handle(x, y));

        }

    }

    /**
     * 最长公共子序列
     *
     * @param x
     * @param y
     * @return
     */
    private static int handle(String x, String y) {

        int n = x.length();
        int m = y.length();

        //dp[i][j]表示x[i..n]与y[j..m]的最长子序列长度
        int[][] dp = new int[n + 1][m + 1];

        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {

                if (x.charAt(i) == y.charAt(j)) {

                    dp[i][j] = 1 + dp[i + 1][j + 1];

                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }

            }

        }


        return dp[0][0];
    }

}
