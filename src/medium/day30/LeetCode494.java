package medium.day30;

import java.util.Arrays;

//给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
//
//返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
//
public class LeetCode494 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{0,0,0,0,0,0,0,0,1}, 1));
    }

    //    public static int findTargetSumWays(int[] nums, int S) {
//        LinkedList<Integer> queue = new LinkedList<>();
//        queue.offerLast(0);
//        for (int num : nums) {
//            int len = queue.size();
//            for (int i = 0; i < len; i++) {
//                Integer value = queue.removeFirst();
//                queue.offerLast(value + num);
//                queue.offerLast(value - num);
//            }
//        }
//        int ans = 0;
//        for (int sum : queue) {
//            if (sum == S) {
//                ans++;
//            }
//        }
//        return ans;
//    }
    public static int findTargetSumWays(int[] nums, int S) {
        if (S > 1000 || S < -1000) {
            return 0;
        }
        int[] sumNum = new int[2001];
        Arrays.fill(sumNum, 0);
        sumNum[1000 + nums[0]] += 1;
        sumNum[1000 - nums[0]] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] newSumNum = new int[2001];
            Arrays.fill(newSumNum, 0);
            for (int index = 0; index < sumNum.length; index++) {
                if (sumNum[index] > 0) {
                    newSumNum[index + nums[i]] += sumNum[index];
                    newSumNum[index - nums[i]] += sumNum[index];
                }
            }
            sumNum = newSumNum;
        }
        return sumNum[S + 1000];
    }


}
