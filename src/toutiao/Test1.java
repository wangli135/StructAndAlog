package toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-30.
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int m = scanner.nextInt();
            int[] array1 = new int[m];
            for (int i = 0; i < array1.length; i++) {
                array1[i] = scanner.nextInt();
            }
            int n = scanner.nextInt();
            Arrays.sort(array1);
            int[] array2 = new int[n];
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < array2.length; i++) {
                array2[i] = scanner.nextInt();
                int index = Arrays.binarySearch(array1, array2[i]);
                if (index >= 0) {
                    result.add(array1[index]);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                if (i != result.size() - 1) {
                    sb.append(result.get(i) + " ");
                } else {
                    sb.append(result.get(i));
                }
            }
            System.out.println(sb);

        }
    }

}
