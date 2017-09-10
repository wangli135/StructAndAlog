package leetcode.likely;

import java.util.*;

/**
 * Created by wangl on 2017/8/8.
 */
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {

            String key = getKey(str);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                map.put(key, list);
                result.add(list);
            }
            list.add(str);

        }

        return result;

    }

    private static String getKey(String str) {
        int[] hash = new int[128];
        char[] data = str.toCharArray();
        for (char c : data) {
            hash[c]++;
        }

        return Arrays.toString(hash);


    }




}
