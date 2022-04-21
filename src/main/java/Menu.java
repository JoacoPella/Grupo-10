package TPCaballo;

import java.util.Scanner;

public class Menu {

    static int iniciar(){

        Scanner input = new Scanner(System.in);
        System.out.println("numero de movimientos a emplear: ");
        int movimientos = input.nextInt();
        System.out.println("posicion inicial (ejemplo A1):");
        String posicion = input.next();


        boolean i = true;
        while (i == true){

            Horse Horse = new Horse(posicion, movimientos);

            System.out.println("Menu Caballo");
            System.out.println("1: Siguiente salto");
            System.out.println("2: Contenido de las pilas");
            System.out.println("3: Salir");
            int opcion = input.nextInt();
            if (opcion==1){
                Horse.looper();
            }
            else if (opcion==2){
                Horse.showPiles();
            }
            else if(opcion ==3){
                System.out.println("Se cerro el menu");
                return -1;
            }
            else{
                System.out.println("Numero invalido");
            }
        }
        return 1;
    }
}