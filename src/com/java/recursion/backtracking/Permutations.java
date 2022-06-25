/*
Print all the permutations of a String/Array
arr = [1,2,3];
result : [

]
n = 3;
 */

package com.java.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    //Optimised Approach for finding all the permutations//
    static void recurPermute(int index, int[] input, List<List<Integer>> res, List<Integer> ds){
        //base conditions//
        //input.length = 3
        if(index == input.length){
            ds = new ArrayList<>();
            //[2,3,1]
            for(int i= 0; i < input.length; i++){
                ds.add(input[i]); //[1
            }
            res.add(new ArrayList<>(ds)); //[[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,2,1], [3,1,2]]
            return;
        }
        //index = 2
        //input.length = 3
        //i = 2,
        for(int i = index; i < input.length; i++){
            swap(i, index, input);
            recurPermute(index+1, input, res, ds);
            //backtracking swap//
            swap(i, index, input);
        }
    }
   //[1,2,3] = [1,2,3]
    private static void swap(int i, int j, int[] input){
        //2
        //1
        int t = input[i];
        input[i] = input[j];
        input[j] = t;
    }
    static List<List<Integer>> permute(int[] input){
        List<List<Integer>> res = new ArrayList<>(); // [[]] //
        List<Integer> ds = new ArrayList<>();
        recurPermute(0,input, res, ds);
        return res;
    }

    static void recursivePermute(int[] input, List<Integer> ds, List<List<Integer>> res, boolean[] freqMap){
        //base condition//
        if(ds.size() == input.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        //[1,2,3]//
        for(int i = 0; i< input.length; i++){
            if(!freqMap[i]){
                ds.add(input[i]);
                freqMap[i] = true;
                recursivePermute(input, ds, res, freqMap);
                ds.remove(ds.size()-1);
                freqMap[i] = false;
            }
        }
    }

    static List<List<Integer>> doPermute(int[] input){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[input.length];
        recursivePermute(input, ds, res, freq);
        return res;
    }




    public static void main(String[] args) {
        int nums[] = {1,2,3};
        List<List<Integer>> result = permute(nums);//doPermute(nums);
        System.out.println("All Permutations are :: ");
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
