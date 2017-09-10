package leetcode.likely;

/**
 * Created by wangl on 2017/8/7.
 */
public class PartionTwoEqualSumSet {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums)
            sum += num;

        if (sum % 2 == 1)
            return false;

        int avg = sum / 2;

        return findVal(nums, 0, avg);

    }

    private boolean findVal(int[] nums, int start, int target) {

        if (target == 0)
            return true;

        if (start == nums.length)
            return false;

        return findVal(nums, start + 1, target) || findVal(nums, start + 1, target - nums[start]);


    }


    public static void main(String[] args) {

        PartionTwoEqualSumSet set=new PartionTwoEqualSumSet();
        System.out.println(set.canPartition(new int[]{1,5,11,5}));

    }

}
