package jd;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Xingfeng on 2017-09-08.
 */
public class Test3 {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            System.out.println(handle(line));

        }

    }

    /**
     * 将合法字符串变成下一个合法字符串可能的次数
     *
     * @param line
     * @return
     */
    private static int handle(String line) {

        if (line.length() == 2)
            return 1;

        int num = 0;

        char[] array = line.toCharArray();

        //找到第一个(
        int index = 0;
        while (index < array.length) {
            if (array[index] == '(') {
                break;
            }
            index++;
        }

        for (int i = 0; i < array.length; i++) {

            if (array[i] == ')' && isCorrect(array, index, i)) {
                num += handle(array, index, i);
            }

        }


        return num;
    }

    /**
     * 判断字符串是否合法
     *
     * @param array
     * @param index
     * @param i
     * @return
     */
    private static boolean isCorrect(char[] array, int index, int i) {

        stack.clear();
        for (int j = 0; j < array.length; j++) {

            if (j == index || j == i)
                continue;

            char c = array[j];
            if (c == '(')
                stack.push(c);
            else {

                if (stack.isEmpty())
                    return false;
                else
                    stack.pop();

            }


        }


        return stack.isEmpty();

    }

    private static String getString(char[] array, int index, int i) {
        char[] newArray = new char[array.length - 2];
        int j = 0;
        for (int i1 = 0; i1 < array.length; i1++) {
            if (i1 == index || i1 == i)
                continue;
            newArray[j++] = array[i1];
        }
        return new String(newArray);
    }

    private static int handle(char[] array, int index, int i) {
        return handle(getString(array, index, i));
    }


}
