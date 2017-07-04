package aqiyi;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-05-14.
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int bag = scanner.nextInt();
            int ball = scanner.nextInt();

            System.out.println(handle2(bag, ball));

        }
    }

    private static int handle(int bag, int ball) {

        int min = (bag + 1) * bag / 2;
        if (ball < min)
            return 0;

        //如果只有一个袋子，那么有多少个球就有多少种方案
        if (bag == 1) {
            return ball;
        }

        //如果球的数量为最少可能，那么只能按照1,2..n这种方式放
        if (ball == min)
            return 1;

        //bag>1且ball>min
        int sum = 1;
        int tempMin = 1, tempMax = bag;
        int extra = ball - min;//剩余小球
        while (extra > 0) {

            int value = -1;
            for (int i = 0; i < bag; i++) {
                value = ball - min - i;
                if (value > 0)
                    sum += value;
                else
                    break;
            }

            if (value <= 0)
                break;

            //还有剩余的球
            //处理sum
            sum = sum - value + 1;
            min = min - tempMin + tempMax + 1;
            tempMin = tempMin + 1;
            tempMax = tempMax + 1;
            extra = ball - min;

        }


        return sum;

    }

    private static int handle2(int bag, int ball) {

        int min = (bag + 1) * bag / 2;
        if (ball < min)
            return 0;

        //如果只有一个袋子，那么有多少个球就有多少种方案
        if (bag == 1) {
            return ball;
        }

        //如果球的数量为最少可能，那么只能按照1,2..n这种方式放
        if (ball == min)
            return 1;

        int maxStart = getMaxStart(bag, ball);
        int tempSum = 0;
        for (int i = 0; i < bag; i++) {
            tempSum += (maxStart + i);
        }


        int sum = 0;

        sum += Math.pow(maxStart - 1, bag);

        int value = -1;
        for (int i = 0; i < bag; i++) {
            value = ball - tempSum - i;
            if (value > 0)
                sum += value;
            else
                break;
        }





        return sum;

    }

    private static int getMaxStart(int bag, int ball) {

        int value = (bag - 1) * bag / 2;
        int max = 1;
        for (int i = 2; i < ball; i++) {

            if (value + bag * i <= ball) {
                max = i;
            } else {
                break;
            }

        }

        return max;

    }

}
