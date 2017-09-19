package netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangl on 2017/8/12.
 */
public class Test7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            handle(line);

        }
    }

    private static void handle(String line) {

        //记录个数的列表
        List<Integer> numList = new ArrayList<>();
        char[] array = line.toCharArray();
        int num = 1;
        char prev = array[0];

        for (int i = 1; i < array.length; i++) {

            if (array[i] == prev) {
                num++;
            } else {

                numList.add(num);
                prev = array[i];
                num = 1;

            }

        }

        //添加最后一个
        numList.add(num);

        int size = numList.size();
        int sum = 0;
        for (int i = 0; i < numList.size(); i++) {
            sum += numList.get(i);
        }

        System.out.println(String.format("%.2f", sum * 1.0f / size));


    }


}

