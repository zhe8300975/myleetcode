package medium.day25;

public class LeetCode287 {
    public static void main(String[] args) {
System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }

    public static int findDuplicate(int[] nums) {
        int min = 1, max = nums.length - 1, ans = -1;
        while (max >= min) {
          int mid=(max+min)/2;
          int count=0;
          for(int i=0;i<nums.length;i++){
              if(nums[i]<=mid){
                  count++;
              }
          }
          if(count<=mid){
              min=mid+1;
          }else{
              max=mid-1;
              ans = mid;
          }
        }
        return ans;
    }

}
