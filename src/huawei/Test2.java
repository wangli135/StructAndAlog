package huawei;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-24.
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            String line = sc.nextLine();
            StringBuilder sb = new StringBuilder("123456");
            char[] valueArray = line.toCharArray();
            for (int i = 0; i < valueArray.length; i++) {

                char c = valueArray[i];
                String s1 = sb.substring(0, 2);
                String s2 = sb.substring(2, 4);
                String s3 = sb.substring(4, 6);
                //左翻
                if (c == 'L') {

                    sb = new StringBuilder(s3 + s2 + new StringBuilder(s1).reverse().toString());

                }
                //右翻
                else if (c == 'R') {

                    sb = new StringBuilder(new StringBuilder(s3).reverse().toString() + s2 + s1);

                }
                //前翻
                else if (c == 'F') {

                    sb = new StringBuilder(s1 + s3 + new StringBuilder(s2).reverse().toString());

                }
                //后翻
                else if (c == 'B') {

                    sb = new StringBuilder(s1 + new StringBuilder(s3).reverse().toString() + s2);

                }
                //逆时针旋转90度
                else if (c == 'A') {

                    sb = new StringBuilder(new StringBuilder(s2).reverse().toString() + s1 + s3);

                }
                //顺时针旋转90度
                else {

                    sb = new StringBuilder(s2 + new StringBuilder(s1).reverse().toString() + s3);

                }

            }

            System.out.println(sb.toString());

        }
    }

}
