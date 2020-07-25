package com.mashibing.leetcode.tree;

/** 235
 * 我们来复习一下二叉搜索树（BST）的性质：
 *
 * 节点 NN 左子树上的所有节点的值都小于等于节点 NN 的值
 * 节点 NN 右子树上的所有节点的值都大于等于节点 NN 的值
 * 左子树和右子树也都是 BST
 *
 */
public class LowestCommonAncestor {
    /*** Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Value of current node or parent node.
        int parentVal = root.val;
        // Value of p
        int pVal = p.val;
        // Value of q;
        int qVal = q.val;
        if (pVal > parentVal && qVal > parentVal) {
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (pVal < parentVal && qVal < parentVal) {
            // If both p and q are lesser than parent
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
}


