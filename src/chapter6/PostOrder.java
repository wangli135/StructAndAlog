package chapter6;

import java.util.Stack;

/**
 * Created by Xingfeng on 2017-03-09.
 */
public class PostOrder {

    public void postOrderInterative(TreeNode root) {

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

                if (stack.isEmpty()) {
                    break;
                } else {
                    root = stack.peek().getRight();
                }


            }

        }

    }

}
