package didi;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-22.
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            System.out.println(convert(line));

        }
    }

    private static String convert(String line) {

        String[] array = line.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(new StringBuilder(array[i]).reverse()).append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();

    }

}
