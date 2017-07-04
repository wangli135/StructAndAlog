package leetcode.array;

/**
 * 数组中某一元素出现次数超过半数，求该数
 * 1、排序，返回中位数
 * 2、使用partion方案
 * 3、使用超过半数特性，遍历一次
 * Created by Xingfeng on 2017-07-04.
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {


//        int partion = 0;
//        int N = nums.length;
//        int left = 0, right = nums.length - 1;
//        while (true) {
//
//            partion = partion(nums, left, right);
//            if (partion == N / 2) {
//                break;
//            } else if (partion < N / 2) {
//                left = partion+1;
//            } else {
//                right = partion-1;
//            }
//
//        }
//        return nums[partion];


        //最好方案
        int major = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else if (major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;

    }

    private int partion(int[] nums, int start, int end) {

        if (start >= end)
            return start;

        int left = start;
        int right = end + 1;
        int base = nums[start];
        while (true) {

            while (nums[++left] <= base)
                if (left == end)
                    break;

            while (nums[--right] >= base)
                if (right == start)
                    break;

            if (left >= right)
                break;

            swap(nums, left, right);

        }

        swap(nums, start, right);

        return right;

    }

    private void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static void main(String[] args) {

        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(new int[]{2, 2}));

    }

}
