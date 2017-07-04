package chapter7;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 堆
 * Created by Xingfeng on 2016-11-13.
 */
public class Heap {

    private int[] array;
    private int count;
    private int capacity;
    private int heapType;

    public Heap(int capacity, int heapType) {
        this.capacity = capacity;
        this.heapType = heapType;

        array = new int[capacity];
        this.count = 0;

    }

    /**
     * 结点的双亲
     *
     * @param i
     * @return
     */
    public int parent(int i) {
        if (i <= 0 || i >= count)
            return -1;
        return (i - 1) / 2;
    }

    /**
     * 结点的左孩子
     *
     * @param i
     * @return
     */
    public int leftChild(int i) {

        int left = 2 * i + 1;
        if (left >= count)
            return -1;

        return left;
    }

    /**
     * 结点的右孩子
     *
     * @param i
     * @return
     */
    public int rightChild(int i) {

        int right = 2 * i + 2;
        if (right >= count)
            return -1;

        return right;
    }

    /**
     * 获取最大元素
     *
     * @return
     */
    public int max() {
        if (count == 0)
            return -1;
        return array[0];
    }

    /**
     * 堆化元素
     *
     * @param i 元素的下标
     */
    public void precolateDown(int i) {

        int l, r, max, temp;
        //在i元素及其左右孩子中找到最大值
        l = leftChild(i);
        r = rightChild(i);
        if (l != -1 && array[l] > array[i])
            max = l;
        else
            max = i;

        if (r != -1 && array[r] > array[max])
            max = r;

        //最大值不是i元素，交换
        if (max != i) {
            temp = array[i];
            array[i] = array[max];
            array[max] = temp;
            precolateDown(max);
        }


    }

    /**
     * 删除最大元素
     *
     * @return
     */
    public int deleteMax() {

        if (count == 0)
            return -1;

        int data = array[0];
        array[0] = array[count - 1];
        count--;
        precolateDown(0);
        return data;
    }

    public int insert(int data) {

        if (count == capacity)
            resizeHeap();  //将堆扩大两倍

        count++;
        int i = count - 1;
        //如果大于父结点，则将值往下赋
        while (i >= 0) {

            //存在父结点
            if (parent(i) != -1) {
                if (data > array[parent(i)]) {
                    array[i] = array[parent(i)];
                    i = parent(i);
                }
            } else {
                break;
            }

        }

        array[i] = data;

        return i;

    }

    private void resizeHeap() {

        int[] data = new int[capacity * 2];
        System.arraycopy(array, 0, data, 0, count);
        array = data;
        capacity *= 2;
    }

    /**
     * 清空堆
     */
    public void clear() {
        count = 0;
        array = null;
    }

    public void buildHeap(Heap h, int[] A, int n) {

        if (h == null)
            return;

        while (n > h.capacity)
            h.resizeHeap();

        for (int i = 0; i < n; i++)
            h.array[i] = A[i];
        h.count = n;

        for (int i = (n - 1) / 2; i >= 0; i--) {
            h.precolateDown(i);
        }

    }

    public void heapSort(int[] A, int n) {

        Heap heap = new Heap(n, 0);
        buildHeap(heap, A, n);
        int oldSize = heap.count;
        int i, temp;
        for (i = n - 1; i > 0; i--) {
            temp = heap.array[0];
            heap.array[0] = heap.array[heap.count - 1];
            heap.array[heap.count - 1] = temp;
            heap.count--;
            heap.precolateDown(0);
        }
        heap.count = oldSize;

    }

    public static void main(String[] args) {

        Heap heap = new Heap(10, 0);

        int[] array = new int[14];
        for (int i = 1; i < 15; i++) {
            array[i - 1] = i;
        }

        heap.heapSort(array, array.length);

        System.out.println(Arrays.toString(heap.array));

    }
}
