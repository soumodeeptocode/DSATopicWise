package com.java.recursion.backtracking;

public class Sudoku {

    //sudoku board is always 9 X (

    static boolean solve(char[][] board){
        // we will be searching for blank spaces//
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    //place number from 1 to 9//
                    for(char c = '1'; c <= '9'; c++){
                        if(valid(board, i,j, c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean valid (char[][] board, int row, int col, char c){
            for(int i = 0; i < 9; i++){
                //row wise//
                if(board[row][i] == c) return false;

                //column wise//
                if(board[i][col] == c) return false;

                //sub-box check//
                if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] == c) return false;

            }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solve(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
