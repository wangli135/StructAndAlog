package bat_video;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreePrinter {
    public int[][] printTree(TreeNode root) {

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();

        if (root != null) {

            queue.offer(root);
            queue.offer(null);
            ArrayList<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()) {

                TreeNode node = queue.remove();
                if (node == null) {

                    arrayLists.add(new ArrayList<>(list));
                    list.clear();

                    if (queue.isEmpty())
                        break;
                    else
                        queue.offer(null);

                } else {
                    list.add(node.val);
                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }

            }

        }

        int[][] result = new int[arrayLists.size()][];
        for (int i = 0; i < arrayLists.size(); i++) {

            ArrayList<Integer> list = arrayLists.get(i);
            int[] data = new int[list.size()];
            for (int i1 = 0; i1 < list.size(); i1++) {
                data[i1] = list.get(i1);
            }
            result[i] = data;

        }

        return result;
    }
}
