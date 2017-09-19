package sogou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-09-08.
 */
public class Test1 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//
//            int n = scanner.nextInt();
//            double[] array = new double[n];
//            for (int i = 0; i < n; i++) {
//                array[i] = scanner.nextDouble();
//            }
//            handle2(array);
//
//        }


        String line = reader.readLine();
        int n = Integer.parseInt(line);
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            line = reader.readLine();
            array[i] = Double.parseDouble(line);
        }
        handle2(array);

    }

    private static void handle(double[] array) {

        double max = 0.0;

        for (int i = 0; i < array.length; i++) {

            double d = array[i];
            double w = findNearest(array, d);

            double dt = Math.abs(w - d);
            if (dt > 180)
                dt = 360 - dt;

            if (dt > max)
                max = dt;

        }

        System.out.println(String.format("%.8f", max));


    }

    /**
     * 找到该点对面和他相距最接近的数
     *
     * @param array
     * @param d
     * @return
     */
    private static double findNearest(double[] array, double d) {

        double target = 0;
        if (d < 180)
            target = d + 180;
        else
            target = d - 180;

        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {

            if (lo == hi)
                return array[lo];

            int mid = (lo + hi) >> 1;
            double midVal = array[mid];
            if (midVal == target) {
                return target;
            } else if (midVal < target) {

                //判断后一个数是否大于target
                if (mid + 1 <= hi && array[mid + 1] > target) {

                    double dt = Math.abs(array[mid + 1] - target) - Math.abs(array[mid] - target);
                    if (dt > 0) {
                        return array[mid];
                    } else {
                        return array[mid + 1];
                    }

                } else {
                    lo = mid + 1;
                }


            } else {

                //判断前一个数是否小于target
                if (mid - 1 >= lo && array[mid - 1] < target) {

                    double dt = Math.abs(array[mid - 1] - target) - Math.abs(array[mid] - target);
                    if (dt > 0) {
                        return array[mid];
                    } else {
                        return array[mid - 1];
                    }

                } else {
                    hi = mid - 1;
                }

            }


        }


        return 0;
    }

    private static void handle2(double[] array) {

        double max = 0.0;

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array.length; j++) {

                double dt = Math.abs(array[i] - array[j]);
                if (dt > 180)
                    dt = 360 - dt;

                if (dt > max)
                    max = dt;


            }

        }

        System.out.println(String.format("%.8f", max));


    }
}
