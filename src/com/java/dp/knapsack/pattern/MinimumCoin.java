package com.java.dp.knapsack.pattern;

import java.util.Arrays;

public class MinimumCoin {

    static int findMinCoins(int idx, int[] deno, int target, int[][] dp){
        //base condition//
        if(idx == 0){
            if(target % deno[idx] == 0){
                return target/deno[idx];
            }else{
                return (int)Math.pow(10,9);
            }
        }

        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = 0 + findMinCoins(idx-1, deno, target, dp);

        int take = (int)Math.pow(10,9);
        if(deno[idx] <= target){
            take = 1 + findMinCoins(idx, deno, target - deno[idx],  dp);
        }
        return dp[idx][target] = Math.min(notTake, take);
    }

    static int findMinCoinsbyTopDown(int[] deno, int n, int target){
        int[][] dp = new int[n][target+1];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
         return findMinCoins(n-1, deno, target, dp);
    }
    public static void main(String[] args) {
        int denomination[] = {9,6,5,1};
        int n = denomination.length;
        int target = 11;

        System.out.println("Minimum number of coins to form target :: "+findMinCoinsbyTopDown(denomination, n, target));
    }
}
