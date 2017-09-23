package xinyongka;

import leetcode.graph.TargetSum;

import java.util.*;

/**
 * Created by Xingfeng on 2017-09-19.
 */
public class Test5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            int m = scanner.nextInt();

            handle(n,m);

        }


    }


    private static void handle(int n, int m) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        handle(result, new ArrayList<Integer>(), 1, n, m);
        System.out.println(result.size());

    }



    private static void handle(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> es, int start, int n, int m) {

        if (m == 0) {
            result.add(new ArrayList<>(es));
            return;
        }

        if (start > n || m < 0) {
            return;
        }

        for (int i = start; i <= n; i++) {
            es.add(i);
            handle(result, es, i + 1, n, m - i);
            es.remove(es.size() - 1);
        }


    }

}
