package com.java.dp.string;

import java.util.Arrays;

public class LongestCommonSubsequence {
    static int findLcs(String s1, String s2, int idx1, int idx2, int[][] dp){
        //base condition//
        if(idx1 == 0 || idx2 == 0) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

        if(s1.charAt(idx1-1) == s2.charAt(idx2-1)){
            return dp[idx1][idx2] = 1 + findLcs(s1, s2, idx1-1, idx2-1, dp);
        }

        return dp[idx1][idx2] = Math.max(findLcs(s1, s2, idx1, idx2-1, dp), findLcs(s1, s2, idx1-1, idx2, dp));
    }

    static int findLcsbyBottomUp(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        //base condition//
        for(int i = 0; i <= n; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j <= m; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        for(int i = 0; i <=n; i++){
            for(int j = 0; j <=m; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[n][m];
    }

    static int findLcsbyTopDown(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return findLcs(s1,s2,n,m, dp);
    }
    public static void main(String[] args) {
        String s1 = "abcde";//"acd";
        String s2 = "bdgek";



        System.out.println("The Longest Common Subsequence :: "+findLcsbyTopDown(s1,s2));
        System.out.println("The Longest Common Subsequence :: "+findLcsbyBottomUp(s1,s2));
    }
}
