package qihu;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String s = scanner.nextLine();
            System.out.println(getNumOf(s));

        }

    }

    private static boolean isOdd(char[] array, int start, int end) {

        int result = 0;
        for (int i = start; i < end; i++) {
            result = result ^ array[i];
        }

        return result == 0;

    }

    private static int getNum(String s) {

        int N = s.length();
        char[] array = s.toCharArray();
        //dp[i][j]表示字符下标i到j子串的异或值
        char[][] dp = new char[N][N];
        //初始化
        for (int i = 0; i < N; i++) {
            dp[i][i] = array[i];
        }
        for (int i = 1; i < N; i++) {
            dp[0][i] = (char) (dp[0][i - 1] ^ array[i]);
        }

        for (int i = 1; i < N; i++) {

            for (int j = i + 1; j < N; j++) {

                dp[i][j] = (char) (dp[i][j - 1] ^ array[j]);

            }

        }

        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (dp[i][j] == 0)
                    num++;
            }
        }


        return num;

    }

    private static int getNumOf(String s) {

        int N = s.length();
        if (N == 1)
            return 0;
        char[] array = s.toCharArray();
        //dp[i]表示前i个子串的子串个数
        int[] dp = new int[N];
        dp[0] = 0;
        dp[1] = array[1] == array[0] ? 1 : 0;
        for (int i = 2; i < N; i++) {

            int num = 0;
            char sum = array[i];
            for (int j = i - 1; j >= 0; j--) {
                sum = (char) (sum ^ array[j]);
                if (sum == 0)
                    num++;
            }
            dp[i] = num + dp[i - 1];

        }

        return dp[N - 1];

    }


}
