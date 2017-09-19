package dji;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-09-16.
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.split(" ");
            int n = Integer.parseInt(array[0]);
            int L = Integer.parseInt(array[1]);
            int m = Integer.parseInt(array[2]);

            //graph[i][j]表示点i与j之间的距离
            int[][] graph = new int[n + 1][n + 1];
            //things[i]表示点i有的东西数量
            int[] things = new int[m + 1];

            for (int i = 0; i < L; i++) {

                line = scanner.nextLine();
                array = line.split(" ");
                int start = Integer.parseInt(array[0]);
                int end = Integer.parseInt(array[1]);
                int distance = Integer.parseInt(array[2]);

                graph[start][end] = distance;
                graph[end][start] = distance;

            }

            for (int i = 0; i < m; i++) {

                line = scanner.nextLine();
                array = line.split(" ");
                int index = Integer.parseInt(array[0]);
                int pointId = Integer.parseInt(array[1]);

                things[pointId]++;

            }

            line = scanner.nextLine();
            array = line.split(" ");
            int x = Integer.parseInt(array[0]);
            int y = Integer.parseInt(array[1]);

            handle(graph, things, y, x);


        }


    }

    /**
     * @param graph  图
     * @param things 东西在点上面的个数
     * @param start  起始点
     * @param end    结束点
     */
    private static void handle(int[][] graph, int[] things, int start, int end) {

        //distance[i]表示从start起点到该点的最短距离
        int[] distance = new int[graph.length];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = -1;
        }

        //path[i]表示start到点最短路径的前一个点编号
        int[] path = new int[graph.length];

        distance[start] = 0;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);

        int v, w;

        while (!queue.isEmpty()) {

            //删除队列中最小的值
            int minIndex = 0;
            for (int i = 0; i < queue.size(); i++)
                if (distance[queue.get(i)] < distance[queue.get(minIndex)])
                    minIndex = i;

            v = queue.remove(minIndex);

            for (w = 0; w < graph.length; w++) {


                if (graph[v][w] > 0) {

                    int newDistance = distance[v] + graph[v][w];

                    if (distance[w] == -1) {
                        distance[w] = newDistance;
                        queue.add(w);
                        path[w] = v;
                    }

                    //距离变小了，需要进行更新
                    if (distance[w] > newDistance) {

                        distance[w] = newDistance;
                        path[w] = v;

                    }
                }

            }


        }


        int minShortestPath = distance[end];

        if (minShortestPath == -1) {
            System.out.println(-1);
            return;
        }

        int thingsNum = 0;
        int index = end;
        while (true) {

            thingsNum += things[index];
            if (index == start)
                break;
            index = path[index];

        }

        System.out.println(minShortestPath + " " + thingsNum);


    }


}
