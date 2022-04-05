package TP4;

public class Sudoku {

//    private final int[][] sudoku;
//    private static final int vacio = 0;
//
//    public TP4.Sudoku() { // crea la matriz
//
//        sudoku = new int[9][9];
//    }
//
//    public TP4.Sudoku(int[][] sudoku) {
//        this.sudoku = sudoku;
//    }


    private static boolean contieneFila(int[][] sudoku, int fila, int numero) { // checkea en toda la fila si el numero ya esta en uso

        for (int i = 0; i < 9; i++) {
            if (sudoku[fila][i] == numero) {
                return true;
            }
        }
        return false;
    }


    private static boolean contieneColumna(int[][] sudoku, int col, int numero) { // // checkea en toda la columna si el numero ya esta en uso

        for (int i = 0; i < 9; i++) {
            if (sudoku[i][col] == numero) {
                return true;
            }
        }
        return false;
    }

    private static boolean contieneCaja(int[][] sudoku, int fila, int col, int numero) { //checkea en la caja de 3x3 si el número yta está en uso

        int f = fila - fila % 3;
        int c = col - col % 3;
        for (int i = f; i < f + 3; i++) {

            for (int j = c; j < c + 3; j++) {

                if (sudoku[i][j] == numero) {
                    return true;
                }
            }

        }
        return false;
    }

    private static boolean esPosible(int[][] sudoku, int fila, int col, int numero) { //utiliza los anteriores 3 métodos para probar que es posible utilizar cierto número en el casillero

        return !(contieneFila(sudoku, fila, numero) || contieneColumna(sudoku, col, numero) || contieneCaja(sudoku, fila, col, numero));
    }

//    public boolean resolverSudoku(int[][] sudoku) {
//
//        for (int fila = 0; fila < sudoku.length; fila++) {
//
//            for (int col = 0; col < sudoku.length; col++) {
//
//                if (sudoku[fila][col] == vacio) {
//
//                    for (int numero = 1; numero <= 9; numero++) {
//
//                        if (esPosible(fila, col, numero)) {
//
//                            sudoku[fila][col] = numero;
//
//                            if (resolverSudoku(sudoku)) {
//                                return true;
//                            } else {
//                                sudoku[fila][col] = vacio;
//                            }
//                        }
//                    }
//                    return false;
//
//                }
//            }
//
//        }
//        return false;
//    }


    public static boolean resolverSudoku(int[][] sudoku){
        int fila = 0;
        int col = 0;
        boolean vacio = true;

        for(int f = 0; f< sudoku.length;f++){

            for(int c = 0;c < sudoku.length; c++){

                if(sudoku[f][c] == 0){
                    fila = f;
                    col = c;
                    vacio = false;
                    break;
                }
            }
            if(!vacio){ //todavía quedan espacios por completar
                break;
            }
        }
        if(vacio){ // no hay más espacios vacíos en nuestro sudoku
            return true;
        }

        for(int numero = 1; numero <= 9; numero++){

            if(esPosible(sudoku, fila, col, numero)){
                sudoku[fila][col] = numero;

                if(resolverSudoku(sudoku)){
                    return true;

                }
                sudoku[fila][col] = 0;
            }
        }
        return false;
    }




    public static void mostrarSudoku(int[][] sudoku) { // muestra el sudoku en consola, quedando claro (visualmente) la separación entre cajas
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


    public static void main(String[] args) {
        int[][] s = new int[][]{ // sudoku a resolver
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


        if (resolverSudoku(s)) {
            mostrarSudoku(s);
        }
    }

}