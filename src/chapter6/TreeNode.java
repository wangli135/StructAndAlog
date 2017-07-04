package chapter6;

/**
 * Created by Xingfeng on 2016-11-10.
 */
public class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this(data, null, null);
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
