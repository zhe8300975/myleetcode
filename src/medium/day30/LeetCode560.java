package medium.day30;

import java.util.HashMap;

public class LeetCode560 {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return ans;
    }

//    public static int subarraySum(int[] nums, int k) {
//        int sum = 0;
//        int max = nums.length * 1000;
//        if (k > max || k < -max) {
//            return 0;
//        }
//        int[] sumNum = new int[max * 2 + 1];
//        Arrays.fill(sumNum, 0);
//        sumNum[nums[0] + max] += 1;
//        if (nums[0] == k) sum++;
//        for (int i = 1; i < nums.length; i++) {
//            int[] newSumNum = new int[max * 2 + 1];
//            Arrays.fill(newSumNum, 0);
//            newSumNum[nums[i] + max] += 1;
//            for (int n = 0; n < max * 2 + 1; n++) {
//                if (sumNum[n] > 0) {
//                    newSumNum[n + nums[i]] += sumNum[n];
//                }
//            }
//            sum += newSumNum[k + max];
//            sumNum = newSumNum;
//        }
//        return sum;
//
//    }
}
