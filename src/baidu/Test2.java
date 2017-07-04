package baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-27.
 */
public class Test2 {

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Pair> map = new HashMap<>();
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl;";
        String s3 = "zxcvbnm,./";

        char[] data = s1.toCharArray();
        for (int i = 0; i < data.length; i++) {
            map.put(data[i], new Pair(i, 2));
        }
        data = s2.toCharArray();
        for (int i = 0; i < data.length; i++) {
            map.put(data[i], new Pair(i, 1));
        }
        data = s3.toCharArray();
        for (int i = 0; i < data.length; i++) {
            map.put(data[i], new Pair(i, 0));
        }


        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            data = line.toCharArray();
            double distance = 0.0f;
            char prev = data[0];
            Pair prevPair = map.get(prev);
            for (int i = 1; i < data.length; i++) {

                char temp = data[i];
                if (temp != prev) {
                    Pair currPair = map.get(temp);
                    int dx = currPair.x - prevPair.x;
                    int dy = currPair.y - prevPair.y;
                    distance += Math.sqrt(dx * dx + dy * dy);
                    prevPair = currPair;
                    prev=temp;
                }

            }

            System.out.println(String.format("%.5f", distance));


        }
    }

}
