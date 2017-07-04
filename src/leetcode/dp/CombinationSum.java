package leetcode.dp;

/**
 * Created by Xingfeng on 2017-03-30.
 */
public class CombinationSum {

    //递归解法，超时
    public int combinationSum4(int[] nums, int target) {

        if (target < 0)
            return 0;

        if (target == 0)
            return 1;

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += combinationSum4(nums, target - nums[i]);
        }

        return sum;

    }

    //动态规划解法，完全背包
    public int combinationSum4Dp(int[] nums, int target) {

        //dp[i]表示组成i的组合数
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (nums[j] <= i) {

                    dp[i] += dp[i - nums[j]];

                }

            }

        }

        return dp[target];
    }


    public static void main(String[] args) {

        int[] array = {1, 2, 3};
        int target = 4;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum4Dp(array, target));

    }

}
