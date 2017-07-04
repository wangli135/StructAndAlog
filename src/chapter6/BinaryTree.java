package chapter6;

/**
 * 二叉搜索树
 * Created by Xingfeng on 2016-11-12.
 */
public class BinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(7);

        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);

        node4.setLeft(node2);
        node4.setRight(node5);
        root.setLeft(node4);

        TreeNode node9 = new TreeNode(9);
        root.setRight(node9);

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(root, 10);
        binaryTree.inOrder(root);
        binaryTree.delete(root, 7);
        binaryTree.inOrder(root);
//        System.out.println(binaryTree.findMaxNonRecursive(root).getData());


    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(TreeNode root) {

        if (root == null)
            return;

        inOrder(root.getLeft());
        System.out.println(root.getData());
        inOrder(root.getRight());

    }

    /**
     * 在二叉搜索树中寻找元素
     *
     * @param root
     * @param data
     * @return
     */
    public TreeNode find(TreeNode root, int data) {

        if (root == null)
            return null;

        if (data == root.getData())
            return root;
        else if (data < root.getData())
            return find(root.getLeft(), data);
        else
            return find(root.getRight(), data);

    }

    /**
     * 在二叉搜索树中寻找元素，非递归方式
     *
     * @param root
     * @param data
     * @return
     */
    public TreeNode findNonRecursive(TreeNode root, int data) {

        while (root != null) {

            if (data == root.getData())
                return root;
            else if (data < root.getData())
                root = root.getLeft();
            else
                root = root.getRight();

        }

        return root;

    }

    public TreeNode findMin(TreeNode root) {

        if (root == null)
            return null;

        if (root.getLeft() == null)
            return root;
        else
            return findMin(root.getLeft());


    }

    public TreeNode findMinNonRecursive(TreeNode root) {

        while (root != null) {

            if (root.getLeft() == null)
                break;
            else
                root = root.getLeft();

        }

        return root;

    }

    public TreeNode findMax(TreeNode root) {
        if (root == null)
            return null;

        if (root.getRight() == null)
            return root;
        else
            return findMax(root.getRight());

    }

    public TreeNode findMaxNonRecursive(TreeNode root) {

        while (root != null) {

            if (root.getRight() == null)
                break;
            else
                root = root.getRight();

        }
        return root;

    }

    /**
     * 在二叉搜索树中插入元素
     *
     * @param root
     * @param data
     */
    public TreeNode insert(TreeNode root, int data) {

        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.getData()) {
            root.setLeft(insert(root.getLeft(), data));
        } else
            root.setRight(insert(root.getRight(), data));

        return root;

    }

    /**
     * 删除二叉搜索树中的某个元素
     *
     * @param root
     * @param data
     * @return
     */
    public TreeNode delete(TreeNode root, int data) {

        if (root == null)
            return null;

        TreeNode temp = null;

        if (data < root.getData())
            root.setLeft(delete(root.getLeft(), data));
        else if (data > root.getData())
            root.setRight(delete(root.getRight(), data));
        else {

            //左、右子树均存在
            if (root.getLeft() != null && root.getRight() != null) {

                temp = findMax(root.getLeft());
                root.setData(temp.getData());
                root.setLeft(delete(root.getLeft(), root.getData()));

            }
            //存在一个孩子结点
            else if (root.getLeft() == null || root.getRight() == null) {

                temp = root;
                if (root.getLeft() == null)
                    root = root.getRight();
                else if (root.getRight() == null)
                    root = root.getLeft();
                temp = null;

            } else
                root = null;

        }

        return root;

    }
}
