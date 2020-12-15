package medium.day26;

import java.util.Arrays;

//最长递增子序列
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
//子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
//
public class LeetCode300 {
    public static void main(String[] args) {
//        [10,9,2,5,3,7,101,18]
//        0,1,0,3,2,3
        System.out.println(lengthOfLIS(new int []{7,7,7,7,7}));
    }

    public static int lengthOfLIS(int[] nums) {
        int [] dp=new int[nums.length];
        Arrays.fill(dp,1);
        int result=1;
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            result=Math.max(result,dp[i]);
        }
        return result;
    }

}
