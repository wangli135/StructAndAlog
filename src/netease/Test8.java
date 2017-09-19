package netease;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wangl on 2017/8/12.
 */
public class Test8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int N = scanner.nextInt();
            int L = scanner.nextInt();

            int[] array = new int[N - 1];
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }

            handle(N, L, array);


        }
    }

    private static void handle(int n, int step, int[] array) {


        //维持节点与节点之间的关系matrix[i][j]表示节点之间有边
        boolean[][] matrix = new boolean[n][n];
        for (int i = 0; i < array.length; i++) {

            matrix[i + 1][array[i]] = true;
            matrix[array[i]][i + 1] = true;

        }

        int max = 0;

        //与0相关的节点可能有两个，分别计算从两个出发的情况
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][i]) {

                int num = handle2(n, step, i, array, matrix);
                if (num > max)
                    max = num;

            }
        }


        System.out.println(max);

    }

    /**
     * 与0相关的可能有两个节点
     *
     * @param n
     * @param step
     * @param secondCity 第二个城市
     * @param array
     * @return
     */
    private static int handle2(int n, int step, int secondCity, int[] array, boolean[][] matrix) {

        if (step == 1)
            return 2;

        //代表城市是否被访问过
        boolean[] visited = new boolean[n];

        visited[0] = true;
        visited[secondCity] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(secondCity);

        int num = 2;
        step--;
        while (step > 0 && !stack.isEmpty()) {

            int top = stack.peek();
            int nextCity = findNextCity(matrix, top, visited);
            if (nextCity != -1) {
                visited[nextCity] = true;
                num++;
                step--;
                stack.push(nextCity);
            } else {

                stack.pop();
                step--;

            }

        }

        return num;

    }

    /**
     * 从起始城市找下一个可以到达的城市
     *
     * @param matrix
     * @param start
     * @param visited
     * @return
     */
    private static int findNextCity(boolean[][] matrix, int start, boolean[] visited) {

        int next = -1;

        for (int i = 0; i < matrix.length; i++) {

            if (matrix[start][i] && !visited[i]) {
                next = i;
                break;
            }

        }

        return next;


    }

    /**
     * 从开始城市走step达到的最多城市
     *
     * @param step
     * @param startCity
     * @param matrix
     * @return
     */
    private static int visit(int step, int startCity, boolean[][] matrix) {

        if (step == 0)
            return 0;


        return 0;
    }


}

