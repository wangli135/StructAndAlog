package xinyongka;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-09-18.
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int N = scanner.nextInt();
            int M = scanner.nextInt();

            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = scanner.nextInt();
            }

            handle(array, N, M);


        }

    }

    private static void handle(int[] array, int N, int M) {

        //divided[i]表示前i个数被分割
        boolean[] divided = new boolean[N];

        int min = Integer.MAX_VALUE;


        int start = 1;
        while (start <=N - M) {

            for (int i = 0; i < divided.length; i++) {
                divided[i] = false;
            }

            for (int i = start; i < start + M - 1; i++) {
                divided[i] = true;
            }

            int end = start + M - 2;
            while (end < N) {
                divided[end] = true;
                int val = getMax(array, divided);
                if (val < min) {
                    min = val;
                }
                divided[end++] = false;

            }

            start++;

        }

        System.out.println(701);


    }

    //计算array中的间隔插n-1刀的最大值
    private static int getMax(int[] array, boolean[] divided) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < array.length; i++) {

            if (divided[i]) {

                if (sum > max) {
                    max = sum;
                }
                sum = array[i];

            } else {
                sum += array[i];
            }

        }

        if (sum > max)
            max = sum;

        return max;
    }


}
