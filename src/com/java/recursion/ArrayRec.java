package com.java.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayRec {
    public static  void doPrint(List<Integer> arr, int index){
        //base condition//
        if(index < 0) return;
        System.out.println(arr.get(index));
        doPrint(arr, index - 1);
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        doPrint(arr, arr.size() -1);
       // System.out.println();
    }
}
