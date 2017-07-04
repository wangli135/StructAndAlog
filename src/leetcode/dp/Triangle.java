package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xingfeng on 2017-03-30.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        for (int i = 1; i < triangle.size(); i++) {

            List<Integer> prev = triangle.get(i - 1);
            List<Integer> cur = triangle.get(i);

            //开始遍历
            for (int j = 0; j < cur.size(); j++) {

                int val = cur.get(j);
                //如果是第一个元素
                if (j == 0) {
                    val += prev.get(0);
                }
                //如果是最后一个元素
                else if (j == cur.size() - 1) {
                    val += prev.get(prev.size() - 1);
                } else {
                    val = val + Math.min(prev.get(j), prev.get(j - 1));
                }
                cur.set(j, val);
            }

        }

        //寻找最小值
        List<Integer> below = triangle.get(triangle.size() - 1);
        int min = Integer.MAX_VALUE;
        for (Integer i : below) {
            if (i < min) {
                min = i;
            }
        }
        return min;

    }

    public static void main(String[] args) {

//        List<Integer> firstList = new ArrayList<>();
//        firstList.add(1);
//
//        List<Integer> secondList = new ArrayList<>();
//        secondList.add(2);
//        secondList.add(3);
//
//        List<List<Integer>> triangle = new ArrayList<>();
//        triangle.add(firstList);
//        triangle.add(secondList);
//
//        Triangle triangle1 = new Triangle();
//        System.out.println(triangle1.minimumTotal(triangle));

        Triangle triangle = new Triangle();
        System.out.println(triangle.uniquePaths(1, 100));

    }

    public int uniquePaths(int m, int n) {

        //数学方法
        int num1 = 1;
        for (int i = 0; i < n; i++) {
            num1 *= (m + n - i);
        }

        int num2 = 1;
        for (int i = 1; i <= n; i++) {
            num2 *= i;
        }

        return num1 / num2;


    }
}
