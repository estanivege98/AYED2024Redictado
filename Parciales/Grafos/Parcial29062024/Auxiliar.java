package Parciales.Grafos.Parcial29062024;

public class Auxiliar {
    private String nombre;
    private int distancia;

    public Auxiliar(String nombre, int distancia){
        this.nombre = nombre;
        this.distancia = distancia;
    }

    public String getNombre(){
        return this.nombre;
    }
    public int getDistancia(){
        return this.distancia;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDistancia(int distancia){
        this.distancia = distancia;
    }
}
