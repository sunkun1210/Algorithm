package com.mashibing.leetcode.dynamicProgramming;

/***  1143
 * �������������� S1 �� S2���ҳ�������Ĺ��������С�
 *
 * ����һ����ά���� dp �����洢����������еĳ��ȣ�
 * ���� dp[i][j] ��ʾ S1 ��ǰ i ���ַ��� S2 ��ǰ j ���ַ�����������еĳ��ȡ����� S1i �� S2j ֵ�Ƿ���ȣ���Ϊ���������
 *
 * �� S1i==S2j ʱ����ô������ S1 ��ǰ i-1 ���ַ��� S2 ��ǰ j-1 ���ַ�����������еĻ������ټ��� S1i ���ֵ��
 * ����������г��ȼ� 1���� dp[i][j] = dp[i-1][j-1] + 1��
 * �� S1i != S2j ʱ����ʱ�����������Ϊ S1 ��ǰ i-1 ���ַ��� S2 ��ǰ j ���ַ�����������У�
 * ���� S1 ��ǰ i ���ַ��� S2 ��ǰ j-1 ���ַ�����������У�ȡ���ǵ�����ߣ��� dp[i][j] = max{ dp[i-1][j], dp[i][j-1] }��
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return  dp[m][n];
    }


    public static void main(String[] args) {
        String text1="a";
        String text2="a";
        LongestCommonSubsequence longestCommonSubsequen= new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequen.longestCommonSubsequence(text1,text2));
    }

    public int longestCommonSubsequence2(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() == 0 || str2.length() == 0)
            return 0;
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
