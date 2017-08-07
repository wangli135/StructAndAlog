package leetcode.likely;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangl on 2017/8/7.
 */
public class Subsets2 {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }


    private void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {

        result.add(new ArrayList<>(list));
        if (start == nums.length)
            return;

        for (int i = start; i < nums.length; i++) {

            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                helper(result, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }


    }

    public static void main(String[] args) {

        System.out.println(new Subsets2().subsets(new int[]{1, 2, 3}));

    }


}
