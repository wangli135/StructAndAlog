package leetcode.likely;

import org.omg.DynamicAny._DynEnumStub;

import java.util.Stack;

/**
 * https://leetcode.com/problems/decode-string/description/
 * Created by wangl on 2017/8/3.
 */
public class DecodeString {

    public String decodeString(String s) {

        Stack<String> vals = new Stack<>();

        String val = "";
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '[') {

                vals.push(new String(val));
                val = "";

            } else if (c == ']') {

                String s2 = val;
                String s1 = vals.pop();

                val=decode(s1 + s2);
//                vals.push(s3);
//
//                val = "";


            } else {
                val += String.valueOf(c);
            }


        }

        return val;


    }

    private String decode(String s) {

        String str = "";
        String val = "";

        boolean numing = false;
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                numing = true;
                val += String.valueOf(c);
            } else {

                if (numing) {

                    for (int j = 0; j < Integer.parseInt(val); j++) {
                        str += decode(s.substring(i));
                    }

                    break;

                } else {
                    str += String.valueOf(c);
                }

            }

        }

        return str;

    }

    public static void main(String[] args) {

        System.out.println(new DecodeString().decodeString("2[20[bc]31[xy]]xd4[rt]"));

    }


}
