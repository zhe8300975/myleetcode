package medium.day11;

import java.util.Arrays;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//你的算法时间复杂度必须是 O(log n) 级别。
//
//如果数组中不存在目标值，返回 [-1, -1]。
public class LeetCode34 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10},8)));
    }

    public static int extremeInsertionIndex(int[] nums, int target, boolean left){
        int start=0;
        int end =nums.length;
        while(end>start){
            int mid=(end+start)/2;
            if(target<nums[mid]||(left&&nums[mid]==target)){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return start;
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);
        if(leftIdx==nums.length||nums[leftIdx]!=target){
            return targetRange;
        }
        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;
        return targetRange;
    }
}
