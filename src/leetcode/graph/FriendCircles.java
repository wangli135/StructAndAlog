package leetcode.graph;

/**
 * https://leetcode.com/problems/friend-circles/#/description
 * Created by wangl on 2017/7/21.
 */
public class FriendCircles {

    public int findCircleNum(int[][] M) {

        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, boolean[] visited, int i) {

        for (int j = 0; j < M.length; j++) {

            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(M, visited, j);
            }

        }

    }

    public static void main(String[] args) {

        int[][] M = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        new FriendCircles().findCircleNum(M);

    }


}
