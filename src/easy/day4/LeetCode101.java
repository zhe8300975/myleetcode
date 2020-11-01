package easy.day4;

public class LeetCode101 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node6;
        node3.right= node5;
        node3.left = node7;
        System.out.println(isSymmetric(node1));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isCheck(root.left, root.right);
    }

    public static boolean isCheck(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            if (left.val == right.val) {
                return isCheck(left.left, right.right) && isCheck(left.right, right.left);
            } else {
                return false;
            }
        } else if (left == null && right == null) {
            return true;
        } else {
            return false;
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
