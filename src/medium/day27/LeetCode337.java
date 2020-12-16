package medium.day27;

import model.TreeNode;

import java.util.HashMap;

//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
//
//计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
//
public class LeetCode337 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;
        node3.right = node5;
        System.out.println(rob(node1));
    }

    private static HashMap<TreeNode, Integer> select = new HashMap<>();
    private static HashMap<TreeNode, Integer> unSelect = new HashMap<>();

    public static int rob(TreeNode root) {
        dfs(root);
        return Math.max(select.getOrDefault(root,0), unSelect.getOrDefault(root,0));
    }

    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        select.put(root, root.val + unSelect.getOrDefault(root.left, 0) + unSelect.getOrDefault(root.right, 0));
        unSelect.put(root, Math.max(select.getOrDefault(root.left, 0), unSelect.getOrDefault(root.left, 0)) + Math.max(select.getOrDefault(root.right, 0), unSelect.getOrDefault(root.right, 0)));
    }

}
