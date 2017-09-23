package dji;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-09-23.
 */
public class Test4 {

    public static Map<Integer, Boolean> map = new HashMap<>();

    public static int[] ruanMonthDays = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static int[] notRuanMonthDays = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int day = scanner.nextInt();

            handle(year, month, day);

        }

    }

    private static void handle(int year, int month, int day) {


        //判断是否是闰年
        if (map.get(year) == null) {
            boolean isRun = isRuanYear(year);
            map.put(year, isRun);
        }

        boolean isRuan = map.get(year);

        if (isRuan) {
            System.out.println(isRuanDay(month, day));
        } else {
            System.out.println(isNotRuanDay(month, day));
        }

    }

    private static int isNotRuanDay(int month, int day) {

        int result = 0;
        for (int i = 1; i <= month - 1; i++) {
            result += notRuanMonthDays[i];
        }
        result += day;
        return result;

    }

    private static int isRuanDay(int month, int day) {

        int result = 0;
        for (int i = 1; i <= month - 1; i++) {
            result += ruanMonthDays[i];
        }
        result += day;
        return result;


    }

    /**
     * 判断年是否闰年
     *
     * @param year
     * @return
     */
    private static boolean isRuanYear(int year) {

        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return true;

        return false;

    }

}
