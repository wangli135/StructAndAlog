package jd;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Xingfeng on 2017-09-08.
 */
public class Test1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            System.out.println(handle(line.toCharArray(), 0, new boolean[line.length()]));

        }

    }

    /**
     * 将合法字符串变成下一个合法字符串可能的次数
     *
     * @param array 必须合法
     * @return
     */
    private static int handle(char[] array, int start, boolean[] used) {

        int num = 0;

        //找到第一个(
        int index = start;
        while (index < array.length) {
            if (array[index] == '('&&!used[index]) {
                used[index] = true;
                break;
            }
            index++;
        }

        //找不到(，说明合法
        if (index == array.length)
            return 1;

        for (int i = 0; i < array.length; i++) {

            if (array[i] == ')' && !used[i] && isCorrect(array, index, i, used)) {
                used[i] = true;
                num += handle(array, start + 1, used);
                used[i] = false;
            }

        }

        used[index] = false;

        return num;
    }

    /**
     * 判断字符串是否合法
     *
     * @param array
     * @param left 左括号
     * @param right 右括号
     * @return
     */
    private static boolean isCorrect(char[] array, int left, int right, boolean[] used) {

        used[right] = true;

        Stack<Character> stack = new Stack<>();
        for (int j = 0; j < array.length; j++) {

            if (j == left || j == right || used[j])
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

        used[right] = false;

        return stack.isEmpty();

    }

//    private static String getString(char[] array, int index, int i) {
//        char[] newArray = new char[array.length - 2];
//        int j = 0;
//        for (int i1 = 0; i1 < array.length; i1++) {
//            if (i1 == index || i1 == i)
//                continue;
//            newArray[j++] = array[i1];
//        }
//        return new String(newArray);
//    }


}
