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
                if ((root.left == null) && (root.right == null)) {  // 当前节点是叶子节点
                    paths.add(path);  // 把路径加入到答案中
                }
                else {
                    path += "->";  // 当前节点不是叶子节点，继续递归遍历
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
