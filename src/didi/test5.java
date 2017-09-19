package didi;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-09-10.
 */
public class test5 {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        int A = scanner.nextInt();
//        int B = scanner.nextInt();

        System.out.println(minTransformNum(9, 20));

    }

    /**
     * 将origin转换为target的最小次数
     *
     * @param origin
     * @param target
     * @return
     */
    private static int minTransformNum(int origin, int target) {

        if (origin == target) {
            return 0;
        }

        if (target / origin < 2) {
            return (target - origin) / 2;
        }

        //加1的结果
        int numOfAdd2 = 1 + minTransformNum(origin + 2, target);
        int numOfMutil2 = 1 + minTransformNum(origin * 2, target);

        if (numOfAdd2 > numOfMutil2)
            return numOfMutil2;
        else
            return numOfAdd2;
    }


}
