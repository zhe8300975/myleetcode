package medium.day14;
//给出一个区间的集合，请合并所有重叠的区间。
// 示例 1:
// 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 示例 2:
//
// 输入: intervals = [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LeetCode56 {
    public static void main(String[] args) {
        int[][] num = {{4, 5}, {1, 4}, {0, 1}};
        int[][] merge = merge(num);
        for (int[] item : merge) {
            System.out.println(Arrays.toString(item));
        }
    }


    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (list.size() == 0) {
                list.add(intervals[i]);
            } else {
                if (list.get(list.size() - 1)[1] >= intervals[i][0]) {
                    list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
                } else {
                    list.add(intervals[i]);
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }

//    public static int[][] merge(int[][] intervals) {
//        for (int i = 0; i < intervals.length - 1; i++) {
//            for (int k = intervals.length - 1; k >i; k--) {
//                if (intervals[k - 1][0] > intervals[k][0]) {
//                    int start, end;
//                    start = intervals[k - 1][0];
//                    end = intervals[k - 1][1];
//                    intervals[k - 1][0] = intervals[k][0];
//                    intervals[k - 1][1] = intervals[k][1];
//                    intervals[k][0] = start;
//                    intervals[k][1] = end;
//                }
//            }
//        }
//        ArrayList<int[]> list = new ArrayList<>();
//        for (int i = 0; i < intervals.length; i++) {
//            if (list.size() == 0) {
//                list.add(intervals[i]);
//            } else {
//                if (list.get(list.size() - 1)[1] >= intervals[i][0]) {
//                    list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
//                } else {
//                    list.add(intervals[i]);
//                }
//            }
//        }
//
//        return list.toArray(new int[list.size()][]);
//    }
}
