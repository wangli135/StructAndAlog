package netease;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class DivideArea {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String line = sc.nextLine();
            String[] array = line.split(" ");
            int n = Integer.parseInt(array[0]);
            int m = Integer.parseInt(array[1]);

            int[][] matrix = new int[n][m];
            for (int i = 0; i < matrix.length; i++) {

                line = sc.nextLine();
                array = line.split(" ");
                for (int i1 = 0; i1 < array.length; i1++) {
                    matrix[i][i1] = Integer.parseInt(array[i1]);
                }

            }


            int max = Integer.MIN_VALUE;




        }

    }

}
