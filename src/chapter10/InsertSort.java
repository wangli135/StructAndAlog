package chapter10;

import java.util.Arrays;

/**
 * 插入排序
 * Created by Xingfeng on 2016-11-14.
 */
public class InsertSort extends Sort {

    @Override
    public void sort(int[] array) {

        int n = array.length;
        int temp = 0;
        for (int i = 1; i < n; i++) {

            temp = array[i];

            for (int j = i - 1; j >= 0; j--) {

                if (array[j] > temp) {
                    swap(array, j, j + 1);
                }

            }

        }

    }

    public void sortExec(int[] array) {

        int n = array.length;

        int temp = 0;
        for (int i = 1; i < n; i++) {

            temp = array[i];

            for (int j = i - 1; j >= 0; j--) {

                if (array[j] > temp)
                    swap(array, j, j + 1);
                else
                    break;
            }

        }

    }

    public static void main(String[] args) {

        int[] array = {8, 7, 6, 5, 4, 3, 2, 1,9};
        InsertSort sort = new InsertSort();
        sort.sortExec(array);
        System.out.println(Arrays.toString(array));

    }
}
