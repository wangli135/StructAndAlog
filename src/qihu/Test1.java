package qihu;

import javafx.scene.shape.SVGPath;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class Test1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int k = scanner.nextInt();
            scanner.nextLine();
            int[] num = new int[k];
            int[] p = new int[k];
            String line = null;
            String[] array = null;
            double result = 0;
            for (int i = 0; i < num.length; i++) {
                line = scanner.nextLine();
                array = line.split(" ");
                num[i] = Integer.parseInt(array[0]);
                p[i] = Integer.parseInt(array[1]);
                result += (num[i] * p[i]) * 1.0f / 100;
            }


            System.out.println(String.format("%.3f", result));


        }

    }

    public String print(List<Integer> list) throws IOException {

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {

            if (i == list.size() - 1) {
                sb.append(list.get(i));
            } else {
                sb.append(list.get(i) + " ");
            }
        }

        PrintWriter writer = new PrintWriter(new FileWriter(""));
        for (int i = 0; i < 10; i++) {

            if (i == 9) {
                writer.write("");
            } else {
                writer.write("" + "\n");
            }

        }
        return sb.toString();

    }

    private String[] getshi(List<String> list) {

        int N = list.size();
        String[] result = new String[N + 1];
        result[0] = list.get(0) + "\n";
        result[1] = "\n";

        StringBuilder sb = null;
        for (int i = 1; i < N; i++) {

            sb = new StringBuilder(list.get(i));
            sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
            if (i != N - 1) {
                sb.append("\n");
            }
            result[i + 1] = sb.toString();

        }
        return result;

    }


}
