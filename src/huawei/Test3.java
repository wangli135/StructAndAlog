package huawei;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Xingfeng on 2017-03-24.
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int[][] matrix = new int[][]{

                    {0, 2, 10, 5, 3, 1000},
                    {1000, 0, 12, 1000, 1000, 10},
                    {1000, 1000, 0, 1000, 7, 1000},
                    {2, 1000, 1000, 0, 2, 1000},
                    {4, 1000, 1000, 1, 0, 1000},
                    {3, 1000, 1, 1000, 2, 0}

            };

            int X = sc.nextInt();//出差城市
            int Y = sc.nextInt();//起雾城市

            //终点城市起雾或起点城市起雾，无解
            if (Y == X || Y == 5) {
                System.out.println(1000);
                System.out.println("[]");
                continue;
            }

            int[] distance = new int[7]; //distance[i]表示城市i到城市5的最短距离
            int[] prev = new int[7];//prev[i]表示城市i最短路径的前一个城市
            boolean[] visited = new boolean[7];
            for (int i = 0; i < distance.length; i++)
                distance[i] = -1;
            distance[5] = 0;
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(5);
            visited[5] = true;
            boolean[] next = new boolean[7];
            while (!queue.isEmpty()) {

                int min = Integer.MAX_VALUE;
                int minIndex = -1;
                for (int i = 0; i < queue.size(); i++) {
                    if (distance[queue.get(i)] < min) {
                        min = distance[queue.get(i)];
                        minIndex = i;
                    }
                }

                int minValue = queue.remove(minIndex);
                int[] array = matrix[minValue - 1];
                for (int i = 0; i < array.length; i++) {

                    if (i == Y - 1 || i == 4 || array[i] == 1000 || array[i] == 0) {
                        continue;
                    }

                    int city = i + 1;
                    //该城市还没有访问过
                    if (distance[city] == -1) {
                        distance[city] = distance[minValue] + matrix[minValue - 1][city - 1];
                        prev[city] = minValue;
                        queue.add(city);
                        visited[city] = true;

                        if (minValue == 5) {
                            next[city] = true;
                        }

                    } else if (!visited[city] && !next[city] && distance[city] < matrix[minValue - 1][city - 1] + distance[minValue]) {
                        distance[city] = matrix[minValue - 1][city - 1] + distance[minValue];
                        prev[city] = minValue;
                    }

                }

            }

            System.out.println(distance[X]);
            Stack<Integer> stack = new Stack<>();
            int index = X;
            while (index != 5) {
                stack.push(index);
                index = prev[index];
            }
            stack.push(index);
            StringBuilder sb = new StringBuilder("[");
            while (!stack.isEmpty()) {
                sb.append(stack.pop() + ",");
            }
            sb.deleteCharAt(sb.length() - 1).append("]");
            System.out.println(sb.toString());


        }
    }

}
