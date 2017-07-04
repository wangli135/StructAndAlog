package leetcode.dp;

/**
 * 最长递增子序列长度
 * Created by Xingfeng on 2017-04-01.
 */
public class MaxLongestIncreaseSequence {

    public int lengthOfLIS(int[] nums) {

        int N = nums.length;

        if (N == 0)
            return 0;

        //dp[i]表示以nums[i]结尾的最长递增子序列
        int[] dp = new int[N];
        int max = 1;
        for (int i = 0; i < N; i++) {

            int m = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] > m) {
                        m = dp[j];
                    }
                }
            }
            dp[i] = m + 1;
        }

        for (int i = 1; i < N; i++) {
            if (dp[i] > max)
                max = dp[i];
        }

        return max;

    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        MaxLongestIncreaseSequence demo = new MaxLongestIncreaseSequence();
        System.out.println(demo.lengthOfLIS(nums));
    }

}
