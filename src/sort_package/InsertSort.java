package sort_package;

import java.util.Arrays;

/**
 * Created by Xingfeng on 2017-03-20.
 */
public class InsertSort {

    public int[] insertSort(int[] data) {

        int N = data.length;
        for (int j = 1; j < N; j++) {
            for (int i = j; i > 0; i--) {
                if (data[i - 1] > data[i])
                    swap(data, i, i - 1);
                else
                    break;
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
        InsertSort insertSort = new InsertSort();
        System.out.println(Arrays.toString(insertSort.insertSort(data)));

    }

}
