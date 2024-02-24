package com.dc.data.structures;

import java.util.Arrays;

public class WorkingWith2DArray {

    public static void main(String[] args) {
        char[][] board = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }

        board[0][0] = 'X';
        board[1][0] = 'X';
        board[2][0] = 'X';

        System.out.println(Arrays.deepToString(board));

        char[][] boardTwo = new char[][]{
                new char[]{'O','X','O'},
                new char[]{'O','O','X'},
                new char[]{'O','X','X'},
        };

        System.out.println(Arrays.deepToString(boardTwo));
    }
}
