package sort_package;

import java.util.Arrays;

/**
 * Created by Xingfeng on 2017-03-20.
 */
public class HeapSort {

    public int[] heapSort(int[] data) {

        Heap heap = new Heap(data);
        return heap.sort();

    }

    static class Heap {
        int[] heap;
        int size;

        public Heap(int[] data) {

            heap = new int[data.length];
            for (int i = 0; i < data.length; i++) {
                add(data[i]);
            }

        }

        private void add(int i) {

            heap[size] = i;
            if (size != 0)
                shiftUp(size, i);
            size++;
        }

        private void shiftUp(int index, int val) {
            int parent = (index - 1) / 2;
            while (parent >= 0 && heap[index] > heap[parent]) {
                swap(heap, index, parent);
                index = parent;
                parent = (index - 1) / 2;
            }
        }


        public int[] sort() {

            while (size > 0) {

                //交换第一个节点与最后一个节点
                swap(heap, 0, --size);
                shiftDown(0);
            }

            return heap;

        }

        //将第index个数据往下递推
        private void shiftDown(int index) {

            int k = index;
            while (k < size) {
                int maxIndex = k;
                int max = heap[k];
                int leftChindIndex = k*2 + 1;
                if (leftChindIndex < size && heap[leftChindIndex] > max) {
                    maxIndex = leftChindIndex;
                    max = heap[leftChindIndex];
                }

                int rightChildIndex = leftChindIndex + 1;
                if (rightChildIndex < size && heap[rightChildIndex] > max) {
                    maxIndex = rightChildIndex;
                    max = heap[rightChildIndex];
                }

                if (max == heap[k])
                    break;

                swap(heap, k, maxIndex);
                k = maxIndex;

            }


        }

        private void swap(int[] data, int i, int j) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }


    }

    public static void main(String[] args) {

        int[] data = {3, 46, -1, 89, 90, 56, 78, 23};
        HeapSort heapSort = new HeapSort();
        System.out.println(Arrays.toString(heapSort.heapSort(data)));

    }

}
