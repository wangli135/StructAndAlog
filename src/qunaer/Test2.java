package qunaer;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-01.
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            handle(line);

        }
    }

    private static void handle(String line) {

        char[] value = line.toCharArray();

        long val = 0;
        int len = value.length;
        for (int i = len - 1; i >= 0; i--) {

            val += (value[i] - 'a') * Math.pow(26, len - 1 - i);

        }

        System.out.println(val);


    }
}
