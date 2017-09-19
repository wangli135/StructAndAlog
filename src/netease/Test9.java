package netease;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by wangl on 2017/8/12.
 */
public class Test9 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {

                int n = scanner.nextInt();
                int[] array = new int[n];
                for (int i1 = 0; i1 < array.length; i1++) {
                    array[i1] = scanner.nextInt();
                }
                handle(array);

            }

        }
    }

    private static void handle(int[] array) {
        //倍数是4的
        List<Integer> fourList = new ArrayList<>();
        //奇数
        List<Integer> oddList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            if (temp % 4 == 0)
                fourList.add(temp);
            else if ((temp & 0x1) == 1)
                oddList.add(temp);
        }
        int fSize = fourList.size();
        int oSize = oddList.size();


        if (oSize > fSize)
            System.out.println("No");
        else
            System.out.println("Yes");
    }


}

