package netease;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class Meal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        HashSet<String> set = new HashSet<>();
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.split(" ");
            for (String s : array)
                set.add(s);

        }
        System.out.println(set.size());

    }

}
