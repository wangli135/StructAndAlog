package perfect;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-29.
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            System.out.println("-1");

            String line = scanner.nextLine();
            String[] array = line.split(",");
            int[] values = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                values[i] = Integer.parseInt(array[i]);
            }
            int gift = Integer.parseInt(scanner.nextLine().trim());

            //dp[i]表示兑换价值为i的最少水果数，如果不存在，则用-1表示
            int[] dp = new int[gift + 1];
            //初始化
            dp[0] = 0;
            for (int i = 1; i < dp.length; i++) {

                int minValue = Integer.MAX_VALUE;
                boolean find = false;
                for (int j = 0; j < values.length; j++) {

                    if (i >= values[j]) {

                        int prev = dp[i - values[j]];
                        if (prev != -1) {
                            if (prev + 1 < minValue) {
                                minValue = prev + 1;
                                find = true;
                            }
                        }
                    }
                }

                //没有找到
                if (!find) {
                    dp[i] = -1;
                } else {
                    dp[i] = minValue;
                }

            }
//            System.out.println("-1");


            System.out.println(dp[gift]);


        }
    }

}
