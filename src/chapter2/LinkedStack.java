package chapter2;

/**
 * Created by Xingfeng on 2016-11-07.
 */
public class LinkedStack<E> {

    private static class Node<E> {

        private E e;
        private Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    }

    private Node<E> top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(E item) {

        Node<E> node = new Node<E>(item, top);
        top = node;

    }

    public E peek() {
        if (isEmpty())
            throw new NullPointerException("栈为空");

        return top.e;

    }

    public E pop() {

        if (isEmpty())
            throw new NullPointerException("栈为空");

        Node<E> node = top;
        top = node.next;
        node.next = null;

        E e = node.e;
        node = null;
        return e;

    }

    public static void main(String[] args) {

        LinkedStack<Integer> stack = new LinkedStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            System.out.println(stack.pop());
        }


    }

}
