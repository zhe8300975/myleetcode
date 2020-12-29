package medium.day31;
//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
//
//例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//
//提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    public static int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Arrays.fill(ans, 0);
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < T.length - 1; i++) {
            if (T[i] < T[i + 1]) {
                ans[i] = 1;
                while (!stack.isEmpty() && T[stack.peekLast()] < T[i + 1]) {
                    int index = stack.pollLast();
                    ans[index] = i + 1 - index;
                }
            } else {
                stack.offerLast(i);
            }
        }
        return ans;
    }


//        public static int[] dailyTemperatures(int[] T) {
//        int[] ans = new int[T.length];
//        Arrays.fill(ans, 0);
//        for (int i = 0; i < T.length - 1; i++) {
//            for (int j = i + 1; j < T.length; j++) {
//                if (T[j] > T[i]) {
//                    ans[i] = j - i;
//                    break;
//                }
//            }
//        }
//        return ans;
//
//    }
}
