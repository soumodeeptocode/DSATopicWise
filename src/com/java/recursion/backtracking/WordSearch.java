package com.java.recursion.backtracking;

/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.

Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 */
public class WordSearch {
    static boolean doFindWord(char[][] grid, String word, int nRow, int nCol, int i, int j, int level){

        //base condtion//
        if(level == word.length()){
            return true;
        }

        //boundary//
        if(i < 0 || j < 0 || i >= nRow || j >= nCol){
            return false;
        }

        if(grid[i][j] == word.charAt(level)){
            //Mark the cell with visited//
            char temp = grid[i][j];
            grid[i][j] = '#';

            //find the next letter in 4 direction//
            //left direction//
            boolean res = doFindWord(grid, word, nRow, nCol, i, j-1, level + 1) |
                    //right direction//
                    doFindWord(grid, word, nRow, nCol, i, j+1, level+1) |
                    //top//
                    doFindWord(grid, word, nRow, nCol, i-1, j, level+1) |
                    //bottom//
                    doFindWord(grid, word, nRow, nCol, i+1, j, level+1) ;
            //backtracking step//
            grid[i][j] = temp;
            return res;
        }else{
            return false;
        }
    }
    static boolean doCheck(char[][] grid, String word, int nRow, int nCol){
        int l = grid.length;
        if(l > nRow * nCol) return false;
        for(int i = 0; i < nRow; i++){
            for(int j = 0; j < nCol; j++){
                if(grid[i][j] == word.charAt(0)){
                    if(doFindWord(grid, word, nRow, nCol, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        char [][] grid = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        int nRow = 3;
        int nCol = 4;
        if(doCheck(grid, "ABCB", nRow, nCol)){
            System.out.println("I have found the word");
        }else{
            System.out.println("Word is not present");
        }

    }
}


