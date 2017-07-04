package qihu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class Test3 {

    static class Period {
        int start;//开始空闲时间
        int end;//结束空闲时间
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] array = line.split(" ");
            int N = Integer.parseInt(array[0]);
            int M = Integer.parseInt(array[1]);

            int[] task = new int[N];
            line = scanner.nextLine();
            array = line.split(" ");

            ArrayList<Period> freeList = new ArrayList<>();
            Period period = null;
            int prev = Integer.MAX_VALUE;
            for (int i = 0; i < task.length; i++) {
                task[i] = Integer.parseInt(array[i]);
                //第一个
                if (i == 0 && task[i] > 1) {
                    period = new Period();
                    period.start = 1;
                    period.end = task[i];
                    freeList.add(period);
                }

                if (task[i] - prev > 1) {
                    period = new Period();
                    period.start = prev + 1;
                    period.end = task[i];
                    freeList.add(period);
                }


                //最后一个
                if (i == task.length - 1) {
                    period = new Period();
                    period.start = task[i] + 1;
                    period.end = task[i] + 2;
                    freeList.add(period);
                }


                prev = task[i];
            }

            int[] tempTask = new int[M];
            int[] value = new int[M];
            for (int i = 0; i < M; i++) {
                line = scanner.nextLine();
                int val = Integer.parseInt(line);
                tempTask[i] = val;
                boolean find = false;
                for (Period p : freeList) {
                    if (val <= p.start) {
                        find = true;
                        value[i] = p.start;
                        break;
                    }

                    if (val > p.start && val <p.end) {
                        find = true;
                        value[i] = val;
                        break;
                    }

                }
                if (!find)
                    value[i] = val;
            }
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }


        }

    }

}
