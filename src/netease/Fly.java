package netease;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class Fly {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long h = sc.nextLong();

            double d = Math.sqrt((h + 4) / 4) - 0.5;
            long v = (long) d;
            while (v * v + v < h) {
                v++;
            }
            if (v * v + v > h) {
                v--;
            }
            System.out.println(v);


        }

    }

}
