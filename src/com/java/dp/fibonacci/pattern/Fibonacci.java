/*
    Fibonacci series solution with Top-Down and Bottom-Up Approach
*/

package com.java.dp.fibonacci.pattern;

import java.util.Arrays;


public class Fibonacci {
    static int count = 0;
    static int countWithoutDp = 0;
    static int[] memo;

    static int findFibonacciwithoutDP(int n) {
        countWithoutDp += 1;
        //base condition//
        if(n == 0) return 0;
        if(n == 1) return 1;

        return findFibonacciwithoutDP(n-1) + findFibonacciwithoutDP(n-2);
    }
    static int findFibonacci(int n) {
        count += 1;
        //base condition//
        if(n == 0) return 0;
        if(n == 1) return 1;

        if(memo[n] != -1) return memo[n];

        memo[n] = findFibonacci(n-1) + findFibonacci(n-2);
        return memo[n];
    }

    static int findFibonacciUsingBottomUp(int n){
        int[] dp = new int[n+1];
        int prev = 0;
        int prev1 = 1;
        int current;
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i<= n; i++){
            //dp[i] = dp[i-1] + dp[i-2];
            current = prev + prev1;
            prev = prev1;
            prev1 = current;
        }
        return prev1;
    }

    //0 1 1 2 3 5 8 13

    public static void main(String[] args) {
        int n = 20;
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        int fib = findFibonacci(n);
        System.out.println("Memoization");
        System.out.println("Total Count :: "+count);
        System.out.println(fib);

        int fibWithoutDp = findFibonacciwithoutDP(n);
        System.out.println("Normal Rec func");
        System.out.println("Total count :: "+countWithoutDp);
        System.out.println(fibWithoutDp);

        int fibwithBottomUp = findFibonacciUsingBottomUp(n);
        System.out.println(fibwithBottomUp);


    }
}



//0 1 1 2 3 5 8

////Top-Down Approach
//Recursion + Memoization
//
////Bottom-Up Approach
//Tabulirazation
//
//Iterative way of solving DP






