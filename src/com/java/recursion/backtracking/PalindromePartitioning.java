package com.java.recursion.backtracking;

import java.util.*;

public class PalindromePartitioning {
    static List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0, s, path, res);
        return res;
    }

    static void func(int index, String s, List<String> path, List<List<String>> res) {
        if(index == s.length()) {
            for(int i = 0; i < path.size(); i++){
                System.out.println(i+" - "+path.get(i));
            }
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < s.length(); ++i) {
            if(isPalindrome(s, index, i)) {
                path.add(s.substring(index, i+1));
                func(i+1, s, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    private static void printAll(List<List<String>> result){
        for(int i = 0; i < result.size(); i++){
            for(int j = 0; j < result.get(i).size(); j++){
                System.out.print(result.get(i).get(j));
            }
            System.out.println();
        }
    }
    private static boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "bababcbadcede";
        List<List<String>> result = partition(s);
    }
}
