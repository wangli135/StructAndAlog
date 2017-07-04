package sort_package;

import java.util.Arrays;

/**
 * Created by Xingfeng on 2017-03-20.
 */
public class BubbleSort {

    public int[] bubbleSort(int[] data) {

        int N = data.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {

                if (data[j] > data[j + 1]) {

                    swap(data, j, j+1);

                }
            }

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
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println(Arrays.toString(bubbleSort.bubbleSort(data)));

    }
}
