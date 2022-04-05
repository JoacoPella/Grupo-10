import java.util.Arrays;

public class Ejercicio3 {

    public int[] merge(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        int iA = 0;
        int iB = 0;
        int iC = 0;
        // se declaran 3 contadores de index, uno para cada array.

        while (iA < A.length && iB < B.length) {
            if (A[iA] < B[iB]) {
                C[iC] = A[iA];
                iA++;
            } else {
                C[iC] = B[iB];
                iB++;
            }
            iC++;
            // cuando ambos contadores, del array A y del B, son menores a sus respectivos largos, se comparan los indices y se agrega el menor al
            // array C.
        }
        if (iB != B.length) {
            while (iB < B.length) {
                C[iC] = B[iB];
                iB++;
                iC++;
            }
        }
        if (iA != A.length) {
            while (iA < A.length) {
                C[iC] = A[iA];
                iA++;
                iC++;
            }

        }return C;
        // ambos if, se encargan de agregar los elementos faltantes de los arrays A y B en el caso de que una de las listas haya sido
        // agregado a C por completo.
    }


    public static void main(String[] args) {
        int[] A = {1, 4, 7, 9, 14};
        int[] B = {2, 3, 6, 8, 11};
        Ejercicio3 f = new Ejercicio3();
        System.out.println(Arrays.toString(f.merge(A, B)));
    }

}

