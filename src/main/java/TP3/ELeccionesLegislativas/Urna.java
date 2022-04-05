package TP3.ELeccionesLegislativas;

public class Urna {
    private int cantidadPartidos; //Partidos que se presentan
    private int votosTotales;
    private int partidosTotales;
    public int votantes;
    private Boleta[] votos ;
    private Partido[] partidos;

    public Urna(int votantes_aux,int cantidadPartidos_aux){
        this.cantidadPartidos= cantidadPartidos_aux;
        this.votantes = votantes_aux;
        votos = new Boleta[votantes];
        partidos = new Partido[cantidadPartidos];
    }

    public Urna(int cantidadPartidos_aux){ //En caso de que no se defina la cantidad total de votantes, el constructor define por default 200 elementos en el array
        this.cantidadPartidos= cantidadPartidos_aux;
        votos = new Boleta[200];
        partidos = new Partido[cantidadPartidos];
    }


    public void agregarPartido(Partido partido_aux){
        partidos[partidosTotales] = partido_aux;
        partidosTotales ++;
    }


    public void votar(Boleta boleta_aux){
        votos[votosTotales] = boleta_aux;
        votosTotales ++;
    }
    public int nrodevotos(){
        return votosTotales;
    }


    public String partidoGanador(){
        int contador[] = new int[cantidadPartidos];
        int max = contador[0];
        int imax = 0;
        int init = 0;

        for(int i = 0; i < votos.length; i++){
            if(votos[i] != null ){
                contador[votos[i].getPartido()-1]++;
            }
        }

        while(init < contador.length){
            if(contador[init]>max){
                max = contador[init];
                imax = init;
            }
            init++;
        }

        return partidos[imax].getNombrePartido();


    }
}