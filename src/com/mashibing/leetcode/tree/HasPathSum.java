package com.mashibing.leetcode.tree;

//112

/**
 * 假定从根节点到当前节点的值之和为 val，我们可以将这个大问题转化为一个小问题：
 * 是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val。
 *
 * 不难发现这满足递归的性质，若当前节点就是叶子节点，那么我们直接判断 sum 是否等于 val 即可
 * （因为路径和已经确定，就是当前节点的值，我们只需要判断该路径和是否满足条件）。若当前节点不是叶子节点，
 * 我们只需要递归地询问它的子节点是否能满足条件即可。
 */
class HasPathSum {

    /*** Definition for a binary tree node.*/
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
    }
    TreeNode init(){
        TreeNode treeNode= new TreeNode(1);
        TreeNode treeNode2= new TreeNode(2);
        TreeNode treeNode3= new TreeNode(3);
        TreeNode treeNode4= new TreeNode(4);
        TreeNode treeNode5= new TreeNode(5);
        treeNode.left=treeNode2;
        treeNode.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        return treeNode;
    }
    public static void main(String[] args) {
        HasPathSum hasPathSum =new HasPathSum();
        TreeNode treeNode=hasPathSum.init();
        System.out.println(hasPathSum.hasPathSum(treeNode,4));
    }

}