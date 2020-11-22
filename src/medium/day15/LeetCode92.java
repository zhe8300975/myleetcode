package medium.day15;

import java.util.ArrayList;
import java.util.List;

//给定一个二叉树的根节点 root ，返回它的 中序 遍历。
public class LeetCode92 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        inorderTraversal(root,result);
        return result;
    }
    public static void inorderTraversal(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        if(root.left!=null){
            inorderTraversal(root.left,result);
        }
        result.add(root.val);
        if(root.right!=null){
            inorderTraversal(root.right,result);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
