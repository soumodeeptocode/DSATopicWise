package com.java.dp.knapsack.pattern;

import java.util.Arrays;

public class GridPath {

    static int countWaysRecursive(int i, int j, int[][] dp){
        //base conditions//
        if(i == 0 && j == 0) return 1;
        //exceeding boundary//
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int up = countWaysRecursive(i-1, j, dp);
        int left = countWaysRecursive(i, j-1, dp);

       return dp[i][j] = up + left;
    }

    static int countWaysBottomUp(int M, int N, int[][] dp){
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                //base condition//
                if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if(i > 0){
                    up = dp[i-1][j];
                }
                if( j > 0){
                    left = dp[i][j-1];
                }

                dp[i][j] = up + left;
            }
        }
        return dp[M-1][N-1];
    }

    static int countWays(int M, int N){
        int dp[][] = new int[M][N];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        //return countWaysRecursive(M-1, N-1, dp);
        return countWaysBottomUp(M, N, dp);
    }
    public static void main(String[] args) {
        int M = 2;
        int N = 3;
        System.out.println(countWays(M,N));

    }
}
