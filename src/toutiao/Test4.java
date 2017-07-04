package toutiao;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-30.
 */
public class Test4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Long> set = new HashSet<>();
        long value =0;
        while (scanner.hasNext()) {

            value = scanner.nextLong();
            if (value==0)
                break;
            else {
                set.add(value);
            }

        }

        System.out.println(set.size());
    }

}
