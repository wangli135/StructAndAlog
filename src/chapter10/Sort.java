package chapter10;

/**
 * Created by Xingfeng on 2016-11-14.
 */
public abstract class Sort {

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public abstract void sort(int[] array);
}
