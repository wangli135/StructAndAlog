package sort_package;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

/**
 * Created by Xingfeng on 2017-03-20.
 */
public class HillSort {

    public int[] hillSort(int[] data) {

        int N = data.length;
        for (int j = (N + 1) / 3; j > 0; j--) {

            for (int i = 0; i < N; i++) {

                for (int k = i + j; k < N; k += j) {


                    for (int m = k; m >= j; m -= j) {

                        if (data[m - j] > data[m])
                            swap(data, m - j, m);
                        else
                            break;

                    }


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
        HillSort hillSort = new HillSort();
        System.out.println(Arrays.toString(hillSort.hillSort(data)));

    }
}
