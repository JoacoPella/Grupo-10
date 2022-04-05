package TP3.ELeccionesLegislativas;

public class Boleta {
    private int partido;
    private int codigo;

    public Boleta(int partido_aux, int codigo_aux){
        this.partido = partido_aux;
        this.codigo = codigo_aux;
    }

    public int getPartido(){
        return partido;
    }
}