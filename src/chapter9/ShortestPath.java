package chapter9;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 最短路径算法
 * Created by Xingfeng on 2016-11-21.
 */
public class ShortestPath {

    /**
     * 无权图的最短路径算法
     *
     * @param g
     * @param s
     */
    public void unweightedShortestPath(WeightDigraph g, int s) {

        LinkedList<Integer> queue = new LinkedList<>();

        int v, w;

        //s顶点到其他顶点的距离
        int[] distance = new int[g.getVertexCount()];
        //path[i]表示从s到i最短路径的前一个顶点
        int[] path = new int[g.getVertexCount()];

        //初始化距离为1
        for (int i = 0; i < g.getVertexCount(); i++)
            distance[i] = -1;
        distance[s] = 0; //s顶点到s顶点距离为0

        queue.add(s);

        while (!queue.isEmpty()) {

            v = queue.remove();

            //查找与v相邻的顶点
            for (w = 0; w < g.getVertexCount(); w++) {

                if (g.getMatrix()[v][w] > 0) {

                    distance[w] = distance[v] + 1;
                    path[w] = v;
                    //删除以w为终点的所有起点
                    for (int j = 0; j < g.getVertexCount(); j++)
                        g.removeEdge(j, w);
                    queue.add(w);

                }

            }

        }

        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(path));

    }

    /**
     * 有权图的最短路径
     * Dijkstra算法
     *
     * @param G
     * @param s
     */
    public void dijkstra(WeightDigraph G, int s) {

        LinkedList<Integer> queue = new LinkedList<>();

        int v, w;

        int[] distance = new int[G.getVertexCount()];
        int[] path = new int[G.getVertexCount()];

        for (int i = 0; i < distance.length; i++) {
            distance[i] = -1;
        }
        distance[0] = 0;

        queue.add(s);

        while (!queue.isEmpty()) {

            //删除队列中最小的值
            int minIndex = 0;
            for (int i = 0; i < queue.size(); i++)
                if (distance[queue.get(i)] < distance[queue.get(minIndex)])
                    minIndex = i;

            v = queue.remove(minIndex);

            for (w = 0; w < G.getVertexCount(); w++) {


                if (G.getMatrix()[v][w] > 0) {

                    int newDistance = distance[v] + G.getMatrix()[v][w];

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

        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(path));


    }

    public void bellmanFordAlgorithm(WeightDigraph G, int s) {

        LinkedList<Integer> queue = new LinkedList<>();

        int v, w;

        int[] distance = new int[G.getVertexCount()];
        int[] path = new int[G.getVertexCount()];

        distance[s] = 0;

        queue.add(s);

        while (!queue.isEmpty()) {

            v = queue.remove();

            for (w = 0; w < G.getVertexCount(); w++) {

                int newDistance = distance[v] + G.getMatrix()[v][w];

                if (distance[w] > newDistance) {

                    distance[w] = newDistance;
                    path[w] = v;

                    //检查w是否在队列中
                    if (!queue.contains(w))
                        queue.add(w);

                }


            }

        }

        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(path));


    }

    public static void main(String[] args) {

//        WeightDigraph weightDigraph = new WeightDigraph(7);
//
//        weightDigraph.addEdge(0, 1, 1); //A->B
//        weightDigraph.addEdge(0, 3, 1); //A->D
//        weightDigraph.addEdge(1, 3, 1); //B->D
//        weightDigraph.addEdge(1, 4, 1); //B->E
//        weightDigraph.addEdge(2, 0, 1); //C->A
//        weightDigraph.addEdge(2, 5, 1); //C->F
//        weightDigraph.addEdge(3, 5, 1); //D->F
//        weightDigraph.addEdge(3, 6, 1); //D->G
//        weightDigraph.addEdge(4, 6, 1); //E->G
//        weightDigraph.addEdge(6, 5, 1); //G->F

        WeightDigraph weightDigraph = new WeightDigraph(5);

        weightDigraph.addEdge(0, 1, 4); //A->B->4
        weightDigraph.addEdge(0, 2, 1); //A->C->1
        weightDigraph.addEdge(1, 4, 4); //B->E->4
        weightDigraph.addEdge(2, 1, 2); //C->B->2
        weightDigraph.addEdge(2, 3, 4); //C->D->4
        weightDigraph.addEdge(3, 4, 4); //D->E->4

        ShortestPath shortestPath = new ShortestPath();
        shortestPath.dijkstra(weightDigraph, 0);


    }

}
