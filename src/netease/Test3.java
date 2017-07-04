package netease;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.split(" ");
            int n = Integer.parseInt(array[0]);
            long k = Long.parseLong(array[1]);

            int[] data = new int[n];
            int[] temp = new int[n];
            line = scanner.nextLine();
            array = line.split(" ");
            for (int i = 0; i < data.length; i++) {
                data[i] = Integer.parseInt(array[i]);
                temp[i] = data[i];
            }

            for (int i = 0; i < k; i++) {
                change(data, temp);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                sb.append(data[i] + " ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());


        }
    }

    //魔力作用
    private static void change(int[] data, int[] temp) {

        int n = data.length;
        //计算前n-1个数
        for (int i = 0; i < n - 1; i++) {
            int val = data[i] + data[i + 1];
            temp[i] = val;
        }
        //计算第n个数
        int val = data[n - 1] + data[0];
        temp[n - 1] = val;

        for (int i = 0; i < data.length; i++) {
            if (temp[i] >= 100)
                data[i] = temp[i] % 100;
            else
                data[i] = temp[i];
        }


    }
}
