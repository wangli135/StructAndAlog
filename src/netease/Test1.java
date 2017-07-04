package netease;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            Stack<Integer> numStack = new Stack<>();
            Stack<Character> operatorStack = new Stack<>();

            int prevIndex = 0;
            for (int i = 0; i < line.length(); i++) {

                char c = line.charAt(i);
                //是数字
                if (c >= '0' && c <= '9') {
                    continue;
                }
                //遇到一个非数字
                else {

                    String s2 = line.substring(prevIndex, i);
                    prevIndex = i + 1;
                    if (!numStack.isEmpty()) {

                        int v1 = numStack.pop();
                        int v2 = Integer.parseInt(s2);
                        char operator = operatorStack.pop();
                        int result = 0;
                        if (operator == '+') {
                            result = v1 + v2;
                        } else if (operator == '-') {
                            result = v1 - v2;
                        } else {
                            result = v1 * v2;
                        }
                        numStack.push(result);

                    } else {
                        numStack.push(Integer.parseInt(s2));
                    }
                    operatorStack.push(c);

                }

            }

            String s2 = line.substring(prevIndex, line.length());
            int v1 = numStack.pop();
            int v2 = Integer.parseInt(s2);
            char operator = operatorStack.pop();
            int result = 0;
            if (operator == '+') {
                result = v1 + v2;
            } else if (operator == '-') {
                result = v1 - v2;
            } else {
                result = v1 * v2;
            }
            numStack.push(result);

            System.out.println(numStack.pop());

        }
    }

}
