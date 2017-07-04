package ctrip;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-11.
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.split(" ");
            int[] data = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                data[i] = Integer.parseInt(array[i]);
            }
            System.out.println(maxSum(data));
        }
    }

    private static int maxSum(int[] data) {

        int maxSoFar = data[0], maxEndingHere = data[0];
        for (int i = 1; i < data.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + data[i], data[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;

    }

}
