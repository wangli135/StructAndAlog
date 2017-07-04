package chapter7;

import javax.swing.plaf.multi.MultiInternalFrameUI;
import java.util.Arrays;

/**
 * Created by Xingfeng on 2017-03-09.
 */
public class MinHeap<T> {

    private T[] queue;
    private int size;

    public MinHeap(int capacity) {
        queue = (T[]) new Object[capacity];
    }

    public void offer(T val) {

        if (size == 0)
            queue[size++] = val;
        else {
            if (size == queue.length)
                throw new IndexOutOfBoundsException();

            siftUp(size++, val);

        }

    }

    private void siftUp(int k, T x) {
        Comparable<T> key = (Comparable) x;
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object c = queue[parent];
            if (key.compareTo((T) c) >= 0)
                break;

            queue[k] = (T) c;
            k = parent;

        }
        queue[k] = (T) key;

    }

    public T poll() {

        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }

        int s = --size;
        T result = queue[0];
        T e = queue[s];
        queue[s] = null;
        if (s != 0)
            siftDown(0, e);
        return result;

    }

    private void siftDown(int k, T t) {

        Comparable<T> key = (Comparable) t;
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;//左孩子
            Object c = queue[child];
            int right = child + 1;
            if (right < size && ((Comparable) c).compareTo(queue[right]) > 0)
                c = queue[child = right];

            if (key.compareTo((T) c) <= 0)
                break;

            queue[k] = (T) c;
            k = child;

        }
        queue[k] = (T) key;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++)
            sb.append(queue[i]).append(",");
        sb.deleteCharAt(sb.length() - 1).append("]");
        return sb.toString();
    }

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(10);
        for (int i = 0; i < 10; i++)
            minHeap.offer(10 - i);

        System.out.println(minHeap);

        for (int i = 0; i < 10; i++) {
            System.out.println(minHeap.poll());
            System.out.println(minHeap);
        }


    }


}
