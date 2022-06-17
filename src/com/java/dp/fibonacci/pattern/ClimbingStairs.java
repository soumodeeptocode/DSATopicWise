/*
Total number of ways to reach Nth stair. Possible moves are 1, 2 and 3 stairs.
*/

package com.java.dp.fibonacci.pattern;

import java.util.Arrays;

public class ClimbingStairs {

    static int[] memo;

    static int totalNumberOfWaysToReachTopDown(int n) {
        //base condition//
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (memo[n] == 0) {
            memo[n] = totalNumberOfWaysToReachwithoutDP(n - 1) + totalNumberOfWaysToReachwithoutDP(n - 2) + +
                    totalNumberOfWaysToReachwithoutDP(n - 3);
        }

        return memo[n];
    }

    static int totalNumberOfWaysToReachwithoutDP(int n){
        //base condition//
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;

        return totalNumberOfWaysToReachwithoutDP(n-1) + totalNumberOfWaysToReachwithoutDP(n-2) + totalNumberOfWaysToReachwithoutDP(n-3);
    }

    public static void main(String[] args) {
        int n = 5;
        memo = new int[n+1];
        Arrays.fill(memo, 0);
        int totalWays = totalNumberOfWaysToReachwithoutDP(n);
        System.out.println("Total Ways :: "+totalWays);

        int totalWaysBottomUp = totalNumberOfWaysToReachTopDown(n);
        System.out.println("Total Ways using Bottom Up :: "+totalWaysBottomUp);
    }
}

//Top-Down Approach//

//Pseudocode//

//f(n){
//
//    if(n == 0) return 1;
//    if(n == 1) return 1;
//    if(n == 2) return 2;
//
//    return f(n-1) + f(n-2) + f(n-3);
//
//}


//Home Task//
//How we are going to apply dp in Array Fill problem
// Top Down Approach
//Minimum Jumps to reach nth stair//
//Possible moves : {1,2,3}


