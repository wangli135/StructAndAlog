package aqiyi;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-05-14.
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            //广告总时长
            int T = scanner.nextInt();
            //广告片库时长
            int N = scanner.nextInt();

            //转化为01背包问题
            int[] ads = new int[N];
            for (int i = 0; i < ads.length; i++) {
                ads[i] = scanner.nextInt();
            }

            System.out.println(handle(T, ads));

        }
    }

    //将该问题转化为01背包问题，背包总价值为时间T，每个物品的重量和价值均为该广告的时间
    public static int handle(int V, int[] value) {

        int[] dp = new int[V + 1];//dp[v]表示容量为v情况下的最大价值
        for (int i = 0; i < value.length; i++) {
            for (int v = V; v >= value[i]; v--) {
                dp[v] = Math.max(dp[v], dp[v - value[i]] + value[i]);
            }
        }

        return dp[V];
    }


}
