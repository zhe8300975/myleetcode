package medium.day23;

import model.TreeNode;

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//
//例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
public class LeetCode236 {

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node4;
        node2.right = node7;
        TreeNode node = lowestCommonAncestor(node3, node5, node1);
        System.out.println(node.val);
    }
    static TreeNode leastNode;

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestor1(root, p, q);
        return leastNode;
    }

    public static boolean lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = lowestCommonAncestor1(root.left, p, q);
        boolean right = lowestCommonAncestor1(root.right, p, q);
        if ((left && right) || (root.val == p.val || root.val == q.val) && (left || right)) {
            leastNode = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }


}
