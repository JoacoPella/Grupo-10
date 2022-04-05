package TP3.ELeccionesLegislativas;

public class Partido {
    private int codigoPartido;
    private String nombrePartido;
    public Partido(int codigoPartido_aux, String nombrePartido_aux){
        this.codigoPartido = codigoPartido_aux;
        this.nombrePartido = nombrePartido_aux;
    }

    public int getCodigoPartido(){
        return codigoPartido;
    }

    public String getNombrePartido(){
        return nombrePartido;
    }
}