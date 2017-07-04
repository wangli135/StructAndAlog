package qunaer;

import chapter6.TreeNode;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-04-01.
 */
public class Test1 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int n = scanner.nextInt();
            int[] prev = new int[n];
            int[] middle = new int[n];

            for (int i = 0; i < prev.length; i++) {
                prev[i] = scanner.nextInt();
            }

            for (int i = 0; i < middle.length; i++) {
                middle[i] = scanner.nextInt();
            }

            handle(prev, middle);

        }
    }

    private static void handle(int[] prev, int[] middle) {

        TreeNode root = buildTree(prev, 0, prev.length - 1, middle, 0, middle.length - 1);

        List<Integer> result = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {

            TreeNode node = queue.remove();
            if (node != null) {

                result.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            } else {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.offer(null);
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                sb.append(result.get(i) + "");
            } else {
                sb.append(result.get(i) + " ");
            }
        }
        System.out.println(sb.toString());

    }

    private static TreeNode buildTree(int[] prev, int prevStart, int prevEnd, int[] middle, int middleStart, int middleEnd) {

        if (prevStart > prevEnd)
            return null;

        TreeNode root = new TreeNode();
        root.val = prev[prevStart];

        int left = 0;
        for (int i = middleStart; i <= middleEnd; i++) {

            if (middle[i] != root.val) {
                left++;
            } else {
                break;
            }
        }

        int leftPrevStart = prevStart + 1;
        int leftPrevEnd = prevStart + left;
        int leftMiddleStart = middleStart;
        int leftMiddleEnd = middleStart + left - 1;

        int rightPrevStart = prevStart + left + 1;
        int rightPrevEnd = prevEnd;
        int rightMiddleStart = leftMiddleEnd + 2;
        int rightMiddleEnd = middleEnd;

        root.left = buildTree(prev, leftPrevStart, leftPrevEnd, middle, leftMiddleStart, leftMiddleEnd);
        root.right = buildTree(prev, rightPrevStart, rightPrevEnd, middle, rightMiddleStart, rightMiddleEnd);

        return root;

    }

}
