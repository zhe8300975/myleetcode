package medium.day10;

//给你一个升序排列的整数数组 nums ，和一个整数 target 。
//
//假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
//
//请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
public class LeetCode33 {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3}, 2));
    }


    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (end > start) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                start = mid;
            } else if (nums[mid] < nums[start] && nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        if (end == start && nums[start] == target) {
            return start;
        }
        return -1;
    }


//    public static int search(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
