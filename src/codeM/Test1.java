package codeM;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-06-11.
 */
public class Test1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine().trim();
            int N = Integer.parseInt(line);

            //首先读前两个数字，比较
            int first = scanner.nextInt();
            int second = scanner.nextInt();

            if (first < second) {
                System.out.println("0");
                break;
            }

            int num = 1;//存活一次
            int[] data = new int[N / 2];
            int pos = 0;
            data[pos++] = first;

            for (int i = 0; i < N - 2; i++, i++) {

                first = scanner.nextInt();
                second = scanner.nextInt();
                if (first > second) {
                    data[pos++] = first;
                } else {
                    data[pos++] = second;
                }

            }

            //在data中继续遍历




        }

    }


}
