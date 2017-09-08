package leetcode.string;

/**
 * https://leetcode.com/problems/implement-strstr/#/description
 * Created by Xingfeng on 2017-07-06.
 */
public class StrStr {
    public int strStr(String haystack, String needle) {

        if (needle == null || haystack == null)
            return -1;

        if (needle.length() > haystack.length())
            return -1;

        if (needle.length() == 0)
            return 0;

        char[] hayArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();

        int result = -1;

        outer:
        for (int i = 0; i < hayArray.length - needleArray.length; i++) {

            if (hayArray[i] == needleArray[0]) {

                for (int j = 1; j < needleArray.length; j++) {

                    if (hayArray[j + i] != needleArray[j]) {
                        continue outer;
                    }

                }

                result = i;
                break;


            }

        }

        return result;

    }

    public static void main(String[] args) {

        new StrStr().strStr("a", "a");

    }

}
