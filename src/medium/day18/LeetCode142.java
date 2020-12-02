package medium.day18;

import model.ListNode;

//142. 环形链表 II
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
//
public class LeetCode142 {
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
        node4.next=node5;
        node5.next=node6;
        node6.next=node2;
        System.out.println(detectCycle(node1).val);
    }

    public static ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=head;
        ListNode fastPre=head;
        while (fastPre!=null){
            pre=pre.next;
            if(fastPre.next==null){
                break;
            }
            fastPre=fastPre.next.next;
            if(pre==fastPre){
                ListNode cur=head;
                while (cur!=fastPre){
                    cur=cur.next;
                    fastPre=fastPre.next;
                }
                return cur;
            }
        }
        return null;
    }
}
