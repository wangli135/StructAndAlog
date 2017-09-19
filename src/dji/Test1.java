package dji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Xingfeng on 2017-09-16.
 */
public class Test1 {

    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine().trim();
        int n = Integer.parseInt(line);

        //table[i][j]表示Cij的值
        int[][] table = new int[21][21];
        for (int i = 0; i < table.length; i++) {
            table[i][0] = 1;
        }

        int[] dp = new int[21];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i * dp[i - 1];
        }

        for (int i = 0; i < n; i++) {

            line = reader.readLine();
            String[] array = line.split(" ");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);
            System.out.println(handle(table, dp, a, b));

        }


    }

    private static int handle(int[][] table, int[] dp, int a, int b) {

        if (table[a][b] == 0)
            cal(table, dp, a, b);

        return table[a][b];

    }

    private static void cal(int[][] table, int[] dp, int a, int b) {

        table[a][b] = dp[a] / dp[a - b] / dp[b];

    }

}
