package easy.day5;

public class LeetCode136 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));

    }

    public static int singleNumber(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }
}
