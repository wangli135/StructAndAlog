package chapter9;

/**
 * 邻接矩阵表示无向图
 * Created by Xingfeng on 2016-11-19.
 */
public class Graph {

    private boolean[][] matrix;
    private int vertexCount;

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        matrix = new boolean[vertexCount][vertexCount];
    }

    /**
     * 在顶点i与j之间添加一条边
     *
     * @param i
     * @param j
     */
    public void addEdge(int i, int j) {

        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            matrix[i][j] = true;
            matrix[j][i] = true;
        }
    }

    /**
     * 移除顶点i和j之间的边
     *
     * @param i
     * @param j
     */
    public void removeEdge(int i, int j) {

        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            matrix[i][j] = false;
            matrix[j][i] = false;
        }

    }

    /**
     * 判断顶点ij之间是否存在边
     * @param i
     * @param j
     * @return
     */
    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            return matrix[i][j];
        }

        return false;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public boolean[][] getMatrix() {
        return matrix;
    }
}
