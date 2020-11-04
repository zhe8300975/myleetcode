package medium.day6;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {


    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result=new ArrayList();
        Arrays.sort(nums);
        int l=nums.length;
        for(int i=0;i<l-3;i++){
            if(i!=0&&nums[i]==nums[i-1]){
                continue;
            }
            int end=l-1;
            for(int start = i+1;start<l-2;start++){
                if(start!=i+1&&nums[start]==nums[start-1]){
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (start < end && nums[start] + nums[end] > -nums[i]) {
                    end--;
                }
                if(start==end){
                    continue;
                }
               if(nums[start]+nums[end]+nums[i]==0){
                   ArrayList<Integer> list= new ArrayList<>();
                   list.add(nums[start]);
                   list.add(nums[end]);
                   list.add(nums[i]);
                   result.add(list);
               }
            }
        }
        return result;
    }
}
