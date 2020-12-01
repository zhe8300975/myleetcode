package medium.day17;

import model.TreeNode;
import model.Utils;

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
//注意:
//你可以假设树中没有重复的元素。
//
//例如，给出
//
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
public class LeetCode105 {
    public static void main(String[] args) {
        Utils.printTree(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(preorder, 0, inorder, 0, preorder.length);
    }

    public static TreeNode createTree(int[] preorder, int preorderStart, int[] inorder, int inorderStart, int size) {
        if (size == 0) {
            return null;
        } else {
            TreeNode root = new TreeNode(preorder[preorderStart]);
            int rootNum = preorder[preorderStart];
            for (int i = 0; i < size; i++) {
                if (inorder[inorderStart + i] == rootNum) {
                    root.left = createTree(preorder, preorderStart + 1, inorder, inorderStart, i);
                    root.right = createTree(preorder, preorderStart + i + 1, inorder, inorderStart + i + 1, size - i - 1);
                }
            }
            return root;
        }
    }
}
