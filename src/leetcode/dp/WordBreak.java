package leetcode.dp;

import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.
 * <p>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 * Created by Xingfeng on 2017-03-30.
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        //dp[i]表示字符长度为i的情况下是否能被分割
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            for (String word : wordDict) {

                //只考虑长度比当前长度小的情况
                if (word.length() <= i) {

                    //如果匹配一段
                    if (s.substring(i - word.length(), i).equals(word)) {
                        dp[i] = dp[i] || dp[i - word.length()];
                    }

                }

            }

        }

        return dp[n];


    }

}
