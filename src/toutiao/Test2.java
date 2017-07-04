package toutiao;

import java.util.*;

/**
 * Created by Xingfeng on 2017-03-30.
 */
public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> list = new ArrayList<>();
        long text = 0;
        while (scanner.hasNext()) {

            text = scanner.nextLong();
            if (text==0)
                break;
            else {
                list.add(text);
            }

        }

        Collections.sort(list);

        long prev = 0;
        int size = 0;
        for (Long val : list) {
            if (val != prev) {
                prev = val;
                size++;
            }
        }


        System.out.println(size);
    }

}
