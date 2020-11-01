package easy.day4;

public class LeetCode70 {
    public static void main(String[] args) {
        for(int i=0;i<6;i++) {
            System.out.println(climbStairs(i));
        }
    }

    public static int climbStairs(int n) {
        if(n==0){
            return 0;
        }
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                num[i] = 1;
            } else if (i == 1) {
                num[i] = 2;
            } else {
                num[i] = num[i - 1] + num[i - 2] ;
            }
        }
        return num[n-1];
    }
}
