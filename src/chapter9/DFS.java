package chapter9;

import java.util.Stack;

/**
 * 深度优先搜索
 * Created by Xingfeng on 2016-11-19.
 */
public class DFS {

    //顶点数组
    private Vertex[] vertexArray;
    //顶点数
    private int vertexCount;

    //邻接矩阵
    private int[][] matrix;

    //栈
    private Stack<Integer> stack;

    public DFS(int count) {

        vertexArray = new Vertex[count];
        matrix = new int[count][count];
        stack = new Stack<>();
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
    public void dfs() {

        //访问第1个顶点
        vertexArray[0].visited = true;
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {

            int nextVertex = getUnvisitedVertex(stack.peek());
            //没有后续可访问顶点
            if (nextVertex == -1) {
                stack.pop();
            } else {

                vertexArray[nextVertex].visited = true;
                displayVertex(nextVertex);
                stack.push(nextVertex);

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
        DFS dfs = new DFS(8);

        dfs.addVertex('A');
        dfs.addVertex('B');
        dfs.addVertex('C');
        dfs.addVertex('D');
        dfs.addVertex('H');
        dfs.addVertex('E');
        dfs.addVertex('F');
        dfs.addVertex('G');

        dfs.addEdge(0, 1); //A-B
        dfs.addEdge(1, 2); //B-C
        dfs.addEdge(2, 3); //C-D
        dfs.addEdge(1, 4); //B-H
        dfs.addEdge(2, 5); //C-E
        dfs.addEdge(4, 5); //H-E
        dfs.addEdge(5, 6); //E-F
        dfs.addEdge(5, 7); //E-G

        dfs.dfs();

    }


}
