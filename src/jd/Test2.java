package jd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-09-08.
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int lo = scanner.nextInt();
            int hi = scanner.nextInt();

            handle(lo, hi);


        }

    }

    private static void handle(int lo, int hi) {

        int num = 0;

        for (int i = lo; i <= hi; i++) {

            if (isMagic(i))
                num++;

        }

        System.out.println(num);


    }

    /**
     * 判断是不是神奇数
     *
     * @param i
     * @return
     */
    private static boolean isMagic(int i) {

        if (i < 11)
            return false;

        List<Integer> datas = new ArrayList<>();
        int sum = 0;
        while (i != 0) {

            int n = i % 10;
            datas.add(n);
            i = i / 10;
            sum += n;

        }

        if (sum % 2 == 1)
            return false;

        int avg = sum / 2;

        return findVal(datas, 0, avg);

    }

    private static boolean findVal(List<Integer> nums, int start, int target) {

        if (target == 0)
            return true;

        if (start == nums.size())
            return false;

        return findVal(nums, start + 1, target) || findVal(nums, start + 1, target - nums.get(start));


    }

}
