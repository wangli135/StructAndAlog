package aqiyi;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-05-14.
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int M = scanner.nextInt();
            int N = scanner.nextInt();

            int[][] matrix = new int[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {

                    matrix[i][j] = scanner.nextInt();

                }
            }

            print(matrix);

        }
    }

    private static void print(int[][] matrix) {

        if (matrix.length == 0)
            return;

        int n = matrix.length, m = matrix[0].length;
        if (m == 0)
            return;

        int layers = (Math.min(n, m) - 1) / 2 + 1;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < layers; i++) {
            for (int k = i; k < m - i; k++) {
                result.append(matrix[i][k] + " ");
            }
            for (int j = i + 1; j < n - i; j++) {
                result.append(matrix[j][m - i - 1] + " ");
            }
            for (int k = m - i - 2; (k >= i) && (n - i - 1 != i); k--) {
                result.append(matrix[n - i - 1][k] + " ");
            }
            for (int j = n - i - 2; (j > i) && (m - i - 1 != i); j--) {
                result.append(matrix[j][i] + " ");
            }
        }

        result.deleteCharAt(result.length() - 1);
        System.out.println(result);

    }

}
