package paypal;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-13.
 */
public class Test1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            String[] arrayA = line.split(" ");
            line = scanner.nextLine();
            String[] arrayB = line.split(" ");

            handle(arrayA, arrayB);
        }

    }

    private static void handle(String[] arrayA, String[] arrayB) {

        //记录A和B中重复的，关于A的索引
        PriorityQueue<Integer> indexA = new PriorityQueue<Integer>();
        PriorityQueue<Integer> indexB = new PriorityQueue<Integer>();
        for (int i = 0; i < arrayA.length; i++) {
            String s1 = arrayA[i];
            for (int j = 0; j < arrayB.length; j++) {
                String s2 = arrayB[j];
                if (s1.equals(s2)) {
                    indexA.add(i);
                    indexB.add(j);
                    break;
                }

            }
        }

        Object[] indexArrayA = indexA.toArray();
        Object[] indexArrayB = indexB.toArray();

        //遍历查找长度
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        ArrayList<Integer> weights = new ArrayList<>();

        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < indexA.size(); i++) {


            int startA = i;
            int startB = 0;
            while (startB < indexB.size()) {
                String s1 = arrayA[(int) indexArrayA[startA]];
                String s2 = arrayB[(int) indexArrayB[startB]];
                if (s1.equals(s2)) {
                    //找到了第一个，继续查找
                    int len = 1;
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add(s1);
                    int weight = (Integer) indexArrayA[startA];
                    startA++;
                    startB++;
                    //继续往后查找
                    while (startA < indexA.size() && startB < indexA.size()) {

                        s1 = arrayA[(int) indexArrayA[startA]];
                        s2 = arrayB[(int) indexArrayB[startB]];
                        if (s1.equals(s2)) {
                            len++;
                            weight += (int) indexArrayA[startA];
                            temp.add(s1);
                            startA++;
                            startB++;
                        } else {
                            startA++;
                        }

                    }

                    if (len > maxLen) {
                        maxLen = len;
                    }

                    if (weight != 0) {
                        groups.add(temp);
                        weights.add(weight);
                    }

                    break;
                } else {
                    startB++;
                }
            }


        }

        //首先找出最大长度
        ArrayList<String> maxLength = new ArrayList<>();
        int minWeight = Integer.MAX_VALUE;
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).size() == maxLen) {
                //比较价值
                if (weights.get(i) > minWeight) {
                    minWeight = weights.get(i);
                    maxLength = groups.get(i);
                }
            }
        }

        System.out.println(minWeight);
        for (int i = 0; i < maxLength.size(); i++) {
            if (i != maxLength.size() - 1) {
                System.out.print(maxLength.get(i) + " ");
            } else {
                System.out.print(maxLength.get(i));
            }
        }

    }

}
