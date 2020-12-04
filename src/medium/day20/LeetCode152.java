package medium.day20;
//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
public class LeetCode152 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-4,-3,-2}));
    }

    public static int maxProduct(int[] nums) {
        int preMax=nums[0];
        int preMin=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            int m=preMax,n=preMin;
            preMax=Math.max(Math.max(m*nums[i],n*nums[i]),nums[i]);
            preMin=Math.min(Math.min(m*nums[i],n*nums[i]),nums[i]);
            max=max>preMax?max:preMax;
        }
        return max;
    }
}
