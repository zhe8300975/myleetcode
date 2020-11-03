package easy.day6;

import java.util.HashMap;

public class LeetCode169 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
    public static int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        if(nums.length==1){
            return nums[0];
        }
        for(int i:nums){
            Integer integer = map.get(i);
            if(integer==null){
                map.put(i,1);
            }else{
                map.put(i,++integer);
                if(integer>nums.length/2){
                    return i;
                }
            }
        }
        return -1;
    }
}
