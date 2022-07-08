package com.java.dp.partition;

import java.util.Arrays;

public class PalindromePartioning {
    static int palindromePartitioningByBottomUp(String s){
        int n = s.length();
        int dp[] = new int[n+1];
        dp[n] = 0;

        for(int i = n-1; i >= 0; i--){
            int minCost = Integer.MAX_VALUE;
            for(int j = i; j < n; j++){
                if(isPalindrome(i, j, s)){
                    int cost = 1 + dp[j+1];
                    minCost = Math.min(cost, minCost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] -1;
    }
    static int palindromePartitioning(String s){
        int n = s.length();
        int dp[] = new int[n];

        Arrays.fill(dp, -1);
        return f(0, n, s, dp) -1;
    }
    static int f(int i, int n, String s, int[] dp){
        if(i == n) return 0;

        if(dp[i] != -1) return dp[i];

        int minCost = Integer.MAX_VALUE;
        for(int j = i; j < n; j++){
            if(isPalindrome(i, j, s)){
                int cost = 1 + f(j+1,n, s, dp);
                minCost = Math.min(minCost, cost);
            }
        }
        return dp[i] = minCost;
    }
    private static boolean isPalindrome(int i, int j, String s){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "bababcbadcede";
        System.out.println("Palindrome Partitioning ::"+palindromePartitioning(s));
        System.out.println("Palindrome Partitioning ::"+palindromePartitioningByBottomUp(s));
    }
}
