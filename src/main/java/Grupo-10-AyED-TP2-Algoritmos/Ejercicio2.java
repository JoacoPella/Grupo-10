public class Ejercicio2 {
    /*algoritmo de seleccion. Consiste en encontrar el menor de todos los elementos del arreglo e
    intercambiarlo con el que está en la primera posicion. Luego el segundo mas pequeño,
    y asi sucesivamente hasta ordenar todo el array*/

    public static void selection(int[] a){
        int n = a.length;
        for(int i =0; i<n-1;i++){
            int min = i;
            for(int j = i+1;j<n;j++){
                if(a[j]<a[min]){
                    min = j;
                    int temp = a[min];
                    a[min] = a[i];
                    a[i] = temp;
                }
            }
        }
    }
    public static void recursiveSelection(int[] a, int index){
        int min = index;
        for(int j = index + 1;j<a.length;j++){
            if(a[j]<a[min]){
                min = j;
            }
        }
        int min_number = a[min];
        a[min] = a[index];
        a[index] = min_number;

        if(index<a.length-1){
            recursiveSelection(a,index+1);
        }

    }
    /*algoritmo de insercion.Suponemos que el primer elemento del array está ordenado. Se toma el segundo elemento y se lo guarda en una variable nueva.
    Compara la variable con el primer elemento. Si el primer elemento es mayor que la variable, la variable se coloca delante del primer elemento.
    Ahora, los dos primeros elementos están ordenados. Se toma el tercer elemento y se lo compara con los elementos a la izquierda.
    Se coloca justo detrás del elemento más pequeño que él. Si no hay ningún elemento más pequeño que él, se coloca al comienzo del array y asi sucesivamente.*/
    public static void insertion (int[] a) {
        for (int i=1; i < a.length; i++) {
            int aux = a[i];
            int j;
            for (j=i-1; j >=0 && a[j] > aux; j--){
                a[j+1] = a[j];
            }
            a[j+1] = aux;
        }
    }

    /*burbujeo.Consiste en recorrer el array desde el primer al ultimo elemento. Luego compara el elemento del indice actual con el siguiente elemento. Si el elemento
    es mayor a su siguiente, los intercambia.*/
    public static void bubble(int[] a){
        int temp;
        for(int i=1;i < a.length;i++){
            for (int j=0 ; j < a.length- 1; j++){
                if (a[j] > a[j+1]){
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }
}
