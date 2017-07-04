package baidu;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-27.
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String type = scanner.nextLine();
            String content = scanner.nextLine();
            if (type.equals("0")) {
                System.out.println(zip(content));
            } else {
                System.out.println(unzip2(content));
            }
        }
    }

    //压缩
    private static String zip(String content) {

        String[] array = content.split(":");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {

            int index = 0;
            String s = array[i];
            while (index < s.length() && s.charAt(index) == '0') {
                index++;
            }

            if (index < s.length()) {
                sb.append(s.substring(index)).append(":");
            } else {
                sb.append(":");
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    //解压缩
    private static String unzip(String content) {
        String[] array = content.split(":");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {

            String s = array[i];
            int len = s.length();
            while (len < 6) {
                sb.append("0");
                len++;
            }

            sb.append(s).append(":");
        }

        sb.deleteCharAt(sb.length() - 1);

        if (content.charAt(content.length() - 1) == ':') {
            sb.append(":000000");
        }

        return sb.toString();
    }

    //解压缩
    private static String unzip2(String content) {

        StringBuilder sb = new StringBuilder();

        int index = 0;
        String temp = "";
        for (int i = 0; i < content.length(); i++) {

            //需要分割
            if (content.charAt(i) == ':') {

                int len = temp.length();
                while (len < 6) {
                    sb.append("0");
                    len++;
                }

                sb.append(temp).append(":");
                temp = "";


            } else {
                temp+= String.valueOf(content.charAt(i));
            }

        }

        int len = temp.length();
        while (len < 6) {
            sb.append("0");
            len++;
        }

        sb.append(temp);
        temp = "";



        return sb.toString();

    }

}
