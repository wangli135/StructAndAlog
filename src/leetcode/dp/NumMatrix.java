package leetcode.dp;

/**
 * Created by Xingfeng on 2017-03-31.
 */
public class NumMatrix {

    int[][] matrix;

    public NumMatrix(int[][] matrix) {

        this.matrix = matrix;
        int N = matrix.length;
        int M = matrix[0].length;

        //处理第一行
        for (int i = 1; i < M; i++) {
            matrix[0][i] += matrix[0][i - 1];
        }

        //处理第一列
        for (int i = 1; i < N; i++) {
            matrix[i][0] += matrix[i - 1][0];
        }

        //处理其他行和列
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] + matrix[i][j] - matrix[i - 1][j - 1];
            }
        }


    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        return matrix[row2][col2] - matrix[row2][col1] - matrix[row1][col2] + matrix[row1][col1];

    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

}
