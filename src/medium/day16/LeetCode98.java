package medium.day16;

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
        node10.left = node5;
        node10.right = node15;
        node15.left = node6;
        node15.right = node20;
//        node5.left=node1;
//        node5.left=node1;
//        node5.left=node1;
//        node5.left=node1;
        System.out.println(isValidBST(node10));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isCheck(root.left, root.val, Integer.MIN_VALUE, true) && isCheck(root.right, Integer.MAX_VALUE, root.val, false);
    }


    public static boolean isCheck(TreeNode root, int upper, int lower, boolean isLeft) {
        if (root == null) {
            return true;
        } else {
            if (root.val > lower && root.val < upper) {
                if (isLeft) {
                    return isCheck(root.left,  root.val, lower, true) && isCheck(root.right, upper, root.val, false);
                } else {
                    return isCheck(root.left, root.val, min, true) && isCheck(root.right, max, root.val, false);
                }
            } else {
                return false;
            }

        }
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
