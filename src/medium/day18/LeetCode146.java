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
            head = new Node();
            last = new Node();
            head.next = last;
            last.pre = head;
            map = new HashMap<>();
            size = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                removeNode(node);
                addToLast(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node == null) {
                Node node1 = new Node();
                node1.value = value;
                node1.key = key;
                addToLast(node1);
            } else {
                removeNode(node);
                node.value=value;
                addToLast(node);
            }
        }

        public void addToLast(Node node) {
            if (size == map.size()) {
                removeHead();
            }
            last.pre.next = node;
            node.pre = last.pre;
            last.pre = node;
            node.next = last;
            map.put(node.key, node);
        }

        public void removeHead() {
            if (size >= 1) {
                Node node = head.next;
                head.next = head.next.next;
                head.next.pre = head;
                map.remove(node.key);
            }
        }

        public void removeNode(Node node) {
            if (size >= 1) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                map.remove(node.key);
            }
        }


        public static class Node {
            public int key;
            public int value;
            public Node next;
            public Node pre;
        }
    }
}
