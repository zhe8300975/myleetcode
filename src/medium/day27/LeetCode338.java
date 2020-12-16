package medium.day27;

import java.util.Arrays;

//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
//给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
//要求算法的空间复杂度为O(n)。
public class LeetCode338 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(10)));
    }

//    public static int[] countBits(int num) {
//        int[] dp=new int[num+1];
//        int k=2;
//        for(int i=0;i<=num;i++){
//            if(i==0||i==1){
//                dp[i]=i;
//            }else {
//                if(i==k){
//                    dp[i]=1;
//                    k*=2;
//                }else{
//                    dp[i]=dp[i-k/2]+1;
//                }
//            }
//        }
//        return dp;
//    }

    public static int[] countBits(int num) {
        int[] dp = new int[num + 1];
        int i = 0, b = 1;
        while (b <= num) {
            while (i < b && i + b <= num) {
                dp[i + b] = dp[i] + 1;
                ++i;
            }
            i = 0;
            b *= 2;
        }
        return dp;
    }


}
