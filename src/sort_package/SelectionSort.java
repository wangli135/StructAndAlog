package sort_package;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

/**
 * Created by Xingfeng on 2017-03-20.
 */
public class SelectionSort {

    public int[] slectionSort(int[] data) {

        int N = data.length;
        for (int i = 0; i < N - 1; i++) {

            int maxIndex = 0;
            for (int j = 0; j < N - 1 - i; j++) {

                if (data[j] > data[maxIndex])
                    maxIndex = j;
            }
            swap(data, maxIndex, N - 1 - i);


        }
        return data;

    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {

        int[] data = {3, 46, -1, 89, 90, 56, 78, 23};
        SelectionSort selectionSort = new SelectionSort();
        System.out.println(Arrays.toString(selectionSort.slectionSort(data)));

    }

}
