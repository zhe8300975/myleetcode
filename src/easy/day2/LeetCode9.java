package easy.day2;

//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
public class LeetCode9 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(1121));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int result=0;
        int x1=x;
        while(x1!=0){
            result=result*10+x1%10;
            x1/=10;
        }
        return result==x;
    }
}
