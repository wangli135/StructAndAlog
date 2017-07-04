package leetcode.dp;

/**
 * Created by Xingfeng on 2017-03-29.
 */
public class CanIWin {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (maxChoosableInteger >= desiredTotal)
            return true;

        //dp[i]表示先手从i到desiredTotal中开始加数字是否会胜利
        boolean[] dp = new boolean[desiredTotal + 1];

        //初始化，小于maxChoosableInteger的都是先手会赢
        for (int i = 0; i <maxChoosableInteger; i++) {
            dp[desiredTotal - i] = true;
        }

        for (int N = desiredTotal - maxChoosableInteger; N >0; N--) {

            dp[N] = false;//默认为输
            for (int j = 1; j <= maxChoosableInteger; j++) {

                //后手为输，那么自己就为赢
                if (!dp[N + j]) {
                    dp[N] = true;
                    break;
                }

            }

        }

        return dp[desiredTotal];


    }

    public static void main(String[] args) {

        CanIWin canIWin = new CanIWin();
        System.out.println(canIWin.canIWin(10, 11));

    }
}
