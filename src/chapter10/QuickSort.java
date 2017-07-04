package chapter10;

import java.util.Arrays;

/**
 * Created by Xingfeng on 2016-11-15.
 */
public class QuickSort extends Sort {

    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int start, int end) {

        if (start >= end)
            return;

        int p = partition(array, start, end);
        quickSort(array, start, p - 1);
        quickSort(array, p + 1, end);

    }

    private int partition(int[] array, int start, int end) {

        int base = array[start];

        int l = start;
        int r = end + 1;

        while (true) {

            while (array[++l] <= base)
                if (l == end)
                    break;

            while (array[--r] >= base)
                if (r == start)
                    break;

            if (l >= r)
                break;

            swap(array, l, r);

        }

        swap(array, start, r);

        return r;
    }

    public void sortExec(int[] array) {

        quickSortExec(array, 0, array.length - 1);

    }

    private void quickSortExec(int[] array, int start, int end) {

        if (start >= end)
            return;

        int p = partionTest(array, start, end);
        quickSortExec(array, start, p - 1);
        quickSortExec(array, p + 1, end);

    }

    public int partitionExec(int[] array, int start, int end) {

        int lo = start;
        int hi = end + 1;
        int base = array[start];

        while (true) {

            while (array[++lo] < base)
                if (lo == end)
                    break;

            while (array[--hi] > base)
                if (hi == start)
                    break;

            if (lo < hi)
                swap(array, lo, hi);
            else
                break;

        }

        swap(array, start, hi);

        return hi;

    }

    public static void main(String[] args) {

        int[] array = {6, 8, 1, 4, 5, 3, 7, 2, 9};
        QuickSort selectSort = new QuickSort();
        selectSort.sortExec(array);
        System.out.println(Arrays.toString(array));

    }


    private int partionTest(int[] array, int start, int end) {

        int base = array[start];
        int lo = start, hi = end + 1;

        while (true) {

            while (array[++lo] <= base)
                if (lo == end)
                    break;

            while (array[--hi] >= base)
                if (hi == start)
                    break;

            if (lo >= hi)
                break;

            swap(array, lo, hi);

        }

        swap(array, start, hi);

        return hi;

    }

}
