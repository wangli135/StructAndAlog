package chapter19;

/**
 * Created by Xingfeng on 2017-03-10.
 */
public class MaxSequenceSum {

    //最大连续子序列和
    public int maxSum(int[] array) {

        int maxSoFar = array[0], maxEndingHere = array[0];
        for (int i = 1; i < array.length; i++) {

            maxEndingHere = Math.max(maxEndingHere + array[i], array[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);

        }
        return maxSoFar;

    }

    public static void main(String[] args) {

        int[] array = {-2, 11, -4, 13, -5, 2};
        System.out.println(new MaxSequenceSum().maxSum(array));

    }

}
