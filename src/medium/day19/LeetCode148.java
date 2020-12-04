package medium.day19;

import model.ListNode;
import model.Utils;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
//进阶：
//
//你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
public class LeetCode148 {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node4.next=node2;
        node2.next=node1;
        node1.next=node3;
        Utils.printList(sortList(node4));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode beforePre = null;
        ListNode pre = head;
        ListNode fastPre = head;
        while (fastPre != null && fastPre.next != null) {
            beforePre = pre;
            pre = pre.next;
            fastPre = fastPre.next.next;
        }
        if (beforePre != null) {
            beforePre.next = null;
        }
        ListNode list1 = sortList(head);
        ListNode list2 = sortList(pre);
        return mergeList(list1, list2);

    }


    public static ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                pre.next = list2;
                break;
            } else if (list2 == null) {
                pre.next = list1;
                break;
            } else if (list1.val <= list2.val) {
                pre.next = list1;
                pre = pre.next;
                list1 = list1.next;
            } else {
                pre.next = list2;
                pre = pre.next;
                list2 = list2.next;
            }
        }
        return head.next;
    }
}
