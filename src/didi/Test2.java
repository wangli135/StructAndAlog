package didi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-22.
 */
public class Test2 {

    static class Toy {
        int width;
        int height;

        public Toy(int width, int height) {
            this.width = width;
            this.height = height;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            Toy[] toys = new Toy[n];
            Toy toy = null;
            int width = 0, height = 0;
            for (int i = 0; i < n; i++) {
                width = scanner.nextInt();
                height = scanner.nextInt();
                toy = new Toy(width, height);
                toys[i] = toy;
            }

            //对toy进行排序
            Arrays.sort(toys, new Comparator<Toy>() {
                @Override
                public int compare(Toy o1, Toy o2) {

                    //先比较宽度
                    if (o1.width < o2.width) {
                        return -1;
                    } else if (o1.width == o2.width) {
                        return o1.height < o2.height ? -1 : o1.height == o2.height ? 0 : 1;
                    } else {
                        return 1;
                    }
                }
            });


            System.out.println(handle(toys));

        }
    }

    private static int handle(Toy[] toys) {
        int n = toys.length;
        //dp[i]表示以i个套娃为终点最多嵌套的个数
        //dp[i]=1,如果i-1不能套进i中；
        //dp[i]=dp[i-1]+1,如果i-1能套进i中
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {

            //到前面找出一个能套进的最大索引值
            int index = -1;
            Toy current = toys[i];
            for (int j = i - 1; j >= 0; j--) {
                Toy prev = toys[j];
                //往前找第一个能套进的娃娃
                if (current.width > prev.width && current.height > prev.height) {
                    index = j;
                    break;
                }

            }

            if (index == -1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[index] + 1;
                if (dp[i] > max) {
                    max = dp[i];
                }
            }


        }

        return max;
    }

}
