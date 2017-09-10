package pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangl on 2017/8/1.
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            int studentNum = Integer.parseInt(line.trim());
            int[] students = new int[studentNum];
            line = scanner.nextLine();
            String[] array = line.trim().split(" ");
            for (int i = 0; i < array.length; i++) {
                students[i] = Integer.parseInt(array[i]);
            }
            line = scanner.nextLine();
            int wNum = Integer.parseInt(line.trim());
            int[] w = new int[wNum];
            line = scanner.nextLine();
            array = line.trim().split(" ");
            for (int i = 0; i < array.length; i++) {
                w[i] = Integer.parseInt(array[i]);
            }

            System.out.println(handler(students, w));

        }

    }

    private static int handler(int[] students, int[] w) {

        Arrays.sort(students);
        Arrays.sort(w);

        int index1 = students.length - 1;
        int index2 = w.length-1;
        int num = 0;

        while (index1 >= 0 && index2 >= 0) {

            if (w[index2] >= students[index1]) {
                num++;
                index2--;
                index1--;
            } else {
                index1--;
            }

        }


        return num;

    }

}
