package leetcode.dp;

/**
 * Created by Xingfeng on 2017-03-31.
 */
public class Coins {

    public int coinChange(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        //dp[i]表示组成i的最少硬币数，如果不存在，则-1
        int[] dp = new int[amount + 1];
        dp[0] = -1;
        for (int i = 1; i <= amount; i++) {

            dp[i] = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {

                if (i >= coins[j]) {

                    int prev = i - coins[j];
                    if (prev == 0) {
                        min = 1;
                    } else if (dp[prev] != -1) {
                        if (1 + dp[prev] < min) {
                            min = 1 + dp[prev];
                        }
                    }
                }

            }

            if (min == Integer.MAX_VALUE) {
                min = -1;
            }
            dp[i] = min;

        }
        return dp[amount];

    }

    public static void main(String[] args) {

        Coins coins = new Coins();
        int[] array = {2};
        System.out.println(coins.coinChange(array, 1));


    }

}
