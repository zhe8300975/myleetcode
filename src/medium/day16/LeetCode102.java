package medium.day16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
public class LeetCode102 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20);
        TreeNode node = new TreeNode(2147483647);
        node10.left = node5;
        node10.right = node15;
        node15.left = node6;
        node15.right = node20;
//        node5.left=node1;
//        node5.left=node1;
//        node5.left=node1;
//        node5.left=node1;
        List<List<Integer>> lists = levelOrder(node10);
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode node = deque.pop();
                list.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
