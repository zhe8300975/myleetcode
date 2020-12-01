package medium.day17;

import model.TreeNode;
import model.Utils;

//给定一个二叉树，原地将它展开为一个单链表。
//例如，给定二叉树
//
//    1
//   / \
//  2   5
// / \   \
//3   4   6
//将其展开为：
//
//1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
//
public class LeetCode114 {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node2.left=node3;
        node2.right=node4;
        node1.right=node5;
        flatten(node1);
        Utils.printTree(node1);
    }

    private static TreeNode head = new TreeNode(0);
    private static TreeNode pre = head;

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        pre.right = root;
        pre = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left=null;
        root.right=null;
        flatten(left);
        flatten(right);
    }
}
