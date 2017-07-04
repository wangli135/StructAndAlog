package toutiao;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-30.
 */
public class Test3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.split(" ");
            int n = Integer.parseInt(array[0]);
            int k = Integer.parseInt(array[1]);

            int[][] jobs = new int[n][n];
            for (int i = 0; i < n; i++) {
                int[] job = new int[i + 1];
                line = scanner.nextLine();
                array = line.split(" ");
                for (int i1 = 0; i1 < array.length; i1++) {
                    job[i1] = Integer.parseInt(array[0]);
                }
                jobs[i] = job;
            }

            System.out.println(handle(jobs, n, k));

        }
    }

    private static int handle(int[][] jobs, int n, int k) {

        //如果k<3，那么只能从最后一行无依赖的数组中查找最大值
        if (k < 3) {
            return bag01(jobs[n - 1], k);
        }

        return 0;
    }

    private static int bag01(int[] value, int k) {

        int[] dp = new int[k + 1];//dp[v]表示容量为v情况下的最大价值
        for (int i = 0; i < value.length; i++) {
            for (int v = k; v >= 1; v--) {
                dp[v] = Math.max(dp[v], dp[v - 1] + value[i]);
            }
        }

        return dp[k];
    }

}
