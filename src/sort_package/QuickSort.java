package sort_package;

import java.util.Arrays;

/**
 * Created by Xingfeng on 2017-03-20.
 */
public class QuickSort {

    public int[] quickSort(int[] data, int start, int end) {

        if (start >= end)
            return data;

        int partion = partion(data, start, end);
        quickSort(data, start, partion - 1);
        quickSort(data, partion + 1, end);

        return data;
    }

    private int partion(int[] data, int start, int end) {
        int base = data[start];
        int lo = start;
        int hi = end + 1;

        while (true) {

            while (data[++lo] < base)
                if (lo == end)
                    break;

            while (data[--hi] > base)
                if (hi == start)
                    break;

            if (lo >= hi)
                break;

            swap(data, hi, lo);

        }

        swap(data, start, hi);

        return hi;
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {

        int[] data = {3, 46, -1, 89, 90, 56, 78, 23};
        QuickSort quickSort = new QuickSort();
        System.out.println(Arrays.toString(quickSort.quickSort(data, 0, data.length - 1)));

    }
}
