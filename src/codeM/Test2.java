package codeM;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-06-11.
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int N = Integer.parseInt(line);
            int[] first = new int[N];
            line = scanner.nextLine();
            String[] array = line.split(" ");
            for (int i = 0; i < first.length; i++) {
                first[i] = Integer.parseInt(array[i]);
            }

            line = scanner.nextLine();
            int M = Integer.parseInt(line);
            line = scanner.nextLine();
            array = line.split(" ");
            int[] second = new int[M];
            for (int i = 0; i < second.length; i++) {
                second[i] = Integer.parseInt(array[i]);
            }

            System.out.println(handle(first, second));


        }

    }

    private static int handle(int[] first, int[] second) {

        int minDiff = Integer.MAX_VALUE;
        int N = first.length, M = second.length;
        for (int i = 0; i + N <= M; i++) {

            //计算差值
            int temp = 0;
            for (int j = 0; j < N; j++) {

                int val = second[j + i] - first[j];
                temp += (val * val);

            }

            if (temp < minDiff) {
                minDiff = temp;
            }

        }


        return minDiff;


    }

}
