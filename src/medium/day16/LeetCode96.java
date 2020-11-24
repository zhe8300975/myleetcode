package medium.day16;

//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
public class LeetCode96 {

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int n) {
        int[] g=new int [n+1];
        g[0]=1;
        g[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                g[i]+=g[j-1]*g[i-j];
            }
        }
        return g[n];
    }


//    public static int numTrees(int n) {
//        if (n == 1 || n == 0) {
//            return 1;
//        } else {
//            int result = 0;
//            for (int left = 0; left <= n - 1; left++) {
//                result += numTrees(left) * numTrees(n - 1 - left);
//            }
//            return result;
//        }
//    }
}
