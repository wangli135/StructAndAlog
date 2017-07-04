package chapter10;

/**
 * Created by Xingfeng on 2016-11-15.
 */
public class BucketSort extends Sort {

    @Override
    public void sort(int[] array) {

        int[] bucket = new int[array.length + 1];

        for (int i = 0; i < array.length; i++)
            bucket[array[i]] = bucket[array[i]] + 1;

        for (int i = 0; i < bucket.length; i++) {

            while (bucket[i] != 0) {

                System.out.println(i);
                bucket[i]--;

            }

        }

    }

    public static void main(String[] args) {

        int[] array = {9, 8, 7, 5, 5, 4, 3, 2, 1};
        Sort sort = new BucketSort();
        sort.sort(array);

    }

}
