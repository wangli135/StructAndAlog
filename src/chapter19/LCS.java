package chapter19;

/**
 * 最长公共子序列
 * Created by Xingfeng on 2016-11-17.
 */
public class LCS {

    public int lcsLength(String x, int i, String y, int j) {

        if (i == x.length() || j == y.length())
            return 0;

        if (x.charAt(i) == y.charAt(j))
            return 1 + lcsLength(x, ++i, y, ++j);
        else
            return Math.max(lcsLength(x, i + 1, y, j), lcsLength(x, i, y, j + 1));

    }

    int[][] dp = new int[1024][1024];

    public int lcsLengthDp(String x, String y) {

        //基本情况
        for (int i = 0; i <= x.length(); i++) {
            dp[y.length()][i] = 0;
        }

        for (int i = 0; i <= y.length(); i++) {
            dp[i][x.length()] = 0;
        }

        for (int i = x.length() - 1; i >= 0; i--) {

            for (int j = y.length() - 1; j >= 0; j--) {


                dp[i][j] = dp[i + 1][j + 1]; //把X[i]与Y[j]相匹配

                if (x.charAt(i) == y.charAt(j))
                    dp[i][j]++;  //匹配了一对

                //其他两种情况-插入一个间隙
                if (dp[i][j + 1] > dp[i][j])
                    dp[i][j] = dp[i][j + 1];
                if (dp[i + 1][j] > dp[i][j])
                    dp[i][j] = dp[i + 1][j];

            }

        }

        return dp[0][0];

    }

    public static void main(String[] args) {

        LCS lcs = new LCS();

        System.out.println(lcs.lcsLength("ABCBDAB", 0, "BDCABA", 0));
        System.out.println(lcs.lcsLengthDp("ABCBDAB", "BDCABA"));

    }

}
