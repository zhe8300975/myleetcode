package medium.day31;

import java.util.LinkedList;

public class LeetCode581 {
    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2,1}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int l=-1,r=-2;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                min=Math.min(min,nums[i]);
            }
        }
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>nums[i+1]){
                max=Math.max(max,nums[i]);
            }
        }
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>min){
                l=i;
                break;
            }
        }
        for(int i=nums.length-1;i>=0;i--) {
            if(nums[i]<max){
                r=i;
                break;
            }
        }
        return r-l+1;
    }

//    public static int findUnsortedSubarray(int[] nums) {
//        LinkedList<Integer> stack = new LinkedList<>();
//        int l = nums.length, r = -1;
//        for (int i = 0; i < nums.length; i++) {
//            while (!stack.isEmpty() && nums[stack.peekLast()] > nums[i]) {
//                l = Math.min(l, stack.pollLast());
//            }
//            stack.offerLast(i);
//        }
//        stack.clear();
//        for (int i = nums.length - 1; i >= 0; i--) {
//            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i]) {
//                r = Math.max(r, stack.pollLast());
//            }
//            stack.offerLast(i);
//        }
//        return r - l + 1;
//    }
}
