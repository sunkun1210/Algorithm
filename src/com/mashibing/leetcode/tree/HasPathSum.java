package com.mashibing.leetcode.tree;

//112

/**
 * �ٶ��Ӹ��ڵ㵽��ǰ�ڵ��ֵ֮��Ϊ val�����ǿ��Խ����������ת��Ϊһ��С���⣺
 * �Ƿ���ڴӵ�ǰ�ڵ���ӽڵ㵽Ҷ�ӵ�·����������·����Ϊ sum - val��
 *
 * ���ѷ���������ݹ�����ʣ�����ǰ�ڵ����Ҷ�ӽڵ㣬��ô����ֱ���ж� sum �Ƿ���� val ����
 * ����Ϊ·�����Ѿ�ȷ�������ǵ�ǰ�ڵ��ֵ������ֻ��Ҫ�жϸ�·�����Ƿ�����������������ǰ�ڵ㲻��Ҷ�ӽڵ㣬
 * ����ֻ��Ҫ�ݹ��ѯ�������ӽڵ��Ƿ��������������ɡ�
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