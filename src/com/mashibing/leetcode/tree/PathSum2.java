package com.mashibing.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
//和上一题一样, 用DFS只不过在遍历时候,要记录val而已 113
public class PathSum2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        // 从根结点到叶子结点的路径
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, path, res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        sum =sum- root.val;
        if (root.left == null && root.right == null) {
            if (sum == 0) {
                // 正是因为每一次向下传递的过程中复制整个列表，在叶子结点出直接添加即可
                res.add(path);
                return;
            }
            return;
        }
        // 基本数据类型在方法传递过程中的行为是是复制
        // new ArrayList<>() 每一次向下传递的过程中复制整个列表，低效
        dfs(root.left, sum, new ArrayList<>(path), res);
        dfs(root.right, sum, new ArrayList<>(path), res);
        // 在递归结束以后无需「状态重置」
    }

    public static void main(String[] args) {
        PathSum2 pathSum2 = new PathSum2();
        List<List<Integer>> list =pathSum2.pathSum(pathSum2.init(),4);
        for (List<Integer> integers : list) {
            System.out.println("====");
            for (Integer integer : integers) {
                System.out.println(integer);
            }
        }
    }
    TreeNode init(){
        TreeNode treeNode= new TreeNode(1);
        TreeNode treeNode2= new TreeNode(2);
        TreeNode treeNode3= new TreeNode(3);
        TreeNode treeNode4= new TreeNode(1);
        TreeNode treeNode5= new TreeNode(5);
        treeNode.left=treeNode2;
        treeNode.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode2.right=treeNode5;
        return treeNode;
    }
}
