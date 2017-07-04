package chapter19;

/**
 * Created by Xingfeng on 2017-03-17.
 */
public class MaxUpSequece {

    public int maxLength(int[] array) {

        int[] dp = new int[array.length];//dp[i]表示以array[i]结尾的严格递增子序列的最长数
        dp[0] = 1;

        for (int i = 1; i < array.length; i++) {

            if (array[i] == array[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                //从i-2往前找到一个比array[i]小的值
                int index = i - 1;
                int max = 0;
                while (index >= 0) {
                    if (array[index] < array[i]) {
                        if (dp[index] > max)
                            max = dp[index];
                    }
                    index--;
                }

                dp[i] = max + 1;
            }

        }


        int max = 1;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > max)
                max = dp[i];
        }

        return max;

    }

    public static void main(String[] args) {

        MaxUpSequece maxUpSequece = new MaxUpSequece();
        int[] array = {5, 6, 2, 3, 4, 1, 9, 9, 8, 9, 5};
        System.out.println(maxUpSequece.maxLength(array));
    }

}
