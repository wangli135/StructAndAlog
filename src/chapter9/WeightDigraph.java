package chapter9;

/**
 * 有向有权图
 * Created by Xingfeng on 2016-11-21.
 */
public class WeightDigraph {

    private int[][] matrix;
    private int vertexCount;

    public WeightDigraph(int vertexCount) {
        this.vertexCount = vertexCount;
        matrix = new int[vertexCount][vertexCount];
    }

    /**
     * 在顶点i与j之间添加一条权重为weight的边
     *
     * @param i
     * @param j
     */
    public void addEdge(int i, int j, int weight) {

        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            matrix[i][j] = weight;
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
            matrix[i][j] = 0;
        }

    }

    /**
     * 判断顶点ij之间是否存在边
     *
     * @param i
     * @param j
     * @return
     */
    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j >= 0 && j < vertexCount) {
            return matrix[i][j] > 0;
        }

        return false;
    }

    public int getVertexCount() {
        return vertexCount;
    }

    public int[][] getMatrix() {
        return matrix;
    }

}
