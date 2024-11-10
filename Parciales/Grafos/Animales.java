package Parciales.Grafos;

public class Animales {
    private String nombre;
    private int tiempo;

    public Animales(String nombre, int tiempo){
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    public String getNombre(){
        return this.nombre;
    }
    public int getTiempo(){
        return this.tiempo;
    }
}
