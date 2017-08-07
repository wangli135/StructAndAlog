package leetcode.dp;

/**
 * Created by wangl on 2017/7/30.
 */
public class MaxiumSquare {

    public int maximalSquare(char[][] matrix) {

        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;

        //dp[i][j]表示以(i,j)为顶点，向右向下的正方形为1的边长
        int[][] dp = new int[row][col];
        int max = 0;
        //初始化
        for (int i = 0; i < col; i++) {
            dp[row - 1][i] = matrix[row - 1][i] == '1' ? 1 : 0;
            if (dp[row - 1][i] > max) {
                max = dp[row - 1][i];
            }
        }
        for (int i = 0; i < row; i++) {
            dp[i][col - 1] = matrix[i][col - 1] == '1' ? 1 : 0;
            if (dp[i][col - 1] > max) {
                max = dp[i][col - 1];
            }
        }

        //开始遍历
        for (int i = row - 2; i >= 0; i--) {

            for (int j = col - 2; j >= 0; j--) {

                char c = matrix[i][j];
                if (c == '1') {

                    int prev = dp[i + 1][j + 1];
                    if (prev == 0) {
                        dp[i][j] = 1;
                    } else {

                        int xOne = 0;
                        int k = j;
                        while (k < col) {
                            if (matrix[i][k++] == '1') {
                                xOne++;
                            } else {
                                break;
                            }
                        }
                        int yOne = 0;
                        k = i;
                        while (k < row) {
                            if (matrix[k++][j] == '1') {
                                yOne++;
                            } else {
                                break;
                            }
                        }
                        dp[i][j] = Math.min(xOne, yOne);
                        dp[i][j] = Math.min(dp[i][j], prev+1);


                    }

                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] > max) {
                    max = dp[i][j];
                }

            }

        }


        return max * max;


    }

    public static void main(String[] args) {

        //["10100","10111","11111","10010"]
        MaxiumSquare square = new MaxiumSquare();
        char[][] matrix = new char[][]{
                "10100".toCharArray(),
                "10111".toCharArray(),
                "11111".toCharArray(),
                "10010".toCharArray()
        };
        System.out.println(square.maximalSquare(matrix));

    }

}
