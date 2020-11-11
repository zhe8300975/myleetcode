package easy.day9;

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
public class LeetCode543 {
    public static void main(String[] agrs) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(diameterOfBinaryTree(node1));
    }

    static int result = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root != null) {
            deepOfBinaryTree(root);
        }
        return result;
    }

    public static int deepOfBinaryTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int left = 0, right = 0;
        int leftDeep = 0, rightDeep = 0;
        if (root.left != null) {
            left = deepOfBinaryTree(root.left);
            leftDeep = left + 1;
        }
        if (root.right != null) {
            right = deepOfBinaryTree(root.right);
            rightDeep = right + 1;
        }
        result = Math.max(result, leftDeep + rightDeep);
        return Math.max(right, left) + 1;
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
