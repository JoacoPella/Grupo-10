package TP4;
// author: Lopez Emiliano, Pontiroli Lourdes y Pella Joaquín.

public class Sudoku {



    private static boolean containsInRow(int[][] sudoku, int row, int number) {
        // check in the whole row if the number is already in use.

        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == number) {
                return true;
            }
        }
        return false;
    }


    private static boolean containsInColumn(int[][] sudoku, int col, int number) {
        // check in the whole column if the number is already in use.

        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsInBox(int[][] sudoku, int row, int col, int number) {
        // check in the whole 3x3 box if the number is already in use.

        int f = row - row % 3;
        int c = col - col % 3;
        for (int i = f; i < f + 3; i++) {

            for (int j = c; j < c + 3; j++) {

                if (sudoku[i][j] == number) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean isPossible(int[][] sudoku, int row, int col, int number) {
        // use the previous 3 methods to prove that it's possible to use the number in that position.

        return !(containsInRow(sudoku, row, number) || containsInColumn(sudoku, col, number) || containsInBox(sudoku, row, col, number));
    }



    public static boolean solveSudoku(int[][] sudoku){
        int row = 0; //keeps the record of the row that has the empty element.
        int col = 0; //keeps the record of the column that has the empty element.
        boolean isFull = true; //boolean which indicates if there are empty spaces.

        for(int f = 0; f < sudoku.length;f++){

            for(int c = 0;c < sudoku.length; c++){

                if(sudoku[f][c] == 0){
                    row = f;
                    col = c;
                    isFull = false;
                    break;
                }
            }
            if(!isFull){ // there are still empty positions.
                break;
            }
        }
        if(isFull){ // if there are no more empty positions remaining, returns true.
            return true;
        }

        for(int number = 1; number <= 9; number++){

            if(isPossible(sudoku, row, col, number)){ 
                sudoku[row][col] = number; //if it's possible to use that number in that position, makes a tentative assigment. 

                if(solveSudoku(sudoku)){ //if solveSudoku is done, return true.
                    return true;

                }
                sudoku[row][col] = 0; //failure, undo and retry.
            }
        }
        return false; 
    }




    public static void displaySudoku(int[][] sudoku) {
        // displays the solved sudoku.

        for (int i = 0; i < 9; i++) {

            if (i % 3 == 0 && i != 0) {
                System.out.println("----------------------------------");
            }
            for (int j = 0; j < 9; j++) {

                if (j % 3 == 0 && j != 0) {
                    System.out.print(" | ");
                }
                System.out.print(" " + sudoku[i][j] + " ");

            }

            System.out.println();
        }
    }
}
