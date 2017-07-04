package netease;

import java.util.Scanner;

/**
 * Created by Xingfeng on 2017-03-25.
 */
public class Student {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new  Scanner(System.in);
        while(input.hasNext()){
            int n = input.nextInt();
            int a[] = new int[n];
            for(int i=0; i<n;i++){
                a[i] = input.nextInt();
            }

            int k = input.nextInt();
            int d = input.nextInt();

            System.out.println(maxmulti(n, k, d, a));
        }

    }


    public static long maxmulti(int n, int k,int d , int[] a){
        //Max[n][k]表示选取了k个学生并且以学生n结尾的最大乘积
        long Max[][] = new long[n+1][k+1];
        long Min[][] = new long[n+1][k+1];
        long maxvalue = Integer.MIN_VALUE;
        for(int i=1; i<=n;i++){
            Max[i][1] = a[i-1];
            Min[i][1] = a[i-1];
            for(int j= 2; j<=k;j++){
                for(int t=i-1;t>= Math.max(1, i-d);t--){
                    long Maxvalue = Max[t][j - 1] * a[i - 1];
                    long Minvalue = Min[t][j - 1] * a[i - 1];
                    Max[i][j] = Math.max(Max[i][j], Math.max(Maxvalue, Minvalue));
                    Min[i][j] = Math.min(Min[i][j], Math.min(Maxvalue, Minvalue));
                }
            }
            maxvalue =Math.max(maxvalue, Max[i][k])   ;
        }

        return maxvalue;
    }

}
