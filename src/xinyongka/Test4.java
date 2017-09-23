package xinyongka;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-09-19.
 */
public class Test4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.split(" ");

            int n = Integer.parseInt(array[0]);
            int x0 = Integer.parseInt(array[1]);

            int left = 0, right = 0;//表示重叠范围
            boolean canMove = true;

            for (int i = 0; i < n; i++) {

                line = scanner.nextLine();

                if (!canMove)
                    continue;

                array = line.split(" ");

                int val1 = Integer.parseInt(array[0]);
                int val2 = Integer.parseInt(array[1]);

                int min = Math.min(val1, val2);
                int max = Math.max(val1, val2);

                if (i == 0) {

                    left = min;
                    right = max;

                } else {

                    if (max < left || min > right) {
                        canMove = false;
                    }

                    //计算重叠部分

                    left = Math.max(left, min);
                    right = Math.min(right, max);

                }

            }

            if (!canMove) {
                System.out.println(-1);
            } else {
                int val = Math.min(Math.abs(left - x0), Math.abs(right - x0));
                System.out.println(val);
            }


        }


    }

}
