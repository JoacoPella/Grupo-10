package TP4;
// author: Lopez Emiliano, Pontiroli Lourdes y Pella Joaquín.

import static TP4.Sudoku.solveSudoku;
import static TP4.Sudoku.dysplaySudoku;

public class Main {
    public static void main(String[] args) {
        int[][] s = new int[][]{ // sudoku to solve.
                {0, 0, 0, 9, 0, 0, 4, 0, 7},
                {0, 0, 0, 0, 5, 4, 1, 0, 0},
                {0, 0, 0, 0, 1, 3, 8, 2, 0},
                {8, 0, 0, 0, 3, 0, 7, 0, 0},
                {0, 6, 0, 2, 0, 5, 0, 8, 0},
                {0, 0, 1, 0, 8, 0, 0, 0, 3},
                {0, 5, 6, 3, 7, 0, 0, 0, 0},
                {0, 0, 9, 5, 2, 0, 0, 0, 0},
                {2, 0, 3, 0, 0, 1, 0, 0, 0},
        };


        if (solveSudoku(s)) {
            displaySudoku(s);
        }
    }
}
