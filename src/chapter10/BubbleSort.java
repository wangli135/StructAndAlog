package chapter10;

import java.net.Socket;
import java.util.Arrays;

/**
 * 冒泡排序
 * Created by Xingfeng on 2016-11-14.
 */
public class BubbleSort extends Sort {

    public void sort(int[] array) {

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - 1 - i; j++) {

                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }

            }

        }

    }

    public void sortImprove(int[] array) {

        int n = array.length;
        boolean isSorted = false;
        int sortNum = 0;

        for (int i = 0; i < n - 1; i++) {

            if (isSorted)
                return;

            for (int j = 0; j < n - 1 - i; j++) {

                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    sortNum++;
                }

            }

            if (sortNum > 0)
                sortNum = 0;
            else
                isSorted = true;

        }


    }


    public void sortExec(int[] array) {

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 1; j < n - i; j++) {

                if (array[j - 1] > array[j])
                    swap(array, j - 1, j);

            }

        }


    }

    public static void main(String[] args) {

        int[] array = {6, 8, 1, 4, 5, 3, 7, 2,9};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sortExec(array);
        System.out.println(Arrays.toString(array));
    }

}
