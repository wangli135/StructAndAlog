package chapter6;

import netscape.security.PrivilegeTable;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 遍历
 * Created by Xingfeng on 2016-11-10.
 */
public class OrderTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, null, null);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.setLeft(left);
        root.setRight(right);

        TreeNode left4 = new TreeNode(4, null, null);
        left.setLeft(left4);
        TreeNode right5 = new TreeNode(5, null, null);
        left.setRight(right5);

        TreeNode left6 = new TreeNode(6, null, null);
        right.setLeft(left6);
        TreeNode right7 = new TreeNode(7, null, null);
        right.setRight(right7);

        new PostOrder().postOrderInterative(root);

    }

    /**
     * 先序遍历（递归版本）
     *
     * @param root
     */
    private static void preOrder(TreeNode root) {

        if (root == null)
            return;

        System.out.println(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());


    }

    /**
     * 先序遍历（非递归版本）
     *
     * @param root
     */
    private static void preOrderNonRecursive(TreeNode root) {

        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        while (true) {

            while (root != null) {
                System.out.println(root.getData());
                stack.push(root);
                root = root.getLeft();
            }

            if (stack.isEmpty())
                break;

            root = stack.pop();
            root = root.getRight();


        }

    }

    /**
     * 中序遍历（递归版本）
     *
     * @param root
     */
    private static void middleOrder(TreeNode root) {

        if (root == null)
            return;

        middleOrder(root.getLeft());
        System.out.println(root.getData());
        middleOrder(root.getRight());


    }

    /**
     * 中序遍历（非递归版本）
     *
     * @param root
     */
    private static void middleOrderNonRecursive(TreeNode root) {

        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        while (true) {

            while (root != null) {

                stack.push(root);
                root = root.getLeft();

            }

            if (stack.isEmpty())
                break;

            root = stack.pop();
            System.out.println(root.getData());
            root = root.getRight();


        }

    }

    /**
     * 后序遍历（递归版本）
     *
     * @param root
     */
    private static void postOrder(TreeNode root) {

        if (root == null)
            return;

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getData());


    }

    private static void postOrderNonRecursive(TreeNode root) {

        if (root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        while (true) {

            if (root != null) {
                stack.push(root);
                root = root.getLeft();
            } else {

                if (stack.isEmpty()) {
                    break;
                } else {
                    if (stack.peek().getRight() == null) {
                        root = stack.pop();
                        System.out.println(root.getData());
                        while (!stack.isEmpty() && root == stack.peek().getRight()) {
                            root = stack.pop();
                            System.out.println(root.getData());
                        }
                    }
                }

                if (!stack.isEmpty()) {
                    root = stack.peek().getRight();
                } else
                    root = null;

            }


        }


    }

    /**
     * 层次遍历
     *
     * @param root
     */
    private static void levelOrder(TreeNode root) {

        if (root == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp = null;
        while (!queue.isEmpty()) {

            temp = queue.removeFirst();
            System.out.println(temp.getData());
            if (temp.getLeft() != null)
                queue.offer(temp.getLeft());
            if (temp.getRight() != null)
                queue.offer(temp.getRight());

        }


    }
}
