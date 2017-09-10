package leetcode.dp;

import java.util.Arrays;

/**
 * Created by wangl on 2017/7/27.
 */
public class MaxLenOfPair {

    public int findLongestChain(int[][] pairs) {

//        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
//        int sum = 0, n = pairs.length, i = -1;
//        while (++i < n) {
//            sum++;
//            int curEnd = pairs[i][1];
//            while (i + 1 < n && pairs[i + 1][0] <= curEnd) i++;
//        }
//        return sum;

        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));

        int i, j, max = 0, n = pairs.length;
        int dp[] = new int[n];

        for (i = 0; i < n; i++) dp[i] = 1;

        for (i = 1; i < n; i++)
            for (j = 0; j < i; j++)
                if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;

        for (i = 0; i < n; i++) if (max < dp[i]) max = dp[i];

        return max;

    }

    public static void main(String[] args) {

        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        new MaxLenOfPair().findLongestChain(pairs);

    }


}
