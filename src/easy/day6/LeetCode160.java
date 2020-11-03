package easy.day6;

//编写一个程序，找到两个单链表相交的起始节点。
public class LeetCode160 {

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node5.next=node6;
        node6.next=node3;
        ListNode intersectionNode = getIntersectionNode(node1, node5);
        System.out.println(intersectionNode==null?"null":intersectionNode.val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currentA = headA;
        ListNode currentB = headB;
        while (currentA!=currentB){
            currentA=currentA==null?headB:currentA.next;
            currentB=currentB==null?headA:currentB.next;
        }
        return currentA;

    }
//    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode currentA = headA;
//        ListNode currentB = headB;
//        while (currentA != null || currentB != null) {
//            if (currentA != null) {
//                if (currentA.next == currentA) {
//                    return currentA;
//                }
//                ListNode node = currentA;
//                currentA = currentA.next;
//                node.next = node;
//            }
//            if (currentB != null) {
//                if (currentB.next == currentB) {
//                    return currentB;
//                }
//                ListNode node = currentB;
//                currentB = currentB.next;
//                node.next = node;
//            }
//        }
//        return null;
//    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
