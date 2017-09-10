package netease;

import javax.swing.text.MutableAttributeSet;
import java.util.*;

/**
 * Created by wangl on 2017/8/12.
 */
public class Test6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            int n = Integer.parseInt(line);
            line = scanner.nextLine();
            String[] sArray = line.split(" ");
            int[] array = new int[n];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(sArray[i]);
            }

            System.out.println(handle2(array));


        }
    }

    private static int handle(int[] array) {

        List<List<Integer>> combines = permuteUnique(array);


        int max = Integer.MIN_VALUE;

        for (int i = 0; i < combines.size(); i++) {
            List<Integer> list = combines.get(i);
            int val = 0;

            for (int j = 0; j < list.size() - 1; j++) {

                val += Math.abs(list.get(j) - list.get(j + 1));

            }

            if (val > max) {
                max = val;
                System.out.println(list);
            }


        }


        return max;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private static int handle2(int[] array) {

        Arrays.sort(array);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(array[array.length - 1]);
        int leftIndex = 0;
        int rightIndex = array.length - 2;
        while (list.size() < array.length) {

            int v1 = Math.abs(array[leftIndex] - list.getFirst());
            int v2 = Math.abs(array[leftIndex] - list.getLast());
            int v3 = Math.abs(array[rightIndex] - list.getFirst());
            int v4 = Math.abs(array[rightIndex] - list.getLast());

            boolean leftMax = v1 > v2;
            int mx1 = v1 > v2 ? v1 : v2;

            boolean rightMax = v4 > v3;
            int mx2 = v4 > v3 ? v4 : v3;

            if (mx2 > mx1) {
                if (rightMax) {
                    list.addLast(array[rightIndex--]);
                } else {
                    list.addFirst(array[rightIndex--]);
                }
            } else {
                if (leftMax) {
                    list.addFirst(array[leftIndex++]);
                } else {
                    list.addLast(array[leftIndex++]);
                }
            }


        }


        return 0;


    }

}

