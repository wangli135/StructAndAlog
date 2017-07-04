package perfect;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-29.
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int N = scanner.nextInt();
            int[] values = new int[N];
            int[] weight = new int[N];
            scanner.nextLine();
            //价值
            for(int i=0;i<N;i++){
                values[i]=scanner.nextInt();
            }
            for(int i=0;i<N;i++){
                weight[i]=scanner.nextInt();
            }

            int maxWeight = scanner.nextInt();
//            //dp[i]表示当重量为i时最大的价值
//            int[] dp = new int[maxWeight + 1];
//
//            //对应于每一个重量
//            for (int i = 0; i < weight.length; i++) {
//
//                for (int v = maxWeight; v >= weight[i]; v--) {
//
//                    dp[v] = Math.max(dp[v], dp[v - weight[i]] + values[i]);
//
//                }
//
//            }

//            System.out.println(dp[maxWeight]);

            int maxValue = bag01(N, maxWeight, weight, values);
            System.out.println(maxValue);

        }
    }

    public static int bag01(int N, int V, int[] weight, int[] value) {

        //dp[i][j]表示前i件物品重量为j时的价值
        int[][] dp = new int[N + 1][V + 1];

        for (int j = 0; j <= V; j++) {
            for (int i = 0; i <= N; i++) {

                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {

                    if (j < weight[i - 1]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                    }

                }

            }
        }

        int max = 0;
        for (int i = 1; i < V + 1; i++)
            if (dp[N][i] > max)
                max = dp[N][i];

        return max;
    }

}
