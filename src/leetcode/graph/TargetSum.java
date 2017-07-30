package leetcode.graph;

/**
 * Created by wangl on 2017/7/26.
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, 0, S);
    }

    private int findTargetSumWays(int[] nums, int start, int S) {

        if (start == nums.length && S == 0)
            return 1;

        if (start == nums.length)
            return 0;

        int num = 0;


        int temp = nums[start];
        num += findTargetSumWays(nums, start + 1, S - temp) + findTargetSumWays(nums, start + 1, S + temp);


        return num;

    }

    public static void main(String[] args) {

        TargetSum targetSum = new TargetSum();
        int[] array = {1, 1, 1, 1, 1};
        System.out.println(targetSum.findTargetSumWays(array, 3));

    }


}
