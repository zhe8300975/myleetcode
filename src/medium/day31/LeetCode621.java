package medium.day31;
//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
//
//然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
//
//你需要计算完成所有任务所需要的 最短时间 。

import java.util.HashMap;
import java.util.Map;

public class LeetCode621 {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int maxExec = 0;
        for (char car : tasks) {
            map.put(car, map.getOrDefault(car, 0) + 1);
            maxExec = Math.max(maxExec, map.getOrDefault(car, 0));
        }
        int maxCount = 0;
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            int value = item.getValue();
            if (value == maxExec) {
                maxCount++;
            }
        }
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

}

