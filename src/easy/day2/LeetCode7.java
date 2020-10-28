package easy.day2;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
public class LeetCode7 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(reverse(123));
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < 0 && (result < Integer.MIN_VALUE / 10 || (Integer.MIN_VALUE / 10 == result && x % 10 < Integer.MIN_VALUE % 10)))
                return 0;
            if (result > 0 && (result > Integer.MAX_VALUE / 10 || (Integer.MAX_VALUE / 10 == result && x % 10 > Integer.MAX_VALUE % 10)))
                return 0;
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        return result;
    }

}
