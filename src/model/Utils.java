package model;

import java.util.LinkedList;

public class Utils {
    private Utils() {
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        printTree(node1);
    }

    //层序打印
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("root = null");
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offerLast(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            for (int i = 0; i < levelCount; i++) {
                TreeNode node = queue.pollFirst();
                System.out.print(node.val + "-");
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }
        }
        System.out.println();

    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }


}
