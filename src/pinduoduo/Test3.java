package pinduoduo;

import java.util.Scanner;

/**
 * Created by wangl on 2017/8/1.
 */
public class Test3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            int n = Integer.parseInt(line.trim());
            int[] nums = new int[n];
            line = scanner.nextLine().trim();
            String[] array = line.split(" ");
            for (int i = 0; i < array.length; i++) {
                nums[i] = Integer.parseInt(array[i]);
            }
            System.out.println(handle(nums));

        }

    }

    private static int handle(int[] nums) {

        int len = nums.length;
        //result[i]表示以i结尾的最大乘积的三个值
        int[] result = new int[len];
        //两个数乘积最大的正数，包含
        int[] twoPositive = new int[len];
        //两个数乘积最小的负数,包含
        int[] twoNegative = new int[len];

        //初始化
        twoPositive[0] = nums[0] > 0 ? nums[0] : 1;
        twoNegative[0] = nums[0] < 0 ? nums[0] : 1;

        twoPositive[1] = nums[1] > 0 ? nums[1] * twoPositive[0] : 0;


        int max = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > max)
                max = result[i];
        }
        return max;

    }


}
