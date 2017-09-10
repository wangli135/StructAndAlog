package lianjia;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangl on 2017/8/21.
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            int[] mathIQs = new int[n];
            int sumOfMath = 0;
            for (int i = 0; i < mathIQs.length; i++) {
                mathIQs[i] = scanner.nextInt();
                sumOfMath += mathIQs[i];
            }

            int m = scanner.nextInt();
            int[] csIQs = new int[n];
            int sumOfCs = 0;
            for (int i = 0; i < csIQs.length; i++) {
                csIQs[i] = scanner.nextInt();
                sumOfCs += csIQs[i];
            }

            System.out.println(handle(mathIQs, sumOfMath, csIQs, sumOfCs));

        }

    }

    /**
     * 求交换个数
     *
     * @param mathIQs
     * @param csIQs
     * @return
     */
    private static int handle(int[] mathIQs, int sumOfMath, int[] csIQs, int sumOfCs) {

        Arrays.sort(csIQs);

        boolean[] used = new boolean[csIQs.length];

        int num = 0;

        float avgOfMath = 0.0f;
        float avgOfCS = 0.0f;

        int lenOfMath = mathIQs.length;
        int lenOfCS = csIQs.length;

        while (true) {

            avgOfMath = sumOfMath * 1.0f / lenOfMath;
            avgOfCS = sumOfCs * 1.0f / lenOfCS;

            //在CS中寻找第一个x，满足avgOfMath<x<avgOfCS

            int index = -1;
            for (int i = 0; i < csIQs.length; i++) {
                if (csIQs[i] > avgOfMath && csIQs[i] < avgOfCS && !used[i]) {
                    used[i] = true;
                    index = i;
                    num++;
                    break;
                }
            }

            if (index == -1) {
                break;
            } else {

                sumOfMath += csIQs[index];
                sumOfCs -= csIQs[index];
                lenOfMath++;
                lenOfCS--;

            }


        }


        return num;


    }

}
