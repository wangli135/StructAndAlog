package ali;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by wangl on 2017/8/10.
 */
public class Test4 {

    static Map<Character, Integer> map = new HashMap<>();

    char[] single = new char[]{'2', 'A', 'K', 'Q', 'J', 'I', '9', '8', '7', '6', '5', '4', '3'};

    public static void main(String[] args) {

        map.put('3', 0);
        map.put('4', 1);
        map.put('5', 2);
        map.put('6', 3);
        map.put('7', 4);
        map.put('8', 5);
        map.put('9', 6);
        map.put('I', 7);
        map.put('J', 8);
        map.put('Q', 9);
        map.put('K', 10);
        map.put('A', 11);
        map.put('2', 12);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String first = scanner.nextLine();
            String second = scanner.nextLine();

            System.out.println(handle(first, second));


        }

    }

    private static String handle(String first, String second) {

        if (second.length() == 1) {
            return single(first, second);
        } else if (second.length() == 2) {
            return pair(first, second);
        } else if (isBoom(second)) {
            return boom(first, second);
        } else if (isSequencePair(second)) {
            return sequencePair(first, second);
        } else {
            return sequence(first, second);
        }

    }

    /**
     * 判断是否是连对
     *
     * @param second
     * @return
     */
    private static boolean isSequencePair(String second) {

        int len = second.length();

        if (len % 2 == 1)
            return false;

        char[] data = second.toCharArray();

        //判断是否是对子
        for (int i = 0; i < data.length; i++, i++) {
            if (data[i] != data[i + 1])
                return false;
        }

        return true;

    }

    /**
     * 连对的情况
     *
     * @param first
     * @param second
     * @return
     */
    private static String sequencePair(String first, String second) {

        char[] data1 = first.toCharArray();
        char[] data2 = second.toCharArray();

        int index1 = 0;
        for (int i = 0; i < data1.length; i++) {


        }


        return "0";

    }

    private static String sequence(String first, String second) {

        int len = second.length();

        char[] data1 = first.toCharArray();
        char[] data2 = second.toCharArray();

        int d = 0;
        int index1 = 0;
        int index2 = 0;

        while (index1 < data1.length && index2 < data2.length) {

            d = data1[index1] - data2[index2];
            if (d > 0) {

                boolean right = true;
                for (int j = index1, i = index2; j < first.length() && i < second.length(); j++, i++) {
                    if (data1[j] - data2[i] != d) {
                        right = false;
                    }
                }

                if (right) {
                    return first.substring(index1, second.length());
                } else {
                    index1++;
                    index2 = 0;
                }


            } else {
                index1++;
                index2 = 0;
            }


        }

        for (int i = 0; i < first.length(); i++) {

            for (int j = 0; j < data2.length; j++) {


            }


        }


        return "0";
    }

    /**
     * 找大的炸弹
     *
     * @param first
     * @param second
     * @return
     */
    private static String boom(String first, String second) {

        char[] data1 = first.toCharArray();
        char[] data2 = second.toCharArray();

        char large = '0';
        int num = 0;
        boolean findFirst = false;
        for (int i = 0; i < data1.length; i++) {

            if (data1[i] > data2[0]) {
                if (!findFirst) {
                    large = data1[i];
                    findFirst = true;
                    num++;
                } else {
                    if (data1[i] == large) {
                        num++;
                        if (num == 4) {
                            return String.valueOf(new char[]{large, large, large, large});
                        }
                    } else {
                        findFirst = false;
                        large = data1[i];
                        num = 1;
                    }
                }
            }
        }

        return "0";


    }

    /**
     * 判断是否是炸弹
     *
     * @param second
     * @return
     */
    private static boolean isBoom(String second) {

        if (second.length() != 4)
            return false;

        char c = second.charAt(0);
        for (int i = 1; i < second.length(); i++) {
            if (second.charAt(i) != c)
                return false;
        }

        return true;


    }

    /**
     * 对子
     *
     * @param first
     * @param second
     * @return
     */
    private static String pair(String first, String second) {

        char[] data1 = first.toCharArray();
        char[] data2 = first.toCharArray();

        char large = '0';
        boolean findFirst = false;
        for (int i = 0; i < data1.length; i++) {

            if (map.get(data1[i]) > map.get(data2[0])) {
                if (!findFirst) {
                    large = data1[i];
                    findFirst = true;
                } else {
                    if (data1[i] == large) {
                        return String.valueOf(large);
                    } else {
                        findFirst = false;
                        large = data1[i];
                    }
                }
            }


        }

        return "0";

    }

    /**
     * 单牌
     *
     * @param first
     * @param second
     * @return
     */
    private static String single(String first, String second) {

        char[] data1 = first.toCharArray();
        char[] data2 = second.toCharArray();

        for (int i = 0; i < data1.length; i++) {
            if (map.get(data1[i]) > map.get(data2[0])) {
                return String.valueOf(data1[i]);
            }
        }

        return "0";

    }


}

