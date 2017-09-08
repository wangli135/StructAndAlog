package leetcode.string;

/**
 * Created by Xingfeng on 2017-07-06.
 */
public class Attendance {

    public boolean checkRecord(String s) {

        if (s == null || s.length() == 0)
            return true;

        int numOfA = 0;
        char[] array = s.toCharArray();
        boolean result = true;
        int firstLIndex = -1, secondLIndex = -1;
        for (int i = 0; i < array.length; i++) {

            char c = array[i];
            if (c == 'A') {
                numOfA++;
                if (numOfA == 2) {
                    result = false;
                    break;
                }

                if (firstLIndex != -1) {
                    firstLIndex = -1;
                    secondLIndex = -1;
                }

            } else if (c == 'L') {
                if (firstLIndex == -1) {
                    firstLIndex = i;
                } else if (secondLIndex == -1) {
                    secondLIndex = i;
                } else {
                    result = false;
                    break;
                }
            } else {

                if (firstLIndex != -1) {
                    firstLIndex = -1;
                    secondLIndex = -1;
                }

            }


        }

        return result;


    }

    public static void main(String[] args) {

        new Attendance().checkRecord("LALL");

    }
}
