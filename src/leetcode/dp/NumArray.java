package leetcode.dp;

/**
 * 时间复杂度O(1)，空间复杂度O(n)，一开始使用空间O(n*n)，内存溢出
 * Created by Xingfeng on 2017-03-27.
 */
public class NumArray {

    //dp[i]表示0到i的和
    int[] dp;

    public NumArray(int[] nums) {
        int N=nums.length;
        dp=new int[N];
        for(int i=0;i<N;i++){
            if(i==0){
                dp[i]=nums[i];
            }else{
                dp[i]=dp[i-1]+nums[i];
            }

        }
    }

    public int sumRange(int i, int j) {
        if(i==0)
            return dp[j];
        return dp[j]-dp[i-1];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray obj = new NumArray(nums);
        System.out.println(obj.sumRange(0, 2));
        System.out.println(obj.sumRange(2, 5));
        System.out.println(obj.sumRange(0, 5));
    }

}
