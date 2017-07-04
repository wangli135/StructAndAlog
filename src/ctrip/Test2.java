package ctrip;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-11.
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.split(",");
            int[] data = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                data[i] = Integer.parseInt(array[i]);
            }
            System.out.println(findOnlyOneElment(data));

        }
    }

    private static int findOnlyOneElment(int[] data) {

        //统计每个单词出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < data.length; i++) {
            if (map.get(data[i]) == null) {
                map.put(data[i], 1);
            } else {
                int num = map.get(data[i]);
                map.put(data[i], num + 1);
            }
        }

        int val = 0;
        //在遍历一次数组，查找出现次数为1的值
        for (int i = 0; i < data.length; i++) {
            if (map.get(data[i]) == 1) {
                val = data[i];
                break;
            }
        }

        return val;
    }
}
