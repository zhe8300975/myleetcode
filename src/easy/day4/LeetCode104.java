package easy.day4;

public class LeetCode104 {

    public static void main(String[] args) {
        LeetCode104.TreeNode node1 = new LeetCode104.TreeNode(1);
        LeetCode104.TreeNode node2 = new LeetCode104.TreeNode(2);
        LeetCode104.TreeNode node3 = new LeetCode104.TreeNode(2);
        LeetCode104.TreeNode node4 = new LeetCode104.TreeNode(3);
        LeetCode104.TreeNode node5 = new LeetCode104.TreeNode(3);
        LeetCode104.TreeNode node6 = new LeetCode104.TreeNode(4);
        LeetCode104.TreeNode node7 = new LeetCode104.TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node6;
        node3.right = node5;
        node3.left = node7;
        System.out.println(maxDepth(node1));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
