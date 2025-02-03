package Parciales.Grafos.Parcial29062024Tema2;

public class Devolver {
    private int cant;
    private boolean popular;

    public Devolver(int cant, boolean pop) {
        this.cant = cant;
        this.popular = pop;
    }

    /*public String getNombre() {
        return ca;
    }*/

    /*public int getDistancia() {
        return distancia;
    }*/

    @Override
    public String toString() {
        return  "Cantidad='" + cant + '\'' +
                ", popular?=" + popular +
                '}';
    }
}
