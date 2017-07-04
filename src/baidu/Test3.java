package baidu;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-27.
 */
public class Test3 {

    static class Pair {
        int t;
        int v;

        public Pair(int t, int v) {
            this.t = t;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int N = Integer.parseInt(scanner.nextLine().trim());
            Pair[] datas = new Pair[N];
            Pair pair = null;
            String line = "";
            String[] array = null;
            for (int i = 0; i < N; i++) {

                line = scanner.nextLine();
                array = line.split(" ");
                int t = Integer.parseInt(array[0]);
                int v = Integer.parseInt(array[1]);

                pair = new Pair(t, v);
                datas[i] = pair;
            }

            int C = Integer.parseInt(scanner.nextLine().trim());
            for (int i = 0; i < C; i++) {

                line = scanner.nextLine();
                array = line.split(" ");
                if (array[0].equals("gt")) {

                    if (array[1].equals("min")) {
                        gtMin(datas, Integer.parseInt(array[2]));
                    } else if (array[1].equals("max")) {
                        gtMax(datas, Integer.parseInt(array[2]));
                    } else {
                        gtAvg(datas, Integer.parseInt(array[2]));
                    }

                } else {

                    if (array[1].equals("min")) {
                        ltMin(datas, Integer.parseInt(array[2]));
                    } else if (array[1].equals("max")) {
                        ltMax(datas, Integer.parseInt(array[2]));
                    } else {
                        ltAvg(datas, Integer.parseInt(array[2]));
                    }

                }

            }


        }
    }

    private static void gtMin(Pair[] datas, int period) {

        int num = 0;

        for (int i = 0; i < datas.length; i++) {

            Pair cur = datas[i];
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {

                Pair prev = datas[j];
                if (prev.t < cur.t - period) {
                    break;
                } else {
                    if (prev.v < min) {
                        min = prev.v;
                    }
                }

            }

            if (min!=Integer.MAX_VALUE&&cur.v > min) {
                num++;
            }

        }


        System.out.println(num);


    }

    private static void gtMax(Pair[] datas, int period) {

        int num = 0;

        for (int i = 0; i < datas.length; i++) {

            Pair cur = datas[i];
            int max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {

                Pair prev = datas[j];
                if (prev.t < cur.t - period) {
                    break;
                } else {
                    if (prev.v > max) {
                        max = prev.v;
                    }
                }

            }

            if (max!=Integer.MIN_VALUE&&cur.v > max) {
                num++;
            }

        }


        System.out.println(num);

    }

    private static void gtAvg(Pair[] datas, int period) {

        int num = 0;

        for (int i = 0; i < datas.length; i++) {

            Pair cur = datas[i];
            int sum = 0;
            int t = 0;
            for (int j = i - 1; j >=0; j--) {

                Pair prev = datas[j];
                sum += prev.v;
                t++;

            }

            if (t != 0 && cur.v > sum / t)
                num++;


        }


        System.out.println(num);

    }

    private static void ltMin(Pair[] datas, int period) {

        int num = 0;

        for (int i = 0; i < datas.length; i++) {


            Pair cur = datas[i];
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {

                Pair prev = datas[j];
                if (prev.t < cur.t - period) {
                    break;
                } else {
                    if (prev.v < min) {
                        min = prev.v;
                    }
                }

            }

            if (min != Integer.MAX_VALUE && cur.v < min) {
                num++;
            }

        }


        System.out.println(num);


    }

    private static void ltMax(Pair[] datas, int period) {

        int num = 0;

        for (int i = 0; i < datas.length; i++) {

            Pair cur = datas[i];
            int max = Integer.MIN_VALUE;
            for (int j = i - 1; j >= 0; j--) {

                Pair prev = datas[j];
                if (prev.t < cur.t - period) {
                    break;
                } else {
                    if (prev.v > max) {
                        max = prev.v;
                    }
                }

            }

            if (max!=Integer.MAX_VALUE&&cur.v < max) {
                num++;
            }

        }



        System.out.println(num);

    }

    private static void ltAvg(Pair[] datas, int period) {

        int num = 0;

        for (int i = 0; i < datas.length; i++) {

            Pair cur = datas[i];
            int sum = 0;
            int t = 0;
            for (int j = i - 1; j >= 0; j--) {

                Pair prev = datas[j];
                sum += prev.v;
                t++;

            }

            if (t != 0 && cur.v < sum / t)
                num++;


        }


        System.out.println(num);

    }

}
