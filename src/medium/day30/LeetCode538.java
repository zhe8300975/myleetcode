package medium.day30;

import model.TreeNode;
import model.Utils;

public class LeetCode538 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(3);
        TreeNode node9 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.right = node8;
        node7.right = node9;
        Utils.printTree(node1);
        Utils.printTree(convertBST(node1));
    }

//    public static TreeNode convertBST(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        convertBST(root, 0);
//        return root;
//    }
//
//    public static int convertBST(TreeNode root, int sum) {
//        if (root.right != null) {
//            root.val += convertBST(root.right, sum);
//        } else {
//            root.val += sum;
//        }
//        if (root.left != null) {
//            return convertBST(root.left, root.val);
//        }
//        return root.val;
//    }

    static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}
