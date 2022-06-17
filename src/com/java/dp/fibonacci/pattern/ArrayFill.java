/*
Fill array with 0's and 1's in such a way that no two 1s are consecutive
*/

package com.java.dp.fibonacci.pattern;

public class ArrayFill {


    static int totalNumberofWays(int index, int n, boolean prev){

        if(index == n+1) return 1;

        int totalWays = 0;
        //either we place 0 here//
        totalWays += totalNumberofWays(index + 1, n, false);
        //or we place 1 here//
        if(prev == false) {
            totalWays += totalNumberofWays(index + 1, n, true);
        }
        return totalWays;
    }


    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++){
            int totalWays = totalNumberofWays(1, i, false);
            System.out.println("Total Number of ways :: "+totalWays);
        }

    }
}

//Hometask

//to apply memoization to this particular problem//

//0 1 1 2 3 5 8 13...
//
//0 1 2 3 3 5 8 13....
//
//totalways = fib(n+2);
//
//fib(n+2);


/*Fibonacci Pattern
        Knapsack 0/1
        knapsack unbounded
Palindromic Subsequence
Longest Common Subsequence (LCS) */


//Length = 1, total = 2
//Length = 2, total = 3
//Length = 3, total = 5

//0,1,0
//
//1 -> 2 -> 3 -> 4
//
//n + 1 == index
//
//4 == 4







