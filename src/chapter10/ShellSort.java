package chapter10;

import java.util.Arrays;

/**
 * 希尔排序
 * Created by Xingfeng on 2016-11-15.
 */
public class ShellSort extends Sort {

    @Override
    public void sort(int[] array) {

        int n = array.length;

        int temp;
        for (int h = n / 3 + 1; h > 0; h--) {

            for (int i = 0; i < h; i++) {

                for (int j = i + h; j < n; j = j + h) {


                    temp = array[j];
                    for (int k = j - h; k >= 0; k -= h) {

                        if (temp < array[k])
                            swap(array, k, k + h);
                        else
                            break;
                    }

                }


            }


        }

    }

    public void sortExec(int[] array) {

        int n = array.length;

        for (int h = n / 3 + 1; h > 0; h--) {

            for (int j = 0; j < h; j++) {

                for (int k = j + h; k < n; k += h) {

                    int temp = array[k];

                    for (int m = k - h; m >= 0; m -= h) {
                        if (array[m] > temp)
                            swap(array, m, m + h);
                        else
                            break;
                    }

                }

            }

        }


    }


    public static void main(String[] args) {

        int[] array = {8, 7, 6, 5, 4, 3, 2, 1,9};
        ShellSort sort = new ShellSort();
        sort.sortExec(array);
        System.out.println(Arrays.toString(array));

    }

}
