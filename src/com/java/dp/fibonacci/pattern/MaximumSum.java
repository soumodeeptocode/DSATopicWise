package com.java.dp.fibonacci.pattern;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class MaximumSum {


    static int solveBottomUp(int n, int[] arr, int[] dp){
        dp[0] = arr[0];

        for(int i = 1; i < n; i++){
            int pick = arr[i];
            if(i > 1) pick += dp[i-2];
            int skip = 0 + dp[i-1];

            dp[i] = Math.max(pick, skip);
        }
        return dp[n-1];
    }

        static int solveBottom(int n, int[] arr){
                int[] dp = new int[n];
            Arrays.fill(dp, -1);
            return solveBottomUp(n, arr, dp);
        }

    static int solveRecur(int idx, int[] arr, int[] dp){
        //base condition//
        if(idx == 0) return arr[idx];
        if(idx < 0) return 0;
        //dp step//
        if(dp[idx] != -1) return dp[idx];
        int pick = arr[idx] + solveRecur(idx-2, arr, dp);
        int skip = 0 + solveRecur(idx-1, arr, dp);
        return dp[idx] = Math.max(pick, skip);
    }

    static int solve(int n, int[] arr){
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return solveRecur(n-1, arr, dp);
    }
    public static void main(String[] args) {
        int arr[] = {2,1,4,9};
        int n = arr.length;
        System.out.println(solve(n, arr));

        System.out.println(solveBottom(n, arr));

    }
}
