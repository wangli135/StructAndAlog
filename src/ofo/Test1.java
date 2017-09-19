package ofo;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-09-14.
 */
public class Test1 {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//
//            String line = scanner.nextLine().trim();
//
//            int n = Integer.parseInt(line);
//
//            System.out.println(reverse(n));
//
//
//        }

//        System.out.println(isModBy7("1280679"));

        System.out.println(canIWin(new HashMap<>(),new int[]{0, 1, 1}));


    }

    /**
     * 将值反转
     *
     * @param n
     * @return
     */
    private static int reverse(int n) {

        StringBuilder sb = new StringBuilder(n + "");

        String result = "";

        if (n < 0) {

            sb.deleteCharAt(0);
            result = "-" + sb.reverse();
            if (Long.parseLong(result) < Integer.MIN_VALUE) {
                result = "0";
            }

        } else {

            result = sb.reverse().toString();
            if (Long.parseLong(result) > Integer.MAX_VALUE) {
                result = "0";
            }


        }

        return Integer.parseInt(result);


    }


    public static int handle(int[] array) {

        int num = 0;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {

                if (i == j)
                    continue;

                if (isModBy7(array[i] + array[j] + ""))
                    num++;


            }

        }

        return num;


    }

    public static boolean isModBy7(String val) {

        if (val.length() < 7)
            return Integer.parseInt(val) % 7 == 0;

        String last = val.substring(val.length() - 3);
        String first = val.substring(0, val.length() - 3);
        return isModBy7((Long.parseLong(first) - Integer.parseInt(last)) + "");


    }

    /**
     * 先手是否能赢
     *
     * @param array
     * @return
     */
    public static boolean canIWin(int[] array) {


        boolean needPlay = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                needPlay = true;
                break;
            }
        }

        //不能赢
        if (!needPlay) {
            return false;
        }

        boolean canIWin = false;

        for (int i = 0; i < array.length; i++) {

            if (array[i] == 1) {

                //更改状态
                for (int j = i; j < array.length; j++) {

                    array[j] = 1 - array[j];

                }

                //别人不能赢
                boolean canOtherWin = canIWin(array);

                if (!canOtherWin) {
                    canIWin = true;
                    break;
                }

                //从新更回状态
                for (int j = i; j < array.length; j++) {

                    array[j] = 1 - array[j];

                }


            }

        }

        return canIWin;


    }

    /**
     * 先手是否能赢
     *
     * @param array
     * @return
     */
    public static boolean canIWin(Map<String, Boolean> map, int[] array) {

        String key = Arrays.toString(array);
        if (map.get(key) == null) {

            boolean canWin = false;

            for (int i = 0; i < array.length; i++) {

                if (array[i] == 1) {

                    //更改状态
                    for (int j = i; j < array.length; j++) {

                        array[j] = 1 - array[j];

                    }

                    //别人不能赢
                    boolean canOtherWin = canIWin(array);

                    if (!canOtherWin) {
                        canWin = true;
                        break;
                    }

                    //从新更回状态
                    for (int j = i; j < array.length; j++) {

                        array[j] = 1 - array[j];

                    }


                }

            }

            map.put(key, canWin);


        }

        return map.get(key);


    }

}
