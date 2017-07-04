package chapter19;

/**
 * 背包问题
 * Created by Xingfeng on 2016-11-18.
 */
public class Dp {

    /**
     * 0-1背包 每件商品只有一件，放或不放
     */

    /**
     * 01背包问题
     * 时间复杂度O(VN)，空间复杂度O(VN)
     * dp[i][v]表示前i件物品在容量v的情况下最大价值
     *
     * @param V      背包总容量
     * @param N      物品总个数
     * @param weight 物品体积大小数组
     * @param price  物品价格数组
     * @return
     */
    public int bag01(int V, int N, int[] weight, int[] price) {

        int[][] dp = new int[N][V + 1];

        for (int i = 1; i < N; i++) {

            for (int j = 1; j <= V; j++) {

                //容量不足以放下第i件物品
                if (j < weight[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + price[i]);

            }

        }


        return dp[N - 1][V];

    }

    /**
     * 0-1背包改进版
     * 时间复杂度O(VN)，空间复杂度O(N)
     * dp[v]表示外循环i情况下容量v下面的最优解
     *
     * @param V
     * @param N
     * @param weight
     * @param price
     * @return
     */
    public int bag01Improve(int V, int N, int[] weight, int[] price) {

        int[] dp = new int[V + 1];

        for (int i = 1; i < N; i++) {

            for (int j = V; j >= 0; j--) {

                if (j >= weight[i])
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);

            }

        }

        return dp[V];

    }

    /**
     * 0-1背包改进版，要求背包必须装满
     *
     * @param V
     * @param N
     * @param weight
     * @param price
     * @return
     */
    public int bag01Change(int V, int N, int[] weight, int[] price) {

        int[] dp = new int[V + 1];

        //初始化dp
        for (int i = 1; i < dp.length; i++)
            dp[i] = Integer.MIN_VALUE;

        for (int i = 1; i < N; i++) {

            for (int j = V; j >= 0; j--) {

                if (j >= weight[i])
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);

            }

        }

        return dp[V];

    }

    /**
     * 完全背包，每种物品有无数件
     */

    /**
     * 完全背包问题
     * 时间复杂度
     * dp[v]表示容量v下的最优值
     * 循环i表示前i件商品中的最优值
     *
     * @param V
     * @param N
     * @param weight
     * @param price
     * @return
     */
    public int fullBag(int V, int N, int[] weight, int[] price) {

        int[] dp = new int[V + 1];

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= V; j++)
                if (j >= weight[i])
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);

        }

        return dp[V];

    }

    /**
     * 找零问题
     */

    /**
     * 时间复杂度O(nC)，空间复杂度O(C)
     * dp[i]表示兑换金额i所需要的最少硬币数
     *
     * @param C     找零金额
     * @param array 金额数组
     * @return
     */
    public int coins(int C, int[] array) {

        if (C < 0)
            return -1;

        int[] dp = new int[C + 1];
        for (int i = 1; i <= C; i++) {
            for (int j = 0; j < array.length; j++)
                if (i >= array[j])
                    dp[i] = Math.min(dp[i - 1], dp[i - array[j]]) + 1;

        }

        return dp[C];

    }


    public static void main(String[] args) {


        String[] array = {"G", "E", "E", "K", "S", "F", "O", "R", "G", "E", "E", "K", "S"};

        Dp dp = new Dp();
        System.out.println(dp.longestPalidromeDp("abacd"));


    }

    /**
     * 最长递增子序列
     */

    /**
     * dp[i]表示
     * 时间复杂度O(n^2)，空间复杂度O(n)
     *
     * @param array
     * @return
     */
    public int maxIncreaseSequence(int[] array) {

        int[] dp = new int[array.length];

        for (int i = 0; i < dp.length; i++)
            dp[i] = 1;

        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < i; j++) {

                if (array[i] > array[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;

            }

        }

        int max = 0;

        for (int i = 0; i < dp.length; i++)
            if (max < dp[i])
                max = dp[i];

        return max;
    }

    /**
     * 最大回文子序列
     */

    /**
     * dp[i][j]表示字符串数组中以i为开始，以j为结束的最大回文子序列的值
     *
     * @param array 输入数组，每个元素为一个字符
     * @return
     */
    public int maxPalindromSubsequence(String[] array) {

        int[][] dp = new int[array.length][array.length];

        //长度为1的字符串数组的最大回文子序列为1
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        int temp = 0;
        //外循环是长度，初始化解决了长度是1的情况
        for (int len = 1; len < array.length; len++) {

            temp = 0;
            //考虑所有连续的长度为i+1的字串
            for (int j = 0; len + j < array.length; j++) {

                //首尾相同
                if (array[len].equals(array[j + len]))
                    temp = dp[j + 1][j + len - 1] + 2;
                    //首尾不同
                else
                    temp = Math.max(dp[j][j + len - 1], dp[j + 1][j + len]);

                dp[j][j + len] = temp;
            }

        }

        return dp[0][array.length - 1];
    }

    /**
     * 最大回文子序列 递归方式
     *
     * @param array 数组
     * @param start 起始，包含
     * @param end   结束，包含
     * @return
     */
    public int maxPalindromSubsequenceRecursive(String[] array, int start, int end) {

        if (start > end)
            return 0;

        if (start == end)
            return 1;

        if (array[start].equals(array[end]))
            return 2 + maxPalindromSubsequenceRecursive(array, start + 1, end - 1);

        return Math.max(maxPalindromSubsequenceRecursive(array, start, end - 1), maxPalindromSubsequenceRecursive(array, start + 1, end));

    }

    /**
     * 最长回文子串
     */

    /**
     * 最长回文子串 动态规划
     * dp[i][j]为1时表示字符i到字符j是一个回文子串，为0表示不是一个回文子串
     * dp[i][j]=dp[i+1]dp[j-1](如果Si=Sj)
     * dp[i][i]=1 dp[i][i+1]=1（如果Si=Si+1）
     *
     * @param s
     * @return
     */
    public int longestPalidromeDp(String s) {

        int longestBegin = 0, maxLen = 1;

        boolean[][] dp = new boolean[s.length()][s.length()];

        //初始化dp[i][i]=true
        for (int i = 0; i < dp.length; i++)
            dp[i][i] = true;

        //初始化dp[i][i+1]
        for (int i = 0; i < dp.length - 1; i++) {

            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                longestBegin = i;
                maxLen = 2;
            }

        }

        //求解,从长度为3的开始，前面两个初始化已经解决了长度为2的情况
        //外部循环每次得到长度为len的最长回文子串
        for (int len = 3; len <= dp.length; len++) {

            //内循环从0开始取长度为Len的子串进行判定
            for (int j = 0; j + len <= dp.length; j++) {

                int t = len + j - 1;

                if (s.charAt(j) == s.charAt(t) && dp[j + 1][t - 1]) {
                    dp[j][t] = true;
                    longestBegin = j;
                    maxLen = len;
                }

            }

        }

        return maxLen;

    }


}
