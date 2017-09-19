package didi;

import java.util.*;

/**
 * #include <iostream>
 * #include<vector>
 * #include<algorithm>
 * using namespace std;
 * int main()
 * {
 * int count;
 * while (cin >> count)
 * {
 * vector<int> arr;
 * for (int i = 0; i < count; i++)
 * {
 * int data;
 * cin >> data;
 * arr.push_back(data);
 * }
 * int start = 0;
 * int sum=0;
 * <p>
 * for (int i = 0; i < count; i++)
 * {
 * if (arr[i] == 0)
 * {
 * sum++;
 * start = i + 1;
 * continue;
 * }
 * for (int j = start; j < i; j++)
 * {
 * int flag = 0;
 * for (int k = j; k <= i; k++)
 * {
 * flag ^= arr[k];
 * }
 * if (flag == 0)
 * {
 * sum++;
 * start = i + 1;
 * continue;
 * }
 * }
 * }
 * cout << sum << endl;
 * <p>
 * }
 * return 0;
 * }
 * <p>
 * Created by Xingfeng on 2017-04-22.
 */
public class Test3 {

    static class Period {

        public int start;
        public int end;

        public Period(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            handle(array);

        }
    }

    private static void handle(int[] array) {

        List<Period> periodList = new ArrayList<>();

        //xorMatrix[i][j]记录array[i]..array[j]之间的异或值
        int[][] xorMatrix = new int[array.length][array.length];
        for (int i = 0; i < xorMatrix.length; i++) {
            for (int j = i; j < xorMatrix.length; j++) {

                if (i == j) {
                    xorMatrix[i][j] = array[i];
                } else {
                    xorMatrix[i][j] = xorMatrix[i][j - 1] ^ array[j];
                }

                if (xorMatrix[i][j] == 0) {
                    periodList.add(new Period(i, j));
                }
            }
        }


        Collections.sort(periodList, new Comparator<Period>() {
            @Override
            public int compare(Period o1, Period o2) {

                if (o1.start < o2.start) {
                    return -1;
                } else if (o1.start == o2.start) {

                    if (o1.end < o2.end) {
                        return -1;
                    } else if (o1.end == o2.end) {
                        return 0;
                    } else {
                        return 1;
                    }


                } else {
                    return 1;
                }

            }
        });

        int max = 0;
        int num = 0;

        for (int i = 0; i < periodList.size(); i++) {

            num = 0;

            int left = -1, right = -1;
            for (int j = i; j < periodList.size(); j++) {

                Period period = periodList.get(j);
                if (period.start != left && period.start > right) {

                    num++;
                    left = period.start;
                    right = period.end;

                }

            }

            if (num > max)
                max = num;


        }


        System.out.println(max);

    }

}
