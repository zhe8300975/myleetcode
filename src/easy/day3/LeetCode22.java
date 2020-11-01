package easy.day3;

public class LeetCode22 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int result=nums[0];
        int sum=0;
        for(int num:nums){
            sum=sum>0?sum+num:num;
            result=result>sum?result:sum;
        }
        return result;
    }

}
