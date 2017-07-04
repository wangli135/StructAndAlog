package chapter9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.jar.Pack200;

/**
 * Prim算法实现最小生成树算法
 * Created by Xingfeng on 2016-11-21.
 */
public class Prim {

    /**
     * prim算法实现最小生成树算法
     *
     * @param G
     * @param s
     */
    public void prims(WeightDigraph G, int s) {

        LinkedList<Integer> queue = new LinkedList<>();

        int v, w;

        int[] distance = new int[G.getVertexCount()];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = -1;
        }
        int[] path = new int[G.getVertexCount()];
        distance[s] = 0;

        queue.add(s);

        while (!queue.isEmpty()) {

            //删除队列中最小值
            int minIndex = 0;
            for (int i = 0; i < queue.size(); i++) {
                if (distance[queue.get(i)] < distance[queue.get(minIndex)])
                    minIndex = i;
            }
            v = queue.remove(minIndex);

            for (w = 0; w < G.getVertexCount(); w++) {

                //如果v和w之间有边
                if (G.getMatrix()[v][w] > 0) {

                    int newDistance = distance[v] + G.getMatrix()[v][w];


                    //w未被访问过
                    if (distance[w] == -1) {
                        distance[w] = newDistance;
                        path[w] = v;
                        queue.add(w);
                    }
                    //更新操作
                    else if (distance[w] > newDistance) {

                        distance[w] = newDistance;
                        path[w] = v;

                    }

                }


            }


        }


        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(path));

    }

    public static void main(String[] args) {

        WeightDigraph weightDigraph = new WeightDigraph(5);

        weightDigraph.addEdge(0, 1, 4); //A->B->4
        weightDigraph.addEdge(0, 2, 1); //A->C->1
        weightDigraph.addEdge(1, 4, 4); //B->E->4
        weightDigraph.addEdge(2, 1, 2); //C->B->2
        weightDigraph.addEdge(2, 3, 4); //C->D->4
        weightDigraph.addEdge(3, 4, 4); //D->E->4

        Prim prim = new Prim();
        prim.prims(weightDigraph, 0);
    }

}
