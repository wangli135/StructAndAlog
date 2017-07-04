package chapter19;

/**
 * Created by Xingfeng on 2017-03-17.
 */
public class LongestPalidromeSubsequence {

    public int longestPalidromeSubsequence(char[] array) {

        int N = array.length;
        int[][] dp = new int[N][N];//dp[i][j]表示字符[i..j]的最长回文子串长度

        for (int i = 0; i < N; i++)
            dp[i][i] = 1;

        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {

                if (array[i] == array[j]) {
                    if (j == i + 1)
                        dp[i][j] = 2;
                    else
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }

            }
        }

        return dp[0][N - 1];
    }

    public static void main(String[] args) {

        String s = "ABCBAEA";
        LongestPalidromeSubsequence demo = new LongestPalidromeSubsequence();
        System.out.println(demo.longestPalidromeSubsequence(s.toCharArray()));

    }

}
