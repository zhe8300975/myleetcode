package medium.day21;

import java.util.ArrayList;
import java.util.HashMap;
//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
//
//在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
//
//给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

public class LeetCode207 {
    public static void main(String[] args) {

        System.out.println(canFinish(2, new int[][]{}));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int[] outDegree = new int[numCourses];

        //初始化入度 出度
        for (int[] item : prerequisites) {
            ArrayList<Integer> arrayList = map.get(item[1]);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(item[0]);
            map.put(item[1], arrayList);
            outDegree[item[0]]++;
        }
        int key = -1;
        for (int i = 0; i < numCourses; i++) {
            if (outDegree[i] == 0) {
                key = i;
                break;
            }
        }
        int visited = 0;
        while (key != -1) {
            visited++;
            outDegree[key]--;
            ArrayList<Integer> inList = map.get(key);
            if (inList != null && inList.size() > 0) {
                for (int item : inList) {
                    outDegree[item]--;
                }
            }
            key = -1;
            for (int i = 0; i < numCourses; i++) {
                if (outDegree[i] == 0) {
                    key = i;
                    break;
                }
            }
        }
        return visited == numCourses;

    }
}
