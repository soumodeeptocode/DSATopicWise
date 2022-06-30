package com.java.dp.knapsack.pattern;

import java.util.*;

public class knapsackBounded {

    static int knapsackBottomUp(int[] wt, int[] val, int n, int W){
        int dp[][] = new int[n][W+1];
        //Base Condition//
        for(int i = wt[0]; i <= W; i++){
            dp[0][i] = val[0];
        }

        for(int idx = 1; idx < n; idx++){
            for(int cap = 0; cap <= W; cap++){


                int notTaken = 0 + dp[idx-1][cap];

                int taken = Integer.MIN_VALUE;

                if(wt[idx] <= cap){
                    taken = val[idx] + dp[idx-1][cap - wt[idx]];
                }
                dp[idx][cap] = Math.max(notTaken, taken);
            }

        }
        return dp[n-1][W];
    }

    static int knapsackRec(int idx, int W, int[] wt, int[] val, int[][] dp){
        //base condition//
        if(idx == 0){
            if(wt[idx] <= W){
                return val[idx];
            }else{
                return 0;
            }
        }

        if(dp[idx][W] != -1) return dp[idx][W];

        //This is a not take case//
        int notTake = 0 + knapsackRec(idx-1, W, wt, val, dp);

        //This is a take case//
        int take = Integer.MIN_VALUE;

        if(wt[idx] <= W){
            take = val[idx] + knapsackRec(idx-1, W-wt[idx], wt,val,dp);
        }

        return dp[idx][W] = Math.max(notTake, take);
    }
    static int knapsack(int[] wt, int[] val, int W, int n){
        int dp[][] = new int[n][W+1];
        for(int row[]: dp){
            Arrays.fill(row, -1);
        }
        return knapsackRec(n-1, W, wt, val, dp);
    }
    public static void main(String[] args) {
        int wt[] = {1,2,4,5};
        int val[] = {5,4,8,6};

        int W = 5;

        int n = wt.length;

        System.out.println("The maximum value of items, thief can steal is :: "+ knapsack(wt, val, W, n));

        System.out.println("The maximum value of items, thief can steal is :: "+ knapsackBottomUp(wt, val, n, W));
    }
}
