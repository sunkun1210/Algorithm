package com.mashibing.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePaths {

    /*** Definition for a binary tree node.*/
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
        public void construct_paths(TreeNode root, String path, LinkedList<String> paths) {
            if (root != null) {
                path += Integer.toString(root.val);
                if ((root.left == null) && (root.right == null)) {  // ��ǰ�ڵ���Ҷ�ӽڵ�
                    paths.add(path);  // ��·�����뵽����
                }
                else {
                    path += "->";  // ��ǰ�ڵ㲻��Ҷ�ӽڵ㣬�����ݹ����
                    construct_paths(root.left, path, paths);
                    construct_paths(root.right, path, paths);
                }
            }
        }

        public List<String> binaryTreePaths(TreeNode root) {
            LinkedList<String> list = new LinkedList();
            construct_paths(root, "", list);
            return list;
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
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> list=   binaryTreePaths.binaryTreePaths(binaryTreePaths.init());
        for (String str : list) {
            System.out.println(str);
        }
    }
}
