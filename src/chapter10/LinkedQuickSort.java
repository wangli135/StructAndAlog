package chapter10;

import com.sun.javafx.collections.SortHelper;
import com.sun.javafx.sg.prism.NGNode;

/**
 * 链表的快速排序
 * Created by Xingfeng on 2016-11-15.
 */
public class LinkedQuickSort {

    private static class Node {

        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    public void sort(Node head) {


        Node tail = head;

        if (tail == null)
            return;

        while (tail.getNext() != null) {
            tail = tail.getNext();
        }

        quickSort(head, tail);

    }

    private void quickSort(Node head, Node tail) {

        if (head == null || tail == null)
            return;

        if (head == tail)
            return;


        Node lessHead = null, lessTail = null;
        Node moreHead = null, moreTail = null;
        Node equalNode = head;

        Node base = head;

        Node temp = head.getNext();

        while (temp != null && temp != moreHead) {

            Node node = temp;
            temp = temp.getNext();

            if (node.getVal() < base.getVal()) {

                //将该结点移到小于部分
                equalNode.setNext(node.getNext());
                node.setNext(null);
                if (lessHead == null) {
                    lessHead = lessTail = node;
                    lessTail.setNext(head);
                } else {
                    node.setNext(lessHead);
                    lessHead = node;
                }

            } else if (node.getVal() > base.getVal()) {

                //将该结点移到大于部分
                equalNode.setNext(node.getNext());
                node.setNext(null);
                if (moreHead == null) {
                    moreHead = moreTail = node;
                    tail.setNext(moreHead);
                } else {
                    moreTail.setNext(node);
                    moreTail = node;
                }

            } else {
                equalNode = node;
            }

        }

        quickSort(lessHead, lessTail);
        quickSort(moreHead, moreTail);

    }

    public static void main(String[] args) {

        Node head = new Node(6);
        Node num2 = new Node(8);
        Node num3 = new Node(1);
        Node num4 = new Node(4);
        Node num5 = new Node(5);
        Node num6 = new Node(3);
        Node num7 = new Node(7);
        Node num8 = new Node(2);

        head.setNext(num2);
        num2.setNext(num3);
        num3.setNext(num4);
        num4.setNext(num5);
        num5.setNext(num6);
        num6.setNext(num7);
        num7.setNext(num8);

        LinkedQuickSort sort = new LinkedQuickSort();
        sort.sort(head);

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getVal());
            temp = temp.getNext();
        }

    }

}
