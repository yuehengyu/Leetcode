package com.yhy.leetcode.tree;

public class AddNodeToBinaryTree {


    public static TreeNode addNode(TreeNode root, int target) throws Exception {
        if (root == null)
            return new TreeNode(target);

        //如果已经存在就直接抛出异常
        if (target == root.val)
            throw new Exception();

        if (target > root.val)
            if (root.right != null) {
                addNode(root.right, target);
            } else {
                root.right = new TreeNode(target);
            }


        if (target < root.val)
            if (root.left != null) {
                addNode(root.left, target);
            } else {
                root.left = new TreeNode(target);
            }
        return root;
    }


    public static void reverseTree(TreeNode root) {
        if (root == null)
            return;

        TreeNode temp = root.right;
        root.left = root.right;
        root.right = temp;

        reverseTree(root.left);
        reverseTree(root.right);
    }


    public void addReverse(TreeNode root, int element) throws Exception {
        root = addNode(root, element);
        reverseTree(root);
    }
}
