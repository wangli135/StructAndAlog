package search;

/**
 * 二叉查找树
 * Created by Xingfeng on 2017-04-14.
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node right, left;
        private int N;

        public Node(Key key, Value value, Node right, Node left, int n) {
            this.key = key;
            this.value = value;
            this.right = right;
            this.left = left;
            N = n;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null)
            return null;

        int result = x.key.compareTo(key);
        if (result == 0) {
            return x.value;
        } else if (result < 0) {
            return get(x.right, key);
        } else {
            return get(x.left, key);
        }

    }

    public void put(Key key, Value value) {

        root = put(root, key, value);

    }

    /**
     * 以节点x为根结点插入数据，并返回根结点
     * @param x
     * @param key
     * @param value
     * @return
     */
    private Node put(Node x, Key key, Value value) {

        if (x == null)
            return new Node(key, value, null, null, 1);

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


}
