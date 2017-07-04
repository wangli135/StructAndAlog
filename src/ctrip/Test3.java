package ctrip;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-11.
 */
public class Test3 {

    /*请完成下面这个函数，实现题目要求的功能*/
/*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */

    /******************************开始写代码******************************/
    static ArrayList<String> doFilter(String[] source, String filter) {

        //保存对应的原数据
        ArrayList<String> result = new ArrayList<>();
        //记录下标索引
        ArrayList<Integer> indexList = new ArrayList<>();

        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                //如果某一个不包含"."，那么为最小
                if (!o1.contains(".")) {
                    return -1;
                }

                if (!o2.contains(".")) {
                    return 1;
                }

                //两个值均有"."
                int i = 0, j = 0;
                //比较，谁先出现"."那么就为大
                while (i < o1.length() && j < o2.length()) {

                    //如果相等，那么索引均+1
                    if (o1.charAt(i) == o2.charAt(j)) {
                        i++;
                        j++;
                    }
                    //不相同
                    else {

                        //如果相同的位置o1出现了"."
                        if (o1.charAt(i) == '.') {
                            return 1;
                        } else {
                            return -1;
                        }

                    }

                }

                //如果某一个值越界了
                //如果o1越界了，那么为大
                if (i == o1.length()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        //遍历处理原数据
        for (int i = 0; i < source.length; i++) {
            String res = find(source[i], filter);
            if (res.length() != 0) {
                queue.add(res);
                result.add(res);
                indexList.add(i);
            }
        }

        ArrayList<String> finalResult = new ArrayList<>();
        while (!queue.isEmpty()) {
            String val = queue.remove();
            int index = result.indexOf(val);
            result.remove(index);
            finalResult.add(source[indexList.get(index)]);
            indexList.remove(index);
        }

        return finalResult;
    }

    //判断是否匹配，返回匹配后的表达式，比如ABCD匹配ABC，返回ABC.
    private static String find(String source, String filter) {

        String res = "";

        //i记录source下标，j记录filter下标
        int i = 0, j = 0;
        while (i < source.length() && j < filter.length()) {

            //如果值相同，那么同时后移
            if (source.charAt(i) == filter.charAt(j)) {
                //添加值
                res += String.valueOf(source.charAt(i));
                i++;
                j++;
            }
            //不相等，那么添加"."，source下标后移
            else {
                res += ".";
                i++;
            }

        }

        //一起越界，那么直接返回
        if (i == source.length() && j == filter.length()) {
            return res;
        }
        //如果source先越界，并且filter还没到，那么不匹配
        if (i == source.length() && j < filter.length()) {
            //清空数据
            res = "";
            return res;
        }

        //source未越界，filter越界了，添加"."
        while (i < source.length()) {
            res += ".";
            i++;
        }

        return res;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {

        String[] _source = {
                "AB",
                "ABC",
                "ACB",
                "ABCD",
                "ADBCF",
                "ABDCF",
                "ABDC",
                "ABDFCG",
                "ABDFGC",
                "ABDEFG",
                "GABCEFG"
        };

        Scanner in = new Scanner(System.in);
        String _filter;
        try {
            _filter = in.nextLine();
        } catch (Exception e) {
            _filter = null;
        }

        ArrayList<String> res = doFilter(_source, _filter);
        if (res.size() == 0) {
            System.out.println("-1");
        } else {
            for (String s : res) {
                System.out.println(s);
            }
        }

    }

}
