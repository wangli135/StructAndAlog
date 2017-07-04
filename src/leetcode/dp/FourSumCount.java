package leetcode.dp;

import java.util.Arrays;

/**
 * Created by Xingfeng on 2017-04-02.
 */
public class FourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        //暴力求解
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                for (int k = 0; k < C.length; k++) {
                    for (int m = 0; m < D.length; m++) {

                        if (A[i] + B[j] + C[k] + D[m] == 0) {
                            sum++;
                        }

                    }
                }
            }
        }
        return sum;

    }

    public int fourSumCount_1(int[] A, int[] B, int[] C, int[] D) {

        //分别记录A数组和B数组的和，C数组和D数组的和，然后遍历和，二分查找C和D的和
        int sum = 0;

        int[] A_B = new int[A.length * A.length];
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                A_B[index++] = A[i] + B[j];
            }
        }

        int[] C_D = new int[C.length * D.length];
        index = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                C_D[index++] = C[i] + D[j];
            }
        }

        //对A_B排序
        Arrays.sort(A_B);
        //对C_D排序
        Arrays.sort(C_D);

        index = 0;
        while (index < A_B.length) {

            int v1 = A_B[index];
            int upSum = 1;
            int r = index + 1;
            while (r < A_B.length && A_B[r] == v1) {
                r++;
                upSum++;
            }
            index = r;
            int j = Arrays.binarySearch(C_D, -v1);
            int downSum = 0;
            if (j >= 0) {
                int left = j - 1;
                while (left >= 0 && C_D[left] == C_D[j]) {
                    left--;
                    downSum++;
                }
                int right = j + 1;
                while (right < C_D.length && C_D[right] == C_D[j]) {
                    right++;
                    downSum++;
                }
                downSum++;

            }

            sum += (upSum * downSum);
        }

        return sum;

    }

    public static void main(String[] args) {

        int[] A = {0, 1, -1};
        int[] B = {-1, 1, 0};
        int[] C = {0, 0, 1};
        int[] D = {-1, 1, 1};

        FourSumCount demo = new FourSumCount();
        System.out.println(demo.fourSumCount_1(A, B, C, D));

    }

}
