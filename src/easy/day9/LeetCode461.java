package easy.day9;

//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//
//给出两个整数 x 和 y，计算它们之间的汉明距离。
//
//注意：
//0 ≤ x, y < 231.
public class LeetCode461 {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }

    public static int hammingDistance(int x, int y) {
        int k = x ^ y;
        int n = 0;
        while (k != 0) {
            n += k % 2;
            k = k >> 1;
        }
        return n;
    }
}
