package medium.day8;

public class LeetCode19 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next=node4;
        node4.next=node5;
        ListNode node = removeNthFromEnd(node1, 1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currentNode = head;
        ListNode  node= head;
        for (int i = 0; i < n; i++) {
            if (currentNode != null) {
                currentNode = currentNode.next;
            } else {
                return null;
            }
        }
        if(currentNode==null){
            return head.next;
        }
        while (currentNode.next!= null) {
            currentNode = currentNode.next;
            node = node.next;
        }
        if (node.next != null) {
            node.next = node.next.next;
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
