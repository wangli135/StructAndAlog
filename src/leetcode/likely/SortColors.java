package leetcode.likely;

/**
 * Created by wangl on 2017/8/10.
 */
public class SortColors {

    public void sortColors(int[] nums) {

        int zeroIndex = -1;
        int oneIndex = -1;
        int twoIndex = nums.length;
        int index = 0;
        while (index < twoIndex) {

            if(nums[index]==0){
                swap(nums, ++zeroIndex, index++);
                oneIndex++;
            }else if(nums[index]==1){
                oneIndex++;
                index++;
            }else{
                swap(nums, index, --twoIndex);
            }

        }


    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {

        int[] colors = new int[]{0};
        new SortColors().sortColors(colors);

    }

}
