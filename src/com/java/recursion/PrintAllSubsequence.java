/*

Write a program to print all the subsequences of an array whose sum is equal to k

arr = {1,2,1};
k = 2

 */

package com.java.recursion;

import java.util.ArrayList;
import java.util.List;



public class PrintAllSubsequence {

    static boolean doPrintAnyOneSubsequence(int index, List<Integer> ds, int curr_sum, int sum, int[] input, int n){
        //n = 3
        //input = {1,2,1}
        //sum = 2
        //base case//
        if(n == index){
            if(curr_sum == sum){
                //Print the ds//
                System.out.println("");
                for(int i = 0; i < ds.size(); i++){
                    System.out.print(ds.get(i));
                }
                return true;
            }else{
                return false;
            }
        }

        // 1st recursive call picks the element//
        curr_sum += input[index]; //1 , 3 , 4, 2,
        ds.add(input[index]); //{1}, {1,2}, {1,2,1}, {1,1}
        if(doPrintAnyOneSubsequence(index+1, ds, curr_sum, sum, input, n) == true){
            return true;
        }

        //Return back to the previous state//
        curr_sum -= input[index]; //3, 2
        ds.remove(ds.size()-1); //{1,2} , {1}

        //2nd recursive call to skip/ignore the current element//
        if(doPrintAnyOneSubsequence(index+1, ds,curr_sum, sum, input, n) == true){
            return true;
        }
        return false;
    }

    static void doPrintAllSubsequence(int index, List<Integer> ds, int curr_sum, int sum, int[] input, int n ){
        //n = 3
        //input = {1,2,1}
        //sum = 2
        //base case//
        if(n == index){
            if(curr_sum == sum){
                //Print the ds//
                System.out.println("");
                for(int i = 0; i < ds.size(); i++){
                    System.out.print(ds.get(i));
                }
            }
            return;
        }

        // 1st recursive call picks the element//
        curr_sum += input[index]; //3, 4, 2, 2, 3, 1
        ds.add(input[index]);  //{1,2}, {1,2,1}, {1,1}, {2}, {2,1}, {1}
        doPrintAllSubsequence(index+1, ds, curr_sum, sum, input, n);

        //Return back to the previous state//
        curr_sum -= input[index]; //3 //1 //1 //2
        ds.remove(ds.size()-1); //{1,2}, {1}, {1}, {2}

        //2nd recursive call to skip/ignore the current element//
        doPrintAllSubsequence(index+1, ds,curr_sum, sum, input, n);
    }


    public static void main(String[] args) {
        List<Integer> ds = new ArrayList<>();
        int[] input = new int[]{1,2,1};
        int n = input.length;
        int curr_sum = 0;
        int sum = 2;
        //doPrintAllSubsequence(0,ds,curr_sum,sum,input,n);
        boolean doPrintAnySub = doPrintAnyOneSubsequence(0,ds,curr_sum,sum,input,n);
        System.out.println(doPrintAnySub);
    }
}
