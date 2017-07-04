package chapter11;

import chapter6.BinaryTree;

/**
 * Created by Xingfeng on 2016-11-16.
 */
public class BinarySearch {

    /**
     * 迭代版本
     *
     * @param array
     * @param n
     * @param data
     * @return
     */
    public int binarySearchIterative(int[] array, int n, int data) {

        int low = 0, high = n - 1;
        int mid = 0;
        while (low <= high) {

            mid = (low + high) / 2;
            if (array[mid] == data)
                return mid;
            else if (array[mid] < data)
                low = mid + 1;
            else
                high = mid - 1;

        }

        return -1;

    }

    public int binarySearchRecursive(int[] array, int low, int high, int data) {

        if (low > high)
            return -1;

        int mid = low + (high - low) / 2;
        if (array[mid] == data)
            return mid;
        else if (array[mid] < data)
            return binarySearchRecursive(array, mid + 1, high, data);
        else
            return binarySearchRecursive(array, low, mid - 1, data);

    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch binarySearch=new BinarySearch();
        System.out.println(binarySearch.binarySearchIterative(array,array.length,3));
        System.out.println(binarySearch.binarySearchIterative(array,array.length,10));
        System.out.println(binarySearch.binarySearchRecursive(array,0,array.length-1,3));
        System.out.println(binarySearch.binarySearchRecursive(array,0,array.length-1,10));


    }


}
