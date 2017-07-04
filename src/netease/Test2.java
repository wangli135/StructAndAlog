package netease;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            //工程师数量
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] array = new String[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextLine();
            }


            System.out.println(getNum(0, array, new boolean[6]));
        }
    }

    //获取第i学工以下可能的情况
    private static int getNum(int index, String[] array, boolean[] task) {

        if (index >= array.length)
            return 1;

        String s = array[index];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {

            int id = s.charAt(i) - '0';
            //没有分配
            if (!task[id]) {
                task[id] = true;
                sum += getNum(index + 1, array, task);
                task[id] = false;
            }

        }

        return sum;

    }


}
