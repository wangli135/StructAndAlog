package leetcode.array;

/**
 * 给定一个step，旋转数组
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 1.创建2倍数组，比如[1,2,3,4,5,6,7,1,2,3,4,5,6,7]，取[nums.length-k,2*num.length-k]一段
 * 2.旋转三步
 * a、全部旋转，得[7,6,5,4,3,2,1]
 * b、旋转[0,k-1]，得[5,6,7,4,3,2,1]
 * c、旋转[k,length-1]，得[5,6,7,1,2,3,4]
 * Created by Xingfeng on 2017-07-04.
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {

        k = k % nums.length;
        resverse(nums, 0, nums.length - 1);
        resverse(nums, 0, k - 1);
        resverse(nums, k, nums.length - 1);
    }

    //[start,end]
    private void resverse(int[] data, int start, int end) {

        while (start < end) {
            swap(data, start++, end--);
        }

    }

    private void swap(int[] data, int i, int j) {

        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;

    }

    public static void main(String[] args) {

        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(new int[]{1}, 0);

    }

}
