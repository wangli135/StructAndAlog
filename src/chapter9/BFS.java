package chapter9;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 广度优先搜索
 * Created by Xingfeng on 2016-11-19.
 */
public class BFS {

    //顶点数组
    private Vertex[] vertexArray;
    //顶点数
    private int vertexCount;

    //邻接矩阵
    private int[][] matrix;

    //队列
    private LinkedList<Integer> queue;

    public BFS(int count) {

        vertexArray = new Vertex[count];
        matrix = new int[count][count];
        queue = new LinkedList<>();
    }

    /**
     * 添加顶点
     *
     * @param lab
     */
    public void addVertex(char lab) {

        Vertex vertex = new Vertex(lab);
        vertexArray[vertexCount++] = vertex;

    }

    /**
     * 在顶点i和j之间添加边
     *
     * @param i
     * @param j
     */
    public void addEdge(int i, int j) {

        matrix[i][j] = 1;
        matrix[j][i] = 1;

    }

    /**
     * 打印顶点
     *
     * @param index 顶点索引
     */
    public void displayVertex(int index) {

        System.out.println(vertexArray[index].label);

    }

    /**
     * 深度优先搜索
     */
    public void bfs() {

        //访问第1个顶点
        vertexArray[0].visited = true;
        displayVertex(0);
        queue.add(0);

        int nextVertex=0;
        while (!queue.isEmpty()) {

            int first =queue.remove();
            //将该顶点的未被访问过的子顶点均加入队列中
            while ((nextVertex=getUnvisitedVertex(first))!=-1){

                vertexArray[nextVertex].visited = true;
                displayVertex(nextVertex);
                queue.add(nextVertex);

            }
        }
    }

    /**
     * 以顶点i为起点寻找未被访问的下一个顶点的索引
     *
     * @param index
     * @return 没有返回-1；
     */
    private int getUnvisitedVertex(int index) {

        for (int i = index + 1; i < matrix.length; i++) {

            if (matrix[index][i] == 1 && !vertexArray[i].visited)
                return i;

        }

        return -1;

    }

    public static void main(String[] args) {

        //测试
        BFS bfs = new BFS(8);

        bfs.addVertex('A');
        bfs.addVertex('B');
        bfs.addVertex('C');
        bfs.addVertex('D');
        bfs.addVertex('H');
        bfs.addVertex('E');
        bfs.addVertex('F');
        bfs.addVertex('G');

        bfs.addEdge(0, 1); //A-B
        bfs.addEdge(1, 2); //B-C
        bfs.addEdge(2, 3); //C-D
        bfs.addEdge(1, 4); //B-H
        bfs.addEdge(2, 5); //C-E
        bfs.addEdge(4, 5); //H-E
        bfs.addEdge(5, 6); //E-F
        bfs.addEdge(5, 7); //E-G

        bfs.bfs();

    }


}
