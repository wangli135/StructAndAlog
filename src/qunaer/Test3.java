package qunaer;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-01.
 */
public class Test3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String start = scanner.nextLine();
            String end = scanner.nextLine();

            String list = scanner.nextLine();
            String[] words = list.split(" ");
            handle(start, end, words);

        }
    }

    private static void handle(String start, String end, String[] words) {

        //value[i]表示需要经过几次变换到start
        int[] value = new int[words.length];
        //初始值均为Int最大值
        for (int i = 0; i < value.length; i++) {
            value[i] = Integer.MAX_VALUE;
        }

        //记录索引
        LinkedList<Integer> prevQueue = new LinkedList<>();

        //预处理，把可以变换一次的均放进prevQueue中
        for (int i = 0; i < words.length; i++) {
            if (isSilimar(start, words[i])) {
                value[i] = 2;
                prevQueue.offer(i);
            }
        }

        //迭代处理
        while (!prevQueue.isEmpty()) {

            int index = prevQueue.remove();
            String s = words[index];
            for (int i = 0; i < words.length; i++) {
                if (isSilimar(s, words[i])) {
                    if (value[i] > value[index] + 1) {
                        value[i] = value[index] + 1;
                        prevQueue.offer(i);
                    }
                }
            }

        }

        int v = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(end))
                v = value[i];
        }
        System.out.println(v);

    }

    //判断两个字符串是否只有一个字符不同
    private static boolean isSilimar(String s1, String s2) {

        //如果相等，则返回false
        if (s1.equals(s2)) {
            return false;
        }

        char[] value1 = s1.toCharArray();
        char[] value2 = s2.toCharArray();
        boolean noSame = false;

        for (int i = 0; i < value1.length; i++) {
            if (value1[i] != value2[i]) {
                if (!noSame) {
                    noSame = true;
                } else {
                    return false;
                }
            }
        }


        return true;


    }

}
