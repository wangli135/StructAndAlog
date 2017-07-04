package chapter6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Xingfeng on 2016-11-10.
 */
public class TreeQuestion {

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

        TreeNode left8 = new TreeNode(8, null, null);
        left4.setLeft(left8);

        TreeNode right9 = new TreeNode(9, null, null);
        left4.setRight(right9);

        zigzagOrder(root);

    }

    /**
     * 在一棵数中找出最大值
     * 取左子树中的最大值，右子树的最大值，再与自身比较得出最大值
     *
     * @param root
     * @return
     */
    private static int findMaxInTree(TreeNode root) {

        if (root == null)
            return Integer.MIN_VALUE;

        int num1 = root.getData();
        int num2 = findMaxInTree(root.getLeft());
        int num3 = findMaxInTree(root.getRight());

        int max;

        if (num1 > num2)
            max = num1;
        else
            max = num2;

        if (num3 > max)
            max = num3;

        return max;

    }

    private static int max = Integer.MIN_VALUE;

    /**
     * 先序遍历时比较大小
     *
     * @param root
     * @return
     */
    private static void findMaxInTreeByOrder(TreeNode root) {

        if (root == null)
            return;

        if (root.getData() > max)
            max = root.getData();
        findMaxInTreeByOrder(root.getLeft());
        findMaxInTreeByOrder(root.getRight());


    }

    private static boolean findValInTree(TreeNode root, int val) {

        if (root == null)
            return false;

        boolean result = false;

        if (root.getData() == val)
            result = true;

        if (!result)
            result = findValInTree(root.getLeft(), val);

        if (!result)
            result = findValInTree(root.getRight(), val);

        return result;


    }

    /**
     * 树的高度，递归方式
     *
     * @param root
     * @return
     */
    private static int heightOfTree(TreeNode root) {

        if (root == null)
            return 0;

        return Math.max(heightOfTree(root.getLeft()), heightOfTree(root.getRight())) + 1;

    }

    /**
     * 树的高度，非递归方式，层次遍历
     *
     * @param root
     * @return
     */
    private static int heightOfTreeNonRecursive(TreeNode root) {

        int count = 1;

        if (root == null)
            return 0;

        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        TreeNode temp = null;
        while (!queue.isEmpty()) {

            temp = queue.removeFirst();

            if (temp == null) {
                if (queue.isEmpty())
                    break;

                count++;
                queue.add(null);
                continue;

            } else {
                if (temp.getLeft() != null)
                    queue.add(temp.getLeft());
                if (temp.getRight() != null)
                    queue.add(temp.getRight());
            }


        }


        return count;
    }

    /**
     * 树中最深结点
     *
     * @param root
     * @return
     */
    private static TreeNode deepestTreeNodeOfTree(TreeNode root) {

        TreeNode temp = null;

        if (root == null)
            return temp;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            temp = queue.removeFirst();

            if (temp.getLeft() != null)
                queue.add(temp.getLeft());
            if (temp.getRight() != null)
                queue.add(temp.getRight());

        }

        return temp;


    }

    /**
     * 叶子结点的个数
     *
     * @param root
     * @return
     */
    private static int leftOfTree(TreeNode root) {

        int num = 0;
        if (root == null)
            return num;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode temp = null;
        while (!queue.isEmpty()) {

            temp = queue.removeFirst();

            if (temp.getLeft() == null && temp.getRight() == null)
                num++;

            if (temp.getLeft() != null)
                queue.add(temp.getLeft());
            if (temp.getRight() != null)
                queue.add(temp.getRight());

        }

        return num;


    }

    /**
     * 满节点的个数
     *
     * @param root
     * @return
     */
    private static int fullOfTree(TreeNode root) {

        int num = 0;
        if (root == null)
            return num;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode temp = null;
        while (!queue.isEmpty()) {

            temp = queue.removeFirst();

            if (temp.getLeft() != null && temp.getRight() != null)
                num++;

            if (temp.getLeft() != null)
                queue.add(temp.getLeft());
            if (temp.getRight() != null)
                queue.add(temp.getRight());

        }

        return num;

    }

    /**
     * 半结点的个数
     *
     * @param root
     * @return
     */
    private static int partOfTree(TreeNode root) {

        int num = 0;
        if (root == null)
            return num;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode temp = null;
        while (!queue.isEmpty()) {

            temp = queue.removeFirst();

            if (temp.getLeft() != null && temp.getRight() == null)
                num++;

            if (temp.getRight() != null && temp.getLeft() == null)
                num++;

            if (temp.getLeft() != null)
                queue.add(temp.getLeft());
            if (temp.getRight() != null)
                queue.add(temp.getRight());

        }

        return num;

    }

    /**
     * 判断两棵树是否相同
     *
     * @param root1
     * @param root2
     * @return
     */
    private static boolean isSameTree(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        return root1.getData() == root2.getData() && isSameTree(root1.getLeft(), root2.getLeft())
                && isSameTree(root1.getRight(), root2.getRight());


    }

    /**
     * 树中同一结点数据之和最大的层
     *
     * @param root
     * @return
     */
    private static int maxLevelSumOfTree(TreeNode root) {

        if (root == null)
            return 0;

        int count = 1;
        int maxLevel = 1;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        TreeNode temp = null;
        while (!queue.isEmpty()) {

            temp = queue.removeFirst();

            if (temp == null) {

                if (queue.isEmpty()) {
                    break;
                } else {

                    if (sum > max) {
                        max = sum;
                        maxLevel = count;
                    }

                    count++;
                    sum = 0;
                    queue.add(null);
                    continue;
                }

            } else {

                sum += temp.getData();

                if (temp.getLeft() != null)
                    queue.add(temp.getLeft());
                if (temp.getRight() != null)
                    queue.add(temp.getRight());

            }


        }

        return maxLevel;

    }


    private static ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

    private static ArrayList<Integer> path = new ArrayList<>();

    /**
     * 打印所有从根结点到叶子结点的路径
     *
     * @param root
     */
    private static void printPaths(TreeNode root) {

        if (root == null)
            return;

        path.add(root.getData());
        if (root.getLeft() == null && root.getRight() == null) {
            paths.add(new ArrayList<>(path));
        }
        printPaths(root.getLeft());
        printPaths(root.getRight());
        path.remove(path.size() - 1);

    }

    private static boolean hasPathSum(TreeNode root, int val) {

        if (root == null)
            return val == 0;

        if (root.getData() == val)
            return true;

        return hasPathSum(root.getLeft(), val - root.getData()) || hasPathSum(root.getRight(), val - root.getData());


    }

    /**
     * ZigZag树的遍历
     *
     * @param root
     */
    private static void zigzagOrder(TreeNode root) {

        if (root == null)
            return;

        boolean ltr = false;
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        TreeNode temp = null;
        currentLevel.push(root);
        while (!currentLevel.isEmpty()) {

            temp = currentLevel.pop();
            System.out.println(temp.getData());
            if (ltr) {
                if (temp.getRight() != null) {
                    nextLevel.push(temp.getRight());
                }
                if (temp.getLeft() != null) {
                    nextLevel.push(temp.getLeft());
                }
            } else {
                if (temp.getLeft() != null) {
                    nextLevel.push(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    nextLevel.push(temp.getRight());
                }
            }

            if (currentLevel.isEmpty()) {
                ltr = !ltr;
                Stack<TreeNode> s = currentLevel;
                currentLevel = nextLevel;
                nextLevel = s;
            }

        }

    }

}
