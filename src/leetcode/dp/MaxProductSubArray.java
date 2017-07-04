package leetcode.dp;

import chapter19.MaxUpSequece;

/**
 * Created by Xingfeng on 2017-03-30.
 */
public class MaxProductSubArray {

    public int maxProduct(int[] nums) {

        int n = nums.length;
        //minDp[i]表示以i结尾的最小负结果
        int[] minDp = new int[n];
        //maxDp[i]表示以i结尾的最大正结果
        int[] maxDp = new int[n];

        minDp[0] = maxDp[0] = nums[0];

        for (int i = 1; i < n; i++) {

            //正数
            if (nums[i] >= 0) {
                maxDp[i] = Math.max(nums[i], nums[i] * maxDp[i - 1]);
                minDp[i] = Math.min(nums[i] * minDp[i - 1], nums[i]);
            } else {
                maxDp[i] = Math.max(nums[i] * minDp[i - 1], nums[i]);
                minDp[i] = Math.min(nums[i], nums[i] * maxDp[i - 1]);
            }

        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < maxDp.length; i++) {
            if (maxDp[i] > max)
                max = maxDp[i];
        }

        return max;

    }

    public static void main(String[] args) {

        MaxProductSubArray maxProductSubArray = new MaxProductSubArray();
        int[] array = {-4, -3, -2};
        System.out.println(maxProductSubArray.maxProduct(array));

    }

}
