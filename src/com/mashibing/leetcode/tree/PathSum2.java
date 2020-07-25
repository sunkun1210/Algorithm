package com.mashibing.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
//����һ��һ��, ��DFSֻ�����ڱ���ʱ��,Ҫ��¼val���� 113
public class PathSum2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        // �Ӹ���㵽Ҷ�ӽ���·��
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
                // ������Ϊÿһ�����´��ݵĹ����и��������б���Ҷ�ӽ���ֱ����Ӽ���
                res.add(path);
                return;
            }
            return;
        }
        // �������������ڷ������ݹ����е���Ϊ���Ǹ���
        // new ArrayList<>() ÿһ�����´��ݵĹ����и��������б���Ч
        dfs(root.left, sum, new ArrayList<>(path), res);
        dfs(root.right, sum, new ArrayList<>(path), res);
        // �ڵݹ�����Ժ����衸״̬���á�
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
