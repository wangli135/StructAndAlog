package lianjia;

import java.util.Scanner;

/**
 * Created by wangl on 2017/8/21.
 */
public class Test1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.trim().split(" ");
            int n = Integer.parseInt(array[0]);
            int m = Integer.parseInt(array[1]);
            int k = Integer.parseInt(array[2]);

            line = scanner.nextLine();
            array = line.split(" ");
            int[] data = new int[n];
            for (int i = 0; i < array.length; i++) {
                data[i] = Integer.parseInt(array[i]);
            }

            System.out.println(handle(n, m, k, data));

        }

    }

    private static int handle(int n, int m, int k, int[] data) {

        //dp[i][j]表示从前i个数取j个数的最大和
        //dp[i][j]=max(dp[i-1][j],dp[i-k][j-1]+data[j])
        int[][] dp = new int[n + 1][k + 1];

        //初始化
        for (int i = 1; i <= n; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], data[i - 1]);
        }

        for (int i = 2; i <= n; i++) {

            for (int j = 2; j <= k; j++) {

                if (i >= k) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - k][j - 1] + data[i - 1]);
                } else {
                    dp[i][j] = 0;
                }


            }

        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (dp[i][k] > max)
                max = dp[i][k];
        }


        return max;
    }

}
