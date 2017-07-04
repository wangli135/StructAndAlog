package chapter19;

import java.util.Arrays;

/**
 * Created by Xingfeng on 2016-11-17.
 */
public class Question {

    /**
     * 题目1，T(0)=T(1)=2
     *       T(n)=2*T(1)*T(0)+2*T(2)*T(1)*....+2*T(n-1)*T(n-2)
     */

    /**
     * 递归实现
     *
     * @param n
     * @return
     */
    public int question1Recursive(int n) {

        if (n == 0)
            return 2;
        if (n == 1)
            return 2;

        int sum = 0;

        for (int i = 1; i < n; i++) {

            sum += 2 * question1Recursive(i) * question1Recursive(i - 1);

        }

        return sum;

    }

    int[] dp1 = new int[1024];

    /**
     * 动态规划实现
     *
     * @param n
     * @return
     */
    public int question1Dp(int n) {

        if (n == 0)
            return 2;
        if (n == 1)
            return 2;

        dp1[0] = 2;
        dp1[1] = 2;

        if (dp1[n] == 0) {

            int sum = 0;
            for (int i = 1; i < n; i++)
                sum += 2 * question1Dp(i) * question1Dp(i - 1);

            dp1[n] = sum;

        }

        return dp1[n];

    }

    /**
     * 改进版，得出公式T(n+1)=T(n)+2*T(n)*T(n-1)
     *
     * @param n
     * @return
     */
    public int question1Imporve(int n) {

        dp1[0] = dp1[1] = 2;
        dp1[2] = 2 * dp1[1] * dp1[0];
        for (int i = 3; i <= n; i++)
            dp1[i] = dp1[i - 1] + 2 * dp1[i - 1] * dp1[i - 2];
        return dp1[n];

    }

    /**
     * 问题2：最大连续子序列和
     */

    /**
     * 暴力法 时间复杂度O(n^2)
     *
     * @param array
     * @return 最大连续子序列
     */
    public int[] question2(int[] array) {

        int maxStart = 0, maxEnd = 0;
        int max = Integer.MIN_VALUE;

        int temp = 0;

        for (int i = 0; i < array.length; i++) {

            temp = 0;
            for (int j = i; j < array.length; j++) {

                temp += array[j];
                if (temp > max) {
                    max = temp;
                    maxEnd = j;
                    maxStart = i;
                }

            }

        }

        int[] result = new int[maxEnd - maxStart + 1];
        for (int i = maxStart; i <= maxEnd; i++)
            result[i - maxStart] = array[i];
        return result;
    }


    /**
     * 动态规划法 result[i]表示以i为末端的所有窗口的最大和
     *
     * @param array
     * @return
     */
    public int question2Dp(int[] array) {

        int[] result = new int[array.length];
        int maxSum = 0;

        if (array[0] > 0)
            result[0] = array[0];
        else
            result[0] = 0;

        for (int i = 1; i < array.length; i++) {

            if (result[i - 1] + array[i] > 0)
                result[i] = result[i - 1] + array[i];
            else
                result[i] = 0;

        }

        maxSum = 0;
        for (int i = 0; i < array.length; i++)
            if (result[i] > maxSum)
                maxSum = result[i];

        return maxSum;

    }

    /**
     * 问题3：卡塔兰数
     */

    /**
     * 递归实现
     *
     * @param n
     * @return
     */
    public int catalanRecursive(int n) {

        if (n == 0)
            return 1;

        int count = 0;
        for (int i = 1; i <= n; i++)
            count += catalanRecursive(i - 1) * catalanRecursive(n - i);

        return count;

    }

    int[] dp3 = new int[1024];

    /**
     * 动态规划算法
     * @param n
     * @return
     */
    public int catalanDp(int n) {

        if (n == 0)
            return 1;

        dp3[0] = 1;

        if (dp3[n] == 0) {
            for (int i = 1; i <= n; i++) {
                dp3[n]+=catalanDp(i-1)*catalanDp(n-i);
            }
        }

        return dp3[n];

    }





    public static void main(String[] args) {

        Question question = new Question();

//        int[] array = {-2, 11, -4, 13, -5, 2};
        int[] array = {1, -3, 4, -2, -1, 6};


        long current = System.nanoTime();
        System.out.println(question.catalanRecursive(3));
        System.out.println(System.nanoTime() - current);
        current = System.nanoTime();
        System.out.println(question.catalanDp(3));
        System.out.println(System.nanoTime() - current);

       /* System.out.println(System.nanoTime() - current);
        current = System.nanoTime();
        System.out.println(question.question1Imporve(22));
        System.out.println(System.nanoTime() - current);*/

    }

}
