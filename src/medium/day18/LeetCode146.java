package medium.day18;

import java.util.HashMap;

//运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
//实现 LRUCache 类：
//
//LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
//int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
//void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
// 
//
//进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
public class LeetCode146 {
    //    ["LRUCache","put","put","get","put","put","get"]
//            [[2],[2,1],[2,2],[2],[1,1],[4,1],[2]
//    [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
//    ["LRUCache","get","put","get","put","put","get","get"]
//            [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 2);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
//        lruCache.put(1, 1);
//        lruCache.put(4, 1);
//        System.out.println(lruCache.get(2));
    }

    public static class LRUCache {
        HashMap<Integer, Node> map;
        Node head;
        Node last;
        int size;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            size = capacity;
        }

        public int get(int key) {
//
        }

        public void put(int key, int value) {
        }

        public static class Node {
            public int key;
            public int value;
            public Node next;
            public Node pre;
        }
    }
}
