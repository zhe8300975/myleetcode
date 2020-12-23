package medium.day29;
//给定一个二叉树，它的每个结点都存放着一个整数值。
//
//找出路径和等于给定数值的路径总数。
//
//路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

import model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode437 {
    public static void main(String[] args) {
        TreeNode node1=new TreeNode(10);
        TreeNode node2=new TreeNode(5);
        TreeNode node3=new TreeNode(-3);
        TreeNode node4=new TreeNode(3);
        TreeNode node5=new TreeNode(2);
        TreeNode node6=new TreeNode(11);
        TreeNode node7=new TreeNode(3);
        TreeNode node8=new TreeNode(-2);
        TreeNode node9=new TreeNode(1);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        node3.right=node6;
        node4.left=node7;
        node4.right=node8;
        node5.right=node9;
        System.out.println(pathSum(node1,8));
    }

    public static int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }

    private static int recursionPathSum(TreeNode node, Map<Integer, Integer> map, int target, int currSum) {
        if (node == null) {
            return 0;
        }
        int res=0;
        currSum+=node.val;
        res+=map.getOrDefault(currSum-target,0);
        map.put(currSum,map.getOrDefault(currSum, 0) + 1);
        res+=recursionPathSum(node.left,map,target,currSum);
        res+=recursionPathSum(node.right,map,target,currSum);
        map.put(currSum,map.get(currSum)-1);
        return res;
    }

}
