package easy.day3;



//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
public class LeetCode21 {
    public static void main(String[] args) {
        ListNode listNode1 = new LeetCode21.ListNode(1, new LeetCode21.ListNode(8, new LeetCode21.ListNode(9)));
        ListNode listNode2 = new LeetCode21.ListNode(4, new LeetCode21.ListNode(5, new LeetCode21.ListNode(6)));
        ListNode node=mergeTwoLists(listNode1,listNode2);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head,prev;
        prev=head=new ListNode();
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                prev.next=l1;
                l1=l1.next;
            }else{
                prev.next=l2;
                l2=l2.next;
            }
            prev=prev.next;
        }
        prev.next=l1==null?l2:l1;
        return head.next;
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
