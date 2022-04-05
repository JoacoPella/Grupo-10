package TP3.ELeccionesLegislativas;

public class Tester {
    public static void main(String[] args) {
        Boleta miboleta1= new Boleta (1, 12);
        Boleta miboleta2= new Boleta (2, 15);
        Boleta miboleta3= new Boleta (3, 19);
        Boleta miboleta4= new Boleta (1, 22);

        Partido partido1 = new Partido(1,"Frente de Todos");
        Partido partido2 = new Partido(2,"Juntos por el Cambio");
        Partido partido3 = new Partido(3,"Avanza Libertad");
        Partido partido4 = new Partido(4,"Frente de Izquierda");

        Urna miurna = new Urna(200, 4);

        miurna.agregarPartido(partido1);
        miurna.agregarPartido(partido2);
        miurna.agregarPartido(partido3);
        miurna.agregarPartido(partido4);

        miurna.votar(miboleta1);
        miurna.votar(miboleta2);
        miurna.votar(miboleta3);
        miurna.votar(miboleta4);

        System.out.println(miurna.nrodevotos());
        System.out.println(miurna.partidoGanador());

    }
}