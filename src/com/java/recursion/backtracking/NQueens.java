package com.java.recursion.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//4  X 4 board//
public class NQueens {
    static List<List<String>> doSolveNQueens(int N){
        char board[][] = new char[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        doSearchPossiblitiesbyDepth(0, board, res);
        return res;
    }
    static void doSearchPossiblitiesbyDepth(int col, char[][] board, List<List<String>> res){
        if(col == board.length){
            res.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(validate(row, col, board)){
                board[row][col] = 'Q';
                doSearchPossiblitiesbyDepth(col+1, board, res);
                board[row][col] = '.';
            }
        }
    }

    private static List<String> construct(char[][] board){
        List<String> result = new LinkedList<String>();
        for(int i = 0; i < board.length; i++){
            String s = new String(board[i]);
            result.add(s);
        }
        return result;
    }
    private static boolean validate(int row, int col, char[][] board){
        int duprow = row;
        int dupcol = col;
        //upper diagonal check//
        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row --;
            col--;
        }

        row = duprow;
        col = dupcol;
        //left side check//
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col --;
        }
        row = duprow;
        col = dupcol;

        //Lower diagonal check//
        while(col >= 0 && row < board.length){
            if(board[row][col] == 'Q') return false;
            col --;
            row ++;
        }
        return true;
    }
    public static void main(String[] args) {
        int N = 4;
        List<List<String>> queen = doSolveNQueens(N);
        int i = 1;
        for(List<String> it: queen){
            System.out.println("Arrangements :: "+i);
            for(String s : it){
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }
}

//Abstraction of OOPS//
