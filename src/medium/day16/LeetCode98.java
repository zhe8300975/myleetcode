package medium.day16;

import java.util.LinkedList;

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。
//
//假设一个二叉搜索树具有如下特征：
//
//节点的左子树只包含小于当前节点的数。
//节点的右子树只包含大于当前节点的数。
//所有左子树和右子树自身必须也是二叉搜索树。
public class LeetCode98 {

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
        System.out.println(isValidBST(node));
    }


    public static boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        while ((!stack.isEmpty()||root!=null)) {
            while (root != null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if(root.val<=inorder){
                return false;
            }
            inorder=root.val;
            root=root.right;
        }
        return true;
    }



//    public static boolean isValidBST(TreeNode root) {
//        return isCheck(root, null, null);
//    }
//
//
//    public static boolean isCheck(TreeNode root, Integer upper, Integer lower) {
//        if (root == null) {
//            return true;
//        } else {
//            if ((lower == null || root.val > lower) && (upper == null || root.val < upper)) {
//                return isCheck(root.left, root.val, lower) && isCheck(root.right, upper, root.val);
//            } else {
//                return false;
//            }
//
//        }
//    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
