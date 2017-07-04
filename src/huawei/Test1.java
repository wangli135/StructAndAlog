package huawei;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-24.
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String line = sc.nextLine();
            String[] array = line.split(",");
            int a = Integer.parseInt(array[0]);
            int b = Integer.parseInt(array[1]);

            if (a < 1 || a > 70000) {
                System.out.println("-1");
                break;
            }

            if (b < 1 || b > 70000) {
                System.out.println("-1");
                break;
            }

            a = Integer.parseInt(new StringBuilder(array[0]).reverse().toString());
            b = Integer.parseInt(new StringBuilder(array[1]).reverse().toString());

            int c = a + b;
            System.out.println(c);

        }
    }

}
