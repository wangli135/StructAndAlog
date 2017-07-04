package leetcode.dp;

/**
 * Created by Xingfeng on 2017-03-31.
 */
public class SubSequence {

    public boolean isSubsequence(String s, String t) {

        if (s.length() == 0)
            return true;

        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {

            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }

        }

        if (sIndex >= s.length())
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        //"axc"
        //"ahbgdc"
        SubSequence subSequence = new SubSequence();
        System.out.println(subSequence.isSubsequence("abc", "ahbgdc"));
    }

}
