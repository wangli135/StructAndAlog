package pinduoduo;

import java.util.Stack;

/**
 * Created by wangl on 2017/7/18.
 */
public class Test {

    int[] data = new int[17];

    public void init() {
        for (int i = 1; i <= 17; i++) {
            data[i - 1] = i * i;
        }
    }


    /**
     * @param m     值
     * @param start 起始下标
     * @return
     */
    public int numOfCombine(int m, int start) {

        if (m < 0)
            return 0;

        if (m == 0)
            return 1;

        int num = 0;
        int val = 0;
        for (int i = start; i < data.length; i++) {

            val = 0;
            if (m < data[i])
                break;

            while (val < m) {
                val = val + data[i];
                if (val > m) {
                    while (val > data[i]) {
                        val -= data[i];
                        num += numOfCombine(m - val, start + 1);
                    }
                    break;
                }else if(val==m){
                    num++;
                    while (val > data[i]) {
                        val -= data[i];
                        num += numOfCombine(m - val, start + 1);
                    }
                    break;
                }
            }

        }

        return num;


    }

    public static void main(String[] args) {

        Test test = new Test();
        test.init();
        System.out.println(test.numOfCombine(4, 0));

    }


}
