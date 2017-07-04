package chapter10;

import java.util.Arrays;

/**
 * 选择排序
 * Created by Xingfeng on 2016-11-14.
 */
public class SelectSort extends Sort {

    public void sort(int[] array) {

        int n = array.length;

        int min = 0;
        for (int i = 0; i < n - 1; i++) {

            min = i;
            for (int j = i + 1; j < n; j++) {

                if (array[j] < array[min]) {
                    min = j;
                }

            }

            swap(array, min, i);

        }

    }


    public void sortExec(int[] array) {

        int n = array.length;

        int maxIndex = 0;
        for (int i = n - 1; i >= 0; i--) {

            maxIndex = 0;
            for (int j = 0; j <= i; j++) {

                if (array[j] > array[maxIndex])
                    maxIndex = j;

            }

            swap(array, maxIndex, i);


        }


    }

    public static void main(String[] args) {

        int[] array = {6, 8, 1, 4, 5, 3, 7, 2,9};
        SelectSort selectSort = new SelectSort();
        selectSort.sortExec(array);
        System.out.println(Arrays.toString(array));

    }

}
