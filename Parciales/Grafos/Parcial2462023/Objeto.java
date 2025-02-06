package Parciales.Grafos.Parcial2462023;

import java.util.ArrayList;
import java.util.List;

public class Objeto {
    private List<String> lugares;
    private int cantidadCuadras;

    public Objeto() {
        this.lugares = new ArrayList<String>();
        this.cantidadCuadras = 0;
    }

    public Objeto(List<String> lugares, int cantidadCuadras) {
        this.lugares = lugares;
        this.cantidadCuadras = cantidadCuadras;
    }

    public List<String> getLugares() {
        return lugares;
    }

    public int getCantidadCuadras() {
        return cantidadCuadras;
    }

    public void añadirLugar(String lugar) {
        this.lugares.add(lugar);
    }

    public void setCantidadCuadras(int cantidadCuadras) {
        this.cantidadCuadras = cantidadCuadras;
    }
}
