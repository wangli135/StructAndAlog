package xinyongka;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-09-19.
 */
public class Test3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.split(" ");

            int n = Integer.parseInt(array[0]);
            int m = Integer.parseInt(array[1]);

            char[][] matrix = new char[n][m];
            for (int i = 0; i < n; i++) {

                line = scanner.nextLine();
                for (int j = 0; j < m; j++) {

                    matrix[i][j] = line.charAt(j);
                }

            }

            handle(matrix);


        }


    }

    private static void handle(char[][] matrix) {

        //对于每一行，记录最左边第一个1和最右边第一个1
        int[] left = new int[matrix.length];
        int[] right = new int[matrix.length];
        boolean[] hasWrite = new boolean[matrix.length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '*') {
                    left[i] = j;
                    hasWrite[i] = true;
                    break;
                }

            }

            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] == '*') {
                    right[i] = j;
                    hasWrite[i] = true;
                    break;
                }
            }

        }

        int startLine = -1;
        int endline = -1;

        int leftest = -1;
        int rightest = -1;

        for (int i = 0; i < left.length; i++) {

            if (!hasWrite[i]) {
                continue;
            }

            if (startLine == -1) {
                startLine = endline = i;
                leftest = left[i];
                rightest = right[i];
            } else {

                leftest = Math.min(left[i], leftest);
                rightest = Math.max(rightest, right[i]);
                endline = i;
            }

        }

        for (int i = startLine; i <= endline; i++) {
            System.out.println(new String(matrix[i], leftest, rightest - leftest + 1));
        }


    }

}
