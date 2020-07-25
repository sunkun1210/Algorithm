package com.mashibing.leetcode.dynamicProgramming;

//64
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        int rows=grid.length;
        int columns=grid[0].length;
        int[][] dp = new int[rows][columns];
        dp[0][0]=grid[0][0];
        for(int i=1;i<rows;i++){
            dp[i][0]= dp[i-1][0]+grid[i][0];
        }
        for(int j=1;j<columns;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<rows;i++){
            for(int j=1;j<columns;j++){
                dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+grid[i][j];// TODO
            }
        }
        return dp[rows-1][columns-1];
    }

    public static void main(String[] args) {
        MinPathSum minPathSum = new MinPathSum();
        int[][] grid = new int[][]{{1,3,4,8},{3,2,2,4},{5,7,1,9},{2,3,2,3}};
        System.out.println(minPathSum.minPathSum(grid));
    }

}
