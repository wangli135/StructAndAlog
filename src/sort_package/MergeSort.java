package sort_package;

import java.util.Arrays;

/**
 * Created by Xingfeng on 2017-03-20.
 */
public class MergeSort {

    public int[] mergeSort(int[] data) {
        int[] temp = new int[data.length];
        mergeSort(data, temp, 0, data.length - 1);
        return data;
    }

    private void mergeSort(int[] data, int[] temp, int start, int end) {

        if (start >= end)
            return;

        int middle = (start + end) >>> 1;
        mergeSort(data, temp, start, middle);
        mergeSort(data, temp, middle + 1, end);
        merge(data, temp, start, middle, end);

    }

    private void merge(int[] data, int[] temp, int lo, int mid, int hi) {

        int leftIndex = mid;
        int rightIndex = hi;
        int index = hi;
        while (leftIndex >= lo && rightIndex >= mid + 1) {

            if (data[leftIndex] < data[rightIndex]) {
                temp[index--] = data[rightIndex--];
            } else {
                temp[index--] = data[leftIndex--];
            }

        }

        while (leftIndex >= lo) {
            temp[index--] = data[leftIndex--];
        }

        while (rightIndex >= mid + 1) {
            temp[index--] = data[rightIndex--];
        }

        for (int i = lo; i <= hi; i++)
            data[i] = temp[i];

    }

    public static void main(String[] args) {

        int[] data = {3, 46, -1, 89, 90, 56, 78, 23};
        MergeSort mergeSort = new MergeSort();
        System.out.println(Arrays.toString(mergeSort.mergeSort(data)));

    }

}
