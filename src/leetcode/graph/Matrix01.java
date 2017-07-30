package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wangl on 2017/7/26.
 */
public class Matrix01 {

    public int[][] updateMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n ||
                        matrix[r][c] <= matrix[cell[0]][cell[1]] + 1) continue;
                queue.add(new int[]{r, c});
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
            }
        }

        return matrix;

    }

    public static void main(String[] args) {

        int[][] matrix = new int[3][];
        matrix[0] = new int[]{0, 0, 0};
        matrix[1] = new int[]{0, 1, 0};
        matrix[2] = new int[]{1, 2, 1};

        Matrix01 matrix01 = new Matrix01();
        matrix01.updateMatrix(matrix);


    }

}
