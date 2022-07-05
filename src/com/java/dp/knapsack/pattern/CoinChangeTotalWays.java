package com.java.dp.knapsack.pattern;

import java.lang.annotation.Target;
import java.util.*;

public class CoinChangeTotalWays {


    static int findTotalWays(int idx, int[] deno, int target, int[][] dp){
        //
        if(idx == 0){
            if(target % deno[0] == 0){
                return 1;
            }else return 0;
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = findTotalWays(idx-1, deno, target, dp);
        int take = 0;
        if(deno[idx] <= target){
            take = findTotalWays(idx,deno, target - deno[idx], dp);
        }
        return dp[idx][target] = take + notTake;
    }
    static int findTotalWaysTopDown(int[] deno, int n, int target){
        int dp[][] = new int[n][target+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return findTotalWays(n-1, deno, target, dp);
    }

    static int findTotalWaysBottomUp(int[] deno, int target, int n){
        int[][] dp = new int[n][target+1];

        //base condition//
        for(int i = 0; i <= target; i++){
            if(i % deno[0] == 0){
                 dp[0][i] = 1;
            }else{
                dp[0][i] = 0;
            }
        }

        //
        for(int idx = 1; idx < n; idx++){
            for(int t = 0; t <=target; t++){
                int notTake = dp[idx-1][t];
                int take = 0;
                if(deno[idx] <= t){
                    take = dp[idx][t - deno[idx]];
                }
                dp[idx][t] = take + notTake;
            }
        }
        return dp[n-1][target];
    }
    public static void main(String[] args) {
        int deno[] = {1,2,3};
        int n = deno.length;
        int target = 4;

        System.out.println("Total Number of ways to for target :: "+findTotalWaysTopDown(deno, n, target));

        System.out.println("Total Number of ways to for target :: "+findTotalWaysBottomUp(deno, target, n));
    }
}
