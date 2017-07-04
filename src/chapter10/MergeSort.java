package chapter10;

import java.util.Arrays;

/**
 * 归并排序
 * Created by Xingfeng on 2016-11-15.
 */
public class MergeSort extends Sort {

    @Override
    public void sort(int[] array) {

        int[] temp = new int[array.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i];
        }
        mergeSort(array, temp, 0, array.length - 1);

    }

    private void mergeSort(int[] array, int[] temp, int start, int end) {

        if (start >= end)
            return;


        int middle = start + (end - start) / 2;
        mergeSort(array, temp, start, middle);
        mergeSort(array, temp, middle + 1, end);
        merge(array, temp, start, middle, end);

    }

    private void merge(int[] array, int[] temp, int start, int middle, int end) {

        int l = start;
        int r = middle + 1;

        int pos = start;

        while (l <= middle && r <= end) {

            if (array[l] < array[r])
                temp[pos++] = array[l++];
            else
                temp[pos++] = array[r++];

        }

        while (l <= middle) {
            temp[pos++] = array[l++];
        }

        while (r <= end) {
            temp[pos++] = array[r++];
        }

        for (int i = start; i <= end; i++)
            array[i] = temp[i];

    }

    public void sortExec(int[] array) {
        int[] temp = new int[array.length];
        mergeSortExec(array, temp, 0, array.length - 1);
    }

    public void mergeSortExec(int[] array, int[] temp, int start, int end) {

        if (start >= end)
            return;

        int middle = start + (end - start) / 2;
        mergeSortExec(array, temp, start, middle);
        mergeSortExec(array, temp, middle + 1, end);
        mergeExec(array, temp, start, middle, end);

    }

    private void mergeExec(int[] array, int[] temp, int start, int middle, int end) {

        int l = start;
        int r = middle + 1;
        int pos = start;

        while (l <= middle && r <= end) {

            if (array[l] < array[r])
                temp[pos++] = array[l++];
            else
                temp[pos++] = array[r++];

        }

        while (l <= middle)
            temp[pos++] = array[l++];

        while (r <= end)
            temp[pos++] = array[r++];

        for (int i = start; i <= end; i++) {
            array[i] = temp[i];
        }


    }

    public static void main(String[] args) {

        int[] array = {89, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        MergeSort sort = new MergeSort();
        sort.sortExec(array);
        System.out.println(Arrays.toString(array));

    }

}
