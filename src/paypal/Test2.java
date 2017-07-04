package paypal;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-13.
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.split(" ");
            int N = Integer.parseInt(array[0]);
            int M = Integer.parseInt(array[1]);
            String val = scanner.nextLine();
            char[] valArray = val.toCharArray();
            int[] intArray = new int[M];
            for (int i = 0; i < M; i++) {
                line = scanner.nextLine();
                array = line.split(" ");
                int start = Integer.parseInt(array[1]) - 1;
                int end = Integer.parseInt(array[2]) - 1;
                int change = Integer.parseInt(array[0]);
                for (int k = start; k <= end; k++) {
                    intArray[k] = change;
                }
            }

            //处理intArray

        }


    }

    private static void descres(char[] val, int starr, int end) {

        Arrays.sort(val, starr, end + 1);
        for (int i = starr, j = end; i < j; i++, j--) {
            char c = val[starr];
            val[starr] = val[end];
            val[end] = c;
        }

    }

    private static void inceres(char[] val, int starr, int end) {

        Arrays.sort(val, starr, end + 1);


    }

}
