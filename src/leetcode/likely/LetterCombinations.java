package leetcode.likely;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by wangl on 2017/8/10.
 */
public class LetterCombinations {

    Map<String, String> map = new HashMap<>();

    {

        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return result;

        helper(result, digits.toCharArray(), "", 0);

        return result;

    }

    private void helper(List<String> result, char[] chars, String s, int start) {

        if (start == chars.length) {
            result.add(s);
            return;
        }

        String letters = map.get(String.valueOf(chars[start]));
        for (int i = 0; i < letters.toCharArray().length; i++) {
            helper(result, chars, s + String.valueOf(letters.charAt(i)), start + 1);
        }

    }

    public static void main(String[] args) {

        System.out.println(new LetterCombinations().letterCombinations("23"));

    }

}
