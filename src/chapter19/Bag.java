package chapter19;

import java.util.Arrays;

/**
 * Created by Xingfeng on 2017-03-10.
 */
public class Bag {

    /**
     * 0-1背包问题
     * 用子问题定义状态：即f[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值。则其状态转移方程便是：
     * f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}
     * 这个方程非常重要，基本上所有跟背包相关的问题的方程都是由它衍生出来的。
     * 所以有必要将它详细解释一下：“将前i件物品放入容量为v的背包中”这个子问题，若只考虑第i件物品的策略（放或不放），
     * 那么就可以转化为一个只牵扯前i-1件物品的问题。如果不放第i件物品，那么问题就转化为“前i-1件物品放入容量为v的背包中”，
     * 价值为f[i-1][v]；如果放第i件物品，那么问题就转化为“前i-1件物品放入剩下的容量为v-c[i]的背包中”，
     * 此时能获得的最大价值就是f[i-1][v-c[i]]再加上通过放入第i件物品获得的价值w[i]。
     *
     * @param N      物品数量
     * @param V      背包容量
     * @param weight 重量数组
     * @param value  价值数组
     * @return
     */
    public int bag01(int N, int V, int[] weight, int[] value) {

        //dp[i][j]表示前i件物品重量为j时的价值
        int[][] dp = new int[N + 1][V + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = V; j >= weight[i]; j--) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }

        int max = 0;
        for (int i = 1; i < V + 1; i++)
            if (dp[N][i] > max)
                max = dp[N][i];

        for (int i = 0; i < dp.length; i++)
            System.out.println(Arrays.toString(dp[i]));

        return max;
    }

    /**
     * 0-1背包问题改进版
     * 时间复杂度O(NV)，空间复杂度O(V)
     * 过程ZeroOnePack，表示处理一件01背包中的物品，两个参数cost、weight分别表明这件物品的费用和价值。
     * procedure ZeroOnePack(cost,weight)
     * for v=V..cost
     * f[v]=max{f[v],f[v-cost]+weight}
     * 我们看到的求最优解的背包问题题目中，事实上有两种不太相同的问法。有的题目要求“恰好装满背包”时的最优解，有的题目则并没有要求必须把背包装满。一种区别这两种问法的实现方法是在初始化的时候有所不同。
     * 如果是第一种问法，要求恰好装满背包，那么在初始化时除了f[0]为0其它f[1..V]均设为-∞，这样就可以保证最终得到的f[N]是一种恰好装满背包的最优解。
     * 如果并没有要求必须把背包装满，而是只希望价格尽量大，初始化时应该将f[0..V]全部设为0。
     * 为什么呢？可以这样理解：初始化的f数组事实上就是在没有任何物品可以放入背包时的合法状态。如果要求背包恰好装满，那么此时只有容量为0的背包可能被价值为0的nothing“恰好装满”，其它容量的背包均没有合法的解，属于未定义的状态，它们的值就都应该是-∞了。如果背包并非必须被装满，那么任何容量的背包都有一个合法解“什么都不装”，这个解的价值为0，所以初始时状态的值也就全部为0了。
     * 这个小技巧完全可以推广到其它类型的背包问题，后面也就不再对进行状态转移之前的初始化进行讲解。
     *
     * @param V      背包容量
     * @param weight
     * @param value
     * @return
     */
    public int bag01Imporve(int V, int[] weight, int[] value) {

        int[] dp = new int[V + 1];//dp[v]表示容量为v情况下的最大价值
        for (int i = 0; i < weight.length; i++) {
            for (int v = V; v >= weight[i]; v--) {
                dp[v] = Math.max(dp[v], dp[v - weight[i]] + value[i]);
            }
        }

        return dp[V];
    }


    /**
     * 完全背包问题，每件商品的数量是无限的，并且可以放多次
     *
     * @param N
     * @param V
     * @param weight
     * @param value
     * @return
     */
    public int bagFull(int N, int V, int[] weight, int[] value) {

        int[] dp = new int[V + 1];

        for (int i = 0; i < weight.length; i++) {

            for (int j = weight[i]; j <= V; j++) {

                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);

            }

        }


        return dp[V];
    }

    public static void main(String[] args) {

        int[] weight = {2, 4, 7, 1, 9, 10};
        int[] value = {3, 4, 5, 6, 7, 8};
        Bag bag = new Bag();
        System.out.println(bag.bag01Imporve(12,weight, value));

    }

}
