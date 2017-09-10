package netease;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangl on 2017/8/12.
 */
public class Test5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            int n = Integer.parseInt(line);
            line = scanner.nextLine();
            int[] array = new int[n];
            String[] sArray = line.split(" ");
            for (int i = 0; i < sArray.length; i++) {
                array[i] = Integer.parseInt(sArray[i]);
            }

            handle2(array);


        }
    }

    private static void handle(int[] array) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
            Collections.reverse(list);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i) + " ");
            }
        }

        System.out.println(sb.toString());

    }

    private static void handle2(int[] array) {

        int[] result = new int[array.length];
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        boolean left = true;

        for (int i = array.length-1; i>=0; i--) {

            if (left) {
                result[leftIndex++] = array[i];
                left = false;
            } else {
                result[rightIndex--] = array[i];
                left = true;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1) {
                sb.append(result[i]);
            } else {
                sb.append(result[i] + " ");
            }
        }

        System.out.println(sb.toString());


    }

}

