package netease;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class Subsequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String s = sc.nextLine();
            String t = sc.nextLine();

            boolean isSequence = isSequence(s, t);
            if (isSequence)
                System.out.println("Yes");
            else
                System.out.println("No");

        }

    }

    private static boolean isSequence(String s, String t) {

        int N = s.length();
        int M = t.length();
        //dp[i][j]表示t的前j个字符串是否是s的前i个字符子串
        boolean[][] dp = new boolean[N + 1][M + 1];
        //初始化,空字符是任意字符子串的子序列
        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                //如果两个值相等
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }


        }


        return dp[N][M];

    }

}
