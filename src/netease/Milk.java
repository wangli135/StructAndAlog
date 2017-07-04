package netease;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class Milk {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int k = sc.nextInt();
            int sum = 0;
            int[] data = new int[k];
            for (int i = 0; i < data.length; i++) {
                data[i] = sc.nextInt();
                sum += data[i];
            }

            if (sum % k != 0) {
                System.out.println("-1");
                continue;
            }

            int avg = sum / k;
            sum = 0;
            for (int i = 0; i < data.length; i++) {

                int e = Math.abs(data[i] - avg);
                if (e % 2 != 0) {
                    System.out.println("-1");
                    return;
                }

                sum += e / 2;

            }

            System.out.println(sum / 2);


        }

    }

}
