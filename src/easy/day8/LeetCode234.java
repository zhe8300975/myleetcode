package easy.day8;

//请判断一个链表是否为回文链表
//进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
public class LeetCode234 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        System.out.println(isPalindrome(node1));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middleNode = endOfFirstHalf(head);
        ListNode reversalNode = reversalList(middleNode.next);
        middleNode.next = reversalNode;
        boolean result = true;
        while (head != null && reversalNode != null) {
            if (head.val != reversalNode.val) {
                result = false;
                break;
            }
            head = head.next;
            reversalNode = reversalNode.next;
        }
        middleNode.next = reversalList(middleNode.next);
        return result;
    }

    //    public static ListNode reversalList(ListNode head) {
//        if (head.next == null) {
//            return head;
//        } else {
//            ListNode result = reversalList(head.next);
//            head.next.next = head;
//            head.next = null;
//            return result;
//        }
//    }
    public static ListNode reversalList(ListNode head) {
        ListNode pre = head;
        ListNode newHead = null;
        while (pre != null) {
            ListNode next = pre.next;
            pre.next = newHead;
            newHead = pre;
            pre = next;
        }
        return newHead;
    }

    public static ListNode endOfFirstHalf(ListNode head) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        return slowNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
