package com.java.dp.knapsack.pattern;

import java.util.Arrays;

public class MinimumCoin {

    static int findMinCoinsByBottomUp(int[] deno, int target){
        int n = deno.length;
        int dp[][] = new int[n][target+1];
        //base condition//
        for(int i = 0; i <= target; i++){
            if(i % deno[0] == 0){
                dp[0][i] = i / deno[0];
            }else{
                dp[0][i] = (int)Math.pow(10,9);
            }
        }
        doPrint(dp);
        for(int i = 1; i < n; i++){
            for(int t = 0; t <= target; t++){

                int notTake = 0 + dp[i-1][t];
                int take = (int)Math.pow(10,9);
                if(deno[i] <= t){
                    take = 1 + dp[i][t - deno[i]];
                }
                dp[i][target] = Math.min(notTake, take);
            }
        }
        doPrint(dp);
        int ans = dp[n-1][target];
        if(ans >= (int)Math.pow(10,9)){
            return -1;
        }
        return ans;
    }

    private static void doPrint(int[][] dp){
        for(int row[]: dp){
            for(int idx: row){
                System.out.print(idx);
            }
            System.out.println();
        }
    }

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
        int denomination[] = {1,2,3};//{9,6,5,1};
        int n = denomination.length;
        int target = 7;//11;

        System.out.println("Minimum number of coins to form target :: "+findMinCoinsbyTopDown(denomination, n, target));

        System.out.println("Minimum number of coins to form target :: "+findMinCoinsByBottomUp(denomination, target));
    }
}
