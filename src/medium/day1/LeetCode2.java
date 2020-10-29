package medium.day1;

//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
public class LeetCode2 {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listNode2 = new ListNode(4, new ListNode(5, new ListNode(6)));
        ListNode list = addTwoNumbers(listNode1, listNode2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode node = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            if (head == null) {
                head = node = new ListNode();
            } else {
                node.next = new ListNode();
                node = node.next;
            }
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            node.val = sum % 10;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
