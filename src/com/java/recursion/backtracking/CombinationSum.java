/*

Print all the possible combinations that forms the target sum
input: [2,3,6,7]
target: 7
//expected o/p: [[2,2,3], [7]]//

 */


package com.java.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    static void findCombination(int index, int target, int[] input, List<List<Integer>> res, List<Integer> ds){
        //base case//
        if(index == input.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        //pick
        if(input[index] <= target){
            ds.add(input[index]);
            findCombination(index, target - input[index], input, res, ds);
            ds.remove(ds.size() -1);
        }
        //Not Pick
        findCombination(index+1, target, input, res, ds);

    }

    static List<List<Integer>> combinationSum(int[] arr, int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findCombination(0, target, arr, res, ds);
        return res;
    }
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> result = combinationSum(arr, target);
        System.out.println("Combinations Sum : ");
        for(int i = 0; i < result.size(); i++){
            for(int j=0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j)+ " ");
            }
            System.out.println();
        }
    }
}
