package medium.day21;

//215. 数组中的第K个最大元素
public class LeetCode215 {
    public static void main(String[] args) {

        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    public static int findKthLargest(int[] nums, int startIndex, int endIndex, int k) {
        //快排 分堆
        int i = startIndex, pivot = endIndex;
        for (int index = startIndex; index <= endIndex - 1; index++) {
            if (nums[index] < nums[pivot]) {
                int swap = nums[index];
                nums[index] = nums[i];
                nums[i] = swap;
                i++;
            }
        }
        int swap = nums[pivot];
        nums[pivot] = nums[i];
        nums[i] = swap;

        int index = nums.length - k;
        if (index == i) {
            return nums[i];
        } else if (index > i) {
            return findKthLargest(nums, i + 1, endIndex, k);
        } else {
            return findKthLargest(nums, startIndex, i - 1, k);
        }

    }
}
