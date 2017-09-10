package netease;

import java.util.*;

/**
 * Created by wangl on 2017/8/12.
 */
public class Test4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String line = scanner.nextLine();
            System.out.println(handle(line));

        }
    }

    private static int handle2(String line) {

        char[] data = line.toCharArray();

        if (line.length() == 1)
            return 1;

        int[] hash = new int[128];
        for (int i = 0; i < data.length; i++) {
            hash[data[i]]++;
        }

        int num = permuteNum(data.length);


        int val = 1;
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                num = num / hash[i];
                val *= hash[i];
            }
        }

        return num - val;


    }

    private static int permuteNum(int length) {

        if (length == 1)
            return 1;

        if (length == 2)
            return 2;

        return length * permuteNum(length - 1);


    }

    private static int handle(String line) {

        if (line.length() == 0)
            return 0;

        char[] data = line.toCharArray();


        Set<String> set = permuteUnique(data);

        int num = 0;
        for (String s : set) {
            if (isRight(s)) {
                num++;
            }
        }

        return num;
    }

    private static boolean isRight(String s) {

        char[] data = s.toCharArray();

        int num = 0;

        for (int i = 1; i < data.length; i++) {

            if (data[i] != data[i - 1])
                num++;

            if (num > 1)
                break;


        }

        return num <= 1;

    }

    public static Set<String> permuteUnique(char[] nums) {
        Set<String> set = new HashSet<>();
        Arrays.sort(nums);
        backtrack(set, new ArrayList<>(), nums, new boolean[nums.length]);
        return set;
    }

    private static void backtrack(Set<String> set, List<Character> tempList, char[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {

            char[] data = new char[tempList.size()];
            for (int i = 0; i < data.length; i++) {
                data[i] = tempList.get(i);
            }

            set.add(new String(data));


        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                tempList.add(nums[i]);
                backtrack(set, tempList, nums, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

}

