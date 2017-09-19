package xinyongka;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-09-18.
 */
public class Test1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.split(" ");
            int[] vote = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                vote[i] = Integer.parseInt(array[i]);
            }

            line = scanner.nextLine();
            array = line.split(" ");
            int[] weight = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                weight[i] = Integer.parseInt(array[i]);
            }

            handle(vote, weight);


        }

    }

    private static void handle(int[] vote, int[] weight) {

        //键为Id，值为权值
        Map<Integer, Integer> weightMap = new HashMap<>();
        //键为Id，值为投票人数
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < vote.length; i++) {

            int id = vote[i];
            int num = weight[i];

            if (weightMap.get(id) == null) {
                weightMap.put(id, num);
                numMap.put(id, 1);
            } else {
                int val = weightMap.get(id);
                val += num;
                weightMap.put(id, val);

                val = numMap.get(id);
                val++;
                numMap.put(id, val);

            }

        }

        int max = Integer.MIN_VALUE;
        int appear = 0;
        int finalId = 0;
        for (Integer id : weightMap.keySet()) {

            int val = weightMap.get(id);
            if (val > max) {
                finalId = id;
                max = val;
                appear = numMap.get(id);
            } else if (val == max) {
                int newAppear = numMap.get(id);
                if (newAppear > appear) {
                    appear = newAppear;
                    finalId = id;
                }
            }

        }

        System.out.println(finalId);


    }

}
